package pipeAndFilter;
import java.util.*;

public class CircularShift {
	
	private ArrayList<String> originalList;
	private ArrayList<String> shiftedList;
	private ArrayList<String> wordsIgnore;

	
	public CircularShift(ArrayList<String> titles, ArrayList<String> words) {
		this.originalList = titles;
		shiftedList = new ArrayList<String>();
		this.wordsIgnore = words;
	}
	
	private void shift() {
		for(int i=0; i<originalList.size();i++) {
			String title = originalList.get(i);
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
	
	public void passData() {
		shift();
		Pipe2 pipe = new Pipe2(shiftedList,wordsIgnore);
		pipe.passData();
	}
	
}
