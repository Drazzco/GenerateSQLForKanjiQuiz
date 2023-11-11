package model.entities;

public class OptionRandom {

	private String op1;
	private String op2;
	private String op3;
	private Integer next;
	
	public OptionRandom(String op1, String op2, String op3, Integer next) {
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.next = next;
	}

	public Integer getNext() {
		return next;
	}

	public void setNext(Integer next) {
		this.next = next;
	}

	public String getOp1() {
		return op1;
	}

	public String getOp2() {
		return op2;
	}

	public String getOp3() {
		return op3;
	}
	
	
	
}
