package com.pipeAndFilter;
import java.util.*;

public class CircularShift extends Filter {
	
	private ArrayList<String> shiftedList;
	private ArrayList<String> titles;
	private ArrayList<String> wordsIgnore;
	private Data data;
	
	public CircularShift() {
		this.titles = new ArrayList<String>();
		this.wordsIgnore = new ArrayList<String>();
		this.shiftedList = new ArrayList<String>();
		data = new Data();
	}

	private void shift() {
		for(int i=0; i<titles.size();i++) {
			String title = titles.get(i);
			shiftedList.add(title);
			lineShift(title);
		}
	}
	
	private void lineShift(String line) {
		String[] words = line.split(" ");
		for(int i=0;i<words.length-1;i++) {
			int index = line.indexOf(" ");
			String firstWord = line.substring(0,index);
			String remainingLine = line.substring(index+1, line.length());
			String newLine = remainingLine + " " + firstWord;
			shiftedList.add(newLine);
			line = newLine;
		}
	}
	
	public void execute(Data data) {
		System.out.println("In circular shift");
		this.titles = data.getTitles();
		this.wordsIgnore = data.getIgnore();
		shift();
		this.data.setTitles(shiftedList);
		this.data.setWordsIgnore(wordsIgnore);
		nextPipe.passData(this.data);
	}
	
}
