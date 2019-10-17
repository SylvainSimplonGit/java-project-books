import java.io.File;

public class ListFile {
    // --------------------------------------------------------------
    //      Declare attributes
    // --------------------------------------------------------------
    private String[] listOfFiles;
    private int numberOfFiles;
    private String pathOfChosenFile;

    // --------------------------------------------------------------
    //      Constructor
    // --------------------------------------------------------------
    public ListFile(String[] listFiles) {
        setListOfValidFiles(listFiles);
        numberOfFiles = calculateNumberOfFiles();
    }

    // --------------------------------------------------------------
    //      Getter
    // --------------------------------------------------------------
    // Return the number of files from the list
    int getNumberOfFiles() {
        return this.numberOfFiles;
    }

    // Return the files list
    String[] getListOfFiles() {
        return this.listOfFiles;
    }

    // Return the path of chosen file
    String getPathOfChosenFile() {
        return this.pathOfChosenFile;
    }

    // Return the path of chosen file
    String getPathOfFileByIndex(int index) {
        return this.listOfFiles[index];
    }

    // --------------------------------------------------------------
    //      Setter
    // --------------------------------------------------------------
    // Set the chosen file
    void setChosenFile(int index) {
        this.pathOfChosenFile = this.listOfFiles[index];
    }

    // --------------------------------------------------------------
    //      Public Methods
    // --------------------------------------------------------------
    // Add a file filename to the files list
    void addFileToListOfFiles(String filename) {
        String[] newListOfFiles;
        if (this.listOfFiles == null) {
            newListOfFiles = new String[1];
            newListOfFiles[0] = filename;
        } else {
            newListOfFiles = new String[this.listOfFiles.length + 1];
            for (int i = 0; i != this.listOfFiles.length; ++i) {
                newListOfFiles[i] = this.listOfFiles[i];
            }
            newListOfFiles[this.listOfFiles.length] = filename;
        }
        this.listOfFiles = newListOfFiles;
        this.setNumberOfFiles();
    }

    // Delete the file at the index from files list
    void deleteFileFromListOfFiles(int index) {
        int indexNew = 0;

        String[] newListOfFiles = new String[this.listOfFiles.length - 1];

        for (int indexOld = 0; indexOld != this.listOfFiles.length; ++indexOld) {
            if (indexOld != index) {
                newListOfFiles[indexNew] = this.listOfFiles[indexOld];
                ++indexNew;
            }
        }
        this.listOfFiles = newListOfFiles;
        this.setNumberOfFiles();
    }

    //
    boolean hasChosenFile() {
        if (this.pathOfChosenFile == null) {
            return false;
        } else {
            return true;
        }
    }

    // --------------------------------------------------------------
    //      Private Methods
    // --------------------------------------------------------------
    // Create list of valid files
    private void setListOfValidFiles(String[] listOfFilesToTest) {
        for (String file : listOfFilesToTest) {
            if (isValidFile(file))
                this.addFileToListOfFiles(file);
        }
    }

    // Valid file in constructor
    private static boolean isValidFile(String filename) {
        File newFile = new File(filename);
        // Si le fichier existe
        return newFile.exists();
    }

    // Set the number of file in files list
    private void setNumberOfFiles() {
        this.numberOfFiles = this.listOfFiles.length;
    }

    // Return the number of files in the file list
    private int calculateNumberOfFiles() {
        if (this.listOfFiles == null) {
            return 0;
        } else {
            return this.listOfFiles.length;
        }
    }

}
