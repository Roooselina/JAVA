package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SnowManFace extends JFrame {
	int stress = 0;
	JLabel text;
	Color faceColor;
	int red;
	int green;
	int blue;

	int leftEyeStart = 180;
	int rightEyeStart = 180;
	int eyeCurve = 10;

	int mouthStart = 180;
	int mouthCurve = 10;

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			if (stress > 0) {
				g.setColor(faceColor);
				g.fillOval(20, 30, 200, 200);

				g.setColor(Color.BLACK);
				int leftEyeAngle = 180 + eyeCurve;
				int rightEyeAngle = 180 - eyeCurve;
				g.drawArc(60, 80, 50, 50, leftEyeAngle, rightEyeAngle);
				// 왼쪽 눈
				g.drawArc(150, 80, 50, 50, leftEyeAngle, rightEyeAngle);
				// 오른쪽 눈
			}

			g.setColor(Color.RED);
			faceColor = g.getColor();

			g.fillOval(20, 30, 200, 200);
			g.setColor(Color.BLACK);

			g.drawArc(60, 80, 50, 50, 180, -180);
			// 왼쪽 눈
			g.drawArc(150, 80, 50, 50, 180, -180);
			// 오른쪽 눈

			g.drawArc(70, 130, 100, 70, 180, 180);
			// 입
		}

		public void SnowManFace() {
			setSize(300, 300);
			setTitle("눈사람 얼굴");

			this.setLayout(new BorderLayout());

			JPanel panel1 = new JPanel();
			JPanel panel3 = new JPanel();

			this.add(panel1, BorderLayout.NORTH);
			add(new MyPanel(), BorderLayout.CENTER);
			this.add(panel3, BorderLayout.SOUTH);

			panel3.setLayout(new GridLayout(1, 3));

			text = new JLabel("현재 스트레스 지수 = " + stress);
			panel1.add(text);

			JButton present = new JButton("선물");
			present.setBackground(Color.green);
			present.addActionListener(e -> {
				stress -= 1;
				changeText();

				blue += 30;
				faceColor = new Color(255, 0, 0);
				repaint();

			});

			JButton assignment = new JButton("과제");
			assignment.setBackground(Color.red);
			assignment.addActionListener(e -> {
				stress += 1;
				changeText();
				int red = Color.yellow.getRed();
				faceColor = new Color(red + 10, Color.yellow.getGreen(), Color.yellow.getBlue());
				repaint();
			});

			panel3.add(present);
			panel3.add(assignment);

			setVisible(true);

			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		public void changeText() {
			text.setText("현재 스트레스 지수 = " + stress);
		}

		public static void main(String[] args) {
			SnowManFace s = new SnowManFace();

		}
	}
}