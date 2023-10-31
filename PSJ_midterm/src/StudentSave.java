import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class StudentSave extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton SaveButton;
	private JButton CancelButton;
	ArrayList<String> list = new ArrayList<> ();
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentSave M = new StudentSave();
					M.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public StudentSave() {

		setTitle("덕성여대 화이팅");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 237);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("이름");
		lblNewLabel.setBounds(36, 45, 151, 15);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("학번");
		lblNewLabel_1.setBounds(36, 70, 151, 15);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("성적");
		lblNewLabel_2.setBounds(36, 95, 113, 15);
		contentPane.add(lblNewLabel_2);


		JLabel lblNewLabel_3 = new JLabel("학생 등록하기");
		lblNewLabel_3.setFont(new Font(" ",Font.PLAIN, 16));
		lblNewLabel_3.setBounds(152, 10, 151, 25);
		contentPane.add(lblNewLabel_3);

		textField = new JTextField();
		textField.setBounds(187, 45, 116, 21);
		contentPane.add(textField);
		textField.setColumns(10); //이름 텍스트필드

		textField_1 = new JTextField();
		textField_1.setBounds(187, 70, 116, 21);
		contentPane.add(textField_1); //ㅎㅏㄱ번 텍스트필드
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(187, 95, 116, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10); //상작 텍스트필드


		SaveButton = new JButton("등록하기");
		SaveButton.setBounds(90, 165, 97, 23);
		contentPane.add(SaveButton);
		SaveButton.addActionListener(e -> {
			list.add(textField.getText());
			list.add(textField_1.getText());
			list.add(textField_2.getText());
		});
		System.out.println("이름 : " +  "학번 : " + "성적 : " );

		CancelButton = new JButton("취소");
		CancelButton.setBounds(206, 165, 97, 23);
		contentPane.add(CancelButton);
		CancelButton.addActionListener(e -> {
			
		});
		}
}