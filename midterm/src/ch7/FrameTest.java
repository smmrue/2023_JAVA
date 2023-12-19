package ch7;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameTest extends JFrame {
	public FrameTest() {
		setSize(300, 150);
		setLocation(200, 300);
		setTitle("MyFrame");
		setLayout(new FlowLayout());
		getContentPane().setBackground(Color.yellow);
		JButton button1 = new JButton("확인");
		JButton button2 = new JButton("취소");
		add(button1);
		add(button2);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		 FrameTest f = new FrameTest();		 

	}

}
