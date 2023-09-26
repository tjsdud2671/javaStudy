package sql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class CakeMain extends JFrame {

	private JPanel contentPane;
	private JButton btnStart;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CakeMain frame = new CakeMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public CakeMain() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,700);
		setTitle("GreenCakeShop");
		
		setLocationRelativeTo(null);
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 684, 661);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(CakeMain.class.getResource("/sql/images/CakeShopMainImage.jpg")));
		lblNewLabel.setBounds(0, -21, 684, 682);
		panel.add(lblNewLabel);
		
		btnStart = new JButton("Welcome to Green Cake Shop");
		btnStart.setForeground(new Color(128, 0, 0));
		btnStart.setBackground(new Color(255, 255, 240));
		btnStart.setFont(new Font("HY신명조", Font.BOLD, 13));
		btnStart.setBounds(221, 314, 267, 31);
		panel.add(btnStart);
		
		/*--------------------------------------*/
		
		// 메인 스타트 버튼 마우스 클릭했을 때 수행
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CakeMainNextPage().setVisible(true);
			}
		});
	}

}
