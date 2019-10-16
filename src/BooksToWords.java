import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BooksToWords {

    public static void main(String[] args)throws FileNotFoundException {
        Pattern p = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS);
        try(Scanner sc = new Scanner(new File(args[0]));
            PrintStream fileOut = new PrintStream(new FileOutputStream(args[1]))){
            for(int i=0; sc.hasNextLine(); ++i){
                for(Matcher m1 = p.matcher(sc.nextLine()); m1.find();) {
                    fileOut.println(m1.group().toLowerCase());
                }
            }
        }
    }
}
