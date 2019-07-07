package ua.nure.rudenko.task4;

public class Word {
	private String content;
	private int frequency;
	
	public Word() {
		content = "";
		frequency = 0;
	}
	
	Word(String cont, int freq) {
		content = cont;
		frequency = freq;
	}
	
	public String getContent() {
		return content;
	}
	
	public int getFrequency() {
		return frequency;
	}
	
	public void increase() {
		frequency++;
	}
	
	public int compareTo(Word other) {
		if (other == null) {
			return -1;
		}
		if (frequency == other.frequency) {
			return content.compareTo(other.content);
		} else {
			return frequency - other.frequency;
		}
	}
}
