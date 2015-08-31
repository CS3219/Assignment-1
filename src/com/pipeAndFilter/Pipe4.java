package com.pipeAndFilter;
import java.util.*;
public class Pipe4 {
	
	private ArrayList<String> list;
	
	public Pipe4(ArrayList<String> list) {
		this.list = list;
	}
	
	public void passData() {
		Alphabetize alphabetize = new Alphabetize(list);
		alphabetize.passData();
	}

}
