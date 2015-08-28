package com.implicit;

import java.util.Observable;
import java.util.Observer;
import java.util.StringTokenizer;

public class CircularShifter implements Observer{

    //private LineStorage rawData = new LineStorage();
    private LineStorage linesToShift = new LineStorage();
    //private LineStorageEvent event = new LineStorageEvent(); 
    
    public CircularShifter(LineStorage linesToShift) {
        this.linesToShift = linesToShift;
    }
    
    @Override
    public void update(Observable arg0, Object arg1) {
        LineStorage rawData = (LineStorage) arg0;
        LineStorageEvent event = (LineStorageEvent) arg1;
        
        parseEvent(event, rawData);
    }

    private void parseEvent(LineStorageEvent event, LineStorage rawData) {
        if (event.isLineAdded()) {
            shiftLines(rawData.getLastTitle());
        } else if (event.isWordsToIgnoreAdded()) {
            linesToShift.addWordsToIgnore(rawData.getWordsToIgnore());
        }
    }

    private void shiftLines (String str) {
        int count = getNumberOfWords(str);
        
        for (int i = 0; i < count; i++) {
           String splitStr[] = str.split(" ", 2);
           str = splitStr[1].concat(" " + splitStr[0]);
           String firstWord[] = str.split(" ", 2);
           
           if (!linesToShift.getWordsToIgnore().contains(firstWord[0])) {
               linesToShift.addLine(str);
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
