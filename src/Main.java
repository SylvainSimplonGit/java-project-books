import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Declaration of Variables
        ListFile listOfFiles;
        Scanner scInput;

        // Instantiation of the Scanner used throughout the program
        scInput = new Scanner(System.in);

        System.out.println("Début de Programme");
        System.out.println();

        // Instantiation of the list of files from the arguments received
        listOfFiles = setListOfFiles(args);

        // Display menus
        Menu.getEntryOfMainMenu(false, listOfFiles, scInput);




        // Test of new instantiation of Book Object
//        Book bookMots = new Book(args[0]);
//        System.out.println("Il y a " + bookMots.getNumberOfDifferentWord() + " mots différents dans " + args[0]);

        System.out.println("Fin de Programme");

    }

    private static ListFile setListOfFiles(String[] listOfArgs) {
        return new ListFile(listOfArgs);
    }

}
