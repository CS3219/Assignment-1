package com.pipeAndFilter;
import java.util.*;

public class Pipe1 {
	
	private ArrayList<String> titles;
	private ArrayList<String> wordsIgnore;
	
	public Pipe1(ArrayList<String> inputList, ArrayList<String> words) {
		this.titles = inputList;
		this.wordsIgnore = words;
	}
	
	public void passData() {
		Capitalize capitalize = new Capitalize(titles, wordsIgnore);
		capitalize.passData();
	}
}
