package nyc.nyctrivia.Classes;

public class Question {
    private final String question;
    private final String correctAnswer;
    private final String[] choices;
    
    public Question(String question, String correctAnswer, String[] choices) {
        this.question = question;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
    }
    
    public String getQuestion() {
        return question;
    }

    public String[] getChoices() {
        return choices;
    }

    public boolean checkAnswer(String userAnswer) {
        return userAnswer.equalsIgnoreCase(this.correctAnswer);
    }
}
