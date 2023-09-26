package sql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Staff extends JFrame {

	private JPanel contentPane;
	private JTable tbl;
	private JScrollPane sp;
	private JButton btnSearch, btnAll, btnClose;
	
	Vector title = null;
	Vector vData = null;
	DefaultTableModel dtm;
	
	CakeDAO dao = new CakeDAO();
	CakeVO vo = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff frame = new Staff();
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
	public Staff() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,700);
		setTitle("GreenCakeShop");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 684, 118);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox cbRsvdate = new JComboBox();
		cbRsvdate.setBackground(Color.WHITE);
		cbRsvdate.setBounds(31, 32, 165, 29);
		panel.add(cbRsvdate);
		
		btnSearch = new JButton("검색");
		btnSearch.setFont(new Font("HY신명조", Font.PLAIN, 13));
		btnSearch.setBackground(SystemColor.menu);
		btnSearch.setBounds(209, 32, 80, 29);
		panel.add(btnSearch);
		
		btnAll = new JButton("전체검색");
		btnAll.setFont(new Font("HY신명조", Font.PLAIN, 13));
		btnAll.setBackground(SystemColor.menu);
		btnAll.setBounds(302, 32, 98, 29);
		panel.add(btnAll);
		
		btnClose = new JButton("종료");
		btnClose.setFont(new Font("HY신명조", Font.PLAIN, 13));
		btnClose.setBackground(SystemColor.menu);
		btnClose.setBounds(581, 32, 80, 29);
		panel.add(btnClose);
		
		JLabel lblNewLabel = new JLabel("주문내역");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("HY신명조", Font.PLAIN, 16));
		lblNewLabel.setBounds(259, 78, 187, 30);
		panel.add(lblNewLabel);
		
		JPanel pn2 = new JPanel();
		pn2.setBackground(Color.WHITE);
		pn2.setBounds(0, 117, 684, 544);
		contentPane.add(pn2);
		pn2.setLayout(null);
		
		tbl = new JTable();
		tbl.setBounds(12, 10, 660, 510);
		pn2.add(tbl);
		
		/*JTable 설계*/
		title = new Vector<>();
		title.add("번호");
		title.add("아이디");
		title.add("성명");
		title.add("예약일");
		
		
		vData = dao.getReservation();
		
		dtm = new DefaultTableModel(vData, title);
		
		tbl = new JTable(dtm);
		
		sp = new JScrollPane(tbl);
		
		pn2.add(sp);
		

		
		/*-------------------------------------*/
		
		//조건검색
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cbRvdt = cbRsvdate.getSelectedItem().toString();
			
//				if(cbRvdt.equals("예약일"))vData = dao.getReservation("예약일");
			}
			
		});
		
		//전체검색 버튼
		btnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vData = dao.getReservation();
				dtm.setDataVector(vData, title);
			}
		});
		
		//종료버튼
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		
		
	}
}
