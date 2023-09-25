package xDatabase;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class InsaSearch extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtAge;
	private ButtonGroup buttonGroup = new ButtonGroup(); 
	private JRadioButton rdMale, rdFemale;
	private JButton btnUpdate, btnDelete, btnClose; 
	
	InsaDAO dao = new InsaDAO();
	InsaVO vo = null;
	int res = 0;


	
	public InsaSearch(InsaVO vo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null); // 가운데에 들어감
		setResizable(false);
		
		setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 82);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("회원개별조회(검색할 성명을 입력하세요)");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 736, 62);
		pn1.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(12, 102, 760, 331);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		JLabel lblName = new JLabel("성명");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("굴림", Font.PLAIN, 22));
		lblName.setBounds(144, 22, 213, 53);
		pn2.add(lblName);
		
		JLabel lblAge = new JLabel("나이");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("굴림", Font.PLAIN, 22));
		lblAge.setBounds(144, 95, 213, 53);
		pn2.add(lblAge);
		
		JLabel lblGender = new JLabel("성별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("굴림", Font.PLAIN, 22));
		lblGender.setBounds(144, 183, 213, 53);
		pn2.add(lblGender);
		
		JLabel lblIpsail = new JLabel("입사일");
		lblIpsail.setHorizontalAlignment(SwingConstants.CENTER);
		lblIpsail.setFont(new Font("굴림", Font.PLAIN, 22));
		lblIpsail.setBounds(144, 257, 213, 53);
		pn2.add(lblIpsail);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setFont(new Font("굴림", Font.PLAIN, 22));
		txtName.setBounds(321, 27, 246, 48);
		txtName.setText(vo.getName());
		pn2.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("굴림", Font.PLAIN, 22));
		txtAge.setColumns(10);
		txtAge.setBounds(321, 100, 246, 48);
		txtAge.setText(vo.getAge()+"");
		pn2.add(txtAge);
		
		rdMale = new JRadioButton("남자");
		rdMale.setSelected(true);
		rdMale.setFont(new Font("굴림", Font.PLAIN, 22));
		rdMale.setBounds(336, 193, 123, 36);
		buttonGroup.add(rdMale);
		
		if(vo.getGender().equals("남자")) rdMale.setSelected(true);
		pn2.add(rdMale);
		
		rdFemale = new JRadioButton("여자");
		rdFemale.setFont(new Font("굴림", Font.PLAIN, 22));
		rdFemale.setBounds(463, 191, 123, 36);
		buttonGroup.add(rdFemale);
		
		if(vo.getGender().equals("여자")) rdFemale.setSelected(true);
		pn2.add(rdFemale);
		
		
		String[] yy = new String[24];
		String[] mm = new String[12];
		String[] dd = new String[31];
		
		
		int imsi;
		for(int i=0; i<yy.length; i++) {
			imsi = i + 2000;
			yy[i] = imsi + "";
		}

		for(int i=0; i<mm.length; i++) {
			mm[i] = (i+1) + "";
		}
		

		for(int i=0; i<dd.length; i++) {
			dd[i] = (i+1) + "";
		}
		
		String[] ymds = vo.getIpsail().substring(0,10).split("-"); // 2023-09-21
		
		
		JComboBox cbYY = new JComboBox(yy);
		cbYY.setFont(new Font("굴림", Font.PLAIN, 20));
		cbYY.setBounds(321, 269, 81, 28);
		cbYY.setSelectedItem(ymds[0]);
		pn2.add(cbYY);
		
		JComboBox cbMM = new JComboBox(mm);
		cbMM.setFont(new Font("굴림", Font.PLAIN, 20));
		cbMM.setBounds(448, 269, 74, 28);
		cbMM.setSelectedItem(ymds[1]);
		pn2.add(cbMM);
		
		JComboBox cbDD = new JComboBox(dd);
		cbDD.setFont(new Font("굴림", Font.PLAIN, 20));
		cbDD.setBounds(565, 269, 74, 28);
		cbDD.setSelectedItem(ymds[2]);
		pn2.add(cbDD);
		
		JLabel lblYY = new JLabel("년");
		lblYY.setFont(new Font("굴림", Font.PLAIN, 15));
		lblYY.setBounds(414, 267, 37, 36);
		pn2.add(lblYY);
		
		JLabel lblMM = new JLabel("월");
		lblMM.setFont(new Font("굴림", Font.PLAIN, 15));
		lblMM.setBounds(534, 267, 37, 36);
		pn2.add(lblMM);
		
		JLabel lblDD = new JLabel("일");
		lblDD.setFont(new Font("굴림", Font.PLAIN, 15));
		lblDD.setBounds(651, 267, 37, 36);
		pn2.add(lblDD);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(12, 443, 760, 88);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		btnUpdate = new JButton("수정하기");
		btnUpdate.setFont(new Font("굴림", Font.PLAIN, 22));
		btnUpdate.setBounds(12, 10, 224, 57);
		pn3.add(btnUpdate);
		
		btnDelete = new JButton("삭제하기");
		btnDelete.setFont(new Font("굴림", Font.PLAIN, 22));
		btnDelete.setBounds(275, 10, 224, 57);
		pn3.add(btnDelete);
		
		btnClose = new JButton("창닫기");
		btnClose.setFont(new Font("굴림", Font.PLAIN, 22));
		btnClose.setBounds(524, 10, 224, 57);
		pn3.add(btnClose);
		
		/*-----------------------------------------------------------------*/
		//회원정보수정 버튼
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String age = txtAge.getText();
				String gender;
				String ipsail = cbYY.getSelectedItem()+"-"+cbMM.getSelectedItem()+"-"+cbDD.getSelectedItem();
				
				if(age.trim().equals("")) {
					JOptionPane.showMessageDialog(null, "나이를 입력하세요.");
					txtAge.requestFocus();
				}
				else {
					if(rdMale.isSelected())gender = "남자";
					else gender="여자";
					
					//정상적으로 수정할 자료가 입력되어 넘어온다면 모든 값을 vo에 담아서 DB에 저장(수정)한다.
					vo.setName(txtName.getText());
					vo.setAge(Integer.parseInt(age));
					vo.setGender(gender);
					vo.setIpsail(ipsail);
					
					res = dao.setInsaUpdate(vo);
					if(res == 0) {
						JOptionPane.showMessageDialog(null, "회원정보 수정실패. 다시 수정하세요");
					}
					else {
						JOptionPane.showMessageDialog(null, "회원정보 수정완료.");
						

					}
				}
				
			}
		});
		
		//삭제하기 버튼
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				int ans = JOptionPane.showConfirmDialog(null, name + "회원을 삭제하시겠습니까?","회원삭제",JOptionPane.YES_NO_OPTION);
				if(ans == 0) {
					res = dao.setInsaDelete(name);
					if(res == 0) {
						JOptionPane.showMessageDialog(null, "회원정보 삭제실패. 다시 확인 하세요");
					}
					else {
						JOptionPane.showMessageDialog(null, "회원정보 삭제완료.");
						dispose();

					}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "회원삭제 취소.");
				}
			
			}
		});
		//창닫기 버튼
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

}
