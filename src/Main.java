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
        listOfFiles = new ListFile(args);

        // Display menus
        Menu menu = new Menu();
        menu.getEntryOfMainMenu(false, listOfFiles, scInput);

        System.out.println("Fin de Programme");

    }

}
