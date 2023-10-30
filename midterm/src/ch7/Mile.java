package ch7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Mile extends JFrame implements ActionListener {
	double t;
	JTextField mileField;
	JTextField kmField;
	
	public Mile() {
		setSize(500, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Mile->Km");
		
		JPanel panel = new JPanel();
		
		JLabel label1 = new JLabel("마일을 입력하시오.");
		mileField = new JTextField(10);
		JLabel label2 = new JLabel("->");
		kmField = new JTextField(10);
		kmField.setEditable(false);
		JButton button1 = new JButton("변환");
		button1.addActionListener(this); // 이벤트 리스너 설정
		
		panel.add(label1);
		panel.add(mileField);
		panel.add(label2);
		panel.add(kmField);
		panel.add(button1);
		
		add(panel);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("변환")) {
			double miles = Double.parseDouble(mileField.getText());
				double kilometers = miles * 1.609344;
				kmField.setText(String.valueOf(kilometers) + "km");
	
		}
	}

	public static void main(String[] args) {
		Mile m = new Mile();
		m.setVisible(true);

	}

}
