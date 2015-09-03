package com.implicitInvocation;

import java.util.Scanner;

/**
 * Gets input from user.
 * @author Manika Agarwal
 *
 */

public class InputReader {
    
    /** Messages to be displayed to tell user to enter input */
    private static final String MESSAGE_TITLES = "Enter titles (press enter "
            + "after each title, double enter when done): ";
    private static final String MESSAGE_WORDS_TO_IGNORE = "Enter words to "
            + "ignore separated by spaces: ";

    /**
     * Gets words to be ignored and titles to be alphabetized from the user.
     * @param rawData LineStorage component in which the inputed data is to be stored.
     */
    public void getInput(LineStorage rawData) {
        Scanner sc = new Scanner(System.in);

        System.out.print(MESSAGE_WORDS_TO_IGNORE);
        String wordsToIgnore = sc.nextLine();
        rawData.addWordsToIgnore(wordsToIgnore);
        
        System.out.println(MESSAGE_TITLES);
        
        while (true) {
            String title = sc.nextLine().toLowerCase().trim();
            if(title.equals("")) {
                break;
            } else {
                rawData.addLine(title); 
            }
        }
    }
}
