import java.util.*;
public class Pipe2 {

	private ArrayList<String> shiftedList;
	private ArrayList<String> wordsIgnore;
	
	public Pipe2(ArrayList<String> list, ArrayList<String> words) {
		this.shiftedList = list;
		this.wordsIgnore = words;
	}
	
	public void passData() {
		RemoveIgnored remove = new RemoveIgnored(shiftedList, wordsIgnore);
		remove.passData();
	}
}
