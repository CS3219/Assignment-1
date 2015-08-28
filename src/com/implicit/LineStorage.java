package com.implicit;

import java.util.ArrayList;
import java.util.Observable;
import java.util.StringTokenizer;

/**
 * Stores and manipulates titles and words to ignore entered by user.
 * @author Manika Agarwal
 *
 */

public class LineStorage extends Observable{

    private ArrayList<String> titles = new ArrayList<String>();
    private ArrayList<String> wordsToIgnore = new ArrayList<String>();
    private LineStorageEvent event = new LineStorageEvent(); 
    
    public void insertLine(String str) {
        titles.add(str.trim());
        event.setLineAdded();
        broadcastEvent();
    }
    
    public void insertWordsToIgnore(String words) {
        StringTokenizer st = new StringTokenizer(words);
        
        while (st.hasMoreTokens()) {
            wordsToIgnore.add(st.nextToken());
        }
        
        event.setWordsToIgnoreAdded();
        broadcastEvent();
    }
    
    public void insertWordsToIgnore(ArrayList<String> words) {
        wordsToIgnore = words;
    }

    private void broadcastEvent() {
        setChanged();
        notifyObservers(event);
    }
    
    public String getLastTitle() {
        return titles.get(titles.size()-1);
    }
    
    public ArrayList<String> getWordsToIgnore() {
        return wordsToIgnore;
    }

}
