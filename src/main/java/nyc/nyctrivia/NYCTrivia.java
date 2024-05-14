package nyc.nyctrivia;

import java.text.DecimalFormat;
import nyc.nyctrivia.Classes.Quiz;
import nyc.nyctrivia.Controllers.SQLiteHandler;
import nyc.nyctrivia.Panels.PanelLogin;
import nyc.nyctrivia.Panels.PanelHome;
import nyc.nyctrivia.Panels.PanelQuiz;
import nyc.nyctrivia.Panels.PanelRegister;
import nyc.nyctrivia.Panels.PanelResults;

public class NYCTrivia {
    private static SQLiteHandler dbHandler;
    private static Quiz quiz;
    
    private static int UserId;
    public static String Username;
    
    
    public static void main(String[] args) {
        dbHandler = new SQLiteHandler();
        initComponents();
        goLogin();
    }
    
    private static void initComponents() {
        pnlHome = new PanelHome();
        pnlQuiz = new PanelQuiz();
        pnlResults = new PanelResults();
        pnlLogin = new PanelLogin();
        pnlRegister = new PanelRegister();
        mFrame = new MainFrame();
        
        mFrame.getContentPane().add(pnlHome);
        mFrame.getContentPane().add(pnlQuiz);
        mFrame.getContentPane().add(pnlResults);
        mFrame.getContentPane().add(pnlLogin);
        mFrame.getContentPane().add(pnlRegister);
        mFrame.pack();
        mFrame.setVisible(true);
    }
    
    public static void NewGame() {
        NYCTrivia.quiz = new Quiz(10, "");
        NYCTrivia.quiz.fetchQuestions();
        
        pnlQuiz.setQuiz(NYCTrivia.quiz);
        goQuiz();
    }
    
    public static void commitAnswer (String userAnswer) {
        pnlQuiz.commitAnswer(userAnswer);
    }
    
    public static void showResults(int score) {
        dbHandler.addScore(UserId, score);
        pnlResults.setScore(score);
        goResults();
    }
    
    public static boolean doesUsernameExist(String username) {
        boolean check = dbHandler.doesUsernameExist(username);
        
        return check;
    }
    
    public static void addUser(String username, String password) {
        dbHandler.addUser(username, password);
    }
    
    public static int CommitLogin(String username, String password) {
        int userId = dbHandler.checkCredentials(username, password);
        
        if (userId >= 0) {
            UserId = userId;
            Username = dbHandler.getNameById(userId);
            goHome();
        }
        
        return userId;
    }
    
    public static void goHome() {
        pnlHome.setVisible(true);

        pnlQuiz.setVisible(false);
        pnlResults.setVisible(false);
        pnlLogin.setVisible(false);
        pnlRegister.setVisible(false);
    }
    
    public static void goQuiz() {
        pnlQuiz.setVisible(true);

        pnlHome.setVisible(false);
        pnlResults.setVisible(false);
        pnlLogin.setVisible(false);
        pnlRegister.setVisible(false);
    }
    
    public static void goResults() {
        pnlResults.setVisible(true);

        pnlHome.setVisible(false);
        pnlQuiz.setVisible(false);
        pnlLogin.setVisible(false);
        pnlRegister.setVisible(false);
    }
    
    public static void goLogin() {
        pnlLogin.setVisible(true);

        pnlHome.setVisible(false);
        pnlQuiz.setVisible(false);
        pnlResults.setVisible(false);
        pnlRegister.setVisible(false);
    }
    
    public static void goRegister() {
        pnlRegister.setVisible(true);

        pnlHome.setVisible(false);
        pnlQuiz.setVisible(false);
        pnlResults.setVisible(false);
        pnlLogin.setVisible(false);
    }
    
    //Declare Components
    private static PanelHome pnlHome;
    private static PanelQuiz pnlQuiz;    
    private static PanelResults pnlResults;
    private static PanelLogin pnlLogin;
    private static PanelRegister pnlRegister;
    private static MainFrame mFrame;
}

