package UI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			searchButton, ClearButton;
	ResultSet rs;
	Statement stmt;

	public MyFrame() throws SQLException {
		super("Database Viewer");
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
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
		        String searchKeyword = search.getText(); 
		        try {
		            
		            String query = "SELECT * FROM 'duksung' WHERE name LIKE '%" + searchKeyword + "%'";
		            ResultSet searchResult = stmt.executeQuery(query);

		            // 검색 결과가 있으면 ResultSet에서 가져온 데이터를 화면에 업데이트
		            if (searchResult.next()) {
		            	stuID.setText("" + rs.getInt("stuID"));
						name.setText("" + rs.getString("name"));
						tel.setText("" + rs.getString("tel"));
						dept.setText("" + rs.getString("dept"));
		            } else {
		                System.out.println("검색 결과가 없습니다.");
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		});

		ClearButton = new JButton("Clear");

		add(previousButton);
		add(nextButton);
		add(InsertButton);
		add(deleteButton);
		add(searchButton);
		add(ClearButton);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350, 200);
		setVisible(true);
		}

		public static Connection makeConnection() {	
			String url = "jdbc:mysql://localhost:3306/duksung";
			String id = "root";
			String password = "";
			Connection con = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("드라이버 적재 성공");
				con = DriverManager.getConnection(url, id, password);
				System.out.println("데이터베이스 연결 성공");
			} catch (ClassNotFoundException e) {
				System.out.println("드라이버를 찾을 수 없습니다.");
			} catch (SQLException e) {
				System.out.println("연결에 실패하였습니다.");
			}
			return con;
		}
		
		public void create() {
			System.out.print("추가할 학생의 정보 ");
		    int postNumber = Integer.parseInt(scanner.nextLine());

		    try {
		        String sql = "SELECT * FROM deuksung WHERE bno = ?";
		        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
		            pstmt.setInt(1, postNumber);
		            try (ResultSet resultSet = pstmt.executeQuery()) {
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    
		}
		
		public void delete() {
			
		}
		
		public void read() {
		}
		
		public void clear() {
			
		}
		}


	public class Database {
		public static void main(String[] args) throws SQLException {
			new MyFrame();
		}
	}