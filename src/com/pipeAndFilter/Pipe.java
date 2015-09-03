package com.pipeAndFilter;

public class Pipe {
	
	private Filter nextFilter;
	
	public Pipe() {
		
	}
	
	public void passData(Data data) {
		nextFilter.execute(data);
	}
	
	public void setNextFilter(Filter filter){
		this.nextFilter = filter;
	}
	
}
