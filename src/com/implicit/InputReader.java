package com.implicit;

import java.util.Scanner;

/**
 * Gets input from user.
 * @author Manika Agarwal
 *
 */

public class InputReader {
    public void getInput(LineStorage rawData) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter words to ignore separated by spaces: ");
        String wordsToIgnore = sc.nextLine();
        rawData.addWordsToIgnore(wordsToIgnore);
        //System.out.println(wordsToIgnore);
        
        System.out.println("Enter titles (press enter after each title, Ctrl+Z when done): ");
        
        while(sc.hasNextLine()) {
            String title = sc.nextLine();
            rawData.addLine(title); 
        }
        
        sc.close();
    }
}
