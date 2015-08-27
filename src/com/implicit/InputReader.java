package com.implicit;

import java.util.Scanner;

/**
 * Gets input from user.
 * @author Manika
 *
 */

public class InputReader {
    public void getInput(Lines rawData) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter words to ignore separated by spaces: ");
        String wordsToIgnore = sc.nextLine();
        System.out.println(wordsToIgnore);

        rawData.insertWordsToIgnore(wordsToIgnore);
        sc.close();
    }
}
