import javax.swing.*;
import java.awt.*;

class TempConverter extends JFrame {
	JLabel label1, label2;
	JTextField field1, field2;
	JButton button;

	public TempConverter() {
		JPanel panel = new JPanel();
		label1 = new JLabel("화씨 온도");
		label2 = new JLabel("섭씨 온도");
		field1 = new JTextField(15);
		field2 = new JTextField(15);
		button = new JButton("변환");

		button.addActionListener(e -> {
			int f = Integer.parseInt(field1.getText());
			double c = (f - 32.0) * 5.0 / 9.0;
			field2.setText("" + c);
		});
		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(button);

		add(panel);

		setSize(300, 150);
		setTitle("온도변환기");
		setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
}

public class FC {

	public static void main(String[] args) {
		TempConverter f = new TempConverter();

	}
}
