package sql;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Join extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtPwd;
	private JTextField txtName;
	private JTextField txtPnb;
	private JButton btnJoin;

	CakeDAO dao = new CakeDAO();
	CakeVO vo = null;
	int res = 0;
	private JButton btnHome;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Join frame = new Join();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Join() {
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
		panel.setBounds(0, 0, 484, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Join");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("HY신명조", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 30, 484, 61);
		panel.add(lblNewLabel);
		
		JLabel lblID = new JLabel("ID");
		lblID.setForeground(new Color(128, 0, 0));
		lblID.setFont(new Font("HY신명조", Font.PLAIN, 14));
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		lblID.setBounds(52, 118, 121, 28);
		panel.add(lblID);
		
		JLabel lblPwd = new JLabel("PWD");
		lblPwd.setForeground(new Color(128, 0, 0));
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setFont(new Font("HY신명조", Font.PLAIN, 14));
		lblPwd.setBounds(52, 169, 121, 28);
		panel.add(lblPwd);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(128, 0, 0));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("HY신명조", Font.PLAIN, 14));
		lblName.setBounds(52, 224, 121, 28);
		panel.add(lblName);
		
		JLabel lblPhonenum = new JLabel("Phone-number");
		lblPhonenum.setForeground(new Color(128, 0, 0));
		lblPhonenum.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhonenum.setFont(new Font("HY신명조", Font.PLAIN, 14));
		lblPhonenum.setBounds(52, 287, 121, 28);
		panel.add(lblPhonenum);
		
		txtId = new JTextField();
		txtId.setFont(new Font("굴림", Font.PLAIN, 14));
		txtId.setBackground(Color.WHITE);
		txtId.setBounds(193, 119, 213, 28);
		panel.add(txtId);
		txtId.setColumns(10);
		
		txtPwd = new JTextField();
		txtPwd.setFont(new Font("굴림", Font.PLAIN, 14));
		txtPwd.setColumns(10);
		txtPwd.setBackground(Color.WHITE);
		txtPwd.setBounds(193, 173, 213, 28);
		panel.add(txtPwd);
		
		txtName = new JTextField();
		txtName.setFont(new Font("굴림", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setBackground(Color.WHITE);
		txtName.setBounds(193, 228, 213, 28);
		panel.add(txtName);
		
		txtPnb = new JTextField();
		txtPnb.setFont(new Font("굴림", Font.PLAIN, 14));
		txtPnb.setColumns(10);
		txtPnb.setBackground(Color.WHITE);
		txtPnb.setBounds(193, 287, 213, 28);
		panel.add(txtPnb);
		
		btnJoin = new JButton("Join");
		btnJoin.setBackground(Color.WHITE);
		btnJoin.setBounds(133, 356, 105, 28);
		panel.add(btnJoin);
		
		btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHome.setBackground(Color.WHITE);
		btnHome.setBounds(267, 356, 105, 28);
		panel.add(btnHome);
		
		/*----------------------------------------------*/
		
		//Home버튼
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		//join버튼
		btnJoin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String mid = txtId.getText();
				String pwd = txtPwd.getText();
				String name = txtName.getText();
				String phonenumber = txtPnb.getText();
				
				
				
				if(mid.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
					txtId.requestFocus();
				}
				else if(pwd.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요");
					txtPwd.requestFocus();
				}
				else if(name.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "성명을 입력하세요");
					txtName.requestFocus();
				}
			
				else if(phonenumber.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "번호를 입력하세요");
					txtPnb.requestFocus();
				}
				else {
//					System.out.println("sadfgsdfgh");
					if(!Pattern.matches("^[0-9]*$", phonenumber)) {
						JOptionPane.showMessageDialog(null, "번호는 숫자만 입력하세요");
						txtPnb.requestFocus();
					}
						
						vo = dao.getIdSearch(mid);
//						System.out.println("vo : " + vo);
						if(vo.getMid()!=null) {
							JOptionPane.showMessageDialog(null, "이미 사용중인 아이디 입니다.");
							txtId.requestFocus();
						} 
						else {
							vo.setMid(mid);
							vo.setPwd(pwd);
							vo.setName(name);
							vo.setPhonenumber(phonenumber);
							
							res = dao.setJoin(vo);
							if(res == 0) {
								JOptionPane.showMessageDialog(null, "회원가입에 실패하셨습니다.");
							}
							else {
								JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
								dispose();
							}
						}
						
					}
				}
			
		});
		
		
	}
}
