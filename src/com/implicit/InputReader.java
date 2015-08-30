package com.implicit;

import java.util.Scanner;

/**
 * Gets input from user.
 * @author Manika Agarwal
 *
 */

public class InputReader {
    private static final String MESSAGE_TITLES = "Enter titles (press enter after each title, Ctrl+Z when done): ";
    private static final String MESSAGE_WORDS_TO_IGNORE = "Enter words to ignore separated by spaces: ";

    public void getInput(LineStorage rawData) {
        Scanner sc = new Scanner(System.in);

        System.out.print(MESSAGE_WORDS_TO_IGNORE);
        String wordsToIgnore = sc.nextLine();
        rawData.addWordsToIgnore(wordsToIgnore);
        //System.out.println(wordsToIgnore);
        
        System.out.println(MESSAGE_TITLES);
        
        while(sc.hasNextLine()) {
            String title = sc.nextLine();
            rawData.addLine(title); 
        }
        
        sc.close();
    }
}
