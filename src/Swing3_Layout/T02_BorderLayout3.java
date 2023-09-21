package Swing3_Layout;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class T02_BorderLayout3 extends JFrame {
	private JButton btn1, btn2, btn3;
	private JPanel pn1;
	
	
	public T02_BorderLayout3() {
		setTitle("BorderLayout연습");
		setSize(300,250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		setLayout(new BorderLayout());
		
		btn1 = new JButton("안녕하세요");
		add(btn1, BorderLayout.NORTH);
		
		
		btn2 = new JButton("버튼2");
		btn3 = new JButton("버튼3");
		

		pn1 = new JPanel(); //올려주기 위한 그릇이라고 생각하면 됨
		pn1.add(btn2);
		pn1.add(btn3);
//		add(pn1);
		add(pn1, BorderLayout.SOUTH);
		
		
/* ------------------------------------------------------------------- 위 디자인, 아래 코드 */		
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "안녕 버튼을 누르셨습니다.");
				
			}
		});
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				T02_BorderLayout3 t02 = new T02_BorderLayout3();
				t02.setVisible(true);
				
				
			}
		});
	}
}
