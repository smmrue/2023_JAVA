package ch6;

class Circle {
	protected int radius;
	public Circle(int r) {radius = r; }
}

public class Pizza extends Circle {
	String menu;
	
	public Pizza(String menu, int r) {
		super(r);
		this.menu = menu;
	}
	public void print() {
		
		System.out.println("피자의 종류 : " + this.menu + "," + "피자의 크기 : " + super.radius);
	}

	public static void main(String[] args) {
		Pizza obj = new Pizza("Pepperoni", 20);
		obj.print();

	}

}