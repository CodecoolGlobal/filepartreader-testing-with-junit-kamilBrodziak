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
                option = menuView.getMenuChoice();
                runChoice(option);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void runChoice(int option) throws FileNotFoundException {
        int[] linesFromTo = {1, 2};
        if(option > 1) {
            linesFromTo = menuView.getLineFromTo();
            filePartReader.setup(menuView.getFilePath(), linesFromTo[0], linesFromTo[1]);
        } else if(option == 1){
            filePartReader.setup(menuView.getFilePath(), linesFromTo[0], linesFromTo[1]);
        }

        switch (option) {
            case 1:
                System.out.println(filePartReader.read());
                break;
            case 2:
                System.out.println(linesFromTo[0] + " " + linesFromTo[1]);
                System.out.println(filePartReader.readLines());
                break;
            case 3:
                System.out.println(fileWordAnalyzer.getWordsOrderedAlphabetically());
                break;
            case 4:
                System.out.println(fileWordAnalyzer.getWordsContainingSubstring(menuView.getSubstring()));
                break;
            case 5:
                System.out.println(fileWordAnalyzer.getStringsWhichPalindromes());
                break;
        }
        menuView.waitTilEnter();
    }
}
