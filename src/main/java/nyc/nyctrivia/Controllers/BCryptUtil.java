package nyc.nyctrivia.Controllers;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptUtil {
    
    // Method to encrypt a password using BCrypt
    public static String encrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
    
    // Method to compare a plain password with its hashed version
    public static boolean compare(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
