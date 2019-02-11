package Tools;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {
    private static FileWordAnalyzer fileWordAnalyzer;
    private static FilePartReader filePartReader;

    @BeforeAll
    public static void setUp() {
        filePartReader = new FilePartReader();
        fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
    }

    @Test
    public void testIfWordsAreAlphabeticallyReturned() throws FileNotFoundException {
        String alph = "[and, other, something, thing, we]";
        filePartReader.setup("test2", 1, 5);
        assertEquals(alph, fileWordAnalyzer.getWordsOrderedAlphabetically().toString());
    }

    @Test
    public void testIfWordsContainingSubstringAreReturned() throws FileNotFoundException {
        String words = "[will, drill]";
        filePartReader.setup("test2", 1, 2000);
        assertEquals(words, fileWordAnalyzer.getWordsContainingSubstring("ill").toString());
    }

    @Test
    public void testIfPalindromesAreReturned() throws FileNotFoundException {
        String palindromes = "[level]";
        filePartReader.setup("test2", 1, 2000);
        assertEquals(palindromes, fileWordAnalyzer.getStringsWhichPalindromes().toString());
    }
}