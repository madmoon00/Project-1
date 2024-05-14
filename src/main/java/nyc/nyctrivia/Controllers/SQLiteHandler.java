package nyc.nyctrivia.Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class SQLiteHandler {
    private Connection connection;

    public SQLiteHandler() {
        String dbFile = "jdbc:sqlite:trivia.db";

        try {
            connection = DriverManager.getConnection(dbFile);
            System.out.println("Connection established.");
            
            // Create tables if not exists
            createTables();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error connecting to database", "Error", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    private void createTables() throws SQLException {
        try {
            String sqlCreateUsers = """
                            CREATE TABLE IF NOT EXISTS users (
                                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                                username TEXT NOT NULL,
                                password TEXT NOT NULL UNIQUE
                            );
                         """;
            
            String sqlCreateScores = """
                            CREATE TABLE IF NOT EXISTS scores (
                                id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                                userId INTEGER NOT NULL,
                                date DATETIME,
                                score INTEGER NOT NULL,
                                FOREIGN KEY (userId) REFERENCES users(id)
                            );
                         """;

            // Create a PreparedStatement object
            PreparedStatement statement = connection.prepareStatement(sqlCreateUsers);
            
            // Execute the SQL statement to create the users table
            statement.execute();
            
            // Prepare the statement for creating scores table
            statement = connection.prepareStatement(sqlCreateScores);
            
            // Execute the SQL statement to create the scores table
            statement.execute();

        } catch (SQLException e) {
            throw e;
        }
    }
    
    public void addUser(String username, String password) {
        try {
            // SQL statement to insert a new user
            String sqlInsertUser = "INSERT INTO users (username, password) VALUES (?, ?)";
            
            // Prepare the statement
            PreparedStatement statement = connection.prepareStatement(sqlInsertUser);
            
            String hashedPassword = BCryptUtil.encrypt(password);
            
            // Set the parameters
            statement.setString(1, username);
            statement.setString(2, hashedPassword);
            
            // Execute the SQL statement to insert the user
            statement.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed register.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void addScore(int userId, int score) {
        try {
            // Get the current datetime
            LocalDateTime currentDateTime = LocalDateTime.now();

            // Format the datetime as a string using a formatter
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = currentDateTime.format(formatter);
            
            // SQL statement to insert a new score
            String sqlInsertScore = "INSERT INTO scores (userId, date, score) VALUES (?, ?, ?)";
            
            // Prepare the statement
            PreparedStatement statement = connection.prepareStatement(sqlInsertScore);
            
            // Set the parameters
            statement.setInt(1, userId);
            statement.setString(2, formattedDateTime);
            statement.setInt(3, score);
            
            // Execute the SQL statement to insert the user
            statement.executeUpdate();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed register.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public boolean doesUsernameExist(String username) {
        boolean exists = false;
        
        try {
            String query = "SELECT COUNT(*) AS count FROM users WHERE username COLLATE NOCASE = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                exists = count > 0;
            }
            
        } catch (SQLException e) {
            System.err.println("Error adding user: " + e.getMessage());
        }
        
        return exists;
    }
    
    public int checkCredentials(String username, String password) {
        try {
            // Check if username exists and get hashed password and user ID
            String query = "SELECT id, password FROM users WHERE username COLLATE NOCASE = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String hashedPassword = resultSet.getString("password");
                
                // Compare passwords
                if (BCryptUtil.compare(password, hashedPassword)) {
                    // Passwords match, return user ID
                    return userId;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            return -1;
        }
        
        return -1;
    }

    public String getNameById(int userId) {
        try {
            // Query to fetch the name of the user by ID
            String query = "SELECT username FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                // Return the username if the user with the given ID exists
                return resultSet.getString("username");
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Return null if user with the given ID does not exist
        return null;
    }
}
