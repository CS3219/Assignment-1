package com.pipeAndFilter;
import java.util.*;
public class RemoveIgnored {
	
	private ArrayList<String> list;
	private ArrayList<String> wordsRemove;
	
	public RemoveIgnored(ArrayList<String> list, ArrayList<String> words) {
		this.list = list;
		this.wordsRemove = words;
	}
	
	private void removeLines() {
		for(int i=0; i<list.size(); i++) {
			String line = list.get(i);
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
		for(int i=0; i<wordsRemove.size(); i++ ){
			String ignore = wordsRemove.get(i);
			if(word.equalsIgnoreCase(ignore)) {
				list.remove(index);
			}
		}
	}
	
	public void passData() {
		removeLines();
		Pipe4 pipe = new Pipe4(list);
		pipe.passData();
		
	}
}
