import java.io.File;
import java.util.Scanner;

public class Menu {

    // Show Main Menu
    // The variable quit indicates whether to leave the menu
    static void getEntryOfMainMenu(boolean quit, ListFile listOfFiles, Scanner scInput) {
        String[] arrayChoiceMainMenu = {
                "[1] => Lister les fichiers",
                "[2] => Ajouter un fichier",
                "[3] => Supprimer un fichier",
                "[4] => Afficher des informations sur un livre",
                "[0] => Quitter le programme"
        };

        int[] validChoices = {0, 1, 2, 3, 4};

        while (!quit) {
            int choice = getChoiceMenu(arrayChoiceMainMenu, scInput);
            if (isValidChoice(choice, validChoices))
                quit = executeFunctions(choice, listOfFiles, scInput);
        }
    }

    // Show Menu Information
    // The variable quit indicates whether to leave the menu
    private static void getEntryOfInfoFilesMenu(boolean quit, ListFile listOfFiles, Scanner scInput) {
        String[] arrayChoiceInfoFilesMenu = {
                "[1] => Afficher la liste des fichiers",
                "[2] => Choisir un des fichiers",
                "[3] => Afficher le sous menu",
                "[0] => Retour au menu précédent"
        };

        int[] validChoices = {0, 1, 2, 3};

        while (!quit) {
            int choice = getChoiceMenu(arrayChoiceInfoFilesMenu, scInput);
            if (isValidChoice(choice, validChoices))
                quit = executeFunctions(choice + 40, listOfFiles, scInput);
        }
    }

    // Show Sub Menu Information
    // The variable quit indicates whether to leave the menu
    private static void getEntryOfInfoFileMenu(boolean quit, ListFile listOfFiles, Scanner scInput) {
        String[] arrayChoiceInfoFileMenu = {
                "[1] => Afficher le nombre de ligne du fichier",
                "[2] => Afficher le nombre de mot du fichier",
                "[0] => Retour au menu précédent"
        };

        int[] validChoices = {0, 1, 2};

        while (!quit) {
            int choice = getChoiceMenu(arrayChoiceInfoFileMenu, scInput);
            if (isValidChoice(choice, validChoices))
                quit = executeFunctions(choice + 430, listOfFiles, scInput);
        }
    }

    // get Menu List Of Files
    private static String[] getListOfFiles(ListFile listOfFiles) {
        String[] arrayChoiceListOfFilesMenu = new String[listOfFiles.getListOfFiles().length];
        for (int i = 0; i != arrayChoiceListOfFilesMenu.length; ++i) {
            arrayChoiceListOfFilesMenu[i] = "[" + i + "] => " + listOfFiles.getListOfFiles()[i];
        }
        return arrayChoiceListOfFilesMenu;
    }

    // Show Menu List Of Files
    private static void showListOfFiles(String[] arrayChoiceListOfFilesMenu) {
        System.out.println("Liste des fichiers :");
        if (arrayChoiceListOfFilesMenu.length > 0) {
            for (int i = 0; i != arrayChoiceListOfFilesMenu.length; ++i) {
                System.out.println("\t" + arrayChoiceListOfFilesMenu[i]);
            }
        } else {
            System.out.println();
            System.out.println(" La liste de fichier est vide !");
        }
        System.out.println();
    }

    // Show Menu Add File
    private static void showMenuAddFile(boolean quit, ListFile listOfFiles, Scanner scInput) {
        boolean noValid = true;
        String entry = "";
        entry = scInput.nextLine();
        while (noValid || !quit) {
            System.out.println("Veuillez entrer le nom et l'emplacement du fichier à ajouter :");
            try {
                entry = scInput.nextLine();
                File newFile = new File(entry);
                // Si le fichier existe
                if (newFile.exists()) {
                    noValid = false;
                    listOfFiles.addFileToListOfFiles(entry);
                } else {
                    System.out.println("Le fichier " + entry + " n'existe pas, veuillez entrer un nom de fichier existant !");
                }

            } catch (Exception e) {
                scInput.nextLine();
                System.out.println("Une erreur est survenue !");
                noValid = true;
            }
        }
//        return entry;
    }

    // Delete File from list of files
    private static void showMenuDeleteFile(boolean quit, ListFile listOfFiles, Scanner scInput) {
        if (listOfFiles.getNumberOfFiles() > 0) {
            String[] arrayChoiceListOfFilesMenu = getListOfFiles(listOfFiles);

            while (!quit) {
                showListOfFiles(arrayChoiceListOfFilesMenu);
                System.out.println("Quel fichier voulez supprimer de la liste");
                int[] validChoices = new int[listOfFiles.getNumberOfFiles()];
                for (int i = 0; i != validChoices.length; ++i) {
                    validChoices[i] = i;
                }

                int choice = getChoiceMenu(arrayChoiceListOfFilesMenu, scInput);
                if (isValidChoice(choice, validChoices))
                    quit = removeFiles(choice, listOfFiles, scInput);
            }
        } else {
            System.out.println();
            System.out.println("La liste de fichiers est vide, vous ne pouvez donc pas supprimer un fichier !");
            System.out.println();
        }

    }

    private static int getChoiceMenu(String[] entriesMenu, Scanner scInput) {
        boolean noValid = true;
        int entry = 0;

        while (noValid) {
            System.out.println("Choisissez parmi la liste suivante :");
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

    private static boolean isValidChoice(int choice, int[] validChoices) {
        boolean flagNoValid = false;

        for (int validChoice : validChoices) {
            if (choice == validChoice) {
                flagNoValid = true;
            }
        }
        return flagNoValid;
    }

    private static boolean removeFiles(int choice, ListFile listOfFiles, Scanner scInput) {
        listOfFiles.deleteFileFromListOfFiles(choice);
        return true;
    }

    private static boolean executeFunctions(int choice, ListFile listOfFiles, Scanner scInput) {
        boolean quit = false;
        switch (choice) {
            case 0:     // Quitter le programme
                quit = true;
                break;
            case 1:     //Lister les fichiers
            case 41:
                showListOfFiles(getListOfFiles(listOfFiles));
                break;
            case 2:     // Ajouter un fichier
                quit = true;
                showMenuAddFile(quit, listOfFiles, scInput);
                quit = false;
                break;
            case 3:     // Supprimer un fichier
                showMenuDeleteFile(quit, listOfFiles, scInput);
                quit = false;
                break;
            case 4:     // Afficher des informations sur un livre
                quit = false;
                getEntryOfInfoFilesMenu(quit, listOfFiles, scInput);
                break;
            case 40:    // Retour au menu principal
                quit = true;
                getEntryOfMainMenu(quit, listOfFiles, scInput);
                break;
            case 42:    // Choisir un des fichiers
//                getNumberFirst(scInput);
                break;
            case 43:    // Afficher le sous menu
                quit = false;
                getEntryOfInfoFileMenu(quit, listOfFiles, scInput);
                break;
            case 430:   // Retour au sous menu
                quit = true;
                getEntryOfInfoFilesMenu(quit, listOfFiles, scInput);
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
