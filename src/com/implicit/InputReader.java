package com.implicit;

import java.util.Scanner;

/**
 * Gets input from user.
 * @author Manika Agarwal
 *
 */

public class InputReader {
    public void getInput(Lines rawData) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter words to ignore separated by spaces: ");
        String wordsToIgnore = sc.nextLine();
        rawData.insertWordsToIgnore(wordsToIgnore);
        //System.out.println(wordsToIgnore);
        
        System.out.println("Enter titles (press enter after each title, Ctrl+Z when done): ");
        
        while(sc.hasNextLine()) {
            String title = sc.nextLine();
            rawData.insertLine(title); 
        }
        
        sc.close();
    }
}
