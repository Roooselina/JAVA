package 교과서;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyClass extends JFrame {
	JLabel findText;
	JTextField f;
	JCheckBox ch1, ch2, ch3, ch4;
	JButton find, cancle;
	
	MyClass() {
		this.setSize(500, 200);
		this.setLayout(new BorderLayout());
		
		JPanel p1 = new JPanel();
		this.add(p1, BorderLayout.WEST);
		findText = new JLabel("찾기 대화 상자");
		p1.add(findText);
		
		JPanel p2 = new JPanel();
		this.add(p2, BorderLayout.CENTER);
		JPanel p2_1 = new JPanel();
		JPanel p2_2 = new JPanel();
		p2_2.setLayout(new GridLayout(2,2));
		f = new JTextField(20);
		ch1 = new JCheckBox("대소문자 구별하기");
		ch2 = new JCheckBox("반복");
		ch3 = new JCheckBox("전체 단어 매치");
		ch4 = new JCheckBox("역순으로");
		p2_1.add(f);
		p2_2.add(ch1);
		p2_2.add(ch2);
		p2_2.add(ch3);
		p2_2.add(ch4);
		p2.add(p2_1, BorderLayout.NORTH);
		p2.add(p2_2, BorderLayout.CENTER);
		
		JPanel p3 = new JPanel();
		this.add(p3, BorderLayout.EAST);
		p3.setLayout(new BorderLayout());
		find = new JButton("찾기");
		cancle = new JButton("취소");
		p3.add(find, BorderLayout.NORTH);
		p3.add(cancle, BorderLayout.CENTER);
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}

}

public class Main extends JFrame {
	public static void main(String[] args) {
		MyClass N = new MyClass();
	}
}
