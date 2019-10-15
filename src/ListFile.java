public class ListFile {
    // --------------------------------------------------------------
    //      Declare attributes
    // --------------------------------------------------------------
    private String[] listOfFiles;
    private int numberOfFiles;
    private int indexOfChosenFile;

    // --------------------------------------------------------------
    //      Constructor
    // --------------------------------------------------------------
    public ListFile(String[] listFiles) {
        listOfFiles = listFiles;
        numberOfFiles = calculateNumberOfFiles();

    }

    // --------------------------------------------------------------
    //      Getter
    // --------------------------------------------------------------
    // Return the number of files from the list
    public int getNumberOfFiles() {
        return this.numberOfFiles;
    }

    // Return the files list
    public String[] getListOfFiles() {
        return this.listOfFiles;
    }

    // Return the index of chosen file
    public int getIndexOfChosenFile() {
        return this.indexOfChosenFile;
    }

    // --------------------------------------------------------------
    //      Getter
    // --------------------------------------------------------------
    // Set the index of chosen file
    public void setIndexOfChosenFile(int index) {
        this.indexOfChosenFile = index;
    }

    // --------------------------------------------------------------
    //      Public Methods
    // --------------------------------------------------------------
    // Add a file filename to the files list
    public void addFileToListOfFiles(String filename) {
        String[] newListOfFiles = new String[this.listOfFiles.length + 1];
        for (int i = 0; i != this.listOfFiles.length; ++i) {
            newListOfFiles[i] = this.listOfFiles[i];
        }
        newListOfFiles[this.listOfFiles.length] = filename;
        this.listOfFiles = newListOfFiles;
        this.setNumberOfFiles();
    }

    // Delete the file at the index from files list
    public void deleteFileFromListOfFiles(int index) {
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

    // --------------------------------------------------------------
    //      Private Methods
    // --------------------------------------------------------------
    // Set the number of file in files list
    private void setNumberOfFiles() {
        this.numberOfFiles = this.listOfFiles.length;
    }

    // Return the number of files in the file list
    private int calculateNumberOfFiles() {
        return this.listOfFiles.length;
    }
}
