import javax.swing.*;

class BMIConverter extends JFrame {
	JLabel label1, label2, label3, headline;
	JTextField field1, field2, field3;
	JButton button;

	public BMIConverter() {
		JPanel panel = new JPanel();
		headline = new JLabel("나의 BMI 지수는 얼마나 될까?	                    ");
		label1 = new JLabel("나의 체중(kg)");
		label2 = new JLabel("나의 키(cm)");
		label3 = new JLabel("나의 BMI");
		field1 = new JTextField(15);
		field2 = new JTextField(15);
		field3 = new JTextField(15);

		button = new JButton("BMI 확인하기");

		button.addActionListener(e -> {
			double w = Double.parseDouble(field1.getText());
			double h = Double.parseDouble(field2.getText());
			h/=100;
			double BMI = w / Math.pow(h, 2);
			field3.setText("" + BMI);
		});
		panel.add(headline);
		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(label3);
		panel.add(field3);
		panel.add(button);

		add(panel);

		setSize(300, 200);
		setTitle("BMI 계산기");
		setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
}

public class BMI {

	public static void main(String[] args) {
		BMIConverter b = new BMIConverter();

	}

}
