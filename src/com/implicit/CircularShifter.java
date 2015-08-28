package com.implicit;

import java.util.Observable;
import java.util.Observer;
import java.util.StringTokenizer;

public class CircularShifter implements Observer{

    private LineStorage rawData = new LineStorage();
    private LineStorage shiftedLines = new LineStorage();
    private LineStorageEvent event = new LineStorageEvent(); 
    
    @Override
    public void update(Observable obj, Object arg1) {
        rawData = (LineStorage) obj;
        event = (LineStorageEvent) arg1;
        
        parseEvent();
    }

    private void parseEvent() {
        if (event.isLineAdded()) {
            shiftLines(rawData.getLastTitle());
        } else if (event.isWordsToIgnoreAdded()) {
            shiftedLines.insertWordsToIgnore(rawData.getWordsToIgnore());
        }
    }

    private void shiftLines (String str) {
        int count = getNumberOfWords(str), i;
        
        for (i = 0; i < count; i++) {
           String splitStr[] = str.split(" ", 2);
           str = splitStr[1].concat(" " + splitStr[0]);
           String firstWord[] = str.split(" ", 2);
           
           if (!shiftedLines.getWordsToIgnore().contains(firstWord[0])) {
               shiftedLines.insertLine(str);
           }
        }
    }

    private int getNumberOfWords(String str) {
        StringTokenizer st = new StringTokenizer(str);
        int count = 0;
        
        while (st.hasMoreTokens()) {
            count++;
            st.nextToken();
        }
        
        return count;
    }
}
