package 교과서_10_1;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class myFrame extends JFrame{
	JButton btn;
	JLabel text;
	int n;
	myFrame(){
		this.setSize(600,200);
		this.setLayout(new BorderLayout(50,50));
		
		JPanel p1 = new JPanel();
		btn = new JButton("버튼을 눌러주세요!");
		btn.addActionListener(e->{
			text.setText("클릭 횟수: "+(++n));
		});
		p1.add(btn);
			
		JPanel p2 = new JPanel();
		text = new JLabel("클릭 횟수: "+n);
		p2.add(text);
		
		this.add(p1, BorderLayout.CENTER);
		this.add(p2, BorderLayout.SOUTH);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	}
}

public class Main {

	public static void main(String[] args) {
		myFrame m = new myFrame();

	}

}
