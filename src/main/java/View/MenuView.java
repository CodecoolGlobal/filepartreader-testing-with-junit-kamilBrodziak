package View;

import java.util.Scanner;

public class MenuView {

    public void printMenu() {
        System.out.println("1. Read all file");
        System.out.println("2. Read from line .. to line ..");
        System.out.println("3. Get words ordered alphabetically");
        System.out.println("4. Get words containing substring");
        System.out.println("5. Get words which are palindromes");
        System.out.println("0. Exit");
    }

    public int getMenuChoice() {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        if(scanner.hasNextInt()) {
            option = scanner.nextInt();
        }

        return option;
    }

    public int[] getLineFromTo() {
        Scanner scanner = new Scanner(System.in);
        int[] lines = {0, 0};
        System.out.println("Provide line from: ");
        if(scanner.hasNextInt()) {
            lines[0] = scanner.nextInt();
        }
        System.out.println("Provide line to: ");
        if(scanner.hasNextInt()) {
            lines[1] = scanner.nextInt();
        }
        return lines;
    }

    public String getSubstring() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Provide substring you are looking for: ");
        String substring = "";
        if(scanner.hasNext()) {
            substring = scanner.next();
        }

        return substring;
    }

    public String getFilePath() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Provide file path: ");
        String filePath = "";

        if(scanner.hasNext()) {
            filePath = scanner.next();
        }
        return filePath;
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void waitTilEnter() {
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
