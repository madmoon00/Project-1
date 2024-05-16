package nyc.nyctrivia.Api;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import nyc.nyctrivia.Classes.Category;

public class OpenTriviaAPI {
    private static final String BASE_URL = "https://opentdb.com/api.php?";
    private static final String TOKEN_URL = "https://opentdb.com/api_token.php";
    private static int counter = 0;
    private int amount;
    private String token;
    private String category;


    public OpenTriviaAPI(int amount, String category) {
        this.amount = amount;
        this.category = category;
        retrieveAndSetNewToken();
    }
    
    public void retrieveAndSetNewToken() {
        try {
            URL url = new URL(TOKEN_URL + "?command=request");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Extract token from JSON response
            String jsonResponse = response.toString();
            int startIndex = jsonResponse.indexOf("\"token\":\"") + 9;
            int endIndex = jsonResponse.indexOf("\"", startIndex);
            token = jsonResponse.substring(startIndex, endIndex);
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }
    
    // Method to reset the session token
    public void resetToken() {
        try {
            URL url = new URL(TOKEN_URL + "?command=reset&token=" + this.token);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Check response code for success
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Token reset successfully.");
            } else {
                System.out.println("Token reset failed. Response code: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private String buildUrlWithToken() {
        String url = BASE_URL + "amount=" + this.amount + "&token=" + this.token;
        
        if (!this.category.equals("")) url += "&category=" + this.category;

        return url;
    }
    
    public String getTriviaQuestions() throws InterruptedException {
        try {
            URL url = new URL(buildUrlWithToken());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
                return response.toString();
            } else {
                return "{\"return_code\" : 5 " + "}";
            }
        } catch (IOException e) {
            ////////////////////
            counter++;
            if (counter < 2) {
                Thread.sleep(5000);
                return getTriviaQuestions();
            }
            else {
                ///////////////
                return null;
            }
        }
    }
    
    public static List<Category> getCategories() throws IOException {
        List<Category> categories = new ArrayList<>();

        // URL for getting trivia categories
        String apiUrl = "https://opentdb.com/api_category.php";

        // Open connection
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Check if response code is OK
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Read response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Parse JSON response
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(response.toString(), JsonObject.class);
            JsonArray categoriesArray = jsonObject.getAsJsonArray("trivia_categories");

            // Extract category IDs and names
            for (JsonElement element : categoriesArray) {
                JsonObject categoryObject = element.getAsJsonObject();
                int id = categoryObject.get("id").getAsInt();
                String name = categoryObject.get("name").getAsString();
                categories.add(new Category(id, name));
            }
        }

        return categories;
    }

}
