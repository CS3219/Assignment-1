package com.pipeAndFilter;

public class PipeAndFilterController {
	
	public PipeAndFilterController() {
		
	}
	
	public void startExecution() {
	Input inputFilter = new Input();
	Capitalize capitalizeFilter = new Capitalize();
	Pipe inputCapitalizePipe = new Pipe();
	inputFilter.setNextPipe(inputCapitalizePipe);
	inputCapitalizePipe.setNextFilter(capitalizeFilter);
	
	CircularShift circularShiftFilter = new CircularShift();
	Pipe inputCircularShiftPipe = new Pipe();
	capitalizeFilter.setNextPipe(inputCircularShiftPipe);
	inputCircularShiftPipe.setNextFilter(circularShiftFilter);
	
	RemoveIgnored removeIgnoredFilter = new RemoveIgnored();
	Pipe inputRemoveIgnoredPipe = new Pipe();
	circularShiftFilter.setNextPipe(inputRemoveIgnoredPipe);
	inputRemoveIgnoredPipe.setNextFilter(removeIgnoredFilter);
	
	Alphabetize alphabetizeFilter = new Alphabetize();
	Pipe inputAlphabetizeFilterPipe = new Pipe();
	removeIgnoredFilter.setNextPipe(inputAlphabetizeFilterPipe);
	inputAlphabetizeFilterPipe.setNextFilter(alphabetizeFilter);
	
	Output outputFilter = new Output();
	Pipe inputOutputFilterPipe = new Pipe();
	alphabetizeFilter.setNextPipe(inputOutputFilterPipe);
	inputOutputFilterPipe.setNextFilter(outputFilter);	
	
	inputFilter.execute();
	}

}
