import java.util.*;
public class Alphabetize {
	
	private ArrayList<String> list;
	private ArrayList<String> wordsIgnore;
	
	public Alphabetize(ArrayList<String> list, ArrayList<String> ignore) {
		this.list = list;
		this.wordsIgnore = ignore;
	}
	
	private void order() {
		Collections.sort(list);
	}
	
	public void passData() {
		order();
		Pipe4 pipe = new Pipe4(list, wordsIgnore);
		pipe.passData();
	}
}
