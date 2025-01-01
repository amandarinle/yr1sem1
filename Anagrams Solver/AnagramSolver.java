/**
 * CODED UP BY AMANDA LE
 */


/* CS 314 STUDENTS:
 *
 * Student information for assignment:
 *
 *  On my honor, Amanda Le, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class AnagramSolver {
    
    // instance variables
    private HashMap<String, LetterInventory> inventories;
    private List<String> possibleWords; // smaller dictionary
    
    /*
     * pre: list != null     
     * @param list Contains the words to form anagrams from.
     */
    public AnagramSolver(Set<String> dictionary) {
        // check preconditions 
        if (dictionary == null) {
            throw new IllegalArgumentException("Violation of preconditions");
        }
        
        possibleWords = new ArrayList<>();
        inventories = new HashMap<>();
        // stores each word in dictionary with its corresponding LetterInventory
        for (String s : dictionary) {
            LetterInventory inventory = new LetterInventory(s);
            inventories.put(s, inventory);
        }
    }

    /*
     * pre: maxWords >= 0, s != null, s contains at least one 
     * English letter.
     * Return a list of anagrams that can be formed from s with
     * no more than maxWords, unless maxWords is 0 in which case
     * there is no limit on the number of words in the anagram
     */
    public List<List<String>> getAnagrams(String s, int maxWords) {
        // check preconditions
        if (maxWords < 0 || s == null) {
            throw new IllegalArgumentException("Violation of preconditions");
        }
        
        // maxWords 0 means no word limit
        if (maxWords == 0) {
            maxWords = s.length();
        }
        
        ArrayList<List<String>> anagrams = new ArrayList<>(); // stores anagrams
        LetterInventory thisInventory = new LetterInventory(s); 
        
        possibleWords.clear(); // clear previous words
        // creates "smaller dictionary" which only include eligible words
        for (String word : inventories.keySet()) {
            if (thisInventory.subtract(inventories.get(word)) != null) {
                possibleWords.add(word);
            }
        }
        // sorts possible words so individual list of anagrams will automatically be sorted
        Collections.sort(possibleWords);
        ArrayList<String> anagramSoFar = new ArrayList<>();
        getAnagramsHelper(thisInventory, maxWords, anagrams, anagramSoFar, 0);
        // sorts final returned list
        Collections.sort(anagrams, new AnagramComparator());
        return anagrams;
    }
 
    /**
     * helper method that handles the recursive calls for getAnagrams
     * pre: none
     * post: adds all possible lists of anagrams (depending on maxWords) to anagrams (list)
     */
    public void getAnagramsHelper(LetterInventory phraseInventory, int maxWords,
            ArrayList<List<String>> anagrams, ArrayList<String> anagramSoFar, int startIndex) {
        // base case: if no letters are remaining in original phrase
        if (phraseInventory.isEmpty()) {
            anagrams.add(new ArrayList<>(anagramSoFar));
            
        }
        else if (anagramSoFar.size() < maxWords) {
            // test all possible words
            for (int i = startIndex; i < possibleWords.size(); i++) {
                LetterInventory wordInventory = inventories.get(possibleWords.get(i));
                LetterInventory remainingLetters = phraseInventory.subtract(wordInventory);
                if (remainingLetters != null) {
                    anagramSoFar.add(possibleWords.get(i));
                    // starts at later index each time to prevent unnecessary checks
                    getAnagramsHelper(remainingLetters, maxWords, anagrams, anagramSoFar, i);
                    anagramSoFar.remove(anagramSoFar.size() - 1); // Backtrack
                }
            }
        }
    }
    
    /**
     * private class that implements comparator to sort list of anagrams per criteria
     */
    private static class AnagramComparator implements Comparator<List<String>> {
        
        /**
         * Compares 2 lists of anagrams
         * pre: none 
         * post: returns positive number if a1 > a2, negative number if a1 < a2, 
         * and 0 if they're equal
         */
        public int compare(List<String> a1, List<String> a2) {
            // checks sizes
            if (a1.size() != a2.size()) {
                return a1.size() - a2.size();
            }
            for (int i = 0; i < a1.size(); i++) {
                int wordComparison = a1.get(i).compareTo(a2.get(i));
                if (wordComparison != 0) {
                    return wordComparison; // Return the first difference
                }
            }
            return 0; // They are equal
        }
    }
}
