import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class RadioClass extends JFrame {
	JRadioButton dog, cat, bird, rabbit, pig;

	RadioClass() {
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(0, 1));

		JLabel label = new JLabel("");
		ImageIcon img = new ImageIcon("src/Image/pig.png");
		label.setIcon(img);
		panel1.add(label, BorderLayout.CENTER);

		bird = new JRadioButton("BIRD");
		bird.addActionListener(e -> {
			ImageIcon changeImg = new ImageIcon("src/Image/bird.png");
			label.setIcon(changeImg);
		});
		panel2.add(bird, BorderLayout.WEST);

		cat = new JRadioButton("CAT");
		cat.addActionListener(e -> {
			ImageIcon changeImg = new ImageIcon("src/Image/cat.png");
			label.setIcon(changeImg);
		});
		panel2.add(cat, BorderLayout.WEST);

		dog = new JRadioButton("DOG");
		dog.addActionListener(e -> {
			ImageIcon changeImg = new ImageIcon("src/Image/dog.png");
			label.setIcon(changeImg);
		});
		panel2.add(dog, BorderLayout.WEST);

		rabbit = new JRadioButton("RABBIT");
		rabbit.addActionListener(e -> {
			ImageIcon changeImg = new ImageIcon("src/Image/rabbit.png");
			label.setIcon(changeImg);
		});
		panel2.add(rabbit, BorderLayout.WEST);

		pig = new JRadioButton("PIG");
		pig.addActionListener(e -> {
			ImageIcon changeImg = new ImageIcon("src/Image/pig.png");
			label.setIcon(changeImg);
		});
		panel2.add(pig, BorderLayout.WEST);

		ButtonGroup group = new ButtonGroup();

		group.add(bird);
		group.add(cat);
		group.add(dog);
		group.add(rabbit);
		group.add(pig);

		this.add(panel1, BorderLayout.CENTER);
		this.add(panel2, BorderLayout.WEST);

		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

public class Radio {
	public static void main(String[] args) {
		RadioClass radio = new RadioClass();
	}
}
