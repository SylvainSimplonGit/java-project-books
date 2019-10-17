import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Book {
    // --------------------------------------------------------------
    //      Declare attributes
    // --------------------------------------------------------------
    private int numberOfDifferentWord;
    private int numberOfTotalWord;
    private String filename;
    private ArrayList<Word> words;

    // --------------------------------------------------------------
    //      Constructor
    // --------------------------------------------------------------
    public Book(String pathFileName) {
        this.filename = pathFileName;
        readFileToArrayList(pathFileName);
    }

    // --------------------------------------------------------------
    //      Getters
    // --------------------------------------------------------------
    // Get the filename of the book
    String getFilename() {
        return this.filename;
    }

    // Get the number of different words in a book
    int getNumberOfTotalWord() {
        return this.numberOfTotalWord;
    }

    // Get the number of different words in a book
    int getNumberOfDifferentWord() {
        return this.numberOfDifferentWord;
    }

    // Get a list of words in the book sorted by number of occurrences
    ArrayList<Word> getArrayListOfWordsSorted() {
        ArrayList<Word> wordsSorted = new ArrayList<>();
        for (int i = 0; i != this.words.size(); ++i) {
            wordsSorted.add(i, this.words.get(i));
        }
        Collections.sort(wordsSorted);
        return wordsSorted;
    }

    // --------------------------------------------------------------
    //      Internal Methods
    // --------------------------------------------------------------

    // Read file and return a HashMap contains different word in file
    private void readFileToArrayList(String nameFile) {
        int numberTotalWord = 0;
        this.words = new ArrayList<>();

        try (Scanner scFile = new Scanner(new File(nameFile))) {
            while (scFile.hasNextLine()) {
                // Read each line of file
                String word = scFile.nextLine();
                // If the line isn't empty
                if (word.length() > 0) {
                    Word wordObject = new Word(word);
                    ++numberTotalWord;
                    // If the word is already in the list, get number of times the word is seen, if not, get zero
                    if (words.size() > 0 && words.contains(wordObject)) {
                        int index = words.indexOf(wordObject);
                        words.get(index).setNumberSeen(words.get(index).getNumberSeen() + 1, numberTotalWord);
                    } else {
                        words.add(wordObject);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Une erreur est survenue !\n" + e.getLocalizedMessage());
        }
        this.numberOfDifferentWord = words.size();
        this.numberOfTotalWord = numberTotalWord;
    }

}
