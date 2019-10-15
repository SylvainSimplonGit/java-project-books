import java.util.Scanner;

public class Main {

//    private ListFile listOfFiles;

    public static void main(String[] args) {
        ListFile listOfFiles;
        Scanner scInput;
        scInput = new Scanner(System.in);

        System.out.println("Début de Programme");

        listOfFiles = setListOfFiles(args);

        // Display menus
        Menu.getEntryOfMainMenu(false, listOfFiles, scInput);




        // Test of new instantiation of Book Object
//        Book bookMots = new Book(args[0]);
//        System.out.println("Il y a " + bookMots.getNumberOfDifferentWord() + " mots différents dans " + args[0]);

        System.out.println("Fin de Programme");

    }


//    private static ArrayList getListOfValidFile(String listOfFile) {
        // Foreach entry of listOfFile, verify if entry is a existed file

//    }

    private static ListFile setListOfFiles(String[] listOfArgs) {
        return new ListFile(listOfArgs);
    }



}
