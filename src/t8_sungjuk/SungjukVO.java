package t8_sungjuk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SungjukVO {

	private int idx;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	
	private int tot;
	private double avg;
	private char grade;
	
	int getIdx() {
		return idx;
	}
	void setIdx(int idx) {
		this.idx = idx;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	int getKor() {
		return kor;
	}
	void setKor(int kor) {
		this.kor = kor;
	}
	int getEng() {
		return eng;
	}
	void setEng(int eng) {
		this.eng = eng;
	}
	int getMat() {
		return mat;
	}
	void setMat(int mat) {
		this.mat = mat;
	}
	int getTot() {
		return tot;
	}
	void setTot(int tot) {
		this.tot = tot;
	}
	double getAvg() {
		return avg;
	}
	void setAvg(double avg) {
		this.avg = avg;
	}
	char getGrade() {
		return grade;
	}
	void setGrade(char grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "SungjukVO [idx=" + idx + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", mat=" + mat + ", tot="
				+ tot + ", avg=" + avg + ", grade=" + grade + "]";
	}
	
	

}

