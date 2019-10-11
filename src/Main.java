import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Début de récupération");
        HashMap listWords = readFileToArrayList("ressources/books/mots.txt");
        System.out.println("Il y a " + listWords.size() + " mots différents dans " + "ressources/books/mots.txt");
        System.out.println("Fin de récupération");
    }

    private static HashMap readFileToArrayList(String nameFile) {
        HashMap<String, Integer> listWords = new HashMap<>();
        int numberWord = 0;
        try (Scanner scFile = new Scanner(new File(nameFile))) {
            for (int i = 0; (scFile.hasNextLine()); ++i) {
                // Pour chaque mot, incrémenter sa valeur
                String word = scFile.nextLine();
                if (word.length() > 0) {
                    numberWord = (listWords.get(word) != null) ? listWords.get(word) : 0;
                    listWords.put(word, numberWord + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Une erreur est survenue !\n" + e.getLocalizedMessage());
        }
        return listWords;
    }
}
