package com.pipeAndFilter;

public class Filter {
	
	protected Pipe nextPipe;
	
	public Filter() {
	}
	
	public void setNextPipe(Pipe pipe) {
		this.nextPipe = pipe;
	}

	public void execute(Data data) {
		
	}

}
