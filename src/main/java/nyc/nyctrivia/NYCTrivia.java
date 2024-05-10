/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package nyc.nyctrivia;

import nyc.nyctrivia.Controllers.SQLiteHandler;
import nyc.nyctrivia.Panels.Login;
import nyc.nyctrivia.Panels.Home;
import nyc.nyctrivia.Panels.Register;

/**
 *
 * @author panvo
 */
public class NYCTrivia {
    private static SQLiteHandler dbHandler;
    
    public static void main(String[] args) {
        dbHandler = new SQLiteHandler();
        initComponents();
        goLogin();
    }
    
    public static boolean doesUsernameExist(String username) {
        boolean check = dbHandler.doesUsernameExist(username);
        
        return check;
    }
    
    public static void addUser(String username, String password) {
        dbHandler.addUser(username, password);
    }
    
    public static int checkCredentials(String username, String password) {
        int userId = dbHandler.checkCredentials(username, password);
        
        if (userId >= 0) {
            UserId = userId;
            Username = dbHandler.getNameById(userId);
            goHome();
        }
        
        return userId;
    }
    
    private static void initComponents() {
        pnlHome = new Home();
        pnlLogin = new Login();
        pnlRegister = new Register();
        mFrame = new MainFrame();
        
        mFrame.getContentPane().add(pnlHome);
        mFrame.getContentPane().add(pnlLogin);
        mFrame.getContentPane().add(pnlRegister);
        mFrame.pack();
        mFrame.setVisible(true);
    }
    
    private static void goHome() {
        pnlHome.setVisible(true);
        pnlLogin.setVisible(false);
        pnlRegister.setVisible(false);
    }
    
    public static void goLogin() {
        pnlHome.setVisible(false);
        pnlLogin.setVisible(true);
        pnlRegister.setVisible(false);
    }
    
    public static void goRegister() {
        pnlHome.setVisible(false);
        pnlLogin.setVisible(false);
        pnlRegister.setVisible(true);
    }
    
    //Declare Components
    private static Home pnlHome;
    private static Login pnlLogin;
    private static Register pnlRegister;
    private static MainFrame mFrame;
    
    private static int UserId;
    public static String Username;
}

