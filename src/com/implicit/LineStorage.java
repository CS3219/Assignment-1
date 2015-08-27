package com.implicit;

import java.util.ArrayList;

/**
 * Stores and manipulates strings entered.
 * @author Manika Agarwal
 *
 */

public class LineStorage {

    private ArrayList<String> titles = new ArrayList<String>();
    private ArrayList<String> wordsToIgnore = new ArrayList<String>();
    
    public void insertLine(String str) {
        titles.add(str);
    }
    
    public void insertWordToIgnore(String str) {
        wordsToIgnore.add(str);
    }
    
}
