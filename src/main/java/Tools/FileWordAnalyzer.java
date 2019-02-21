package Tools;

import java.io.FileNotFoundException;
import java.util.*;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically() throws FileNotFoundException {
        String readFile = filePartReader.readLines().toLowerCase().replaceAll("\n",  " ").replaceAll("[ ]+", " ");
        List<String> words = Arrays.asList(readFile.split(" "));
        Set<String> set = new LinkedHashSet<>();
        set.addAll(words);
        words = new ArrayList<>();
        words.addAll(set);
        words.sort(Comparator.naturalOrder());
        return words;
    }

    public List<String> getWordsContainingSubstring(String substring) throws FileNotFoundException {
        String readFile = filePartReader.readLines().toLowerCase().replaceAll("\n", " ");
        String[] words = readFile.split(" ");
        List<String> wordsSearchedFor = new ArrayList<>();
        for(String word: words) {
            if(word.matches(".*" + substring + ".*")) {
                wordsSearchedFor.add(word);
            }
        }
        return wordsSearchedFor;
    }

    public List<String> getStringsWhichPalindromes() throws FileNotFoundException {
        String readFile = filePartReader.readLines().toLowerCase().replaceAll("\n", " ");
        String[] words = readFile.split(" ");
        List<String> wordsSearchedFor = new ArrayList<>();

        for(String word: words) {
            String reversed = new StringBuilder(word).reverse().toString();
            if(reversed.equals(word)) {
                wordsSearchedFor.add(word);
            }
        }
        return wordsSearchedFor;
    }
}
