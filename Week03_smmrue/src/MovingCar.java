import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MovingCar extends JFrame {
    private int carX = 200;
    private JButton leftButton;
    private JButton rightButton;
    private JPanel panel;
    private ImageIcon carIcon;
    
    public MovingCar() {
        setTitle("자동차 움직이기");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawCar(g, carX, 50);
            }
        };
        
        carIcon = new ImageIcon("C://Car.jpg");

        leftButton = new JButton("왼쪽");
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveCarLeft();
            }
        });

        rightButton = new JButton("오른쪽");
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveCarRight();
            }
        });

        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(leftButton);
        buttonPanel.add(rightButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
    
    private void drawCar(Graphics g, int x, int y) {
        if (carIcon != null) {
            carIcon.paintIcon(this, g, x, y);
        }
    }

    private void moveCarLeft() {
        carX -= 10;
        panel.repaint();
    }

    private void moveCarRight() {
        carX += 10;
        panel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MovingCar());
    }
}

