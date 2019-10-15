import java.util.Scanner;

public class Menu {

    // Show Main Menu
    // The variable quit indicates whether to leave the menu
    public static void getEntryOfMainMenu(boolean quit) {
        String[] arrayChoiceMainMenu = {
                "[1] => Lister les fichiers",
                "[2] => Ajouter un fichier",
                "[3] => Supprimer un fichier",
                "[4] => Afficher des informations sur un livre",
                "[0] => Quitter le programme"
        };

        Scanner scInput;

        while (!quit) {
            scInput = new Scanner(System.in);
            int choice = getChoiceMenu(arrayChoiceMainMenu, scInput);
            quit = executeFunctions(choice);
        }
    }

    // Show Menu Information
    // The variable quit indicates whether to leave the menu
    private static void getEntryOfInfoFilesMenu(boolean quit) {
        String[] arrayChoiceInfoFilesMenu = {
                "[1] => Afficher la liste des fichiers",
                "[2] => Choisir un des fichiers",
                "[3] => Afficher le sous menu",
                "[0] => Retour au menu précédent"
        };
        Scanner scInput;

        while (!quit) {
//            clearConsole();
            scInput = new Scanner(System.in);
            int choice = getChoiceMenu(arrayChoiceInfoFilesMenu, scInput);
            quit = executeFunctions(choice + 40);
        }
    }

    // Show Sub Menu Information
    // The variable quit indicates whether to leave the menu
    private static void getEntryOfInfoFileMenu(boolean quit) {
        String[] arrayChoiceInfoFileMenu = {
                "[1] => Afficher le nombre de ligne du fichier",
                "[2] => Afficher le nombre de mot du fichier",
                "[0] => Retour au menu précédent"
        };
        Scanner scInput;

        while (!quit) {
//            clearConsole();
            scInput = new Scanner(System.in);
            int choice = getChoiceMenu(arrayChoiceInfoFileMenu, scInput);
            quit = executeFunctions(choice + 430);
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

    private static boolean executeFunctions(int choice) {
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
                quit = false;
                getEntryOfInfoFilesMenu(quit);
                break;
            case 40:    // Retour au menu principal
                quit = true;
                getEntryOfMainMenu(quit);
                break;
            case 41:    // Afficher la liste des fichiers
//                getPalindrome(scInput);
                break;
            case 42:    // Choisir un des fichiers
//                getNumberFirst(scInput);
                break;
            case 43:    // Afficher le sous menu
                quit = false;
                getEntryOfInfoFileMenu(quit);
                break;
            case 430:   // Retour au sous menu
                quit = true;
                getEntryOfInfoFilesMenu(quit);
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
