package com.pipeAndFilter;
import java.util.*;
public class Output {
	
	ArrayList<String> outputList;
	
	public Output(ArrayList<String> list) {
		this.outputList = list;
	}
		
	public void passData() {
		printOutput();
	}
	
	private void printOutput() {
		System.out.println("Output:");
		for(int i=0; i<outputList.size();i++) {
			System.out.println(outputList.get(i));
		}
	}
}
