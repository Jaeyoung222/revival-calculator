import java.awt.*;

import javax.swing.*;

public class Revival_Calculator_Frame extends JFrame {
	//출력값이 답인지 확인할 isAnswer assign
	static public boolean isAnswer = false;
	public Calculate cal = new Calculate();
	public JTextField monitor;

	public Revival_Calculator_Frame() {

		// 기본 레이아웃 사용
		setLayout(null);

		//모니터 부분
		monitor = new JTextField();
		//편집 불가능
		monitor.setEditable(false);
		//초기값 0으로 설정
		monitor.setText("0");
		//배경 색상 설정
		monitor.setBackground(Color.LIGHT_GRAY);
		//정렬위치 설정
		monitor.setHorizontalAlignment(JTextField.RIGHT);
		//글씨체 설정
		monitor.setFont(new Font("굴림", Font.BOLD, 50));
		//위치와 크기(x:5,y:10의 위치에 290x90의 크기)
		monitor.setBounds(5, 10, 290, 90);

		//버튼넣을 패널 만들기
		JPanel buttonPanel = new JPanel();
		//gridlayout 사용
		buttonPanel.setLayout(new GridLayout(6, 4, 5, 5));
		//location and size
		buttonPanel.setBounds(5, 110, 290, 235);
		// button name array 생성
		String[] button_name = {"x", "y", "z", "Rev.", "AC", "C", "^", "÷", "1", "2", "3", "×", "4", "5", "6", "−", "7",
			"8", "9", "+", "00", "0", ".", "="};
		// 버튼들의 배열 설정
		JButton[] button = new JButton[button_name.length];
		// 각 button에 name 입력
		for (int i = 0; i < button_name.length; i++) {
			button[i] = new JButton(button_name[i]);
			// 글씨체 설정
			button[i].setFont(new Font("굴림", Font.BOLD, 15));
			//ButtonActionListener를 버튼에 추가
			button[i].addActionListener(new ButtonActionListener(monitor, cal));
			// 버튼 패널에 추가
			buttonPanel.add(button[i]);
		}

		//프로그램이름 보이기, size 설정
		setTitle("Revival Calculator");
		setVisible(true);
		setSize(300, 380);
		//가운데에 띄움
		setLocationRelativeTo(null);
		//사이즈 조절 불가능
		setResizable(false);

		//프레임에 패널들 추가
		add(monitor);
		add(buttonPanel);
		//창을 닫으면 프로그램도 같이 종료되도록 함
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}