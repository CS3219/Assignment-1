package com.pipeAndFilter;
import java.util.*;
public class RemoveIgnored extends Filter {
		
	private ArrayList<String> titles;
	private ArrayList<String> wordsIgnore;
	private Data data;
	
	public RemoveIgnored () {
		data = new Data();
		this.titles = new ArrayList<String>();
		this.wordsIgnore = new ArrayList<String>();
	}
	
	private void removeLines() {
		for(int i=0; i<titles.size(); i++) {
			String line = titles.get(i);
			int index = line.indexOf(" ");
			String firstWord;
			if(index == -1) {
				firstWord = line;
			} else {
			firstWord = line.substring(0, index);
			}
			checkIgnore(i, firstWord);
		}
	}
	
	private void checkIgnore(int index, String word) {
		for(int i=0; i<wordsIgnore.size(); i++ ){
			String ignore = wordsIgnore.get(i);
			if(word.equalsIgnoreCase(ignore)) {
				titles.remove(index);
			}
		}
	}
	
	public void execute(Data data) {
		this.titles = data.getTitles();
		this.wordsIgnore = data.getIgnore();
		removeLines();
		this.data.setTitles(titles);
		nextPipe.passData(this.data);
	}
	
}
