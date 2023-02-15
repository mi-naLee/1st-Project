package selectMemberPage;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import openDoorVo.OpenDoorVO;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;

public class AdminMemberList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	JScrollPane scroll;
	String[] title = {"아이디", "이름", "성별", "나이", "직업",
			"재산", "전화번호", "외모"};
	private JLabel idLb;
	private JLabel nameLb;
	private JLabel genderLb;
	private JLabel rrnLb;
	private JLabel propLb;
	private JLabel telLb;
	private JLabel faceLb;
	private JButton reSelectBtn;
	private JLabel jobLb;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminMemberList frame = new AdminMemberList(null, null, null);
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
	public AdminMemberList(ArrayList<OpenDoorVO> memArray, String id, String pw) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 941, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// 조회 결과 출력 label
		JLabel memListLb = new JLabel("\uC870\uD68C \uACB0\uACFC \uCD9C\uB825");
		memListLb.setFont(new Font("굴림", Font.BOLD, 19));
		memListLb.setBounds(384, 32, 134, 28);
		contentPane.add(memListLb);
		
		// table 생성
		DefaultTableModel tbModel = new DefaultTableModel(title,0);
		
		// 조회 결과 출력해주기
		for(int i=0; i<memArray.size(); i++) {
			String memId = memArray.get(i).getId();
			String memName = memArray.get(i).getName();
			String memGender = memArray.get(i).getGender();
			java.util.Date memRrn = memArray.get(i).getRrn();
			String memJob = memArray.get(i).getJob();
			int memProp = memArray.get(i).getProp();
			String memTel = memArray.get(i).getTel();
			String memFace = memArray.get(i).getFace();
			
			Object[] data = {memId, memName, memGender, memRrn, 
					memJob, memProp, memTel, memFace};
			tbModel.addRow(data);
		}
		
		// 조회 테이블 생성
		table = new JTable(tbModel); 
		table.setFont(new Font("굴림", Font.BOLD, 14));
		table.setBounds(12,93,903,360);
		contentPane.add(table);
		
		// 항목별 Label --------------------------------
		idLb = new JLabel("\uC544\uC774\uB514");
		idLb.setFont(new Font("굴림", Font.BOLD, 15));
		idLb.setBounds(12, 68, 50, 28);
		contentPane.add(idLb);
		
		nameLb = new JLabel("\uC774\uB984");
		nameLb.setFont(new Font("굴림", Font.BOLD, 15));
		nameLb.setBounds(118, 71, 50, 22);
		contentPane.add(nameLb);
		
		genderLb = new JLabel("\uC131\uBCC4");
		genderLb.setFont(new Font("굴림", Font.BOLD, 15));
		genderLb.setBounds(244, 71, 50, 22);
		contentPane.add(genderLb);
		
		jobLb = new JLabel("\uC9C1\uC5C5");
		jobLb.setFont(new Font("굴림", Font.BOLD, 15));
		jobLb.setBounds(468, 72, 50, 20);
		contentPane.add(jobLb);
		
		rrnLb = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		rrnLb.setFont(new Font("굴림", Font.BOLD, 15));
		rrnLb.setBounds(357, 70, 61, 22);
		contentPane.add(rrnLb);
		
		propLb = new JLabel("\uC7AC\uC0B0");
		propLb.setFont(new Font("굴림", Font.BOLD, 15));
		propLb.setBounds(593, 72, 50, 20);
		contentPane.add(propLb);
		
		telLb = new JLabel("\uC804\uD654\uBC88\uD638");
		telLb.setFont(new Font("굴림", Font.BOLD, 15));
		telLb.setBounds(700, 72, 69, 20);
		contentPane.add(telLb);
		
		faceLb = new JLabel("\uC678\uBAA8");
		faceLb.setFont(new Font("굴림", Font.BOLD, 15));
		faceLb.setBounds(828, 71, 50, 22);
		contentPane.add(faceLb);
		// --------------------------------항목별 Label-end
		
		// 하단 Button-------------------------------
		reSelectBtn = new JButton("\uB418\uB3CC\uC544\uAC00\uAE30");
		reSelectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); 
				new AdminSelect(id, pw).setVisible(true);
			}
		});
		reSelectBtn.setFont(new Font("굴림", Font.BOLD, 15));
		reSelectBtn.setBounds(384, 463, 134, 33);
		contentPane.add(reSelectBtn);
		// -------------------------------하단 Button-end
		
	}
}
