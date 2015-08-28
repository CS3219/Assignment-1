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
    
    public void addLine(String str) {
        titles.add(str.trim());
        event.setLineAdded();
        broadcastEvent();
    }
    
    public void addWordsToIgnore(String words) {
        insertWordsToIgnore(words);
        
        event.setWordsToIgnoreAdded();
        broadcastEvent();
    }

    private void insertWordsToIgnore(String words) {
        StringTokenizer st = new StringTokenizer(words);
        
        while (st.hasMoreTokens()) {
            wordsToIgnore.add(st.nextToken());
        }
    }
    
    public void addWordsToIgnore(ArrayList<String> words) {
        wordsToIgnore = words;
    }
    
    public void setAllTitles(ArrayList<String> titles) {
        this.titles = titles;
    }
    
    public ArrayList<String> getAllTitles() {
        return titles;
    }
    
    public String getLastTitle() {
        return titles.get(titles.size()-1);
    }
    
    public ArrayList<String> getWordsToIgnore() {
        return wordsToIgnore;
    }

    private void broadcastEvent() {
        setChanged();
        notifyObservers(event);
    }
}
