package com.implicit;

import java.util.Observable;
import java.util.Observer;

public class CircularShifter implements Observer{

    private LineStorage rawData, shiftedLines;
    
    @Override
    public void update(Observable obj, Object arg1) {
        rawData = (LineStorage) obj;
        shiftLines(rawData.getLastTitle(), rawData.getWordsToIgnore());
    }

    private void shiftLines (String str) {
        
    }
}
