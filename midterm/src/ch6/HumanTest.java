package ch6;

class Human {
	String name;
	int height;
	int weight;
	
	
	public Human(String name, int height, int weight) {
		
		this.name = name;
		this.height = height;
		this.weight = weight;
	}
	
	public void displayInfo() {
		
		
		System.out.println("이름 " + name);
		System.out.println("신장 " + height + "cm");
		System.out.println("몸무게 " +weight + "kg");
	}
}

class Person extends Human {
	String occupation;
	
	public Person(String name, int height, int weight, String occupation) {
		super(name, height, weight);
		this.occupation = occupation;
	}
	@Override
	public void displayInfo() {
		super.displayInfo();
		System.out.println("직업 " + occupation);
		}
	}
public class HumanTest {	
	public static void main(String[] args) {
		Person gildong = new Person("길동", 170, 60, "학생");
		Person chulsu = new Person("철수", 166, 72, "회사원");
		
		System.out.println("길동의 정보:");
		gildong.displayInfo();
		
		System.out.println("\n철수의 정보:");
		chulsu.displayInfo();
	}

	

}
