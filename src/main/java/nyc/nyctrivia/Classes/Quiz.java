package nyc.nyctrivia.Classes;

import nyc.nyctrivia.Api.OpenTriviaAPI;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Quiz {
    private OpenTriviaAPI otAPI;
    private Question[] questions;
    public int amount;
    
    public Quiz(int amount, String category) {
        this.otAPI = new OpenTriviaAPI(amount, category);
        this.amount = amount;
        init();
    }
    
    private void init() {
        this.questions = null;
    }

    public Question[] getQuestions() {
        return this.questions;
    }
    
    public void fetchQuestions(){
        Question[] questions = null;
        
        String jsonResponse = this.otAPI.getTriviaQuestions();
        
        if (jsonResponse != null){
            // Parse JSON response
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);
            
            int responseCode = jsonObject.get("response_code").getAsInt();
            switch (responseCode) {
                case 0:
                    JsonArray resultsArray = jsonObject.getAsJsonArray("results");
                    questions = new Question[resultsArray.size()];
                    
                    for (int i = 0; i < resultsArray.size(); i++) {
                        JsonObject resultObject = resultsArray.get(i).getAsJsonObject();
                        
                        String question = resultObject.get("question").getAsString();
                        String correctAnswer = resultObject.get("correct_answer").getAsString();
                        JsonArray choicesArray = resultObject.getAsJsonArray("incorrect_answers");
                        String[] choices = new String[choicesArray.size() + 1];
                        
                        // Add correct answer to choices array
                        choices[0] = correctAnswer;
                        // Add incorrect choices to choices array
                        for (int j = 0; j < choicesArray.size(); j++) {
                            choices[j + 1] = choicesArray.get(j).getAsString();
                        }
                        
                        // Create a new Question object and add it to the array
                        questions[i] = new Question(question, correctAnswer, choices);
                    }
                    break;
                case 1,2:
                    throw new Error("Internal Error! Try again.");
                case 3:
                    // Token Not Found: Session Token does not exist
                    System.out.println("Token Not Found: Session Token does not exist.");
                    break;
                case 4:
                    // Token Empty: Session Token has returned all possible questions for the specified query
                    System.out.println("Token Empty: Session Token has returned all possible questions for the specified query. Resetting the Token is necessary.");
                    break;
                case 5:
                    // Rate Limit: Too many requests have occurred
                    System.out.println("Rate Limit: Too many requests have occurred. Each IP can only access the API once every 5 seconds.");
                    break;
                default:
                    // Handle other response codes if necessary
                    System.out.println("Unknown response code: " + responseCode);
                    break;
            }
            
            JsonArray resultsArray = jsonObject.getAsJsonArray("results");

        }
        
        this.questions = questions;
    }
}
