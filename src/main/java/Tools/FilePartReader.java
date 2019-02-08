package Tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FilePartReader {
    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader() {
        filePath = "";
        fromLine = -1;
        toLine = -2;
    }

    public void setup(String filePath, int fromLine, int toLine) {
        this.filePath = filePath;
        if(toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException();
        }
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws FileNotFoundException {
        Scanner scanner = new Scanner(getFile());

        String output = "";

        while(scanner.hasNextLine()) {
            output += scanner.next();
        }

        return output;
    }

    public String readLines() throws FileNotFoundException {
        Scanner scanner = new Scanner(getFile());

        String output = "";

        int i = 1;
        while(scanner.hasNextLine()) {
            if(i >= fromLine && i <= toLine) {
                output += scanner.nextLine();
            } else if(i < fromLine) {
                scanner.nextLine();
            } else if(i > toLine) {
                break;
            }
        }

        return output;
    }

    private File getFile() {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(filePath).getFile());
    }
}