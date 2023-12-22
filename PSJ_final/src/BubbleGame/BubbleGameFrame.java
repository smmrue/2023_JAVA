package BubbleGame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BubbleGameFrame extends JFrame {
	public BubbleGameFrame() {
		setTitle("버블 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePanel p = new GamePanel();
		setContentPane(p);
		setSize(300, 300);
		JButton btn1 = new JButton("시작");
		JButton btn2 = new JButton("종료");
		add(btn1);
		add(btn2);
		setVisible(true);
	}
	

	public static void main(String[] args) {
		new BubbleGameFrame();

	}

}
class GamePanel extends JPanel {
	public GamePanel() {
		setLayout(null);
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				new BubbleThread(e.getX(), e.getY()).start();
			}
		});
	}
	
	class BubbleThread extends Thread {
		private JLabel bubble;
		
		public BubbleThread(int bubbleX, int bubbleY) {
			ImageIcon img = new ImageIcon("C://bubble.jpg");
			bubble = new JLabel(img);
			bubble.setSize(img.getIconWidth(),img.getIconWidth());
			bubble.setLocation(bubbleX, bubbleY);
			add(bubble);
			repaint();
		}
		
		@Override
		public void run() {
			try {
				while (bubble.getLocation().y + bubble.getHeight() > 0 ) {
					Thread.sleep(20);
					bubble.setLocation(bubble.getLocation().x, bubble.getLocation().y - 5);
					repaint();
				}
				remove(bubble);
				repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
