import java.io.*;

public class Debug {
    private static void showTrace(String function, String message) {
        System.out.println("[" + function + "] => " + message);
    }

    static void writeMessageInFile(String filename, String message) {
        try (PrintStream fileOut = new PrintStream(new FileOutputStream(filename, true))) {
            fileOut.println(message);

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
