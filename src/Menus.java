import java.util.Scanner;

public class Menus {

    // TODO la sortie des différents menus boucle mal, à analyser

    // Show Main Menu
    public static void getEntryOfMainMenu() {
        String[] arrayChoiceMainMenu = {
                "[1] => Lister les fichiers",
                "[2] => Ajouter un fichier",
                "[3] => Supprimer un fichier",
                "[4] => Afficher des informations sur un livre",
                "[0] => Quitter le programme"
        };
        boolean quit = false;
        Scanner scInput;

        while (!quit) {
//            clearConsole();
            scInput = new Scanner(System.in);
            int choice = getChoiceMenu(arrayChoiceMainMenu, scInput);
            quit = executeFunctions(choice, scInput);
        }

    }

    // Show Menu Informations
    private static void getEntryOfInfoFilesMenu() {
        String[] arrayChoiceInfoFilesMenu = {
                "[1] => Afficher la liste des fichiers",
                "[2] => Choisir un des fichiers",
                "[3] => Afficher le sous menu",
                "[0] => Retour au menu précédent"
        };
        boolean quit = false;
        Scanner scInput;

        while (!quit) {
//            clearConsole();
            scInput = new Scanner(System.in);
            int choice = getChoiceMenu(arrayChoiceInfoFilesMenu, scInput);
            quit = executeFunctions(choice + 40, scInput);
        }
    }

    // Show Sub Menu Informations
    private static void getEntryOfInfoFileMenu() {
        String[] arrayChoiceInfoFileMenu = {
                "[1] => Afficher le nombre de ligne du fichier",
                "[2] => Afficher le nombre de mot du fichier",
                "[0] => Retour au menu précédent"
        };
        boolean quit = false;
        Scanner scInput;

        while (!quit) {
//            clearConsole();
            scInput = new Scanner(System.in);
            int choice = getChoiceMenu(arrayChoiceInfoFileMenu, scInput);
            quit = executeFunctions(choice + 430, scInput);
        }
    }

    private static int getChoiceMenu(String[] entriesMenu, Scanner scInput) {
        boolean noValid = true;
        int entry = 0;

        while (noValid) {
            System.out.println("Choisissez la fonction que vous souhaitez executer");
            for (String menu : entriesMenu) {
                System.out.println(menu);
            }
            System.out.println("Votre choix :");
            try {
                entry = scInput.nextInt();
                noValid = false;
            } catch (Exception e) {
                scInput.nextLine();
                System.out.println("Une erreur est survenue !");
                noValid = true;
            }
        }

        return entry;
    }

    private static boolean executeFunctions(int choice, Scanner scInput) {
        boolean quit = false;
        switch (choice) {
            case 0:     // Quitter le programme
                quit = true;
                break;
            case 1:     //Lister les fichiers
//                getCalculateTVA(scInput);
                break;
            case 2:     // Ajouter un fichier
//                getLeapYear(scInput);
                break;
            case 3:     // Supprimer un fichier
//                getFactorial(scInput);
                break;
            case 4:     // Afficher des informations sur un livre
                getEntryOfInfoFilesMenu();
                break;
            case 40:    // Retour au menu principal
                quit = true;
                getEntryOfMainMenu();
                break;
            case 41:    // Afficher la liste des fichiers
//                getPalindrome(scInput);
                break;
            case 42:    // Choisir un des fichiers
//                getNumberFirst(scInput);
                break;
            case 43:    // Afficher le sous menu
                getEntryOfInfoFileMenu();
                break;
            case 430:   // Retour au sous menu
                quit = true;
                getEntryOfInfoFilesMenu();
                break;
            case 431:   // Afficher le nombre de ligne du fichier
//                getMultiplicationTable(scInput);
                break;
            case 432:   // Afficher le nombre de mot du fichier
//                getMultiplicationTable(scInput);
                break;
            default:

        }
        return quit;
    }
}
