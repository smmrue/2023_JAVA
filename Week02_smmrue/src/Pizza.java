class Circle {
	protected int radius;
	
	protected Circle(int r) {
		radius = r;
	}
}

public class Pizza extends Circle {
	String menu;
	
	public Pizza(String p, int r) {
		super(r);
		this.menu = p;
	}
	
	public void print() {
		System.out.println("피자의 종류 : " + this.menu + "," + "피자의 크기 : " + super.radius);
		
	}
	
	public static void main(String[] args) {
		Pizza obj = new Pizza("Pepperoni", 20);
		obj.print();
	}
}

