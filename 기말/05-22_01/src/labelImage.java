import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MyFrame extends JFrame {
	MyFrame() {
		this.setTitle("Swing 이미지");
		this.setSize(1000, 600);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 3));

		JLabel dog = new JLabel("");
		JLabel cat = new JLabel("");
		JLabel bird = new JLabel("");

		ImageIcon dogImg = new ImageIcon("src/Image/dog.png");
		ImageIcon catImg = new ImageIcon("src/Image/cat.png");
		ImageIcon birdImg = new ImageIcon("src/Image/bird.png");

		dog.setIcon(dogImg);
		cat.setIcon(catImg);
		bird.setIcon(birdImg);

		panel.add(cat);
		panel.add(dog);
		panel.add(bird);

		this.add(panel);

		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

public class labelImage {

	public static void main(String[] args) {
		MyFrame myframe = new MyFrame();

	}

}
