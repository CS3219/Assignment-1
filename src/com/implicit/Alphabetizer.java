package com.implicit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Observer;

public class Alphabetizer implements Observer{

    //private LineStorage shiftedLines = new LineStorage();

    @Override
    public void update(Observable arg0, Object arg1) {
        LineStorage shiftedLines = (LineStorage) arg0;
        LineStorageEvent event = (LineStorageEvent) arg1;
        
        if (event.isLineAdded()) {
            sort(shiftedLines);
        }
    }

    public void sort(LineStorage shiftedLines) {
        ArrayList<String> titles = shiftedLines.getAllTitles();
        Collections.sort(titles);
        shiftedLines.setAllTitles(titles);
    }

}
