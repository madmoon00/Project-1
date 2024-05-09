/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package nyc.nyctrivia;

import nyc.nyctrivia.Controllers.SQLiteHandler;
import nyc.nyctrivia.Panels.Login;
import nyc.nyctrivia.MainFrame;

/**
 *
 * @author panvo
 */
public class NYCTrivia {
    private static SQLiteHandler dbHandler = new SQLiteHandler();
    public static MainFrame mFrame;
    public static void main(String[] args) {
        
        mFrame = new MainFrame();
        mFrame.setVisible(true);
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
        }
        
        return userId;
    }
    
    private static int UserId;
    public static String Username;
}

