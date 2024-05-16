package nyc.nyctrivia;

import java.awt.Container;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import nyc.nyctrivia.Classes.Category;
import nyc.nyctrivia.Controllers.ErrorHandler;
import nyc.nyctrivia.Classes.Quiz;
import nyc.nyctrivia.Controllers.SQLiteHandler;
import nyc.nyctrivia.Panels.PanelCategory;
import nyc.nyctrivia.Panels.PanelHistory;
import nyc.nyctrivia.Panels.PanelLogin;
import nyc.nyctrivia.Panels.PanelHome;
import nyc.nyctrivia.Panels.PanelQuiz;
import nyc.nyctrivia.Panels.PanelRegister;
import nyc.nyctrivia.Panels.PanelResults;
import nyc.nyctrivia.Panels.PanelStatistics;

public class NYCTrivia {
    
    
    //Declare Components
    private static final ErrorHandler errHandler = new ErrorHandler();
    private static final SQLiteHandler dbHandler = new SQLiteHandler();

    private static PanelHome pnlHome;
    private static PanelCategory pnlCategory;
    private static PanelQuiz pnlQuiz;
    private static PanelResults pnlResults;
    private static PanelHistory pnlHistory;
    private static PanelStatistics pnlStatistics;
    private static PanelLogin pnlLogin;
    private static PanelRegister pnlRegister;
    private static MainFrame mFrame;
    private static ArrayList<JPanel> Panels;
    
    
    private static int UserId;
    public static String Username;

    private static Quiz quiz;
    
    public static void main(String[] args) {
        try {
            initComponents();
        } catch (Exception e) {
            ErrorHandler.log(e, "Failed Initilizing Components.", true, true);
        }
        
        goLogin();

    }
    
    private static void initComponents() {
        pnlHome = new PanelHome();
        pnlCategory = new PanelCategory();
        pnlQuiz = new PanelQuiz();
        pnlResults = new PanelResults();
        pnlHistory = new PanelHistory();
        pnlStatistics = new PanelStatistics();
        pnlLogin = new PanelLogin();
        pnlRegister = new PanelRegister();
        mFrame = new MainFrame();
        
        Panels = new ArrayList<>();
        Panels.add(pnlHome);
        Panels.add(pnlCategory);
        Panels.add(pnlQuiz);
        Panels.add(pnlResults);
        Panels.add(pnlHistory);
        Panels.add(pnlStatistics);
        Panels.add(pnlLogin);
        Panels.add(pnlRegister);
        
        for (JPanel panel : Panels) {
            // Add each panel to the parent container
            mFrame.add(panel);
        }
        
        mFrame.pack();
        mFrame.setLocationRelativeTo(null);
        mFrame.setVisible(true);
    }
    
    public static void NewGame(int categoryId) {
        String category = "";
        
        if (categoryId > -1){
            category += "" + categoryId;
        }
        
        try {
            NYCTrivia.quiz = new Quiz(10, category);
            NYCTrivia.quiz.fetchQuestions();

            pnlQuiz.setQuiz(NYCTrivia.quiz);
            goQuiz();
        }
        catch (Exception e) {
            ///////////////////////////////////////////////// mono mhnuma
            goHome();
        }
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
    
    private static void navigate(JPanel selectedPanel){
        try {
            for (JPanel panel : Panels) {
                if (selectedPanel == panel) panel.setVisible(true);
                else panel.setVisible(false);
            }
        }
        catch (Exception e) {
            ErrorHandler.log(e, "Failed on navigate(JPanel selectedPanel). Press Ok to Exit.", true, true);
        }
        
    }
    
    public static void goHome() {
        navigate(pnlHome);
    }
    
    public static void goCategory() {
        pnlCategory.getCategories();
        navigate(pnlCategory);
    }
    
    public static void goQuiz() {
        navigate(pnlQuiz);
    }
    
    public static void goResults() {
        navigate(pnlResults);
    }
    
    public static void goHistory() {
        ResultSet history = dbHandler.retrieveHistory(UserId);
        
        if (history == null){
            return;
        }
        pnlHistory.setHistory(history);
        navigate(pnlHistory);
    }
    
    public static void goStatistics() {
        ResultSet bestPlayers = dbHandler.retrieveTopPlayers();
        ResultSet mostActivePlayers = dbHandler.retrieveMostActivePlayers();
        
        if (bestPlayers == null || mostActivePlayers == null){
            return;
        }
        pnlStatistics.setTables(bestPlayers, mostActivePlayers);
        navigate(pnlStatistics);
    }
    
    public static void goLogin() {
        navigate(pnlLogin);
    }
    
    public static void goRegister() {
        navigate(pnlRegister);
    }
}

