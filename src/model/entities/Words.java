package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Words implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer level;
	private Integer lesson;
	private String hWordQuestion;
	private String hWord1;
	private String hWord2;
	private String hWord3;
	private String hWord4;
	private Integer hWordAnswer;
	private String kWordQuestion;
	private String kWord1;
	private String kWord2;
	private String kWord3;
	private String kWord4;
	private Integer kWordAnswer;
	private String englishTrad;
	private String portugueseTrad;
	
	public Words() {
	}

	public Words(Integer level, Integer lesson, String hWordQuestion, String hWord1, String hWord2,
			String hWord3, String hWord4, Integer hWordAnswer, String kWordQuestion, String kWord1, String kWord2,
			String kWord3, String kWord4, Integer kWordAnswer, String englishTrad, String portugueseTrad) {
		this.id = 0;
		this.level = level;
		this.lesson = lesson;
		this.hWordQuestion = hWordQuestion;
		this.hWord1 = hWord1;
		this.hWord2 = hWord2;
		this.hWord3 = hWord3;
		this.hWord4 = hWord4;
		this.hWordAnswer = hWordAnswer;
		this.kWordQuestion = kWordQuestion;
		this.kWord1 = kWord1;
		this.kWord2 = kWord2;
		this.kWord3 = kWord3;
		this.kWord4 = kWord4;
		this.kWordAnswer = kWordAnswer;
		this.englishTrad = englishTrad;
		this.portugueseTrad = portugueseTrad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getLesson() {
		return lesson;
	}

	public void setLesson(Integer lesson) {
		this.lesson = lesson;
	}

	public String gethWordQuestion() {
		return hWordQuestion;
	}

	public void sethWordQuestion(String hWordQuestion) {
		this.hWordQuestion = hWordQuestion;
	}

	public String gethWord1() {
		return hWord1;
	}

	public void sethWord1(String hWord1) {
		this.hWord1 = hWord1;
	}

	public String gethWord2() {
		return hWord2;
	}

	public void sethWord2(String hWord2) {
		this.hWord2 = hWord2;
	}

	public String gethWord3() {
		return hWord3;
	}

	public void sethWord3(String hWord3) {
		this.hWord3 = hWord3;
	}

	public String gethWord4() {
		return hWord4;
	}

	public void sethWord4(String hWord4) {
		this.hWord4 = hWord4;
	}

	public Integer gethWordAnswer() {
		return hWordAnswer;
	}

	public void sethWordAnswer(Integer hWordAnswer) {
		this.hWordAnswer = hWordAnswer;
	}

	public String getkWordQuestion() {
		return kWordQuestion;
	}

	public void setkWordQuestion(String kWordQuestion) {
		this.kWordQuestion = kWordQuestion;
	}

	public String getkWord1() {
		return kWord1;
	}

	public void setkWord1(String kWord1) {
		this.kWord1 = kWord1;
	}

	public String getkWord2() {
		return kWord2;
	}

	public void setkWord2(String kWord2) {
		this.kWord2 = kWord2;
	}

	public String getkWord3() {
		return kWord3;
	}

	public void setkWord3(String kWord3) {
		this.kWord3 = kWord3;
	}

	public String getkWord4() {
		return kWord4;
	}

	public void setkWord4(String kWord4) {
		this.kWord4 = kWord4;
	}

	public Integer getkWordAnswer() {
		return kWordAnswer;
	}

	public void setkWordAnswer(Integer kWordAnswer) {
		this.kWordAnswer = kWordAnswer;
	}

	public String getEnglishTrad() {
		return englishTrad;
	}

	public void setEnglishTrad(String englishTrad) {
		this.englishTrad = englishTrad;
	}

	public String getPortugueseTrad() {
		return portugueseTrad;
	}

	public void setPortugueseTrad(String portugueseTrad) {
		this.portugueseTrad = portugueseTrad;
	}

	@Override
	public int hashCode() {
		return Objects.hash(englishTrad, hWordAnswer, id, portugueseTrad);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Words other = (Words) obj;
		return Objects.equals(englishTrad, other.englishTrad) && Objects.equals(hWordAnswer, other.hWordAnswer)
				&& Objects.equals(id, other.id) && Objects.equals(portugueseTrad, other.portugueseTrad);
	}

	@Override
	public String toString() {
		return "(" + level + "," + lesson + ",'" + hWordQuestion + "','"
				+ hWord1 + "','" + hWord2 + "','" + hWord3 + "','" + hWord4 + "',"
				+ hWordAnswer + ",'" + kWordQuestion + "','" + kWord1 + "','" + kWord2
				+ "','" + kWord3 + "','" + kWord4 + "'," + kWordAnswer + ",'"
				+ englishTrad + "','" + portugueseTrad + "')";
	}
	
	
	
}
