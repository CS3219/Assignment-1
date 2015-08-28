package com.implicit;

public class LineStorageEvent {
    
    private enum EVENT_TYPES {LINE_ADDED, WORDS_TO_IGNORE_ADDED}; //CIRCULAR_SHIFTS_ADDED};
    private EVENT_TYPES event;
    
    public void setLineAdded() {
        setEvent(EVENT_TYPES.LINE_ADDED);
    }
    
    public void setWordsToIgnoreAdded() {
        setEvent(EVENT_TYPES.WORDS_TO_IGNORE_ADDED);
    }
    
    /*public void setCircularShiftsAdded() {
        setEvent(EVENT_TYPES.CIRCULAR_SHIFTS_ADDED);
    }*/
    
    public boolean isLineAdded() {
        if (event == EVENT_TYPES.LINE_ADDED) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isWordsToIgnoreAdded() {
        if (event == EVENT_TYPES.WORDS_TO_IGNORE_ADDED) {
            return true;
        } else {
            return false;
        }
    }
    
    /*public boolean isCircularShiftsAdded() {
        if (event == EVENT_TYPES.CIRCULAR_SHIFTS_ADDED) {
            return true;
        } else {
            return false;
        }
    }*/
    
    private void setEvent (EVENT_TYPES et) {
        event = et;
    }
}
