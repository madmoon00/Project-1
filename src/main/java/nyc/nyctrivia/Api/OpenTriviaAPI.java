package nyc.nyctrivia.Api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenTriviaAPI {
    private static final String BASE_URL = "https://opentdb.com/api.php?";
    private static final String TOKEN_URL = "https://opentdb.com/api_token.php";
    
    private int amount;
    private String token;
    private String category;


    public OpenTriviaAPI(int amount, String category) {
        this.amount = amount;
        this.category = category;
        this.token = retrieveToken();
    }
    
    private String retrieveToken() {
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
            // Assuming the response format is {"response_code":0,"response_message":"Token Generated Successfully!","token":"YOURTOKENHERE"}
            String jsonResponse = response.toString();
            int startIndex = jsonResponse.indexOf("\"token\":\"") + 9;
            int endIndex = jsonResponse.indexOf("\"", startIndex);
            return jsonResponse.substring(startIndex, endIndex);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
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
    
    public String getTriviaQuestions() {
        try {
            URL url = new URL(buildUrlWithToken());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
