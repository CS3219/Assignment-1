package com.implicit;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Stores and manipulates strings entered.
 * @author Manika Agarwal
 *
 */

public class Lines {

    private ArrayList<String> titles = new ArrayList<String>();
    private ArrayList<String> wordsToIgnore = new ArrayList<String>();
    
    public void insertLine(String str) {
        titles.add(str);
    }
    
    public void insertWordsToIgnore(String words) {
        StringTokenizer st = new StringTokenizer(words);
        
        while (st.hasMoreTokens()) {
            wordsToIgnore.add(st.nextToken());
        }
    }
    
}
