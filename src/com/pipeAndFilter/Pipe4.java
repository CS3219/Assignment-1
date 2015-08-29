package pipeAndFilter;
import java.util.*;
public class Pipe4 {
	
	private ArrayList<String> list;
	private ArrayList<String> wordsIgnore;
	
	public Pipe4(ArrayList<String> list, ArrayList<String> ignore ) {
		this.list = list;
		this.wordsIgnore = ignore;
	}
	
	public void passData() {
		Output output = new Output(list, wordsIgnore);
		output.passData();
	}

}
