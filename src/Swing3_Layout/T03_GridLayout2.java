package Swing3_Layout;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

// GridLayout 연습
@SuppressWarnings("serial")
public class T03_GridLayout2 extends JFrame {
	private JButton[][] btn;

	public T03_GridLayout2() {
		setTitle("GridLayout연습");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(new GridLayout(2, 3));
		
//		add(getBtn1());
//		add(getBtn2());
//		add(getBtn3());
//		add(getBtn4());
//		add(getBtn5());
//		add(getBtn6());
		
		for(int r=0; r<2; r++) { //행
			for(int c=0; c<3; c++) { //열
				add(getBtn()[r][c]);
			}
		}
	}
	
private JButton[][] getBtn() {
	int cnt = 1;
	btn = new JButton[2][3];
	for(int r=0; r<2; r++) { //행
		for(int c=0; c<3; c++) { //열
			btn[r][c]=new JButton("버튼"+cnt);
			cnt++;
		}
	}
		return btn;
	}

//	private JButton getBtn1() {
//		btn1 = new JButton("버튼1");
//		return btn1;
//	}
//	private JButton getBtn2() {
//		btn2 = new JButton("버튼2");
//		return btn2;
//	}
//	private JButton getBtn3() {
//		btn3 = new JButton("버튼3");
//		return btn3;
//	}
//	private JButton getBtn4() {
//		btn4 = new JButton("버튼4");
//		return btn4;
//	}
//	private JButton getBtn5() {
//		btn5 = new JButton("버튼5");
//		return btn5;
//	}
//	private JButton getBtn6() {
//		btn6 = new JButton("버튼6");
//		return btn6;
//	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				T03_GridLayout2 t03 = new T03_GridLayout2();
				t03.setVisible(true);
			}
		});
		
	}
}
