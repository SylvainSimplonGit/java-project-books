//public class Word {
public class Word implements Comparable<Word> {

    // --------------------------------------------------------------
    //      Declare attributes
    // --------------------------------------------------------------
    private String word;
    private int numberSeen;

    // --------------------------------------------------------------
    //      Constructor
    // --------------------------------------------------------------
    public Word (String word) {
        this.word = word;
        this.numberSeen = 1;
    }


    // --------------------------------------------------------------
    //      Getters
    // --------------------------------------------------------------
    int getNumberSeen() {
        return numberSeen;
    }

    public String getWord() {
        return word;
    }

    // --------------------------------------------------------------
    //      Setter
    // --------------------------------------------------------------
    void setNumberSeen(int numberSeen) {
        this.numberSeen = numberSeen;
    }

    public void setWord(String word) {
        this.word = word;
    }

    // --------------------------------------------------------------
    //      External Methods
    // --------------------------------------------------------------
    // Function to check the instance equality of Word
    public boolean equals(Object other){
        if(other != null && (other instanceof Word)){
            Word otherPerson = (Word) other;
            if(word.equals(otherPerson.word)){
                return true;
            }
        }
        return false;
    }

    //
    @Override
    public int compareTo(Word compareBook) {
        int compareReturn = 0;

        if (this.numberSeen < compareBook.numberSeen)
            compareReturn = 1;
        else if (this.numberSeen == compareBook.numberSeen)
            compareReturn = this.word.compareTo(compareBook.word);
        else
            compareReturn = -1;

        return compareReturn;
    }
}
