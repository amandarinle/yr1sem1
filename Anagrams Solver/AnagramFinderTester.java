import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* CS 314 STUDENTS:
 *
 * Student information for assignment:
 *
 *  On my honor, Amanda Le, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 */

public class AnagramFinderTester {


    private static final String testCaseFileName = "testCaseAnagrams.txt";
    private static final String dictionaryFileName = "d3.txt";

    /**
     * main method that executes tests.
     * @param args Not used.
     */
    public static void main(String[] args) {

        cs314StudentTestsForLetterInventory();
        // tests on the anagram solver itself
        boolean displayAnagrams = getChoiceToDisplayAnagrams();
        AnagramSolver solver 
                = new AnagramSolver(AnagramMain.readWords(dictionaryFileName));
        runAnagramTests(solver, displayAnagrams);
    }
    
    /**
     * Method that tests LetterInventory class (2 per method)
     */
    private static void cs314StudentTestsForLetterInventory() {
        // test 1: size
        LetterInventory tester = new LetterInventory("Amanda");
        int expected = 6;
        int actual = tester.size();
        System.out.println("Test 1: size()");
        System.out.println("expected result: " + expected);
        System.out.println("actual result: " + actual);
        if (expected == actual) {
            System.out.println("passed test 1");
        }
        else {
            System.out.println("failed test 1");
        }
        
        // test 2: size
        System.out.print("\n");
        tester = new LetterInventory("loopty loop");
        expected = 10;
        actual = tester.size();
        System.out.println("Test 2: size()");
        System.out.println("expected result: " + expected);
        System.out.println("actual result: " + actual);
        if (expected == actual) {
            System.out.println("passed test 2");
        }
        else {
            System.out.println("failed test 2");
        }
        
        // test 3: get
        System.out.print("\n");
        expected = 4;
        actual = tester.get('O');
        System.out.println("Test 3: get(char c)");
        System.out.println("expected result: " + expected);
        System.out.println("actual result: " + actual);
        if (expected == actual) {
            System.out.println("passed test 3");
        }
        else {
            System.out.println("failed test 3");
        }
        
        // test 4: get
        System.out.print("\n");
        expected = 0;
        actual = tester.get('r');
        System.out.println("Test 4: get(char c)");
        System.out.println("expected result: " + expected);
        System.out.println("actual result: " + actual);
        if (expected == actual) {
            System.out.println("passed test 4");
        }
        else {
            System.out.println("failed test 4");
        }
        
        // test 5: toString
        System.out.print("\n");
        String expectedS = "llooooppty";
        String actualS = tester.toString();
        System.out.println("Test 5: toString()");
        System.out.println("expected result: " + expectedS);
        System.out.println("actual result: " + actualS);
        if (expectedS.equals(actualS)) {
            System.out.println("passed test 5");
        }
        else {
            System.out.println("failed test 5");
        }
        
        // test 6: toString
        System.out.print("\n");
        tester = new LetterInventory("");
        expectedS = "";
        actualS = tester.toString();
        System.out.println("Test 6: toString()");
        System.out.println("expected result: " + expectedS);
        System.out.println("actual result: " + actualS);
        if (expectedS.equals(actualS)) {
            System.out.println("passed test 6");
        }
        else {
            System.out.println("failed test 6");
        }
        
        // test 7: isEmpty()
        System.out.print("\n");
        boolean expectedBool = true;
        boolean actualBool = tester.isEmpty();
        System.out.println("Test 7: isEmpty()");
        System.out.println("expected result: " + expectedBool);
        System.out.println("actual result: " + actualBool);
        if (expectedBool == actualBool) {
            System.out.println("passed test 7");
        }
        else {
            System.out.println("failed test 7");
        }
        
        // test 8: isEmpty()
        System.out.print("\n");
        tester = new LetterInventory("When I Fly Towards You");
        expectedBool = false;
        actualBool = tester.isEmpty();
        System.out.println("Test 8: isEmpty()");
        System.out.println("expected result: " + expectedBool);
        System.out.println("actual result: " + actualBool);
        if (expectedBool == actualBool) {
            System.out.println("passed test 8");
        }
        else {
            System.out.println("failed test 8");
        }
        
        // test 9: equals(Object other)
        System.out.print("\n");
        LetterInventory tester2 = new LetterInventory("wheniflytowardsyou");
        expectedBool = true;
        actualBool = tester.equals(tester2);
        System.out.println("Test 9: equals(Object other)");
        System.out.println("expected result: " + expectedBool);
        System.out.println("actual result: " + actualBool);
        if (expectedBool == actualBool) {
            System.out.println("passed test 9");
        }
        else {
            System.out.println("failed test 9");
        }
        
        // test 10: equals(Object other)
        System.out.print("\n");
        expectedBool = false;
        actualBool = tester.equals("When I Fly Towards You");
        System.out.println("Test 10: equals(Object other)");
        System.out.println("expected result: " + expectedBool);
        System.out.println("actual result: " + actualBool);
        if (expectedBool == actualBool) {
            System.out.println("passed test 10");
        }
        else {
            System.out.println("failed test 10");
        }
        
        // test 11: add(LetterInventory other)
        System.out.print("\n");
        tester = new LetterInventory("WOMP womp");
        tester2 = new LetterInventory("POW");
        expectedS = "mmooopppwww";
        actualS = tester.add(tester2).toString();
        System.out.println("Test 11: add(LetterInventory other)");
        System.out.println("expected result: " + expectedS);
        System.out.println("actual result: " + actualS);
        if (expectedS.equals(actualS)) {
            System.out.println("passed test 11");
        }
        else {
            System.out.println("failed test 11");
        }
        
        // test 12 add(LetterInventory other)
        System.out.print("\n");
        tester2 = new LetterInventory("meeep");
        expectedS = "eeemmmoopppww";
        actualS = tester.add(tester2).toString();
        System.out.println("Test 12: add(LetterInventory other)");
        System.out.println("expected result: " + expectedS);
        System.out.println("actual result: " + actualS);
        if (expectedS.equals(actualS)) {
            System.out.println("passed test 12");
        }
        else {
            System.out.println("failed test 12");
        }
        
        // test 13 subtract(LetterInventory other)
        System.out.print("\n");
        System.out.println("Test 13: subtract(LetterInventory other)");
        System.out.println("expected result: " + null);
        if (tester.subtract(tester2) == null) {
            System.out.println("passed test 13");
        }
        else {
            System.out.println("failed test 13");
        }
        
        // test 14 subtract(LetterInventory other)
        System.out.print("\n");
        tester2 = new LetterInventory("womp");
        expectedS = "mopw";
        actualS = tester.subtract(tester2).toString();
        System.out.println("Test 14: subtract(LetterInventory other)");
        System.out.println("expected result: " + expectedS);
        System.out.println("actual result: " + actualS);
        if (expectedS.equals(actualS)) {
            System.out.println("passed test 14");
        }
        else {
            System.out.println("failed test 14");
        }
    }

    private static boolean getChoiceToDisplayAnagrams() {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter y or Y to display anagrams during tests: ");
        String response = console.nextLine();
        console.close();
        return response.length() > 0 
                && response.toLowerCase().charAt(0) == 'y';
    }

    /**
     * Method to run tests on Anagram solver itself.
     * pre: the files d3.txt and testCaseAnagrams.txt are in the local directory
     * 
     * assumed format for file is
     * <NUM_TESTS>
     * <TEST_NUM>
     * <MAX_WORDS>
     * <PHRASE>
     * <NUMBER OF ANAGRAMS>
     * <ANAGRAMS>
     */
    private static void runAnagramTests(AnagramSolver solver, 
            boolean displayAnagrams) {
        
        int solverTestCases = 0;
        int solverTestCasesPassed = 0;
        Stopwatch st = new Stopwatch();
        try {
            Scanner sc = new Scanner(new File(testCaseFileName));
            final int NUM_TEST_CASES = Integer.parseInt(sc.nextLine().trim());
            System.out.println(NUM_TEST_CASES);
            for (int i = 0; i < NUM_TEST_CASES; i++) {
                // expected results
                TestCase currentTest = new TestCase(sc);
                solverTestCases++;
                st.start();
                // actual results
                List<List<String>> actualAnagrams 
                    = solver.getAnagrams(currentTest.phrase, currentTest.maxWords);
                st.stop();
                if(displayAnagrams) {
                    displayAnagrams("actual anagrams", actualAnagrams);
                    displayAnagrams("expected anagrams", currentTest.anagrams);
                }


                if(checkPassOrFailTest(currentTest, actualAnagrams))
                    solverTestCasesPassed++;
                System.out.println("Time to find anagrams: " + st.time());
                /* System.out.println("Number of calls to recursive helper method: " 
                        + NumberFormat.getNumberInstance(Locale.US).format(AnagramSolver.callsCount));*/
            }
            sc.close();
        } catch(IOException e) {
            System.out.println("\nProblem while running test cases on AnagramSolver. Check" +
                            " that file testCaseAnagrams.txt is in the correct location.");
            System.out.println(e);
            System.out.println("AnagramSolver test cases run: " + solverTestCases);
            System.out.println("AnagramSolver test cases failed: " 
                        + (solverTestCases - solverTestCasesPassed));
        }
        System.out.println("\nAnagramSolver test cases run: " + solverTestCases);
        System.out.println("AnagramSolver test cases failed: " + (solverTestCases - solverTestCasesPassed));
    }


    // print out all of the anagrams in a list of anagram
    private static void displayAnagrams(String type,
                    List<List<String>> anagrams) {

        System.out.println("Results for " + type);
        System.out.println("num anagrams: " + anagrams.size());
        System.out.println("anagrams: ");
        for (List<String> singleAnagram : anagrams) {
            System.out.println(singleAnagram);
        }
    }


    // determine if the test passed or failed
    private static boolean checkPassOrFailTest(TestCase currentTest,
                    List<List<String>> actualAnagrams) {

        boolean passed = true;
        System.out.println();
        System.out.println("Test number: " + currentTest.testCaseNumber);
        System.out.println("Phrase: " + currentTest.phrase);
        System.out.println("Word limit: " + currentTest.maxWords);
        System.out.println("Expected Number of Anagrams: " 
                    + currentTest.anagrams.size());
        if(actualAnagrams.equals(currentTest.anagrams)) {
            System.out.println("Passed Test");
        } else {
            System.out.println("\n!!! FAILED TEST CASE !!!");
            System.out.println("Recall MAXWORDS = 0 means no limit.");
            System.out.println("Expected number of anagrams: " 
                        + currentTest.anagrams.size());
            System.out.println("Actual number of anagrams:   " 
                        + actualAnagrams.size());
            if(currentTest.anagrams.size() == actualAnagrams.size()) {
                System.out.println("Sizes the same, "
                        + "but either a difference in anagrams or"
                        + " anagrams not in correct order.");
            }
            System.out.println();
            passed = false;
        }  
        return passed;
    }

    // class to handle the parameters for an anagram test 
    // and the expected result
    private static class TestCase {

        private int testCaseNumber;
        private String phrase;
        private int maxWords;
        private List<List<String>> anagrams;

        // pre: sc is positioned at the start of a test case
        private TestCase(Scanner sc) {
            testCaseNumber = Integer.parseInt(sc.nextLine().trim());
            maxWords = Integer.parseInt(sc.nextLine().trim());
            phrase = sc.nextLine().trim();
            anagrams = new ArrayList<>();
            readAndStoreAnagrams(sc);
        }

        // pre: sc is positioned at the start of the resulting anagrams
        // read in the number of anagrams and then for each anagram:
        //  - read in the line
        //  - break the line up into words
        //  - create a new list of Strings for the anagram
        //  - add each word to the anagram
        //  - add the anagram to the list of anagrams
        private void readAndStoreAnagrams(Scanner sc) {
            int numAnagrams = Integer.parseInt(sc.nextLine().trim());
            for (int j = 0; j < numAnagrams; j++) {
                String[] words = sc.nextLine().split("\\s+");
                ArrayList<String> anagram = new ArrayList<>();
                for (String st : words) {
                    anagram.add(st);
                }
                anagrams.add(anagram);
            }
            assert anagrams.size() == numAnagrams 
                    : "Wrong number of angrams read or expected";
        }
    }
}
