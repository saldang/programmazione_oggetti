package Soluzione240424;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    public String path;

    public Logger(String path) {
        this.path = path;
    }

    public void writeToLogFile(String message){

        try{
            FileWriter fileWriter = new FileWriter(path, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(message);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
