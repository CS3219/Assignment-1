package com.implicitInvocation;

/**
 * This is the controller of the Implicit Invocation method to solve the 
 * KWIC problem. 
 * @author Manika Agarwal
 *
 */

public class ImplicitController {
    
    /**
     * Instantiates components, gets input and prints output.
     */
    public void start() {
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
