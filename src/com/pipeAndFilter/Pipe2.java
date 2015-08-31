package pipeAndFilter;
import java.util.*;
public class Pipe2 {

	private ArrayList<String> list;
	private ArrayList<String> wordsIgnore;
	
	public Pipe2(ArrayList<String> list, ArrayList<String> words) {
		this.list = list;
		this.wordsIgnore = words;
	}
	
	public void passData() {
		 CircularShift circularShift = new CircularShift(list, wordsIgnore);
		circularShift.passData();
	}
}
