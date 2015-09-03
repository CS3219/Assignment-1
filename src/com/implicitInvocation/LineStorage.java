package com.implicitInvocation;

import java.util.ArrayList;
import java.util.Observable;
import java.util.StringTokenizer;

/**
 * Stores and manipulates titles and words to be ignored entered by user.
 * @author Manika Agarwal
 *
 */

public class LineStorage extends Observable{

    /** Stores the titles to be alphabetized */
    private ArrayList<String> titles = new ArrayList<String>();
    
    /** Stores the words to be ignored */
    private ArrayList<String> wordsToIgnore = new ArrayList<String>();
    
    /** For broadcasting events */
    private LineStorageEvent event = new LineStorageEvent(); 
     
    /**
     * Adds in the passed string to titles and broadcasts the relevant event.
     * @param str String to be added to titles.
     */
    public void addLine(String str) {
        titles.add(str.trim());
        event.setLineAdded();
        broadcastEvent();
    }
    
    /**
     * Adds in the passed words to be ignored to wordsToIgnore and broadcasts 
     * the relevant event.
     * @param words String of words to be added to wordsToIgnore.
     */
    public void addWordsToIgnore(String words) {
        insertWordsToIgnore(words);
        
        event.setWordsToIgnoreAdded();
        broadcastEvent();
    }
    
    /**
     * Adds in the passed words to be ignored to wordsToIgnore.
     * @param words ArrayList of words to be added to wordsToIgnore.
     */
    public void addWordsToIgnore(ArrayList<String> words) {
        wordsToIgnore = words;
    }
    
    /**
     * Sets this.titles to the passed titles.
     * @param titles ArrayList of titles. 
     */
    public void setAllTitles(ArrayList<String> titles) {
        this.titles = titles;
    }
    
    /**
     * Returns this.titles.
     * @return this.titles.
     */
    public ArrayList<String> getAllTitles() {
        return titles;
    }
    
    /**
     * Returns the last title in this.titles. 
     * @return last title.
     */
    public String getLastTitle() {
        return titles.get(titles.size()-1);
    }
    
    /**
     * Returns this.wordsToIgnore.
     * @return words to ignore.
     */
    public ArrayList<String> getWordsToIgnore() {
        return wordsToIgnore;
    }

    /**
     * Tokenizes the string of words to be added and adds each word one by one 
     * to wordsToIgnore.
     * @param words String of words to be added to wordsToIgnore.
     */
    private void insertWordsToIgnore(String words) {
        StringTokenizer st = new StringTokenizer(words);
        
        while (st.hasMoreTokens()) {
            wordsToIgnore.add(st.nextToken());
        }
    }
    
    /**
     * Broadcast event.
     */
    private void broadcastEvent() {
        setChanged();
        notifyObservers(event);
    }
}
