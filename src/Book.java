import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Book {
    // --------------------------------------------------------------
    //      Declare attributes
    // --------------------------------------------------------------
    //    private int numberOfWord;
    private int numberOfDifferentWord;
    private String filename;

    // --------------------------------------------------------------
    //      Constructor
    // --------------------------------------------------------------
    public Book(String pathFileName) {
        filename = pathFileName;
        numberOfDifferentWord = calculateNumberOfDifferentWord();

    }

    // --------------------------------------------------------------
    //      Getters
    // --------------------------------------------------------------
    // Get the number of different words in a book
    public int getNumberOfDifferentWord() {
        return numberOfDifferentWord;
    }

    // Get a list of words in the book sorted by number of occurrences

    // --------------------------------------------------------------
    //      Internal Methods
    // --------------------------------------------------------------

    // Find the number of different word in file
    private int calculateNumberOfDifferentWord() {
        // Read file this.filename
        HashMap listWords = readFileToArrayList(this.filename);
        // Count the number of different words
        return listWords.size();
    }

    // Read file and return a HashMap contains different word in file
    private static HashMap readFileToArrayList(String nameFile) {
        HashMap<String, Integer> listWords = new HashMap<>();
        int numberWord = 0;
        try (Scanner scFile = new Scanner(new File(nameFile))) {
            for (int i = 0; (scFile.hasNextLine()); ++i) {
                // Read each line of file
                String word = scFile.nextLine();
                // If the line isn't empty
                if (word.length() > 0) {
                    // If the word is already in the list, get number of times the word is seen, if not, get zero
                    numberWord = (listWords.get(word) != null) ? listWords.get(word) : 0;
                    // For each word, increment its value
                    listWords.put(word, numberWord + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Une erreur est survenue !\n" + e.getLocalizedMessage());
        }
        return listWords;
    }

    // Find a list of words sorted by number of times the word is seen


}
