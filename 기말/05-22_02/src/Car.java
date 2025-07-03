import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyCar extends JFrame {

	MyCar() {
		setSize(500, 500);

		this.setLayout(new BorderLayout());
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());
		this.setLayout(new BorderLayout());

		ImageIcon carImg = new ImageIcon("src/Image/car.jpg");
		JLabel car = new JLabel("");
		car.setIcon(carImg);

		JButton left = new JButton("LEFT");
		left.addActionListener(e -> {
			car.setLocation(car.getX() - 10, car.getY());
		});

		JButton right = new JButton("RIGHT");
		right.addActionListener(e -> {
			car.setLocation(car.getX() + 10, car.getY());
		});

		panel1.add(car);
		panel2.add(left);
		panel2.add(right);

		this.add(panel1, BorderLayout.CENTER);
		this.add(panel2, BorderLayout.SOUTH);

		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

	}
}

public class Car {

	public static void main(String[] args) {
		MyCar mycar = new MyCar();
	}

}
