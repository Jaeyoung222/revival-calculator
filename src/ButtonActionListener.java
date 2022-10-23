import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ButtonActionListener implements ActionListener {

	public JTextField monitor;
	public Calculate cal;

	public ButtonActionListener(JTextField monitor, Calculate cal) {
		this.monitor = monitor;
		this.cal = cal;
	}

	public void actionPerformed(ActionEvent e) {
		//어떤 버튼이 눌렸는지 확인
		String operation = e.getActionCommand();

		// frame 생성자 설정
		// AC가 눌릴 경우 all clear 후 0 나오게 함
		switch (operation) {
			case "AC":
				monitor.setText("0");
				break;
			// C가 눌릴 경우 뒤에서 하나 삭제함
			case "C":
				//식이 두 글자 이상 입력 되어 있는 경우
				String tmp = monitor.getText();
				if (tmp.length() >= 2) {
					tmp = tmp.substring(0, tmp.length() - 1);
					monitor.setText(tmp);
				}
				//식이 한 글자인 경우, 0이 나타나게 함
				else {
					monitor.setText("0");
				}

				break;

			//revival 기능 구현
			case "Rev.":
				try {
					Thread.sleep(2000);
					new Revival_Calculator_Frame();
				} catch (Exception ex) {
					throw new RuntimeException(ex);
				}

				break;

			// =이 눌리면 계산하도록 함
			case "=": {

				String result = Double.toString(cal.calculate(monitor.getText()));
				if (result.length() >= 9) {
					result = result.substring(0, 8);
				}
				monitor.setText(result + "");
				cal.num = "";
				Revival_Calculator_Frame.isAnswer = true;
				break;
			}
			//숫자 누르는 경우
			default: {
				String cur = monitor.getText();
				String result;
				if (cur.equals("0") || Revival_Calculator_Frame.isAnswer) {
					result = operation;
				} else {
					result = monitor.getText() + operation;
				}
				monitor.setText(result);
				Revival_Calculator_Frame.isAnswer = false;
				break;
			}
		}
	}

}
