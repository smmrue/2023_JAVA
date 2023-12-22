package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class MyFrame extends JFrame {
	JTextField stuID, name, tel, dept;
	JButton previousButton, nextButton, InsertButton, deleteButton,
			searchButton;
	ResultSet rs;
	Statement stmt;

	public MyFrame() throws SQLException {
		super("Database Viewer");
		initComponents();
		Connection con = makeConnection();
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		//ResultsSet이 처음부터 끝까지 이동하면서 데이터를 순회할 수 있음
		rs = stmt.executeQuery("SELECT * FROM books");
		//모든 데이터를 가져옴

		setLayout(new GridLayout(0, 2));
		add(new JLabel("ID", JLabel.CENTER));
		add(stuID = new JTextField());

		add(new JLabel("TITLE", JLabel.CENTER));
		add(name = new JTextField());

		add(new JLabel("PUBLISHER", JLabel.CENTER));
		add(tel = new JTextField());

		add(new JLabel("YEAR", JLabel.CENTER));
		add(dept = new JTextField());

		previousButton = new JButton("Previous");
		previousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					rs.previous(); 
					stuID.setText("" + rs.getInt("stuID"));
					name.setText("" + rs.getString("name"));
					tel.setText("" + rs.getString("tel"));
					dept.setText("" + rs.getString("dept"));
					} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		nextButton = new JButton("Next");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					rs.next();
					stuID.setText("" + rs.getInt("stuID"));
					name.setText("" + rs.getString("name"));
					tel.setText("" + rs.getString("tel"));
					dept.setText("" + rs.getString("dept"));

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});

		InsertButton = new JButton("Insert");
		deleteButton = new JButton("Delete");
		searchButton = new JButton("Search");

		add(previousButton);
		add(nextButton);
		add(InsertButton);
		add(deleteButton);
		add(searchButton);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 200);
		setVisible(true);
	}
}