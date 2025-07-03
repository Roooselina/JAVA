
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyGUI extends JFrame {
	JLabel label1, headline, label2;
	JTextField field;
	JButton button1, button2, button3;
	int ran;
	int guess = 0;

	public MyGUI() {
		JPanel panel = new JPanel();
		headline = new JLabel("숫자를 추측하시오: " + guess);
		field = new JTextField(15);
		ran = (int) (Math.random() * 100) + 1;
		label1 = new JLabel("");
		label2 = new JLabel("정답: "+ran);

		button1 = new JButton("새 게임");
		button1.addActionListener(e -> {
			ran = (int) (Math.random() * 100) + 1;
			guess = 0;
			changeLabel(guess);
			label2.setText("정답: "+ran);
			label1.setText("");
			
			field.setBackground(Color.white);
			field.setText("");
		});
		button2 = new JButton("종료");
		button2.addActionListener(e -> {
			System.exit(0);
		});
		button3 = new JButton("검사해보기");
		button3.addActionListener(e->{
			int input = Integer.parseInt(field.getText());
			changeLabel(input);
			
			if (input>ran) {
				field.setBackground(Color.red);
				label1.setText("너무 큽니다!");
			}
			else if(input<ran) {
				field.setBackground(Color.cyan);
				label1.setText("너무 작습니다!");
			}
			else {
				field.setBackground(Color.yellow);
				label1.setText("정답을 맞추셨습니다!");

			}
		});
		
		panel.add(headline);
		panel.add(field);
		panel.add(label1);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(label2);
		
		add(panel);

		setSize(300, 200);
		setTitle("숫자 맞추기 게임");
		setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
	void changeLabel(int n) {
		guess= n;
		headline.setText("숫자를 추측하시오: " + guess);
	}
	
	
	void exit() {
		System.exit(0);
	}
}

public class RandomGame {

	public static void main(String[] args) {
		MyGUI mg = new MyGUI();

	}

}
