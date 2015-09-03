package com.implicitInvocation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;

public class Alphabetizer implements Observer{

    /**
     * Stores the passed parametres as shifted lines and event. Parses the event 
     * and takes appropriate action.
     * @param arg0  The observed object.
     * @param arg1  The event which triggerred the broadcast. 
     */
    @Override
    public void update(Observable arg0, Object arg1) {
        LineStorage shiftedLines = (LineStorage) arg0;
        LineStorageEvent event = (LineStorageEvent) arg1;
        
        if (event.isLineAdded()) {
            sort(shiftedLines);
        }
    }

    /**
     * Sorts the passed titles.
     * @param shiftedLines   LineStorage object whose tiles are to be sorted.
     */
    public void sort(LineStorage shiftedLines) {
        ArrayList<String> titles = shiftedLines.getAllTitles();
        Collections.sort(titles);
        shiftedLines.setAllTitles(titles);
    }

}
