package Tools;

import java.io.FileNotFoundException;
import java.lang.IllegalArgumentException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    private static FilePartReader filePartReader;

    @BeforeAll
    public static void setUp() {
        filePartReader = new FilePartReader();
    }

    @Test
    public void testIfInvalidFromToLinePassedToSetupThrowException() {
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("file", 0, 0));
    }

    @Test
    public void testIfReadedTextIsValid() throws FileNotFoundException {
        String validString = "test\ntest2\ntest3 test4\n";
        filePartReader.setup("test", 1, 2);
        assertEquals(validString, filePartReader.read());
    }

    @Test
    public void testIfInvalidFilePathThrowException() {
        filePartReader.setup("hsajsahk", 1, 2);
        assertThrows(FileNotFoundException.class, () -> filePartReader.read());
    }

    @Test
    public void testIfReadedLinesAreValid() throws FileNotFoundException {
        String validString = "test2\ntest3 test4\n";
        filePartReader.setup("test", 2, 3);
        assertEquals(validString, filePartReader.readLines());
        filePartReader.setup("test", 1, 2);
        validString = "test\ntest2\n";
        assertEquals(validString, filePartReader.readLines());
    }
}