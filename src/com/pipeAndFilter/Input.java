package com.pipeAndFilter;

import java.util.*;

//This program is implemented using the Pipe and Filter architecture.
public class Input extends Filter {

	private static final String WELCOME_MESSAGE = "Welcome you are now running KWIC implemented by pipe and filter.";
	private static final String TITLES_MESSAGE = "Please enter the titles, pressing enter after each title. \nPlease press enter twice when you have finished entering the titles.";
	private static final String IGNORE_MESSAGE = "Please enter words you wish to ignore and separate them by a space:";

	private static Scanner sc;
	private Data data;
	private ArrayList<String> titles;
	private ArrayList<String> wordsIgnore;
	
	public Input() {
		data = new Data();
		this.titles = new ArrayList<String>();
		this.wordsIgnore = new ArrayList<String>();
		sc = new Scanner(System.in);
	}
	
	public void execute() {
		printWelcome();
		printRequestWordsIgnore();
		saveIgnore();
		printRequestTitles();
		saveTitles();
		passToPipe();
	}

	private static void printWelcome() {
		System.out.println(WELCOME_MESSAGE);
	}

	private static void printRequestTitles() {
		System.out.println(TITLES_MESSAGE);
	}

	private static void printRequestWordsIgnore() {
		System.out.println(IGNORE_MESSAGE);
	}

	private void saveTitles() {
		String inputLine;
		while (true) {
			inputLine = sc.nextLine().toLowerCase().trim();
			if(inputLine.equals("")) {
				break;
			} else {
			titles.add(inputLine);
			}
		}
	}

	private void saveIgnore() {
		String inputLine = sc.nextLine();
		String[] words = inputLine.split(" ");
		for (int i = 0; i < words.length; i++)
			wordsIgnore.add(words[i]);
	}

	private void passToPipe() {
		data.setTitles(titles);
		data.setWordsIgnore(wordsIgnore);
		nextPipe.passData(data);
	}
}
