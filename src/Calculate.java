import java.util.ArrayList;

public class Calculate {
	// 계산식의 숫자 담을 변수
	public String num = "";
	// 계산식 자체를 담을 arraylist equation assign
	public ArrayList<String> equation = new ArrayList<>();

	// 계산식을 담는 과정 구현
	public void fullTextParsing(String monitor) {
		equation.clear();

		//현재까지 계산식 훑기
		for (int i = 0; i < monitor.length(); i++) {
			char ch = monitor.charAt(i);

			//연산기호 나오면 현재까지 숫자를 equation에 넣고 연산기호 따로 추가
			if (ch == '+' || ch == '−' || ch == '×' || ch == '÷' || ch == '^') {
				equation.add(num);
				//num 초기화
				num = "";
				//연산기호도 추가
				equation.add(ch + "");
			} else {
				num = num + (ch + "");
			}
		}
		equation.add(num);
	}

	//계산 기능 구현
	public double calculate(String monitor) {
		fullTextParsing(monitor);

		//연산 이전 값과 연산 이후 값 담을 변수 assign
		double prev = 0;
		double current = 0;
		// 연산 담아놓을 op 선언
		String op = "";

		for (String s : equation) {
			//연산에 따라 op에 연산 assign
			if (s.equals("+")) {
				op = "add";
			} else if (s.equals("−")) {
				op = "minus";
			} else if (s.equals("×")) {
				op = "multiple";
			} else if (s.equals("÷")) {
				op = "divide";
			} else if (s.equals("^")) {
				op = "involute";
			} else {
				current = Double.parseDouble(s);
				if (op == "add") {
					prev += current;
				} else if (op == "minus") {
					prev -= current;
				} else if (op == "multiple") {
					prev *= current;
				} else if (op == "divide") {
					prev /= current;
				} else if (op == "involute") {
					prev = Math.pow(prev, current);
				} else {
					prev = current;
				}
			}
		}
		return prev;
	}
}
