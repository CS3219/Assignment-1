package com.implicit;

public class ImplicitController {
    
    public void initialize() {
        InputReader in = new InputReader();
        LineStorage rawData = new LineStorage();
        CircularShifter shifter = new CircularShifter();
        rawData.addObserver(shifter);
        
        getInput(in, rawData);
    }
    
    private void getInput(InputReader in, LineStorage rawData) {
        in.getInput(rawData);
    }
}
