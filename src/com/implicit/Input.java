package com.implicit;

import java.util.Scanner;

/**
 * Gets input from user.
 * @author Manika
 *
 */

public class Input {
    public void getInput(Lines rawData) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter words to ignore separated by spaces: ");
        scanner.nextLine();
        String wordsToIgnore = scanner.nextLine();
        scanner.close();
        rawData.insertWordsToIgnore(wordsToIgnore);
        
    }
}
