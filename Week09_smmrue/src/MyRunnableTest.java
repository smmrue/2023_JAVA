class MyRunnable1 implements Runnable {
	public void run() {
		for (int i = 0; i <= 10; i++)
			System.out.println(i + " ");
	}
}
public class MyRunnableTest {

	public static void main(String[] args) {
		Thread t = new Thread(new MyRunnable1());
		t.start();

	}

}
