package sql;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Reservation extends JFrame {

	private JPanel contentPane;
	private JTextField txtMid;
	private JTextField txtName;
	private JButton btnRsv, btnHome;
	
	CakeDAO dao = new CakeDAO();
	CakeVO vo ;
	int res = 0;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation frame = new Reservation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	


	public Reservation() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,465);
		setResizable(false);
		setTitle("GreenCakeShop");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 484, 426);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reservation");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("HY신명조", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(92, 21, 274, 52);
		panel.add(lblNewLabel);
		
		JLabel lblMid = new JLabel("ID");
		lblMid.setForeground(new Color(128, 0, 0));
		lblMid.setFont(new Font("HY신명조", Font.PLAIN, 14));
		lblMid.setHorizontalAlignment(SwingConstants.CENTER);
		lblMid.setBounds(44, 104, 119, 31);
		panel.add(lblMid);
		
		JLabel lblCake = new JLabel("Cake");
		lblCake.setHorizontalAlignment(SwingConstants.CENTER);
		lblCake.setForeground(new Color(128, 0, 0));
		lblCake.setFont(new Font("HY신명조", Font.PLAIN, 14));
		lblCake.setBounds(44, 223, 119, 31);
		panel.add(lblCake);
		
		JLabel lblNewLabel_1_2 = new JLabel("예약날짜");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_1_2.setFont(new Font("HY신명조", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(44, 279, 119, 31);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblMid_1 = new JLabel("성명");
		lblMid_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblMid_1.setForeground(new Color(128, 0, 0));
		lblMid_1.setFont(new Font("HY신명조", Font.PLAIN, 14));
		lblMid_1.setBounds(44, 162, 119, 31);
		panel.add(lblMid_1);
		
		txtMid = new JTextField();
		txtMid.setFont(new Font("굴림", Font.PLAIN, 13));
		txtMid.setBounds(165, 104, 187, 31);
		panel.add(txtMid);
		txtMid.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("굴림", Font.PLAIN, 13));
		txtName.setColumns(10);
		txtName.setBounds(165, 162, 187, 31);
		panel.add(txtName);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("HY신명조", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"무화과 케이크", "패션후르츠 케이크", "몬스터 케이크", "하트 케이크", "체리 케이크"}));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(165, 223, 187, 31);
		panel.add(comboBox);
		
		btnRsv = new JButton("Reservation");
		btnRsv.setForeground(new Color(128, 0, 0));
		btnRsv.setFont(new Font("HY신명조", Font.PLAIN, 13));
		btnRsv.setBackground(Color.WHITE);
		btnRsv.setBounds(122, 341, 119, 31);
		panel.add(btnRsv);
		
		btnHome = new JButton("Home");
		btnHome.setForeground(new Color(128, 0, 0));
		btnHome.setFont(new Font("HY신명조", Font.PLAIN, 13));
		btnHome.setBackground(Color.WHITE);
		btnHome.setBounds(260, 341, 119, 31);
		panel.add(btnHome);
		
		String[] yy = new String[1];
		String[] mm = new String[12];
		String[] dd = new String[31];
		
		int imsi;
		for(int i=0; i<yy.length; i++) {
			imsi = i + 2023;
			yy[i] = imsi + "";
		}
		
		for(int i=0; i<mm.length; i++) {
			mm[i] = (i+1) + "";
		}
		
		for(int i=0; i<dd.length; i++) {
			dd[i] = (i+1) + "";
		}
		
		JComboBox cbYY = new JComboBox(yy);
		cbYY.setBackground(Color.WHITE);
		cbYY.setFont(new Font("HY신명조", Font.PLAIN, 14));
		cbYY.setBounds(149, 283, 83, 23);
//		cbYY.setSelectedItem(ymds[0]);
		panel.add(cbYY);
		
		JComboBox cbMM = new JComboBox(mm);
		cbMM.setBackground(Color.WHITE);
		cbMM.setFont(new Font("HY신명조", Font.PLAIN, 14));
		cbMM.setBounds(269, 283, 65, 23);
		panel.add(cbMM);
		
		JComboBox cbDD = new JComboBox(dd);
		cbDD.setBackground(Color.WHITE);
		cbDD.setFont(new Font("HY신명조", Font.PLAIN, 14));
		cbDD.setBounds(365, 283, 65, 23);
		panel.add(cbDD);
		
		JLabel lblNewLabel_1 = new JLabel("년");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("HY신명조", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(226, 283, 34, 23);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("월");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("HY신명조", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(328, 283, 34, 23);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("일");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("HY신명조", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(421, 283, 34, 23);
		panel.add(lblNewLabel_1_1_1);
		/*------------------------------------------------*/
		
		
		
		
		
		//Home버튼
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		//Reservation버튼
		btnRsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mid = txtMid.getText();
				String name = txtName.getName();
				
				if(mid.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
				}
				else if(name.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "성명을 입력하세요");
				}
				
				else {
					vo.setMid(mid);
					vo.setName(name);
					
//					res = dao.set
					
				}
				
			}
		});
		

	}

}
