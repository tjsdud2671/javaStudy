package sql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CakeList extends JFrame {

	private JPanel contentPane;
	private JButton btnCake1, btnCake2, btnCake3, btnCake4, btnCake5, btnReservation, btnClose;
	private JPanel panel_2;
	private JLabel lblCake1;
	private JLabel lblCake2;
	private JLabel lblCake3;
	private JLabel lblCake4;
	private JLabel lblCake5;
	private JLabel lblInfor5;
	private JButton btnRandom;
	private JLabel lblNewLabel;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CakeList frame = new CakeList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CakeList() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(654,700);
		setTitle("GreenCakeShop");
		
		
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 638, 661);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(419, 25, 207, 382);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btnCake1 = new JButton("무화과 케이크");
		btnCake1.setBackground(Color.WHITE);
		btnCake1.setFont(new Font("HY신명조", Font.PLAIN, 14));
		btnCake1.setBounds(26, 99, 158, 23);
		panel_1.add(btnCake1);
		
		btnCake2 = new JButton("패션후르츠 케이크");
		btnCake2.setFont(new Font("HY신명조", Font.PLAIN, 14));
		btnCake2.setBackground(Color.WHITE);
		btnCake2.setBounds(26, 142, 158, 23);
		panel_1.add(btnCake2);
		
		btnCake3 = new JButton("체리 케이크");
		btnCake3.setFont(new Font("HY신명조", Font.PLAIN, 14));
		btnCake3.setBackground(Color.WHITE);
		btnCake3.setBounds(26, 186, 158, 23);
		panel_1.add(btnCake3);
		
		btnCake4 = new JButton("하트 케이크");
		btnCake4.setFont(new Font("HY신명조", Font.PLAIN, 14));
		btnCake4.setBackground(Color.WHITE);
		btnCake4.setBounds(26, 231, 158, 23);
		panel_1.add(btnCake4);
		
		btnCake5 = new JButton("몬스터 케이크");
		btnCake5.setFont(new Font("HY신명조", Font.PLAIN, 14));
		btnCake5.setBackground(Color.WHITE);
		btnCake5.setBounds(26, 273, 158, 23);
		panel_1.add(btnCake5);
		
		btnReservation = new JButton("Reservation");
		btnReservation.setForeground(new Color(139, 69, 19));
		btnReservation.setFont(new Font("HY신명조", Font.PLAIN, 14));
		btnReservation.setBackground(Color.WHITE);
		btnReservation.setBounds(26, 326, 158, 23);
		panel_1.add(btnReservation);
		
		btnClose = new JButton("Close");
		btnClose.setForeground(new Color(139, 69, 19));
		btnClose.setFont(new Font("HY신명조", Font.PLAIN, 14));
		btnClose.setBackground(Color.WHITE);
		btnClose.setBounds(26, 359, 158, 23);
		panel_1.add(btnClose);
		
		btnRandom = new JButton("Random Cake");
		btnRandom.setBackground(new Color(255, 250, 250));
		btnRandom.setForeground(new Color(139, 69, 19));
		btnRandom.setFont(new Font("HY신명조", Font.PLAIN, 14));
		btnRandom.setBounds(26, 10, 158, 23);
		panel_1.add(btnRandom);
		
		lblNewLabel = new JLabel("Click ↓");
		lblNewLabel.setBackground(new Color(128, 128, 128));
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(26, 65, 158, 24);
		panel_1.add(lblNewLabel);
		
		JLabel lblInfor1 = new JLabel("");
		lblInfor1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblInfor1.setIcon(new ImageIcon(CakeList.class.getResource("/sql/images/무화과 케이크 정보.png")));
		lblInfor1.setBounds(12, 415, 614, 221);
		panel.add(lblInfor1);
		
		JLabel lblInfor2 = new JLabel("");
		lblInfor2.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfor2.setIcon(new ImageIcon(CakeList.class.getResource("/sql/images/패션후르츠케이크정보.png")));
		lblInfor2.setBounds(12, 415, 614, 221);
		panel.add(lblInfor2);
		
		JLabel lblInfor3 = new JLabel("");
		lblInfor3.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfor3.setIcon(new ImageIcon(CakeList.class.getResource("/sql/images/체리케이크정보.png")));
		lblInfor3.setBounds(12, 415, 614, 221);
		panel.add(lblInfor3);
		
		JLabel lblInfor4 = new JLabel("");
		lblInfor4.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfor4.setIcon(new ImageIcon(CakeList.class.getResource("/sql/images/하트케이크정보.png")));
		lblInfor4.setBounds(0, 415, 614, 221);
		panel.add(lblInfor4);
		
		lblInfor5 = new JLabel("");
		lblInfor5.setIcon(new ImageIcon(CakeList.class.getResource("/sql/images/몬스터케이크정보.png")));
		lblInfor5.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfor5.setBounds(12, 415, 614, 221);
		panel.add(lblInfor5);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(12, 25, 407, 382);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		lblCake1 = new JLabel("");
		lblCake1.setIcon(new ImageIcon(CakeList.class.getResource("/sql/images/무화과 케이크.jpeg")));
		lblCake1.setBackground(Color.WHITE);
		lblCake1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCake1.setBounds(0, 0, 407, 382);
		panel_2.add(lblCake1);
		
		lblCake2 = new JLabel("");
		lblCake2.setIcon(new ImageIcon(CakeList.class.getResource("/sql/images/패션후르츠.jpg")));
		lblCake2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCake2.setBackground(Color.WHITE);
		lblCake2.setBounds(0, 0, 407, 382);
		panel_2.add(lblCake2);
		
		lblCake3 = new JLabel("");
		lblCake3.setIcon(new ImageIcon(CakeList.class.getResource("/sql/images/체리 케이크.jpeg")));
		lblCake3.setHorizontalAlignment(SwingConstants.CENTER);
		lblCake3.setBackground(Color.WHITE);
		lblCake3.setBounds(0, 0, 407, 382);
		panel_2.add(lblCake3);
		
		lblCake4 = new JLabel("");
		lblCake4.setIcon(new ImageIcon(CakeList.class.getResource("/sql/images/하트 케이크.jpeg")));
		lblCake4.setHorizontalAlignment(SwingConstants.CENTER);
		lblCake4.setBackground(Color.WHITE);
		lblCake4.setBounds(0, 0, 407, 382);
		panel_2.add(lblCake4);
		
		lblCake5 = new JLabel("");
		lblCake5.setIcon(new ImageIcon(CakeList.class.getResource("/sql/images/몬스터케이크.jpg")));
		lblCake5.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCake5.setBackground(Color.WHITE);
		lblCake5.setBounds(0, 0, 407, 382);
		panel_2.add(lblCake5);
		
		/*-------------------------------*/
		
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reservation().setVisible(true);
			}
		});
		
		
		btnCake1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCake1.setVisible(true);
				lblCake2.setVisible(false);
				lblCake3.setVisible(false);
				lblCake4.setVisible(false);
				lblCake5.setVisible(false);
				lblInfor1.setVisible(true);
				lblInfor2.setVisible(false);
				lblInfor3.setVisible(false);
				lblInfor4.setVisible(false);
				lblInfor5.setVisible(false);
				
			}
		});
		btnCake2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCake1.setVisible(false);
				lblCake2.setVisible(true);
				lblCake3.setVisible(false);
				lblCake4.setVisible(false);
				lblCake5.setVisible(false);
				lblInfor1.setVisible(false);
				lblInfor2.setVisible(true);
				lblInfor3.setVisible(false);
				lblInfor4.setVisible(false);
				lblInfor5.setVisible(false);
	
			}
		});
		btnCake3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCake1.setVisible(false);
				lblCake2.setVisible(false);
				lblCake3.setVisible(true);
				lblCake4.setVisible(false);
				lblCake5.setVisible(false);
				lblInfor1.setVisible(false);
				lblInfor2.setVisible(false);
				lblInfor3.setVisible(true);
				lblInfor4.setVisible(false);
				lblInfor5.setVisible(false);
			}
		});
		btnCake4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCake1.setVisible(false);
				lblCake2.setVisible(false);
				lblCake3.setVisible(false);
				lblCake4.setVisible(true);
				lblCake5.setVisible(false);
				lblInfor1.setVisible(false);
				lblInfor2.setVisible(false);
				lblInfor3.setVisible(false);
				lblInfor4.setVisible(true);
				lblInfor5.setVisible(false);
			}
		});
		btnCake5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCake1.setVisible(false);
				lblCake2.setVisible(false);
				lblCake3.setVisible(false);
				lblCake4.setVisible(false);
				lblCake5.setVisible(true);
				lblInfor1.setVisible(false);
				lblInfor2.setVisible(false);
				lblInfor3.setVisible(false);
				lblInfor4.setVisible(false);
				lblInfor5.setVisible(true);
			}
		});
		
	}

}
