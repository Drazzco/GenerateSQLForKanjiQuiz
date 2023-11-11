package model.entities;

public class Option {
	
	private String hiragana;
	private OptionRandom pos1;
	private OptionRandom pos2;
	
	public Option(String hiragana, OptionRandom pos1, OptionRandom pos2) {
		this.hiragana = hiragana;
		this.pos1 = pos1;
		this.pos2 = pos2;
	}

	public String getHiragana() {
		return hiragana;
	}

	public OptionRandom getPos1() {
		return pos1;
	}

	public OptionRandom getPos2() {
		return pos2;
	}
	
	
	
}
