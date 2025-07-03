package 교과서_10_2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class myFrame extends JFrame {
	int x = 100;
	int y = 100;
	JPanel panel;

	myFrame() {
		this.setSize(800, 600);
		this.setLayout(null);

		panel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.RED);
				g.fillRect(x, y, 50, 50);
			}
		};
		panel.setBounds(0, 0, 800, 600); // 패널의 크기를 프레임에 맞게 설정
		panel.setLayout(null); // 패널 레이아웃 설정
		this.add(panel);

		panel.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				x = e.getX() - 25;
				y = e.getY() - 25;
				panel.repaint();
			}
		});

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new myFrame();
	}
}
