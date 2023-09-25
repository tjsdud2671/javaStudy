package xDatabase;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class InsaMain extends JFrame {

	private JPanel contentPane;
	private JButton btnInput, btnSearch, btnList, btnExit;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsaMain frame = new InsaMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public InsaMain() {
		setTitle("인사관리 메뉴");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null); // 가운데에 들어감
		setResizable(false);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 106);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("인사관리 프로그램(v1.0)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 28));
		lblNewLabel.setBounds(12, 10, 736, 75);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 126, 760, 309);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblMain = new JLabel("");
		lblMain.setHorizontalAlignment(SwingConstants.CENTER);
		lblMain.setIcon(new ImageIcon(InsaMain.class.getResource("/xDatabase/images/1.jpg")));
		lblMain.setBounds(0, 0, 700, 500);
		pn2.add(lblMain);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 445, 760, 106);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("사원등록");
		btnInput.setBounds(12, 10, 162, 75);
		pn3.add(btnInput);
		
		btnSearch = new JButton("개별조회");
		btnSearch.setBounds(198, 10, 162, 75);
		pn3.add(btnSearch);
		
		btnList = new JButton("전체조회");
		btnList.setBounds(385, 10, 162, 75);
		pn3.add(btnList);
		
	  btnExit = new JButton("종료");
		btnExit.setBounds(567, 10, 162, 75);
		pn3.add(btnExit);
		
/* ====================================================== */
		
		// 사원 등록 버튼을 마우스로 클릭했을 때 수행
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InsaInput();
			}
		});
		
		// 사원 등록 버튼을 키보드 엔터키 눌렀을 때 수행
		btnInput.addKeyListener(new KeyAdapter() {
			

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) new InsaInput();
			}
		});
		
		// 개별사원조회 버튼
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog("검색할 성명을 입력하세요");
				InsaDAO dao =new InsaDAO();
				InsaVO vo = dao.getNameSearch(name);
				
				if(vo.getName() == null) JOptionPane.showMessageDialog(null, "검색한 회원이 없습니다.");
				else new InsaSearch(vo);
			}
		});
		
		// 전체 사원 조회 버튼
		btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new InsaList();
				
			}
		});
		
		// 종료버튼을 마우스로 클릭했을 때 수행처리
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	
		// 종료버튼을 키보드 엔터를 눌렀을 때 수행처리
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() ==KeyEvent.VK_ENTER) {
				System.exit(0);
			 }
			}
		});
		
	}

}

	