import javax.swing.*;
import java.awt.*;

class MyFrame extends JFrame {
	JLabel label;
	JTextField field;
	JButton button1, button2, button3;
	int counter = 0;

	public MyFrame() {
		JPanel panel = new JPanel();
		label = new JLabel("카운터 값");
		field = new JTextField(15
				);
		field.setText("" + counter);
		button1 = new JButton("증가");
		button2 = new JButton("감소");
		button3 = new JButton("초기화");

		button1.addActionListener(e -> {
			field.setText("" + (++counter));
		});
		button2.addActionListener(e -> {
			field.setText("" + (--counter));
		});
		button3.addActionListener(e -> {
			counter=0;
			field.setText("" + (counter));
		});

		panel.add(label);
		panel.add(field);
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);

		add(panel);

		setSize(300, 150);
		setTitle("MyFrame");
		setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

}

public class counter {

	public static void main(String[] args) {
		MyFrame mf = new MyFrame();

	}

}
