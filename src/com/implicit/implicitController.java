package com.implicit;

public class ImplicitController {
    
    public void initialize() {
        InputReader in = new InputReader();
        
        LineStorage rawData = new LineStorage();
        LineStorage shiftedLines = new LineStorage();
        
        CircularShifter shifter = new CircularShifter(shiftedLines);
        rawData.addObserver(shifter);
         
        Alphabetizer alpha = new Alphabetizer();
        shiftedLines.addObserver(alpha);
        
        OutputWriter ow = new OutputWriter();
        in.getInput(rawData);
        ow.print(shiftedLines);
    }
    
}
