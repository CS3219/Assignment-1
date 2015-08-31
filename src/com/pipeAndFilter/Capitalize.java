package com.pipeAndFilter;

import java.util.ArrayList;

public class Capitalize {

	private ArrayList<String> titles;
	private ArrayList<String> wordsIgnore;
	
	public Capitalize(ArrayList<String> titles, ArrayList<String> ignore) {
		this.titles = titles;
		this.wordsIgnore = ignore;
	}
	
	private void capitalizeKeywords() {
		for(int i=0; i<titles.size(); i++) {
			String line = titles.get(i);
			capitalize(line, i);
		}
	}
	
	private void capitalize(String line, int index) {
		String[] words = line.split(" ");
		ArrayList<Integer> indexIgnored = new ArrayList<Integer>();
		
		for(int i=0;i<wordsIgnore.size();i++) {
			for(int j=0; j<words.length;j++) {
				if(words[j].equalsIgnoreCase(wordsIgnore.get(i))) {
					indexIgnored.add(j);
				}
			}
		}
		words = replaceLetter(words, indexIgnored);
		replaceLine(words, index);
		}
	
	private String[] replaceLetter(String[] words, ArrayList<Integer> indexIgnored) {
		for(int i=0;i<words.length;i++) {
			if(!indexIgnored.contains(i)) {
		String capital = words[i].substring(0, 1).toUpperCase();
		String restWord = words[i].substring(1, words[i].length());
		String keywordCapitalized = capital + restWord;
		words[i] = keywordCapitalized;
			}
		}
		return words;
	}
	
	private void replaceLine(String[] words, int index) {
		String newLine = "";
		for(int i=0;i<words.length;i++) {
			newLine = newLine + words[i] + " ";
		}
		titles.set(index, newLine.trim());
	}
	
	public void passData() {
		capitalizeKeywords();
		Pipe2 pipe = new Pipe2(titles, wordsIgnore);
		pipe.passData();
	}
}
