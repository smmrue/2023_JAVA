interface Animal {
	void walk();
	void fly();
	void sing();
}
public class Bird implements Animal {
	public void walk() {
		System.out.println("걸을 수 있음");
	}
	public void fly() {
		System.out.println("날 수 있음");
	}
	public void sing() {
		System.out.println("노래 부를 수 있음");
	}

	public static void main(String[] args) {
		Bird b = new Bird();
		
		b.walk();
		b.fly();
		b.sing();

	}

}
