package com.implicit;

import java.util.ArrayList;

public class OutputWriter {
    
    private static final String MESSAGE_OUTPUT = "Sorted Lines: ";

    public void print(LineStorage lines) {
        ArrayList<String> titles = lines.getAllTitles();
        
        System.out.println(MESSAGE_OUTPUT);
        for(int i = 0; i < titles.size(); i++) {   
            System.out.println(titles.get(i));
        } 
    }
}
