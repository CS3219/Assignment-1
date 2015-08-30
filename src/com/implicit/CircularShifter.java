package com.implicit;

import java.util.ArrayList;
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
            String capitalStr = capitalize(rawData.getLastTitle());
            shiftLines(capitalStr);
        } else if (event.isWordsToIgnoreAdded()) {
            linesToShift.addWordsToIgnore(rawData.getWordsToIgnore());
        }
    }

    private String capitalize(String str) {
        int count = getNumberOfWords(str);
        String splitStr[] = str.split(" "), strToShift = "";

        for (int i = 0; i < count; i++) {
            if (containsCaseInsensitive(splitStr[i], linesToShift.getWordsToIgnore())) {
                strToShift = strToShift + splitStr[i].toLowerCase() + " ";
            } else {
                if (splitStr[i].length() == 1) {
                    strToShift = strToShift + splitStr[i].toUpperCase() + " ";
                }
                else {
                    strToShift = strToShift + splitStr[i].substring(0,1).toUpperCase()
                            + splitStr[i].substring(1).toLowerCase() + " ";
                }
            }
        }

        return strToShift.trim();
    }

    private void shiftLines (String str) {
        int count = getNumberOfWords(str);

        if (count <= 1) {
            //System.out.println("yes1");
            if (!containsCaseInsensitive(str, linesToShift.getWordsToIgnore())) {
                linesToShift.addLine(str);
                //System.out.println("yes");
            }
        } else {
            for (int i = 0; i < count; i++) {
                String splitStr[] = str.split(" ", 2);
                str = splitStr[1].concat(" " + splitStr[0]);
                String firstWord[] = str.split(" ", 2);

                if (!containsCaseInsensitive(firstWord[0], linesToShift.getWordsToIgnore())) {
                    //linesToShift.getWordsToIgnore().contains(firstWord[0])) {
                    linesToShift.addLine(str);
                }
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

    private boolean containsCaseInsensitive(String strToCompare, ArrayList<String> list) {
        for(String str:list) {
            if(str.equalsIgnoreCase(strToCompare)) {
                return true ;
            }
        }

        return false ;
    }
}
