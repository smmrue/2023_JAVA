package ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClubMembershipForm extends JFrame {

    private JTextField nameField;
    private JTextField phoneNumberField;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private ButtonGroup genderGroup;
    private JTextArea addressArea;
    private JCheckBox agreeCheckBox;
    private JButton submitButton;
    private JButton resetButton;
    private ArrayList<Member> members = new ArrayList<>();

    public ClubMembershipForm() {
        setTitle("동아리 회원 가입");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // 가운데 정렬 및 간격 설정
       
        // 상단 레이블
        JLabel titleLabel = new JLabel("입회원서");
        mainPanel.add(titleLabel);

        // 이름 입력 필드
        createLabelAndTextField("이름:", nameField, mainPanel);
        // 전화번호 입력 필드
        createLabelAndTextField("전화번호:", phoneNumberField, mainPanel);

        // 성별 라디오 버튼
        createGenderRadioButtons(mainPanel);

        // 주소 입력
        createLabelAndTextArea("주소:", addressArea, mainPanel);

        // "규칙을 준수하겠습니다." 체크 박스
        agreeCheckBox = new JCheckBox("규칙을 준수하겠습니다.");
        mainPanel.add(agreeCheckBox);

        // 제출 및 초기화 버튼
        submitButton = new JButton("제출");
        resetButton = new JButton("초기화");
        mainPanel.add(submitButton);
        mainPanel.add(resetButton);

        add(mainPanel);
    }

    private void createLabelAndTextField(String label, JTextField textField, JPanel panel) {
        JPanel fieldPanel = new JPanel();
        fieldPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0)); // 왼쪽 정렬 및 간격 설정

        JLabel nameLabel = new JLabel(label);
        fieldPanel.add(nameLabel);

        textField = new JTextField(20);
        fieldPanel.add(textField);

        panel.add(fieldPanel);
    }

    private void createGenderRadioButtons(JPanel panel) {
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0)); // 왼쪽 정렬 및 간격 설정

        JLabel genderLabel = new JLabel("성별:");
        radioPanel.add(genderLabel);

        maleRadioButton = new JRadioButton("남자");
        femaleRadioButton = new JRadioButton("여자");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadioButton);
        genderGroup.add(femaleRadioButton);

        radioPanel.add(maleRadioButton);
        radioPanel.add(femaleRadioButton);

        panel.add(radioPanel);
    }

    private void createLabelAndTextArea(String label, JTextArea textArea, JPanel panel) {
        JPanel areaPanel = new JPanel();
        areaPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0)); // 왼쪽 정렬 및 간격 설정

        JLabel addressLabel = new JLabel(label);
        areaPanel.add(addressLabel);

        textArea = new JTextArea(4, 20);
        JScrollPane addressScrollPane = new JScrollPane(textArea);
        addressScrollPane.setPreferredSize(new Dimension(350, 100)); // 주소 칸 크기 설정
        areaPanel.add(addressScrollPane);

        panel.add(areaPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClubMembershipForm form = new ClubMembershipForm();
            form.setVisible(true);
        });
    }

    private class Member {
        private String name;
        private String phoneNumber;
        private String gender;
        private String address;

        public Member(String name, String phoneNumber, String gender, String address) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.gender = gender;
            this.address = address;
        }

        @Override
        public String toString() {
            return "이름: " + name + ", 전화번호: " + phoneNumber + ", 성별: " + gender + ", 주소: " + address;
        }
    }
}
