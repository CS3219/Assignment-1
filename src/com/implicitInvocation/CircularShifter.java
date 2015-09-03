package com.implicitInvocation;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.StringTokenizer;

public class CircularShifter implements Observer{

    /** Stores the lines to be shifted and the associated words to ignore. */
    private LineStorage shiftedLines = new LineStorage();

    /**
     * Constructor. Initializes this.linesToShift with the passed LineStorage object. 
     * @param linesToShift LineStorage object to be used for initialization.
     */
    public CircularShifter(LineStorage linesToShift) {
        this.shiftedLines = linesToShift;
    }
    
    /**
     * Stores the passed parametres as rawData(unshifted lines) and event. Sends 
     * the event for parsing of event type.  
     * @param arg0  The observed object.
     * @param arg1  The event which triggered the broadcast. 
     */
    @Override
    public void update(Observable arg0, Object arg1) {
        LineStorage rawData = (LineStorage) arg0;
        LineStorageEvent event = (LineStorageEvent) arg1;

        parseEvent(event, rawData);
    }

    /**
     * Parses the event to find out what kind of event occurred and takes 
     * appropriate action.
     * @param event     Event to be parsed. 
     * @param rawData   Data to be altered/used.
     */
    private void parseEvent(LineStorageEvent event, LineStorage rawData) {
        if (event.isLineAdded()) {
            String capitalStr = capitalize(rawData.getLastTitle());
            shiftLines(capitalStr);
        } else if (event.isWordsToIgnoreAdded()) {
            shiftedLines.addWordsToIgnore(rawData.getWordsToIgnore());
        }
    }

    /**
     * Capitalizes the first letter of keywords and converts non-keywords 
     * to lowercase.
     * @param str   String to be formatted.
     * @return formatted string.
     */
    private String capitalize(String str) {
        int count = getNumberOfWords(str);
        String splitStr[] = str.split(" "), strToShift = "";

        for (int i = 0; i < count; i++) {
            if (containsCaseInsensitive(splitStr[i], shiftedLines.getWordsToIgnore())) {
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

    /**
     * Performs circular shifts on the passed string and stores the shifts that 
     * begin with a keyword into shiftedLines.   
     * @param str   String to be shifted.
     */
    private void shiftLines (String str) {
        int count = getNumberOfWords(str);

        if (count <= 1) {
            if (!containsCaseInsensitive(str, shiftedLines.getWordsToIgnore())) {
                shiftedLines.addLine(str);
            }
        } else {
            for (int i = 0; i < count; i++) {
                String splitStr[] = str.split(" ", 2);
                str = splitStr[1].concat(" " + splitStr[0]);
                String firstWord[] = str.split(" ", 2);

                if (!containsCaseInsensitive(firstWord[0], shiftedLines.getWordsToIgnore())) {
                    shiftedLines.addLine(str);
                }
            }
        }
    }

    /**
     * Returns the number of words in the passed string.
     * @param str   String.
     * @return number of words in str.
     */
    private int getNumberOfWords(String str) {
        StringTokenizer st = new StringTokenizer(str);
        int count = 0;

        while (st.hasMoreTokens()) {
            //System.out.println();
            count++;
            st.nextToken();
        }
     
        return count;
    }

    /**
     * Checks if the passed ArrayList contains the passed string.
     * @param strToCompare      String to be checked.
     * @param list              ArrayList to be checked.
     * @return true     if list contains strToCompare.
     *         false    otherwise.
     */
    private boolean containsCaseInsensitive(String strToCompare, ArrayList<String> list) {
        for(String str:list) {
            if(str.equalsIgnoreCase(strToCompare)) {
                return true ;
            }
        }

        return false ;
    }
}
