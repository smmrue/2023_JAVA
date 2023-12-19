import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CountDownTest extends JFrame {

	private JLabel label;
	private int count;
	Thread t;
	
	class Counter extends Thread {
		public void run() {
			for (int i = 0; i <= 10; i++) {
				try {
					Thread.sleep(1000);
					
				} catch (InterruptedException e) {
					return;
				}
				label.setText(i + "");
				
			}
		}
	}
	
	public CountDownTest() {
		setTitle("카운트다운");
		setSize(400,150);
		getContentPane().setLayout(null);
		label = new JLabel("0");
		label.setBounds(0, 0, 384, 111);
		label.setFont(new Font("Serif", Font.BOLD, 100));
		getContentPane().add(label);
		
		JButton btnNewButton1 = new JButton("카운터 중지");
		btnNewButton1.setBounds(246, 24, 125, 23);
		JButton btnNewButton2 = new JButton("카운터 다시시작");
		btnNewButton2.setBounds(246, 50, 125, 23);
		
		btnNewButton1.addActionListener(e->t.interrupt());
		getContentPane().add(btnNewButton1);
		setVisible(true);
		t = new Counter();
		t.start();
		
		getContentPane().add(btnNewButton2);
		btnNewButton2.addActionListener(e -> {
		    if (t != null) {
		        t.interrupt(); 
		        t = new Counter(); 
		        t.start(); 
		    }
		});

		
	}
	
	public static void main(String[] args) {
		CountDownTest t = new CountDownTest();
	}

}
