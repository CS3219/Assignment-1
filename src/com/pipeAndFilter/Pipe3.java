package pipeAndFilter;
import java.util.*;
public class Pipe3 {
	
	private ArrayList<String> list;
	private ArrayList<String> wordsIgnore;
	
	public Pipe3(ArrayList<String> list, ArrayList<String> ignore) {
		this.list = list;
		this.wordsIgnore = ignore;
	}
	
	public void passData() {
		Alphabetize alphabetizer = new Alphabetize(list, wordsIgnore);
		alphabetizer.passData();
	}

}
