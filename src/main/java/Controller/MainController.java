package Controller;

import Tools.FilePartReader;
import Tools.FileWordAnalyzer;
import View.MenuView;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainController {
    private FilePartReader filePartReader;
    private FileWordAnalyzer fileWordAnalyzer;
    private MenuView menuView;

    public MainController() {
        filePartReader = new FilePartReader();
        fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        menuView = new MenuView();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        while(option != 0) {
            menuView.clearScreen();
            menuView.printMenu();
            try {
                runChoice(menuView.getMenuChoice());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void runChoice(int option) throws FileNotFoundException {
        int[] linesFromTo = {0, 0};
        if(option != 1) {
            linesFromTo = menuView.getLineFromTo();
            filePartReader.setup(menuView.getFilePath(), linesFromTo[0], linesFromTo[1]);
        }

        filePartReader.setup(menuView.getFilePath(), linesFromTo[0], linesFromTo[1]);
        switch (option) {
            case 1:
                filePartReader.read();
                break;
            case 2:

                filePartReader.readLines();
                break;
            case 3:
                fileWordAnalyzer.getWordsOrderedAlphabetically();
                break;
            case 4:
                fileWordAnalyzer.getWordsContainingSubstring(menuView.getSubstring());
                break;
            case 5:
                fileWordAnalyzer.getStringsWhichPalindromes();
                break;
        }
        menuView.getMenuChoice();
    }
}
