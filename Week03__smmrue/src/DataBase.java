import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DataBase extends JFrame {
	
	public DataBase() {

		JPanel panel = new JPanel();
        
        add(panel);

		JLabel label0 = new JLabel("       회원 등록하기      ");
		JLabel label1 = new JLabel("이름   ");
		JLabel label2 = new JLabel("패스워드 ");
		JLabel label3 = new JLabel("이메일 주소");
		JLabel label4 = new JLabel("전화번호 ");

		JTextField field1 = new JTextField(20);
		JTextField field2 = new JTextField(20);
		JTextField field3 = new JTextField(20);
		JTextField field4 = new JTextField(20);
		JButton button1 = new JButton("등록하기");
		JButton button2 = new JButton("취소");

		panel.add(label0);
		panel.add(new JLabel());
		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(label3);
		panel.add(field3);
		panel.add(label4);
		panel.add(field4);
		panel.add(button1);
		panel.add(button2);
		

		setSize(400, 200);

		setVisible(true);

	}



	public static void main(String[] args) {
		DataBase b = new DataBase();

	}

}