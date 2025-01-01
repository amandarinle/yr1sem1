/**
 * CODED UP BY AMANDA LE
 */

/*  Student information for assignment:
 *
 *  On my honor, Amanda Le, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 */

public class LetterInventory {
    // instance variables 
    private String word;
    private int[] letterFreqs;
    private final int ALPHABET_LENGTH = 26;
    private final int ASCII = 97; // used to convert character into its proper index in letterFreqs
    private int size; // total # of letters in word
    
    /**
     * constructor for LetterInventory
     * pre: s != null
     * post: constructs a new LetterInventory object ignoring case and 
     * consisting of only characters from the English alphabet
     */
    public LetterInventory(String s) {
        // check preconditions
        if (s == null) {
            throw new IllegalArgumentException("Violation of preconditions: "
                    + "string cannont be null");
        }
        
        letterFreqs = new int[ALPHABET_LENGTH];
        size = 0;
        word = s.toLowerCase(); // ignores case
        // accounts for the number of every distinct, legal letter in word
        for (int i = 0; i < word.length(); i++) {
            if ('a' <= word.charAt(i) && word.charAt(i) <= 'z') {
                letterFreqs[word.charAt(i) - ASCII]++;
                size++;
            }
        }  
    }
    
    /**
     * gets the frequency of a specified character
     * pre: c must be in the English alphabet ignoring case
     * post: returns an int representing the number of times the character appears 
     * in the word/phrase
     */
    public int get(char c) {
        String tgt = "" + c;
        tgt = tgt.toLowerCase(); // ignores case
        return letterFreqs[tgt.charAt(0) - ASCII];
    }
    
    /**
     * gets total number of letters in this LetterInventory
     * pre: none
     * post: returns int representing total number of letters in word/phrase
     */
    public int size() {
        return size;
    }
    
    /**
     * checks is the LetterInventory is empty
     * pre: none
     * post: returns true if the LetterInventory is empty, false otherwise
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * gets the string representation of this LetterInventory
     * pre: none
     * post: returns the string version of this LetterInventory in alphabetical order
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < letterFreqs.length; i++) {
            // converts index to corresponding character
            char letter = (char) (i + ASCII);
            // adds letter depending on the number of time it appears in word
            for (int j = 0; j < letterFreqs[i]; j++) {
                result.append("" + letter);
            }
        }
        return result.toString();
    }
    
    /**
     * adds letters from both LetterInventories together
     * pre: other != null
     * post: returns a new LetterInventory with the added frequencies from both LetterInventories
     * neither the calling or parameter LetterInventory will be altered
     */
    public LetterInventory add(LetterInventory other) {
        // check preconditions
        if (other == null) {
            throw new IllegalArgumentException("Violation of preconditions");
        }
        LetterInventory result = new LetterInventory("");
        result.size = 0;
        for (int i = 0; i < letterFreqs.length; i++) {
            // add frequencies
            result.letterFreqs[i] = letterFreqs[i] + other.letterFreqs[i];
            result.size += result.letterFreqs[i];
        }
        return result;
    }
    
    /**
     * subtract letters other to calling inventory
     * pre: other != null
     * post: return new LetterInventory created by subtracting the letter frequencies of other 
     * from this inventory. The calling and parameter inventories will not be altered
     */
    public LetterInventory subtract(LetterInventory other) {
        //  check preconditions
        if (other == null) {
            throw new IllegalArgumentException("Violation of preconditions");
        }

        LetterInventory result = new LetterInventory("");
        result.size = 0;
        for (int i = 0; i < letterFreqs.length; i++) {
            // Subtract frequencies
            result.letterFreqs[i] = letterFreqs[i] - other.letterFreqs[i];

            // Check for negative frequencies
            if (result.letterFreqs[i] < 0) {
                return null; // Return null if any count goes negative
            }
            
            result.size += result.letterFreqs[i];
        }
        return result;
    }
    
    /**
     * determines if two LetterFrequecies are equal
     * pre: other != null and is an instance of LetterInventory
     * post: return true if frequency for each letter in the alphabet in both, false otherwise
     */
    public boolean equals(Object other) {
        // checks if other is null or not of type LetterInventory
        if (!(other instanceof LetterInventory)) {
            return false;
        }
        LetterInventory otherInventory = (LetterInventory) other;
        if (size != otherInventory.size()) {
            return false;
        }
        // checks each frequency for equality
        for (int i = 0; i < letterFreqs.length; i++) {
            if (letterFreqs[i] != otherInventory.letterFreqs[i]) {
                return false;
            }
        }
        return true; 
    }
}
