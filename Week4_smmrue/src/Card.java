import javax.swing.*;
import java.awt.*;

public class Card {
    public static void main(String[] args) {
 
        JFrame frame = new JFrame("명함");

 
        frame.setSize(800, 400);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

        
        ImageIcon imageIcon = new ImageIcon("C://dog.jpg"); // 이미지 파일 경로를 지정하세요
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(10, 10, Image.SCALE_SMOOTH); // 원하는 크기로 조정
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

  
        JLabel imageLabel = new JLabel(imageIcon);

        JLabel label1 = new JLabel("김덕성");
        JLabel label2 = new JLabel("소프트웨어 엔지니어");
        JLabel label3 = new JLabel("덕성주식회사");
        
        panel.add(imageLabel, BorderLayout.WEST);
        panel.add(label1, BorderLayout.NORTH);
        panel.add(label2, BorderLayout.CENTER);
        panel.add(label3, BorderLayout.SOUTH);


        frame.add(panel);
        frame.setVisible(true);
    }
}
