public class Word implements Comparable<Word> {

    /**
     * Declare attributes
     */
    private String word;
    private int numberSeen;

    // --------------------------------------------------------------
    //      Constructor
    // --------------------------------------------------------------

    /**
     * Constructor of Word
     *
     * @param word  : String of word
     */
    public Word (String word) {
        this.word = word;
        this.numberSeen = 1;
    }

    /**
     * Get the number of times the word is seen
     * @return      : the number of times the word is seen
     */
    int getNumberSeen() {
        return numberSeen;
    }

    /**
     * Get the word string
     * @return      : the word string
     */
    String getWord() {
        return word;
    }

    /**
     * Set the number of times the word has been seen
     *
     * @param numberSeen        : the number of times the word is seen
     */
    void setNumberSeen(int numberSeen) {
        this.numberSeen = numberSeen;
    }

    /**
     * Set the string of word
     *
     * @param word      : the word string
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * Function to check the instance equality of Word
     *
     * @param other     : instance of Object
     * @return          : true if the Object is equal to the word
     */
    public boolean equals(Object other){
        if(other != null && (other instanceof Word)){
            Word otherPerson = (Word) other;
            return word.equals(otherPerson.word);
        }
        return false;
    }

    /**
     * Method to compare two instance of Word
     *
     * @param compareWord   : Object Word to be compared
     * @return              : 1 if compareWord is greater than this word, -1 if not
     */
    @Override
    public int compareTo(Word compareWord) {
        int compareReturn;

        if (this.numberSeen < compareWord.numberSeen)
            compareReturn = 1;
        else if (this.numberSeen == compareWord.numberSeen)
            compareReturn = this.word.compareTo(compareWord.word);
        else
            compareReturn = -1;

        return compareReturn;
    }
}
