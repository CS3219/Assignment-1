package com.implicit;

import java.util.ArrayList;

public class OutputWriter {
    
    /** Messages to be displayed when writing output. */
    private static final String MESSAGE_OUTPUT = "Sorted Lines: ";

    /**
     * Prints the titles of the passed LineStorage object.
     * @param lines     LineStorage object to be printed.
     */
    public void print(LineStorage lines) {
        ArrayList<String> titles = lines.getAllTitles();
        
        System.out.println(MESSAGE_OUTPUT);
        for(int i = 0; i < titles.size(); i++) {   
            System.out.println(titles.get(i));
        } 
    }
}
