package StudentManagementSystem;

import java.util.ArrayList;

public class Student {
	private String name;
	private int number;
	private double grade;
	int total = 0;
	
	ArrayList<Student> studentList;
	
	Student(String Name, int ID, int Grade) {
		
		this.name = Name;
		this.number = ID;
		this.grade = Grade;
	}
	
	String getName() {
		return name;
	}
	int getNumber () {
		return number;
	}
	double getGrade() {
		return grade;
	}
	
	public void average(int sum) {
		int total = 0;
		
		total = sum/studentList.size();
	}
	
	public void showScoreInfo() {
		
		
		for (Student student : studentList);
		System.out.println("전체 학생은 총" + studentList.size() + "명 이고, 학생들의 전체 평균 점수는 " + total +"점입니다." );
	}
	
}
