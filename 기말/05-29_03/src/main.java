import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class MyFrame extends JFrame {
	int prevX, prevY, currX, currY;
	boolean dragging;
	Color currentColor;
	JPanel canvas;

	MyFrame() {
		this.setTitle("Simple Paint");
		this.setSize(600, 500);
		currentColor = Color.red;

		this.setLayout(new BorderLayout());
		canvas = new JPanel();
		canvas.setBackground(Color.white);
		canvas.addMouseListener(new MouseListener() {

			@Override
			public void mousePressed(MouseEvent e) {
				prevX = e.getX();
				prevY = e.getY();
				dragging = true;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				dragging = false;
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		canvas.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if (dragging) {
					currX = e.getX();
					currY = e.getY();
					Graphics g = canvas.getGraphics();
					g.setColor(currentColor);
					g.drawLine(prevX, prevY, currX, currY);
					prevX = currX;
					prevY = currY;
				}
			}
		});

		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout());

		JButton black = new JButton("Black");
		black.addActionListener(e -> {
			currentColor = Color.black;
		});
		JButton red = new JButton("Red");
		red.addActionListener(e -> {
			currentColor = Color.red;
		});
		JButton clear = new JButton("Clear");
		clear.addActionListener(e -> {
			Graphics g = canvas.getGraphics();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		});

		panel2.add(black);
		panel2.add(red);
		panel2.add(clear);

		this.add(canvas, BorderLayout.CENTER);
		this.add(panel2, BorderLayout.SOUTH);

		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
}

public class main {

	public static void main(String[] args) {
		MyFrame m = new MyFrame();

	}

}
