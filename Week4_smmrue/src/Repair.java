import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Repair extends JPanel implements ItemListener {
    JCheckBox[] buttons = new JCheckBox[4];
    String[] items = { "엔진오일 교환", "자동변속기오일교환", "에어컨필터교환", "타이어 교환" };
    int[] prices = { 45000, 80000, 30000, 100000 };
    int money = 0;
    JLabel label;

    public Repair() {
        super();
        setLayout(new GridLayout(5, 1));

        label = new JLabel("현재까지의 가격은 " + money + "원");
        add(label);

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JCheckBox(items[i]);
            buttons[i].addItemListener(this);
            add(buttons[i]);
        }
    }

    public void itemStateChanged(ItemEvent e) {
        calTotalCost();
    }

    private void calTotalCost() {
        money = 0;
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].isSelected()) {
                money += prices[i];
            }
        }
        label.setText("현재까지의 가격은: " + money + "원");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("CheckBoxDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JComponent newContentPane = new Repair();
        newContentPane.setVisible(true);
        frame.setContentPane(newContentPane);
        frame.setSize(500, 200);
        frame.setVisible(true);
    }
}

