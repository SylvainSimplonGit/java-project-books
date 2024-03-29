# Projet JAVA

- [Rappels](#rappels)
  - [Contexte](#contexte)
  - [MVP](#minimum-vailable-product)
  - [Objectifs](#objectifs)
  - [Pré traitements](#pré-traitements)
- [Installation](#installation)
- [Execution](#execution)
- [Etapes](#etapes)
- [Ressources externes utilisées](#ressources-externes-utilisées)

<!-- toc -->

## Rappels

### Contexte

Le programme doit permettre de travailler sur un ensemble de fichiers texte correspondant à des livres. On voudra pouvoir avoir des informations sur le contenu des ces livres.

### Minimum Vailable Product

Le programme doit accepter un nombre quelconque d'arguments qui sont des noms de fichiers. Ensuite, il doit présenter le menu suivant :

1. Lister les fichiers
2. Ajouter un fichier
3. Supprimer un fichier
4. Afficher des informations sur un livre
5. Quitter le programme

Pendant toute l'exécution du programme, celui-ci maintient une liste des noms de fichiers, initialisée par les arguments du programme, qu'il est possible de consulter et modifier avec les trois premières options.

Le quatrième choix :

1. affiche la liste des fichiers
2. propose de choisir d'un de ces fichiers
3. propose le sous-menu suivant :
    1. Afficher le nombre de lignes du fichier
    2. Afficher le nombre de mots du fichier

### Objectifs

Parmi les informations proposées pour un fichier, ajouter :

- afficher les 50 mots les plus fréquents et leur nombre d'occurrences
- afficher les mots qui sont présents seulement dans ce fichier et aucun des autres fichiers
- Afficher pour chacun des autres fichiers le pourcentage de mots de l'autre fichier qui sont présents dans le fichier sélectionnés, par ordre décroissant de ce pourcentage.

### Pré traitements

Les fichiers de texte contiennent, en plus des mots, des signes, notamment de ponctuation, qu'on voudra éliminer. Pour faciliter le mini-projet, on peut le faire avec un prétraitement, par exemple en utilisant le programme suivant pour générer des fichiers ne contenant que les mots (un par ligne), d'un fichier texte :

```java
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BooksToWords {
    public static void main(String[] args)throws FileNotFoundException {
        Pattern p = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS);
        try(Scanner sc = new Scanner(new File(args[0]));
            PrintStream fileOut = new PrintStream(new FileOutputStream(args[1]))){
            for(int i=0; sc.hasNextLine(); ++i){
                for(Matcher m1 = p.matcher(sc.nextLine()); m1.find();) {
                    fileOut.println(m1.group());
                }
            }
        }
    }
}
```

On peut aussi réaliser ce programme en python :

```python
import sys
import re
with open(sys.argv[1]) as input, open(sys.argv[2], "w") as output:
    for line in input:
        for word in re.findall(r'\w+', line):
            output.write(word.lower())
            output.write('\n')
```

Si vous le voulez, vous pouvez vous inspirer de ce code pour que votre programme puisse traiter directement les fichiers de texte en réalisant vous-même l'extraction des mots.

## Installation

### Pré requis

Logiciels necessaires :

- Git **v2.21.0** ou supérieure
  - ([Installation](https://git-scm.com/downloads))
- JDK Java **v11** ou supérieure
  - ([Installation sur Linux](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-linux-platforms.html#GUID-737A84E4-2EFF-4D38-8E60-3E29D1B884B8))
  - ([Installation sur Windows](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-microsoft-windows-platforms.html#GUID-A7E27B90-A28D-4237-9383-A58B416071CA))
  - ([Installation sur MacOs](https://docs.oracle.com/en/java/javase/11/install/installation-jdk-macos.html#GUID-2FE451B0-9572-4E38-A1A5-568B77B146DE))

Dans un répertoire vide dénommé dans la suite **\<repertoire\>**, executer la commande suivante :

```git
git clone https://github.com/SylvainSimplonGit/java-project-books.git
```

Cette commande fera une copie de ce repository sur votre poste local.

## Execution

### Via IntelliJ

#### Pré traitement

- Sélectionnez dans le menu d'IntelliJ, ***Run*** puis le sous menu ***Edit Configurations...***

- Dans ***Main Class*** choisir *BooksToWords*

- Dans ***Program arguments*** entrez le nom du fichier à pré traiter :
  - ex :
    - **Smith-Richesse_des_Nations_1.txt**

  **ATTENTION** les fichiers à traiter devront être dans le répertoire ressources/books du projet

#### Execution du programme principal

- Sélectionnez dans le menu d'IntelliJ, ***Run*** puis le sous menu ***Edit Configurations...***

- Dans ***Main Class*** choisir *Main*

- Dans ***Program arguments*** entrez le(s) nom(s) du(es) fichier(s) à pré traiter :
  - ex :
    - **Smith-Richesse_des_Nations_1.txt** **Smith-Richesse_des_Nations_2.txt**

  **ATTENTION à bien ajouter les bons chmins sinon le programme ne prendra pas le fichier invalide !**
  
- Ensuite parcourez les menus pour afficher ce que vous souhaitez !

## Etapes

1. Compter le nombre de mots dans le fichier *mot.txt*

   => [commit](https://github.com/SylvainSimplonGit/java-project-books/commit/72cd14796d016956a8ed3b6b4046c7375b6caf06)

1. Créer la class BooksToWords pour effectuer le pré-traitement des livres

   => **le pré traitement par la class Java ne remplace pas les Majuscules**

1. Utilisation du fichier BooksToWords.py, j'ai utilisé cette ligne de commande sous *Windows*

   ```cmd
    c:\Python3\python.exe src\BooksToWords.py ressources\books\mots.txt ressources\books\mots.epure.txt
    ```

1. Trouver les 50 mots les plus utilisés

   => Reportée

1. Créer la Class Book pour accéder aux propriété de chaque livre

   => [commit](https://github.com/SylvainSimplonGit/java-project-books/commit/d85e8edf71c4a05766a9ca5caeb648b6b6d42af7)

1. Créer une Class Menu pour l'affichage des différents menus

   => [commit](https://github.com/SylvainSimplonGit/java-project-books/commit/1636510f80a4431a9e6ca13cfba850b164b2a937)

1. Créer une Class ListFile pour gérer les listes de fichiers livres

   => [commit](https://github.com/SylvainSimplonGit/java-project-books/commit/4554360c59febbfb9a175295b002b06d48194625)

1. ***MVP atteint*** les différents menus fonctionnent

   => [commit](https://github.com/SylvainSimplonGit/java-project-books/commit/7d116da00e2b0b503049a7d9c1d67b3ed5e647dc)

1. Créer une Class Word pour gérer les apparitions et tri de mots

   => [commit](https://github.com/SylvainSimplonGit/java-project-books/commit/e0be013e0693548446e6ddb16ad10a4a20abc5cd)

1. Adaptation de la Class BooksToWords

   => [commit](https://github.com/SylvainSimplonGit/java-project-books/commit/fd1adba0489f29b1bcb6dca2e7276d273d3970ad#diff-9ada41f22c4bb9796ffa2dfbcb0d9ca5)

1. Affichage des 50 mots les plus utilisés sur un fichier

   => [commit](https://github.com/SylvainSimplonGit/java-project-books/commit/52e73253ef5b789162673daa0c4f2df507648f15)

1. Correction d'un bug lors du lancement du programme principal sans argument

   => [commit](https://github.com/SylvainSimplonGit/java-project-books/commit/6a18b59865217e3dd398d48009bec564d6a75685)

1. Affichage des pourcentages de fichiers communs entre chaque fichier hors de la liste et le fichier de référence

   => [commit](https://github.com/SylvainSimplonGit/java-project-books/commit/c0d5a53bc885b205735bd4837b731bf250e0d348)

1. Pour ajouter un fichier à la liste gérée, utiliser un menu qui liste les fichiers disponible dans le répertoire **books_clean**

   => [commit](https://github.com/SylvainSimplonGit/java-project-books/commit/0d0924c244c0c772c95c5cce91e1ffc31ddc5d1d)

### Améliorations à prévoir

- Lors de l'ajout d'un fichier, n'afficher que les fichiers non présents dans la liste gérée

- Ajouter le pré traitement dans le menu principal
  - Entrée du menu : Pré traitements de tous les fichiers bruts (Attention cela peut prendre du temps !)
  - Lancement du pré traitement pour tous les fichiers du répertoire /ressources/books
  - Modifier la documentation en conséquence
  
- Green Code
  - "Be Lazy" : Charger les contenus des livres **QUE** lorsqu'on en a besoin
  - Vérifier si le livre est chargé avant de retourner une propriété du livre
  
- Ne pas oublier de fermer le Scanner d'entrée une fois inutile

- Renommer les variables qui comporte un type de variable

## Ressources externes utilisées

- [Installation de JAVA sous Windows](https://superuser.com/a/1317117)
- [Configuration du poste pour utiliser JAVA](https://www.commentcamarche.net/forum/affich-2143404-variable-d-environnement-java)

## Références 

- [Correction avec implémentation d'interface pour les menus](https://github.com/simplonco/java-project-books/tree/master/Etudes)
- [Correction complète](https://github.com/jlsgrand/java-project-books)