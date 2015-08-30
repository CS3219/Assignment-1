package com.implicit;

import java.util.ArrayList;

public class OutputWriter {
    
    public void print(LineStorage lines) {
        ArrayList<String> titles = lines.getAllTitles();
        
        System.out.println("Sorted Lines: ");
        for(int i = 0; i < titles.size(); i++) {   
            System.out.println(titles.get(i));
        } 
    }
}
