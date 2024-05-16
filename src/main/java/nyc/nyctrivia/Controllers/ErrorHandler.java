package nyc.nyctrivia.Controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.swing.JOptionPane;

public class ErrorHandler {
    private static PrintWriter writer;
    
    public ErrorHandler() {
        try {
            File file = new File("error.log");
            if(!file.exists()) {
                file.createNewFile();
            }
            writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
        } catch (IOException e) {
            System.out.println("Cannot create or open error.log file");
            System.exit(1);
        }
    }
    
    public static void log(Exception e, String message, boolean inform, boolean exit) {
        String errLine = new Date() + " || " + e.toString() + " || " + message;
        
        writer.write(errLine);
        writer.println();
        writer.flush();
        
        if (inform) JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.INFORMATION_MESSAGE);
        if (exit) System.exit(-1);
    }
}

    

