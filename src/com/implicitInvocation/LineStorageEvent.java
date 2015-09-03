package com.implicitInvocation;

/**
 * Event class implements a simple protocol for describing the type of 
 * event that occurred in a LineStorage object.
 * @author Manika Agarwal
 *
 */

public class LineStorageEvent {
    
    /** Types of events */
    private enum EVENT_TYPES {LINE_ADDED, WORDS_TO_IGNORE_ADDED}; 
    
    /** Records which type of event has occurred */
    private EVENT_TYPES event;
    
    /**
     * Sets the event type to LINE_ADDED.
     */
    public void setLineAdded() {
        setEvent(EVENT_TYPES.LINE_ADDED);
    }
    
    /**
     * Sets the event type to WORDS_TO_IGNORE_ADDED.
     */
    public void setWordsToIgnoreAdded() {
        setEvent(EVENT_TYPES.WORDS_TO_IGNORE_ADDED);
    }

    /**
     * Checks if the event is of type LINE_ADDED.
     * @return true     if event is of type LINE_ADDED.
     *         false    otherwise
     */
    public boolean isLineAdded() {
        if (event == EVENT_TYPES.LINE_ADDED) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Checks if the event is of type WORDS_TO_IGNORE_ADDED.
     * @return true     if event is of type WORDS_TO_IGNORE_ADDED.
     *         false    otherwise
     */
    public boolean isWordsToIgnoreAdded() {
        if (event == EVENT_TYPES.WORDS_TO_IGNORE_ADDED) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Sets the event to the passed event type.
     * @param et Type of event.
     */
    private void setEvent (EVENT_TYPES et) {
        event = et;
    }
}
