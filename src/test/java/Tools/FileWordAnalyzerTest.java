package Tools;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest {
    private static FileWordAnalyzer fileWordAnalyzer;
    private static FilePartReader filePartReader;

    @BeforeAll
    public static void setUp() {
        filePartReader = mock(FilePartReader.class);
        fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
    }

    @Test
    public void testIfWordsAreAlphabeticallyReturned() throws FileNotFoundException {
        String alph = "[and, are, nothing, or, other, something, thing, we, words]";
        when(filePartReader.readLines()).thenReturn("and or\nsomething thing we are\nwords\nnothing other");
        assertEquals(alph, fileWordAnalyzer.getWordsOrderedAlphabetically().toString());
    }

    @Test
    public void testIfWordsAreAlphabeticallyReturnedWhenSomeWordsAreDuplicated() throws FileNotFoundException {
        String alph = "[and, are, nothing, or, other, something, thing, we, words]";
        when(filePartReader.readLines()).thenReturn("and or or\nsomething thing we are are\nwords\nnothing are other\nsomething");
        assertEquals(alph, fileWordAnalyzer.getWordsOrderedAlphabetically().toString());
    }

    @Test
    public void testIfWordsAreAlphabeticallyReturnedWhenMoreThanOneSpaceDivideWords() throws FileNotFoundException {
        String alph = "[and, are, nothing, or, other, something, thing, we, words]";
        when(filePartReader.readLines()).thenReturn("and or or  \n something thing we  are are\nwords\nnothing    are other\nsomething");
        assertEquals(alph, fileWordAnalyzer.getWordsOrderedAlphabetically().toString());
    }

    @Test
    public void testIfWordsContainingSubstringAreReturned() throws FileNotFoundException {
        String words = "[will, drill]";
        when(filePartReader.readLines()).thenReturn("space continue\nsomething\nwrong\ndance\nwill drill");
        assertEquals(words, fileWordAnalyzer.getWordsContainingSubstring("ill").toString());
    }

    @Test
    public void testIfPalindromesAreReturned() throws FileNotFoundException {
        String palindromes = "[level]";
        when(filePartReader.readLines()).thenReturn("space continue\nlevel\nwrong\ndance\nwill drill");
        assertEquals(palindromes, fileWordAnalyzer.getStringsWhichPalindromes().toString());
    }
}