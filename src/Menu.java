import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    private static Book bookChosen;

    /**
     * Display the Main menu
     *
     * @param quit          : The variable quit indicates whether to leave the menu
     * @param listOfFiles   : Object ListFile
     * @param scInput       : Object Scanner
     */
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

    /**
     * Display Menu Information
     *
     * @param quit          : The variable quit indicates whether to leave the menu
     * @param listOfFiles   : Object ListFile
     * @param scInput       : Object Scanner
     */
    private static void getEntryOfInfoFilesMenu(boolean quit, ListFile listOfFiles, Scanner scInput) {
        String[] arrayChoiceInfoFilesMenu = {
                "[1] => Afficher la liste des fichiers",
                "[2] => Choisir un des fichiers",
                "[3] => Afficher le fichier sélectionné",
                "[4] => Afficher le sous menu",
                "[0] => Retour au menu précédent"
        };

        int[] validChoices = {0, 1, 2, 3, 4};

        while (!quit) {
            int choice = getChoiceMenu(arrayChoiceInfoFilesMenu, scInput);
            if (isValidChoice(choice, validChoices))
                quit = executeFunctions(choice + 40, listOfFiles, scInput);
        }
    }

    /**
     * Display Sub Menu Information
     *
     * @param quit          : The variable quit indicates whether to leave the menu
     * @param listOfFiles   : Object ListFile
     * @param scInput       : Object Scanner
     */
    private static void getEntryOfInfoFileMenu(boolean quit, ListFile listOfFiles, Scanner scInput) {
        String[] arrayChoiceInfoFileMenu = {
                "[1] => Afficher le fichier sélectionné",
                "[2] => Afficher le nombre de ligne du fichier",
                "[3] => Afficher le nombre de mot unique du fichier",
                "[4] => Afficher les 50 premiers mots le plus souvent utilisés dans le fichier",
                "[5] => Afficher les mots qui sont uniquement dans le fichier selectionné",
                "[6] => Afficher les pourcentages de mots communs avec le fichier selectionné",
                "[0] => Retour au menu précédent"
        };

        int[] validChoices = {0, 1, 2, 3, 4, 5, 6};

        while (!quit) {
            int choice = getChoiceMenu(arrayChoiceInfoFileMenu, scInput);
            if (isValidChoice(choice, validChoices))
                quit = executeFunctions(choice + 430, listOfFiles, scInput);
        }
    }

    private static String[] getListOfFilesInFolderClean(ListFile listOfFiles) {
        return getListOfFilesWithIndex(listOfFiles.getListOfFileInFolder());
    }

    /**
     * Get a formatted files list to display
     *
     * @param listOfFiles   : Object ListFile
     * @return              : an Array that contains each filename in the managed file list
     */
    private static String[] getListOfFiles(ListFile listOfFiles) {
        return getListOfFilesWithIndex(listOfFiles.getListOfFiles());
    }

    /**
     * Get a list of files with an index at start of line
     *
     * @param arrayOfFiles  :
     * @return              : a list of string which start by index and add the file
     */
    private static String[] getListOfFilesWithIndex(String[] arrayOfFiles) {
        String[] arrayOfFilesResult;
        if (arrayOfFiles.length > 0) {
            arrayOfFilesResult = new String[arrayOfFiles.length];
            for (int i = 0; i != arrayOfFiles.length; ++i) {
                arrayOfFilesResult[i] = "[" + i + "] => " + arrayOfFiles[i];
            }
        } else {
            arrayOfFilesResult = new String[0];
        }
        return arrayOfFilesResult;
    }

    /**
     * Display managed file list
     *
     * @param arrayChoiceListOfFilesMenu    : array that contains each filename in the managed file list
     */
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

    /**
     * Display menu add file in managed file list
     *
     * @param quit          : The variable quit indicates whether to leave the menu
     * @param listOfFiles   : Object ListFile
     * @param scInput       : Object Scanner
     */
    private static void showMenuAddFile(boolean quit, ListFile listOfFiles, Scanner scInput) {
        if (listOfFiles.getListOfFileInFolder().length > 0) {
            String[] arrayChoiceListOfFilesMenu = getListOfFilesInFolderClean(listOfFiles);

            while (!quit) {
                System.out.println("Quel fichier voulez ajouter à la liste");
                int[] validChoices = new int[listOfFiles.getListOfFileInFolder().length];
                for (int i = 0; i != validChoices.length; ++i) {
                    validChoices[i] = i;
                }

                int choice = getChoiceMenu(arrayChoiceListOfFilesMenu, scInput);
                if (isValidChoice(choice, validChoices)) {
                    if (!listOfFiles.isFileExistInList(listOfFiles.getListOfFileInFolder()[choice])) {
                        listOfFiles.addFileToListOfFiles(listOfFiles.getListOfFileInFolder()[choice]);
                        quit = true;
                    } else {
                        System.out.println("Le fichier choisi existe déjà dans la liste !");
                        System.out.println();
                    }
                } else {
                    System.out.println("Choix de fichier non valide, veuillez choisir dans la liste !");
                    System.out.println();
                }
            }
        } else {
            System.out.println();
            System.out.println("La liste de fichiers est vide, vous ne pouvez donc pas ajouter un fichier !");
            System.out.println();
        }
    }

    /**
     * Display menu delete file from managed file list
     *
     * @param quit          : The variable quit indicates whether to leave the menu
     * @param listOfFiles   : Object ListFile
     * @param scInput       : Object Scanner
     */
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
                if (isValidChoice(choice, validChoices)) {
                    quit = removeFile(choice, listOfFiles);
                } else {
                    System.out.println("Choix de fichier non valide, veuillez choisir dans la liste !");
                }
            }
        } else {
            System.out.println();
            System.out.println("La liste de fichiers est vide, vous ne pouvez donc pas supprimer un fichier !");
            System.out.println();
        }
    }

    /**
     * Remove file from managed file list
     *
     * @param choice        : index of the file selected for deletion
     * @param listOfFiles   : Object ListFile
     * @return              : true to go back to the previous menu
     */
    private static boolean removeFile(int choice, ListFile listOfFiles) {
        listOfFiles.deleteFileFromListOfFiles(choice);
        return true;
    }

    /**
     * Display menu to choose a file in managed file list
     *
     * @param quit          : The variable quit indicates whether to leave the menu
     * @param listOfFiles   : Object ListFile
     * @param scInput       : Object Scanner
     */
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
                if (isValidChoice(choice, validChoices)) {
                    quit = chooseFile(choice, listOfFiles);
                } else {
                    System.out.println("Choix de fichier non valide, veuillez choisir dans la liste !");
                }
            }
        } else {
            System.out.println();
            System.out.println("La liste de fichiers est vide, vous ne pouvez donc pas avoir d'informations sur un fichier !");
            System.out.println();
        }
    }

    /**
     * Choose a file from the managed file list
     *
     * @param choice        : index of the file selected
     * @param listOfFiles   : Object ListFile
     * @return              : true to go back to the previous menu
     */
    private static boolean chooseFile(int choice, ListFile listOfFiles) {
        listOfFiles.setChosenFile(choice);
        bookChosen = new Book(listOfFiles.getPathOfChosenFile());
        return true;
    }

    /**
     * Display the number of line in chosen file
     *
     * @param listOfFiles   : Object ListFile
     * @return              : the number of line in the chosen file
     */
    private static boolean showNumberOfLinesOfChosenFile(ListFile listOfFiles) {
        System.out.println("Le fichier " + listOfFiles.getPathOfChosenFile() + " contient " + bookChosen.getNumberOfTotalWord() + " ligne(s)");
        System.out.println();
        return false;
    }

    /**
     * Display the number of different words in chosen file
     *
     * @param listOfFiles   : Object ListFile
     * @return              : the number of different words in the chosen file
     */
    private static boolean showNumberOfDifferentsWordsOfChosenFile(ListFile listOfFiles) {
        System.out.println("Le fichier " + listOfFiles.getPathOfChosenFile() + " contient " + bookChosen.getNumberOfDifferentWord() + " mot(s) différent(s)");
        System.out.println();
        return false;
    }

    /**
     * Display the most used words in the chosen file
     *
     * @param numbers       : the number of word to display
     * @param listOfFiles   : Object ListFile
     * @return              : true to go back to the previous menu
     */
    private static boolean showMostUsedWords(int numbers, ListFile listOfFiles) {
        ArrayList wordsSorted = bookChosen.getArrayListOfWordsSorted();
        System.out.println("Les " + numbers + " premiers mots les plus utilisés du fichier " + listOfFiles.getPathOfChosenFile() + " sont :");
        for (int i = 0; i != numbers; ++i) {
            Word wordSorted = (Word) wordsSorted.get(i);
            System.out.println("(" + wordSorted.getNumberSeen() + ")\t" + wordSorted.getWord());
        }
        System.out.println();
        return false;
    }

    /**
     * Display words only seen in the chosen file
     *
     * @param listOfFiles   : Object ListFile
     * @return              : false to stay into the menu
     */
    private static boolean showWordsOnlyInFile(ListFile listOfFiles) {
        Book[] books = new Book[listOfFiles.getNumberOfFiles() - 1];
        int j = 0;
        for (int i = 0; i != listOfFiles.getNumberOfFiles(); ++i) {
            // Si le fichier choisi et égale au fichier courant ne pas insérer dans le tableau
            if (listOfFiles.getPathOfFileByIndex(i) != bookChosen.getFilename()) {
                Book book = new Book(listOfFiles.getPathOfFileByIndex(i));
                books[j] = book;
                ++j;
            }
        }
        ArrayList<Word> listWordsOfChosenFile = bookChosen.getArrayListOfWordsSorted();
        for (Word word : listWordsOfChosenFile) {
            boolean flagSeen = false;
            int indexFileSave = 0;
            for (int indexFile = 0; indexFile != books.length; ++indexFile) {
                if (books[indexFile].getArrayListOfWordsSorted().contains(word)) {
                    flagSeen = true;
                    indexFileSave = indexFile;
                    break;
                }
            }
            if (!flagSeen) {
                System.out.println(word.getWord());
                String filenameBookChosenShort = "ressources/extracts/" + bookChosen.getFilename().substring(bookChosen.getFilename().lastIndexOf("/") + 1);

                Debug.writeMessageInFile(filenameBookChosenShort, word.getWord());
            }
        }
        System.out.println();
        return false;
    }

    /**
     * Display chosen file
     *
     * @param listOfFiles   : Object ListFile
     */
    private static void showChosenFile(ListFile listOfFiles) {
        if (listOfFiles.hasChosenFile()) {
            System.out.println("Le fichier sélectionné : ");
            System.out.println(bookChosen.getFilename());
        } else {
            System.out.println("Pas encore de fichiers sélectionné !");
        }
        System.out.println();
    }

    /**
     * Display Percentage of appearance of words
     *
     * @param listOfFiles   : Object ListFile
     */
    private static void showPercentOfWords(ListFile listOfFiles) {
        if (listOfFiles.hasChosenFile()) {
            for (int i = 0; i != listOfFiles.getNumberOfFiles(); ++i) {
                if (!listOfFiles.getPathOfFileByIndex(i).equals(bookChosen.getFilename())) {
                    Book book = new Book(listOfFiles.getPathOfFileByIndex(i));
                    ArrayList<Word> arrayListBook = book.getArrayListOfWordsSorted();
                    ArrayList<Word> arrayListChosenBook = bookChosen.getArrayListOfWordsSorted();

                    int countOfCommonWordInBook = getCountOfCommonWords(arrayListBook, arrayListChosenBook);

                    float percentOfWords = calculatePercent(countOfCommonWordInBook, bookChosen.getNumberOfDifferentWord());
                    System.out.println(String.format("%.2f", percentOfWords) + " % des mots du fichier " + listOfFiles.getPathOfFileByIndex(i) + " sont dans le fichier de référence " + bookChosen.getFilename());
                }
            }
        } else {
            System.out.println("Pas encore de fichiers sélectionné !");
        }
        System.out.println();
    }

    /**
     * Calculate the percentage
     *
     * @param value         : the number of element
     * @param valueMax      : the number max of element
     * @return              : the percentage of value compared to valueMax
     */
    private static float calculatePercent(int value, int valueMax) {
        return (float)( 100 * value ) / valueMax;
    }

    /**
     * Get the count of common word between two list of Words
     *
     * @param listOfWordA   : list of word to test
     * @param listOfWordB   : list of word to test
     * @return              : count of common words
     */
    private static int getCountOfCommonWords(ArrayList<Word> listOfWordA, ArrayList<Word> listOfWordB) {
        int countOfCommonWords = 0;
        ArrayList<Word> listOfWordMin = (listOfWordA.size() < listOfWordB.size()) ? listOfWordA : listOfWordB;
        for (Word word : listOfWordMin) {
            if (listOfWordB.contains(word))
                ++countOfCommonWords;
        }
        return countOfCommonWords;
    }

    /**
     * Display the menu and get the type input
     *
     * @param entriesMenu   : array of possible entries in menu
     * @param scInput       : Object Scanner
     * @return              : choice of the user
     */
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

    /**
     * Check if choice is in validChoice list
     *
     * @param choice        : choice of the user
     * @param validChoices  : array of valid choices
     * @return              : true if the choice of user is valid other false
     */
    private static boolean isValidChoice(int choice, int[] validChoices) {
        boolean flagNoValid = false;

        for (int validChoice : validChoices) {
            if (choice == validChoice) {
                flagNoValid = true;
                break;
            }
        }
        return flagNoValid;
    }

    /**
     * Execute the function according to the choice
     *
     * @param choice        : choice of the user
     * @param listOfFiles   : Object ListFile
     * @param scInput       : Object Scanner
     * @return              : true to go back to the previous menu, false to keep in the current menu
     */
    private static boolean executeFunctions(int choice, ListFile listOfFiles, Scanner scInput) {
        // the variable quit makes it possible to know if it is necessary to leave or not of the following menu
        boolean quit = false;
        switch (choice) {
            case 0:     // Quitter le programme
                quit = true;
                break;
            case 1:     //Lister les fichiers du répertoire clean
                showListOfFiles(getListOfFilesInFolderClean(listOfFiles));
                break;
            case 2:     // Ajouter un fichier
//                quit = true;
                showMenuAddFile(quit, listOfFiles, scInput);
//                quit = false;
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
            case 41:    //Lister les fichiers
                showListOfFiles(getListOfFiles(listOfFiles));
                break;
            case 42:    // Choisir un des fichiers
                showMenuChooseFile(quit, listOfFiles, scInput);
                quit = false;
                break;
            case 43:    // Afficher le fichier sélectionné
            case 431:   // Afficher le fichier sélectionné
                showChosenFile(listOfFiles);
                break;
            case 44:    // Afficher le sous menu
                if (listOfFiles.hasChosenFile()) {
                    quit = false;
                    getEntryOfInfoFileMenu(quit, listOfFiles, scInput);
                } else {
                    System.out.println("Pas de fichier sélectionné !");
                    System.out.println();
                }
                break;
            case 430:   // Retour au sous menu
                quit = true;
                getEntryOfInfoFilesMenu(quit, listOfFiles, scInput);
                break;
            case 432:   // Afficher le nombre de ligne du fichier
                showNumberOfLinesOfChosenFile(listOfFiles);
                break;
            case 433:   // Afficher le nombre de mot du fichier
                showNumberOfDifferentsWordsOfChosenFile(listOfFiles);
                break;
            case 434:   // Afficher les 50 premiers mots les plus utilisés du fichier
                int numbers = 50;
                showMostUsedWords(numbers, listOfFiles);
                break;
            case 435:   // Afficher les mots uniquement dans ce fichier
                showWordsOnlyInFile(listOfFiles);
                break;
            case 436:   // Afficher les pourcentage d'apparition des mots
                showPercentOfWords(listOfFiles);
                break;
            default:

        }
        return quit;
    }

}
