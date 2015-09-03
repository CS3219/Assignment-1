package com.pipeAndFilter;
import java.util.*;
public class Alphabetize extends Filter {
	
	private ArrayList<String> titles;
	private Data data;
	
	public Alphabetize() {
		data = new Data();
		this.titles = new ArrayList<String>();
	}
	
	private void order() {
		Collections.sort(titles);
	}
	
	public void execute(Data data) {
		this.titles = data.getTitles();
		order();
		this.data.setTitles(titles);
		nextPipe.passData(this.data);
	}
}
