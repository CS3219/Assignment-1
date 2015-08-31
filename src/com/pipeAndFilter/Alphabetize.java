package pipeAndFilter;
import java.util.*;
public class Alphabetize {
	
	private ArrayList<String> list;
	
	public Alphabetize(ArrayList<String> list) {
		this.list = list;
	}
	
	private void order() {
		Collections.sort(list);
	}
	
	public void passData() {
		order();
		Pipe5 pipe = new Pipe5(list);
		pipe.passData();
	}
}
