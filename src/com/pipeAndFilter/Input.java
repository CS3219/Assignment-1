package com.pipeAndFilter;

import java.util.*;

//This program is implemented using the Pipe and Filter architecture.
public class Input {

	private static final String WELCOME_MESSAGE = "Welcome you are now running KWIC implemented by pipe and filter.";
	private static final String TITLES_MESSAGE = "Please enter the titles, pressing enter after each title. Please press CTRL-Z when you have finished entering the titles.";
	private static final String IGNORE_MESSAGE = "Please enter words you wish to ignore and separate them by a space:";

	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<String> titles = new ArrayList<String>();
	private static ArrayList<String> wordsIgnore = new ArrayList<String>();

	public static void main(String[] args) {
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

	private static void saveTitles() {
		while (sc.hasNextLine()) {
			titles.add(sc.nextLine().toLowerCase().trim());
		}
	}

	private static void saveIgnore() {
		String inputLine = sc.nextLine();
		String[] words = inputLine.split(" ");
		for (int i = 0; i < words.length; i++)
			wordsIgnore.add(words[i]);
	}

	private static void passToPipe() {
		Pipe1 pipe = new Pipe1(titles, wordsIgnore);
		pipe.passData();
	}
}
