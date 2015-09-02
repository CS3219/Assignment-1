package com.pipeAndFilter;

import java.util.ArrayList;

public class Data {
	ArrayList<String> titles;
	ArrayList<String> wordsIgnore;
	
	public Data(){
		titles = new ArrayList<String>();
		wordsIgnore = new ArrayList<String>();
	}
	
	public void setTitles(ArrayList<String> titles) {
		this.titles = titles;
	}
	
	public void setWordsIgnore(ArrayList<String> ignore) {
		this.wordsIgnore = ignore;
	}
	
	public ArrayList<String> getTitles() {
		return titles;
	}
	
	public ArrayList<String> getIgnore() {
		return wordsIgnore;
	}
}
