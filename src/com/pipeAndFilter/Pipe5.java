package com.pipeAndFilter;
import java.util.*;
public class Pipe5 {

	private ArrayList<String> sortedList;
	
	public Pipe5(ArrayList<String> list) {
		this.sortedList = list;
	}
	
	public void passData() {
		Output output = new Output(sortedList);
		output.passData();
	}
	
	
}
