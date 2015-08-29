package pipeAndFilter;
import java.util.*;

//This program is implemented using the Pipe and Filter architecture.
public class InputFilter {
	
	private static final String WELCOME_MESSAGE = "Welcome to KWIC index system. Please enter number of titles you wish to enter:";
	private static final String TITLES_MESSAGE = "Please enter the titles:";
	private static final String IGNORENUMBER_MESSAGE =  "Please enter number of words to ignore:";
	private static final String IGNORE_MESSAGE = "Please enter words you wish to ignore";
	
	
	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<String> titles = new ArrayList<String>();
	private static ArrayList<String> wordsIgnore = new ArrayList<String>();
	private static int numberTitles;
	private static int numberIgnore;
	
	public static void main(String[] args) {
		printWelcome();
		saveNumberTitles();
		printRequestTitles();
		saveTitles();
		printRequestNumberIgnore();
		saveNumberIgnore();
		printRequestWordsIgnore();
		saveIgnore();
		passToPipe();
	}
	
	private static void printWelcome() {
		System.out.println(WELCOME_MESSAGE);
	}
	
	private static void printRequestNumberIgnore() {
		System.out.println(IGNORENUMBER_MESSAGE);
	}
	
	private static void printRequestTitles() {
		System.out.println(TITLES_MESSAGE);
	}
	
	private static void printRequestWordsIgnore() {
		System.out.println(IGNORE_MESSAGE);
	}
	private static void saveTitles() {
		for(int i=0; i<numberTitles; i++) {
			titles.add(sc.nextLine().toLowerCase().trim());
		}
	}
	
	private static void saveIgnore() {
		for(int i=0; i<numberIgnore;i++) {
			wordsIgnore.add(sc.nextLine().trim());		
		}
	}
	
	private static void saveNumberTitles() {
		String numberString = sc.nextLine();
		numberTitles = Integer.parseInt(numberString);
	}
	
	private static void saveNumberIgnore() {
		String numberString = sc.nextLine();
		numberIgnore = Integer.parseInt(numberString);
	}
	private static void passToPipe() {
		Pipe1 pipe = new Pipe1(titles, wordsIgnore);
		pipe.passData();
	}
}
