import java.util.*;
public class Output {
	
	ArrayList<String> outputList;
	ArrayList<String> wordsIgnore;
	
	public Output(ArrayList<String> list, ArrayList<String> ignore) {
		this.outputList = list;
		this.wordsIgnore = ignore;
	}
	
	private void capitalizeKeywords() {
		for(int i=0; i<outputList.size(); i++) {
			String line = outputList.get(i);
			capitalize(line, i);
		}
	}
	
	private void capitalize(String line, int index) {
		String[] words = line.split(" ");
		ArrayList<Integer> indexIgnored = new ArrayList<Integer>();
		
		for(int i=0;i<wordsIgnore.size();i++) {
			for(int j=0; j<words.length;j++) {
				if(words[j].equalsIgnoreCase(wordsIgnore.get(i))) {
					indexIgnored.add(j);
				}
			}
		}
		words = replaceLetter(words, indexIgnored);
		replaceLine(words, index);
		}
	
	private String[] replaceLetter(String[] words, ArrayList<Integer> indexIgnored) {
		for(int i=0;i<words.length;i++) {
			if(!indexIgnored.contains(i)) {
		String capital = words[i].substring(0, 1).toUpperCase();
		String restWord = words[i].substring(1, words[i].length());
		String keywordCapitalized = capital + restWord;
		words[i] = keywordCapitalized;
			}
		}
		return words;
	}
	
	private void replaceLine(String[] words, int index) {
		String newLine = "";
		for(int i=0;i<words.length;i++) {
			newLine = newLine + words[i] + " ";
		}
		outputList.set(index, newLine.trim());
	}
	
	public void passData() {
		capitalizeKeywords();
		printOutput();
	}
	
	private void printOutput() {
		System.out.println("Output:");
		for(int i=0; i<outputList.size();i++) {
			System.out.println(outputList.get(i));
		}
	}
}
