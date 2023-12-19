package ch11;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class MouseDraggingFrame extends JFrame {
	public MouseDraggingFrame() {
		super("드래깅동안 YELLOW로 변경");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setBackground(Color.GREEN);
		
		MyMouseListener m1 = new MyMouseListener();
		c.addMouseMotionListener(m1);
		c.addMouseListener(m1);
		
		setSize(250, 150);
		setVisible(true);
	}
	
	class MyMouseListener extends MouseAdapter implements MouseMotionListener {
		public void mouseDragged(MouseEvent e) {
			Container c = (Container)e.getSource();
			c.setBackground(Color.YELLOW);
		}
		public void mouseMoved(MouseEvent e) {}
		
		public void mouseReleased(MouseEvent e) {
			Container c = (Container)e.getSource();
			c.setBackground(Color.GREEN);
			
		}
	}

	public static void main(String[] args) {
		new MouseDraggingFrame();

	}

}
