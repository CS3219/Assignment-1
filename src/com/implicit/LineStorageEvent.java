package com.implicit;

public class LineStorageEvent {
    
    private enum EVENT_TYPES {LINE_ADDED, WORDS_TO_IGNORE_ADDED, CIRCULAR_SHIFTS_ADDED};
    private EVENT_TYPES event;
    
    public void setEvent (EVENT_TYPES et) {
        event = et;
    }
}
