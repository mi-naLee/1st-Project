package selectMemberPage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginPage.AdminLogin;
import openDoorDAO.SelectMemberDAO;
import openDoorVo.OpenDoorVO;

import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AdminSelect extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSelect frame = new AdminSelect(null, null);
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
	public AdminSelect(String id, String pw) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// 회원 검색 라벨 
		JLabel readLabel = new JLabel("\uD68C\uC6D0 \uAC80\uC0C9");
		readLabel.setFont(new Font("굴림", Font.BOLD, 25));
		readLabel.setBounds(189, 72, 151, 98);
		contentPane.add(readLabel);
		
		// 개별 검색 Label
		JLabel aSearchLb = new JLabel("<\uAC1C\uBCC4 \uC870\uD68C>");
		aSearchLb.setFont(new Font("굴림", Font.BOLD, 15));
		aSearchLb.setBounds(189, 168, 91, 23);
		contentPane.add(aSearchLb);
		
		// 회원 검색 comboBox
		String search[] = {"(선택)","아이디로 검색","이름으로 검색","연락처로 검색"};
		JComboBox<String> combo;
		JComboBox readCbx = new JComboBox(search);
		readCbx.setBounds(189, 201, 151, 23);
		contentPane.add(readCbx);
		
		// 회원 검색 textField
		textField = new JTextField();
		textField.setBounds(365, 202, 96, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		// 회원 검색 버튼 클릭 시 이벤트 
		JButton aReadBtn = new JButton("\uAC80\uC0C9");
		aReadBtn.setFont(new Font("굴림", Font.BOLD, 14));
		aReadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // 검색 버튼 누를 시 키워드 검색
				String selectedValue = readCbx.getSelectedItem().toString();
				String textValue = textField.getText();
				
				// 1. 아이디로 검색
				if(selectedValue.equals("아이디로 검색")) {
					// 1) 빈 칸일 때는 내용 필요 안내
					// 2) 내용이 있을 경우에는 그 내용으로 조회 출력
						if(textValue.trim().isEmpty()||textValue==null) {
							JOptionPane.showMessageDialog(null, "입력이 필요합니다.");
						}
						else {// 내용이 있을 경우 처리
							try {
								SelectMemberDAO selDao = new SelectMemberDAO();
								ArrayList<OpenDoorVO> memArray = selDao.getAllInfo();
								if(memArray.isEmpty()) {
									JOptionPane.showMessageDialog(null, "해당 아이디가 존재하지 않습니다.");
								}else {// MemberList 창으로 이동
									setVisible(false); // 지금 창 안 보이게
									new AdminMemberList(memArray, id, pw).setVisible(true);
								}
							}catch(Exception e1) {
								e1.printStackTrace();
							}
						}
				}
				// 2. 이름으로 검색
				else if(selectedValue.equals("이름으로 검색")) {
					if(textValue.trim().isEmpty()||textValue==null) {
						JOptionPane.showMessageDialog(null, "입력이 필요합니다.");
					}
					else {// 내용이 있을 경우 처리
						try {
							SelectMemberDAO memDao = new SelectMemberDAO();
							ArrayList<OpenDoorVO> memArray = memDao.getNameInfo(textValue);
							if(memArray.isEmpty()) {
								JOptionPane.showMessageDialog(null, "해당 이름이 존재하지 않습니다.");
							}else {// MemberList 창으로 이동
								setVisible(false); // 지금 창 안 보이게
								new AdminMemberList(memArray, id, pw).setVisible(true);
							}
						}catch(Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				// 3. 연락처로 검색
				else if(selectedValue.equals("연락처로 검색")) {
					if(textValue.trim().isEmpty()||textValue==null) {
						JOptionPane.showMessageDialog(null, "입력이 필요합니다.");
					}
					else if(textValue.length()<=11) {
						JOptionPane.showMessageDialog(null, "'000-0000-0000' 형식으로 입력해 주세요");
					}
					else {// 내용이 있을 경우 처리
						try {
							SelectMemberDAO memDao = new SelectMemberDAO();
							ArrayList<OpenDoorVO> memArray = memDao.getTelInfo(textValue);
							if(memArray.isEmpty()) {
								JOptionPane.showMessageDialog(null, "해당 전화번호가 존재하지 않습니다.");
							}else {// MemberList 창으로 이동
								setVisible(false); // 지금 창 안 보이게
								new AdminMemberList(memArray, id, pw).setVisible(true);
							}
						}catch(Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				// 4. (선택) 옵션에서 선택이 없는 경우
				else {
					JOptionPane.showMessageDialog(null, "옵션을 선택해주세요.");
				}
			}
		});
		aReadBtn.setBounds(458, 201, 91, 23);
		contentPane.add(aReadBtn);
		
		// 전체 조회 버튼 클릭 event
		JButton readAllButton = new JButton("\uC804\uCCB4 \uC870\uD68C");
		readAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SelectMemberDAO memDao = new SelectMemberDAO();
					ArrayList<OpenDoorVO> memArray = memDao.getAllInfo(); // 전체 정보
					setVisible(false); // 지금 창 안 보이게
					new AdminMemberList(memArray, id, pw).setVisible(true); 
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		readAllButton.setFont(new Font("굴림", Font.BOLD, 13));
		readAllButton.setBounds(249, 269, 91, 23);
		contentPane.add(readAllButton);
		
		// 취소 버튼 
		JButton cancelBtn = new JButton("\uCDE8\uC18C");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminLogin(id, pw).setVisible(true);
			}
		});
		cancelBtn.setFont(new Font("굴림", Font.BOLD, 13));
		cancelBtn.setBounds(365, 269, 91, 23);
		contentPane.add(cancelBtn);
		
	}
}
