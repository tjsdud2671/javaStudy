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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CakeMainNextPage extends JFrame {

	private JPanel contentPane;
	private JButton btnCakeList, btnRsv, btnJoin, btnStaff;
	private JButton btnLogin;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CakeMainNextPage frame = new CakeMainNextPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public CakeMainNextPage() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,700);
		setResizable(false);
		setTitle("GreenCakeShop");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 684, 555);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(CakeMainNextPage.class.getResource("/sql/images/리본.jpg")));
		lblNewLabel.setBounds(-85, 0, 708, 565);
		panel.add(lblNewLabel);
		
		btnCakeList = new JButton("Cake List");
		btnCakeList.setForeground(new Color(128, 0, 0));
		btnCakeList.setBounds(444, 289, 121, 37);
		panel.add(btnCakeList);
		btnCakeList.setBackground(Color.WHITE);
		btnCakeList.setFont(new Font("HY신명조", Font.PLAIN, 14));
		
		btnRsv = new JButton("Reservation");
		btnRsv.setForeground(new Color(128, 0, 0));
		btnRsv.setBounds(444, 346, 121, 37);
		panel.add(btnRsv);
		btnRsv.setFont(new Font("HY신명조", Font.PLAIN, 14));
		btnRsv.setBackground(Color.WHITE);
		
		btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(128, 0, 0));
		btnLogin.setBounds(444, 399, 121, 37);
		panel.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setFont(new Font("HY신명조", Font.PLAIN, 14));
		btnLogin.setBackground(Color.WHITE);
		
		btnJoin = new JButton("Join");
		btnJoin.setForeground(new Color(128, 0, 0));
		btnJoin.setBounds(444, 458, 121, 37);
		panel.add(btnJoin);
		btnJoin.setFont(new Font("HY신명조", Font.PLAIN, 14));
		btnJoin.setBackground(Color.WHITE);
		
		//join버튼
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Join().setVisible(true);
			}
		});
		
		//Reservation 버튼
		btnRsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reservation().setVisible(true);
			}
		});
		
		//CakeList버튼
		btnCakeList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CakeList().setVisible(true);
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 555, 684, 106);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		btnStaff = new JButton("Staff ");
		btnStaff.setForeground(new Color(0, 0, 0));
		btnStaff.setFont(new Font("HY신명조", Font.PLAIN, 14));
		btnStaff.setBackground(Color.WHITE);
		btnStaff.setBounds(459, 63, 108, 25);
		panel_1.add(btnStaff);
		
		/* ------------------------------------------ */
	}
}
