import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MiletoKm extends JFrame implements ActionListener {
	JButton button1;
	JLabel label1;
	JLabel label2;
	JTextField field1;
	JTextField field2;
	
	public MiletoKm() {
		setSize(500, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Mile->Km");
		label1 = new JLabel("마일을 입력하시오.");
		field1 = new JTextField(10);
		label2 = new JLabel("->");
		field2 = new JTextField(10);
		button1 = new JButton("변환");
		button1.addActionListener(this);
		JPanel panel = new JPanel();
		
		panel.add(label1);
        panel.add(field1);
        panel.add(label2);
        panel.add(field2);
        panel.add(button1);
       
        add(panel);
       
        setVisible(true);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			convertMiletoKm();
			
		}
	}
	
	private void convertMiletoKm() {
		 try {
		        double miles = Double.parseDouble(field1.getText());
		        double kilometers = miles * 1.609344;
		        field2.setText(String.format("%.6f km", kilometers));
		    } catch (NumberFormatException ex) {
		        field2.setText("올바른 숫자를 입력하세요.");
		    }
	}

	public static void main(String[] args) {
		MiletoKm m = new MiletoKm();


	}



}