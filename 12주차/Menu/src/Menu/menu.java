package Menu;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyFrame extends JFrame {
    JTextField text;
    String word;

    MyFrame() {
        this.setTitle("Menu Example");
        JPanel panel = new JPanel();
        this.setSize(400, 200);
        word = "";

        text = new JTextField(20); 
        panel.add(text); 

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("파일");
        menuBar.add(fileMenu);

        JMenu open = new JMenu("열기");
        fileMenu.add(open);

        JMenuItem projectItem = new JMenuItem("저장하기");
        projectItem.addActionListener(e -> {
            text.setText(projectItem.getText());
        });
        JMenuItem moduleItem = new JMenuItem("다른이름으로 저장하기");
        moduleItem.addActionListener(e -> {
            text.setText(moduleItem.getText());
        });
        fileMenu.add(projectItem);
        fileMenu.add(moduleItem);

        JMenu printMenu = new JMenu("출력");
        fileMenu.add(printMenu);
        
        JMenuItem printerPrint = new JMenuItem("프린터로 출력하기");
        printerPrint.addActionListener(e -> {
            text.setText(printerPrint.getText());
        });
        JMenuItem pdfPrint = new JMenuItem("pdf로 출력하기");
        pdfPrint.addActionListener(e -> {
            text.setText(pdfPrint.getText());
        });

        printMenu.add(printerPrint);
        printMenu.add(pdfPrint);

        this.setJMenuBar(menuBar);
        this.add(panel);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

public class menu {
    public static void main(String[] args) {
        MyFrame f = new MyFrame();
    }
}
