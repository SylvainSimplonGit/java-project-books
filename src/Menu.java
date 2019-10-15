import java.io.File;
import java.util.Scanner;

public class Menu {

    // Display Main Menu
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

    // Display Menu Information
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

    // Display Sub Menu Information
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

    // Get a formatted files list to display
    private static String[] getListOfFiles(ListFile listOfFiles) {
        String[] arrayChoiceListOfFilesMenu = new String[listOfFiles.getListOfFiles().length];
        for (int i = 0; i != arrayChoiceListOfFilesMenu.length; ++i) {
            arrayChoiceListOfFilesMenu[i] = "[" + i + "] => " + listOfFiles.getListOfFiles()[i];
        }
        return arrayChoiceListOfFilesMenu;
    }

    // Display files list
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

    // Display menu add file in files list
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

    // Display menu delete file from files list
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
                    quit = removeFile(choice, listOfFiles);
            }
        } else {
            System.out.println();
            System.out.println("La liste de fichiers est vide, vous ne pouvez donc pas supprimer un fichier !");
            System.out.println();
        }
    }

    // Remove file from files list
    private static boolean removeFile(int choice, ListFile listOfFiles) {
        listOfFiles.deleteFileFromListOfFiles(choice);
        return true;
    }

    // Display menu to choose a file in files list
    private static void showMenuChooseFile(boolean quit, ListFile listOfFiles, Scanner scInput) {
        if (listOfFiles.getNumberOfFiles() > 0) {
            String[] arrayChoiceListOfFilesMenu = getListOfFiles(listOfFiles);

            while (!quit) {
                showListOfFiles(arrayChoiceListOfFilesMenu);
                System.out.println("Sur quel fichier voulez-vous travailler");
                int[] validChoices = new int[listOfFiles.getNumberOfFiles()];
                for (int i = 0; i != validChoices.length; ++i) {
                    validChoices[i] = i;
                }

                int choice = getChoiceMenu(arrayChoiceListOfFilesMenu, scInput);
                if (isValidChoice(choice, validChoices))
                    quit = chooseFile(choice, listOfFiles);
            }
        } else {
            System.out.println();
            System.out.println("La liste de fichiers est vide, vous ne pouvez donc pas avoir d'informations sur un fichier !");
            System.out.println();
        }
    }

    // Choose a file from the files list
    private static boolean chooseFile(int choice, ListFile listOfFiles) {
        listOfFiles.setChosenFile(choice);
        return true;
    }

    // Display the number of line in chosen file
    private static boolean showNumberOfLinesOfChosenFile(ListFile listOfFiles) {
        Book book = new Book(listOfFiles.getPathOfChosenFile());
        System.out.println("Le fichier " + listOfFiles.getPathOfChosenFile() + " contient " + book.getNumberOfTotalWord() + " ligne(s)");
        return false;
    }

    // Display the number of line in chosen file
    private static boolean showNumberOfDifferentsWordsOfChosenFile(ListFile listOfFiles) {
        Book book = new Book(listOfFiles.getPathOfChosenFile());
        System.out.println("Le fichier " + listOfFiles.getPathOfChosenFile() + " contient " + book.getNumberOfDifferentWord() + " mot(s) différent(s)");
        return false;
    }

    // Display the menu and get the type input
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

    // Check if choice is in validChoice list
    private static boolean isValidChoice(int choice, int[] validChoices) {
        boolean flagNoValid = false;

        for (int validChoice : validChoices) {
            if (choice == validChoice) {
                flagNoValid = true;
            }
        }
        return flagNoValid;
    }

    // Execute the function according to the choice
    private static boolean executeFunctions(int choice, ListFile listOfFiles, Scanner scInput) {
        // the variable quit makes it possible to know if it is necessary to leave or not of the following menu
        boolean quit = false;
        switch (choice) {
            case 0:     // Quitter le programme
                quit = true;
                break;
            case 1:     //Lister les fichiers
            case 41:    //Lister les fichiers
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
                showMenuChooseFile(quit, listOfFiles, scInput);
                quit = false;
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
                showNumberOfLinesOfChosenFile(listOfFiles);
                break;
            case 432:   // Afficher le nombre de mot du fichier
                showNumberOfDifferentsWordsOfChosenFile(listOfFiles);
                break;
            default:

        }
        return quit;
    }

}
