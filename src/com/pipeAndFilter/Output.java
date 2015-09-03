package com.pipeAndFilter;
import java.util.*;
public class Output extends Filter {
	
	private ArrayList<String> titles;
	
	public Output() {
		this.titles = new ArrayList<String>();
	}
		
	public void execute(Data data) {
		this.titles = data.getTitles();
		printOutput();
	}
	
	private void printOutput() {
		System.out.println("Output:");
		for(int i=0; i<titles.size();i++) {
			System.out.println(titles.get(i));
		}
	}
}
