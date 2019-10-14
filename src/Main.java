import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        System.out.println("Début de Programme");

        // Display menus
        Menus.getEntryOfMainMenu();

        // Test of new instantiation of Book Object
        Book bookMots = new Book(args[0]);
        System.out.println("Il y a " + bookMots.getNumberOfDifferentWord() + " mots différents dans " + args[0]);

        System.out.println("Fin de Programme");

    }


//    private static ArrayList getListOfValidFile(String listOfFile) {
        // Foreach entry of listOfFile, verify if entry is a existed file

//    }



}
