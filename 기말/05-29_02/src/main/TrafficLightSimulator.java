package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame extends JFrame {
	MyFrame() {
		this.setSize(600, 300);
		this.add(new MyPanel());
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
}

class MyPanel extends JPanel implements ActionListener {
	private static final int LIGHT_RADIUS = 30;
	private static final int LIGHT_GAP = 20;
	private static final int PANEL_HEIGHT = 100;

	private int lightNumber = 0;
	private int x = LIGHT_RADIUS + LIGHT_GAP;

	public MyPanel() {
		setLayout(new BorderLayout());

		JButton b = new JButton("신호 변경");
		b.addActionListener(this);
		add(b, BorderLayout.SOUTH);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int y = (PANEL_HEIGHT - LIGHT_RADIUS) / 2;

		if (lightNumber == 0) {
			g.setColor(Color.red);
			g.fillOval(x, y, LIGHT_RADIUS * 2, LIGHT_RADIUS * 2);
			x += LIGHT_RADIUS * 2 + LIGHT_GAP;

			g.setColor(Color.black);
			g.drawOval(x, y, LIGHT_RADIUS * 2, LIGHT_RADIUS * 2);
			x += LIGHT_RADIUS * 2 + LIGHT_GAP;

			g.drawOval(x, y, LIGHT_RADIUS * 2, LIGHT_RADIUS * 2);
			x += LIGHT_RADIUS * 2 + LIGHT_GAP;
		} else if (lightNumber == 1) {

			g.setColor(Color.black);
			g.drawOval(x, y, LIGHT_RADIUS * 2, LIGHT_RADIUS * 2);
			x += LIGHT_RADIUS * 2 + LIGHT_GAP;

			g.setColor(Color.yellow);
			g.fillOval(x, y, LIGHT_RADIUS * 2, LIGHT_RADIUS * 2);
			x += LIGHT_RADIUS * 2 + LIGHT_GAP;

			g.setColor(Color.black);
			g.drawOval(x, y, LIGHT_RADIUS * 2, LIGHT_RADIUS * 2);
			x += LIGHT_RADIUS * 2 + LIGHT_GAP;
		} else if (lightNumber == 2) {

			g.setColor(Color.black);
			g.drawOval(x, y, LIGHT_RADIUS * 2, LIGHT_RADIUS * 2);
			x += LIGHT_RADIUS * 2 + LIGHT_GAP;

			g.drawOval(x, y, LIGHT_RADIUS * 2, LIGHT_RADIUS * 2);
			x += LIGHT_RADIUS * 2 + LIGHT_GAP;

			g.setColor(Color.green);
			g.fillOval(x, y, LIGHT_RADIUS * 2, LIGHT_RADIUS * 2);
			x += LIGHT_RADIUS * 2 + LIGHT_GAP;
		}

		x = LIGHT_RADIUS + LIGHT_GAP;

	}

	private Color getLightColor(int lightIndex) {
		if (lightIndex == lightNumber) {
			return Color.GREEN; // Assuming the order is Green, Yellow, Red
		} else {
			return Color.BLACK;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		lightNumber = (lightNumber + 1) % 3;
		repaint();
	}
}

public class TrafficLightSimulator {
	public static void main(String[] args) {
		new MyFrame();
	}
}
