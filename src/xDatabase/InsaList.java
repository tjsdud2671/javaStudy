package xDatabase;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class InsaList extends JFrame {

	private JPanel contentPane;
	private JTable tbl;
	private JScrollPane sp;
	private ButtonGroup genderGroup = new ButtonGroup(); //한번쓰고말거라 생성함
	private JButton btnCondition, btnList, btnExit;
	private JComboBox cbCondition;
	
	
	@SuppressWarnings("rawtypes")
	Vector title = null;
	Vector vData = null;
	DefaultTableModel dtm;
	
	// xDatabase 패키지의 InsaDAO클래스 참조 (import)
	InsaDAO dao = new InsaDAO();
	private JTextField txtCondition;
	


	@SuppressWarnings("unchecked")
	public InsaList() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,491);
		setLocationRelativeTo(null);
		setTitle("JTable연습(DB에서 값을 가져와서 JTable에 뿌리기)");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setVisible(true);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pn1 = new JPanel();
		pn1.setBounds(0, 0, 584, 69);
		contentPane.add(pn1);
		pn1.setLayout(null);
		
		btnExit = new JButton("종료");
		btnExit.setFont(new Font("굴림", Font.PLAIN, 18));
		btnExit.setBounds(456, 10, 116, 31);
		pn1.add(btnExit);
		
		cbCondition = new JComboBox();
		cbCondition.setFont(new Font("굴림", Font.PLAIN, 14));
		cbCondition.setModel(new DefaultComboBoxModel(new String[] {"성명", "나이", "성별", "입사일"}));
		cbCondition.setBounds(12, 10, 92, 31);
		pn1.add(cbCondition);
		
		txtCondition = new JTextField();
		txtCondition.setHorizontalAlignment(SwingConstants.CENTER);
		txtCondition.setFont(new Font("굴림", Font.PLAIN, 14));
		txtCondition.setBounds(116, 11, 116, 31);
		pn1.add(txtCondition);
		txtCondition.setColumns(10);
		
	  btnCondition = new JButton("조건검색");
		btnCondition.setFont(new Font("굴림", Font.PLAIN, 14));
		btnCondition.setBounds(244, 10, 97, 31);
		pn1.add(btnCondition);
		
		btnList = new JButton("전체검색");
		btnList.setFont(new Font("굴림", Font.PLAIN, 14));
		btnList.setBounds(353, 10, 97, 31);
		pn1.add(btnList);
		
		JPanel pn2 = new JPanel();
		pn2.setBounds(0, 73, 584, 293);
		contentPane.add(pn2);
		pn2.setLayout(null);
//		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(12, 10, 560, 273);
//		pn2.add(scrollPane);
//		
//		tb1 = new JTable();
//		scrollPane.setViewportView(tb1);
		
		JPanel pn3 = new JPanel();
		pn3.setBounds(0, 372, 584, 80);
		contentPane.add(pn3);
		pn3.setLayout(null);
		
		JButton btnNameAsc = new JButton("성명 오름차순");
		btnNameAsc.setFont(new Font("굴림", Font.PLAIN, 10));
		btnNameAsc.setBounds(362, 10, 97, 23);
		pn3.add(btnNameAsc);
		
		JButton btnNameDesc = new JButton("성명 내림차순");
		btnNameDesc.setFont(new Font("굴림", Font.PLAIN, 10));
		btnNameDesc.setBounds(362, 43, 97, 23);
		pn3.add(btnNameDesc);
		
		JButton btnIpsailAsc = new JButton("입사일 오름차");
		btnIpsailAsc.setFont(new Font("굴림", Font.PLAIN, 10));
		btnIpsailAsc.setBounds(471, 10, 97, 23);
		pn3.add(btnIpsailAsc);
		
		JButton btnIpsailDesc = new JButton("입사일 내림차");
		btnIpsailDesc.setFont(new Font("굴림", Font.PLAIN, 10));
		btnIpsailDesc.setBounds(471, 43, 97, 23);
		pn3.add(btnIpsailDesc);
		
		JRadioButton rdFemale = new JRadioButton("여자");
		rdFemale.setFont(new Font("굴림", Font.PLAIN, 14));
		rdFemale.setBounds(20, 9, 65, 23);
		genderGroup.add(rdFemale);
		pn3.add(rdFemale);
		
		JRadioButton rdMale = new JRadioButton("남자");
		rdMale.setFont(new Font("굴림", Font.PLAIN, 14));
		rdMale.setBounds(20, 42, 65, 23);
		genderGroup.add(rdMale);
		pn3.add(rdMale);
		
		JButton btnGenderSearch = new JButton("성별 검색");
		btnGenderSearch.setFont(new Font("굴림", Font.PLAIN, 10));
		btnGenderSearch.setBounds(253, 9, 97, 23);
		pn3.add(btnGenderSearch);
		
		/* 아래로 JTable 설계하기*/
		// - '부제목'과 '데이터'를 vector 타입으로 준비한다.
		
		//1. '부제목'을 vector타입으로 준비
		title = new Vector<>();
		title.add("번호");
		title.add("성명");
		title.add("나이");
		title.add("성별");
		title.add("입사일");
		
		//2. '데이터'를 Vector타입으로 준비한다. - 데이터는 Database에서 가져온다.
		vData = dao.getInsaList();
		
		//3. DB에서 가져온 자료를 DefaultTableModel을 생성하면서 담아준다.
		dtm = new DefaultTableModel(vData, title);
		
		//4. DefaultTableModel에 담긴 Vector형식의 자료와 타이틀로 JTable을 생성시켜준다. (생성시 담아준다.)
		tbl = new JTable(dtm);
		
		//5. 자료가 담긴 table을 JScrollPane생성시 함께 담아서 생성한다.
		sp = new JScrollPane(tbl);
		sp.setBounds(12, 10, 560, 273);
		
		//6. JScrollPane을 패널에 올려준다.
		pn2.add(sp);
		
		// JTable안의 셀의 내용을 가운데 정렬하기
		tableCellAlign(tbl);
		
		// 0번열(idx(고유번호)) 셀의 크기를 50픽셀로 조정하기
		tbl.getColumnModel().getColumn(0).setMaxWidth(50);
		
		
		/* ================================================== */
		
		
		
		/* 성별버튼 클릭 시 성별별로 조회하기*/
		//남자 라디오 버튼 클릭시 남자만 검색처리
		/*
		rdMale.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vData = dao.getGender("남자");
				dtm.setDataVector(vData, title);
			}
		});
		
		//여자 라디오 버튼 클릭시 여자만 검색처리
		rdFemale.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vData = dao.getGender("여자");
				dtm.setDataVector(vData, title);
			}
		});
		*/
		
		// 성별 라디오버튼으로 성별 선택 후 '성별버튼' 클릭 시 해당 자료만 검색처리 출력 
		btnGenderSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender;
				if(rdMale.isSelected()) gender="남자";
				else gender = "여자";
				
				vData = dao.getGender(gender);
				dtm.setDataVector(vData, title);
				
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		
		
		
		
		
		// 입사일 오름차순 버튼
		btnIpsailAsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getNameAscList("ipsail","a");
				dtm.setDataVector(vData, title);
				
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		// 입사일 내림차순 버튼
		btnIpsailDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getNameAscList("ipsail","d");
				dtm.setDataVector(vData, title);
				
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		
		
		//성명 오름차순 버튼
		btnNameAsc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getNameAscList("name","a");
				dtm.setDataVector(vData, title);
				
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		//성명 내림차순 버튼
		btnNameDesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getNameAscList("name","d");
				dtm.setDataVector(vData, title);
				
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		//table 안의 셀을 클릭할 때 입력된 정보 가져오기
		tbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tbl.getSelectedRow();
				int col = tbl.getSelectedColumn();
				
				Object value = tbl.getValueAt(row, col);
				
//				lblMsg.setText("row:"+row+",col:"+col+",value:"+value);
			}
		});
		

		//조건별 검색처리하기 (조건버튼 클릭시 처리할 내용들)
		btnCondition.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cbCondi = cbCondition.getSelectedItem().toString();
				String txtCondi = txtCondition.getText();
				
				if(txtCondi.trim().equals("")){
					JOptionPane.showMessageDialog(null, "검색할 내용을 입력하세요");
					txtCondition.requestFocus();
					return;
				}
				
				if(cbCondi.equals("성명")) vData = dao.getConditionSearch("name",txtCondi);
				else if(cbCondi.equals("나이")) {
					if(!Pattern.matches("^[0-9]*$", txtCondi)) {
						JOptionPane.showMessageDialog(null, "나이는 숫자로 입력하세요");
						txtCondition.requestFocus();
					}
					else vData =  dao.getConditionSearch("age",txtCondi);
				}
				else if(cbCondi.equals("성별")) vData =  dao.getConditionSearch("gender",txtCondi);
				else if(cbCondi.equals("입사일")) vData =  dao.getConditionSearch("ipsail",txtCondi);
				
				dtm.setDataVector(vData, title);
				
				//셀을 중앙정렬하고 0열의 크기를 50픽셀로 조정
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		//조건검색 항목 선택 후 조건에 필요한 검색어를 입력하고 '엔터키' 누르면 바로 검색 실행
 
		
		
		//전체검색 버튼 클릭시 실행
		btnList.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vData = dao.getInsaList();
				dtm.setDataVector(vData, title);
				
				tableCellAlign(tbl);
				tbl.getColumnModel().getColumn(0).setMaxWidth(50);
			}
		});
		
		// 조건검색 콤보박스안의 항목을 변경할 때마다 자동으로 커서를 입력 텍스트필드로 이동
		cbCondition.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				txtCondition.requestFocus();
			}
		});
		
	
		
		
		//종료버튼
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}


	// 가운데정렬
	private void tableCellAlign(JTable tbl) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		
		TableColumnModel tcm = tbl.getColumnModel();
		for(int i=0; i<tcm.getColumnCount(); i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
			
		}
	}
}
