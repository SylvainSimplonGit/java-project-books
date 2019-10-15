public class ListFile {
    // --------------------------------------------------------------
    //      Declare attributes
    // --------------------------------------------------------------
    private String[] listOfFiles;
    private int numberOfFiles;

    // --------------------------------------------------------------
    //      Constructor
    // --------------------------------------------------------------
    public ListFile(String[] listFiles) {
        listOfFiles = listFiles;
        numberOfFiles = calculateNumberOfFiles();

    }

    public int getNumberOfFiles() {
        return this.numberOfFiles;
    }

    private void setNumberOfFiles() {
        this.numberOfFiles = this.listOfFiles.length;
    }

    public String[] getListOfFiles() {
        return this.listOfFiles;
    }

    public void addFileToListOfFiles(String filename) {
        String[] newListOfFiles = new String[this.listOfFiles.length + 1];
        for (int i = 0; i != this.listOfFiles.length; ++i) {
            newListOfFiles[i] = this.listOfFiles[i];
        }
        newListOfFiles[this.listOfFiles.length] = filename;
        this.listOfFiles = newListOfFiles;
        this.setNumberOfFiles();
    }

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
    }

    private int calculateNumberOfFiles() {
        return this.listOfFiles.length;
    }
}
