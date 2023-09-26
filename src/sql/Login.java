package sql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	CakeDAO dao = new CakeDAO();
	CakeVO vo = null;
	int res = 0;
	
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField txtId;
	private JButton btnLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("GreenCakeShop");
		setLocationRelativeTo(null);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GreenCakeShop");
		lblNewLabel.setFont(new Font("HY신명조", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(84, 25, 269, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		lblId.setFont(new Font("HY신명조", Font.PLAIN, 14));
		lblId.setBounds(84, 79, 65, 25);
		contentPane.add(lblId);
		
		JLabel lblPwd = new JLabel("Pwd");
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		lblPwd.setFont(new Font("HY신명조", Font.PLAIN, 14));
		lblPwd.setBounds(84, 121, 65, 25);
		contentPane.add(lblPwd);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(144, 121, 188, 25);
		contentPane.add(passwordField);
		
		txtId = new JTextField();
		txtId.setBounds(144, 79, 188, 25);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.setBackground(Color.WHITE);
		btnLogin.setFont(new Font("HY신명조", Font.PLAIN, 14));
		btnLogin.setBounds(120, 185, 97, 23);
		contentPane.add(btnLogin);
		
		JButton btnHome = new JButton("Home");
		btnHome.setFont(new Font("HY신명조", Font.PLAIN, 14));
		btnHome.setBackground(Color.WHITE);
		btnHome.setBounds(245, 185, 97, 23);
		contentPane.add(btnHome);
		
		/*-------------------------------------------------*/
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String mid = txtId.getText();
				String pwd = passwordField.getText();
				
				if(mid.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
					txtId.requestFocus();
				}
				else if(pwd.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력하세요");
					passwordField.requestFocus();
				}
				
		
				
	
			}
		});
		
		
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
}
