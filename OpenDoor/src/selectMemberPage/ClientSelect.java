package selectMemberPage;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import loginPage.ClientLogin;
import openDoorDAO.SelectMemberDAO;
import openDoorVo.OpenDoorVO;

public class ClientSelect extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientSelect frame = new ClientSelect(null, null);
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
	public ClientSelect(String id, String pw) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// 회원 검색 라벨 
		JLabel readLabel = new JLabel("\uD68C\uC6D0 \uAC80\uC0C9");
		readLabel.setFont(new Font("굴림", Font.BOLD, 25));
		readLabel.setBounds(310, 10, 151, 98);
		contentPane.add(readLabel);
		
		// 개별 검색 Label
		JLabel aSearchLb = new JLabel("<\uAC1C\uBCC4 \uC870\uD68C>");
		aSearchLb.setFont(new Font("굴림", Font.BOLD, 15));
		aSearchLb.setBounds(12, 85, 91, 23);
		contentPane.add(aSearchLb);
		
		// 얼굴 검색 Label--------------------------------------------------
		JLabel faceLb = new JLabel("\uC678\uBAA8\uB85C \uAC80\uC0C9");
		faceLb.setFont(new Font("굴림", Font.BOLD, 15));
		faceLb.setBounds(35, 121, 91, 31);
		contentPane.add(faceLb);
		
		// 얼굴 상,중,하 선택
		JRadioButton upRBtn = new JRadioButton("\uC0C1");
		upRBtn.setFont(new Font("굴림", Font.BOLD, 15));
		upRBtn.setBounds(159, 125, 59, 23);
		contentPane.add(upRBtn);
		
		JRadioButton midRBtn = new JRadioButton("\uC911");
		midRBtn.setFont(new Font("굴림", Font.BOLD, 15));
		midRBtn.setBounds(222, 125, 59, 23);
		contentPane.add(midRBtn);
		
		JRadioButton lowRBtn = new JRadioButton("\uD558");
		lowRBtn.setFont(new Font("굴림", Font.BOLD, 15));
		lowRBtn.setBounds(285, 125, 51, 23);
		contentPane.add(lowRBtn);
		
		// 외모 상,중,하 중복 선택 방지
		ButtonGroup group = new ButtonGroup();
		group.add(upRBtn);
		group.add(midRBtn);
		group.add(lowRBtn);
		
		// 외모 검색 Btn
		JButton faceBtn = new JButton("\uAC80\uC0C9");
		faceBtn.addActionListener(new ActionListener() { // 검색 이벤트 처리
			public void actionPerformed(ActionEvent e) {
				String faceGrade = "";
				if(upRBtn.isSelected()) {
					faceGrade = "상";
					try {
						SelectMemberDAO memDao = new SelectMemberDAO();
						ArrayList<OpenDoorVO> memArray = memDao.getFaceInfo(faceGrade);
						if(memArray.isEmpty()) {
							JOptionPane.showMessageDialog(null, "해당 조건의 검색 결과가 없습니다.");
						}
						else {
							setVisible(false); 
							new ClientMemberList(memArray,id,pw).setVisible(true); 
						}
					}catch(Exception e1){
						e1.printStackTrace();
					}
				}
				else if(midRBtn.isSelected()) {
					faceGrade = "중";
					try {
						SelectMemberDAO memDao = new SelectMemberDAO();
						ArrayList<OpenDoorVO> memArray = memDao.getFaceInfo(faceGrade);
						if(memArray.isEmpty()) {
							JOptionPane.showMessageDialog(null, "해당 조건의 검색 결과가 없습니다.");
						}
						else {
							setVisible(false); 
							new ClientMemberList(memArray,id,pw).setVisible(true); 
						}
					}catch(Exception e1){
						e1.printStackTrace();
					}
				}
				else if(lowRBtn.isSelected()) {
					faceGrade = "하";
					try {
						SelectMemberDAO memDao = new SelectMemberDAO();
						ArrayList<OpenDoorVO> memArray = memDao.getFaceInfo(faceGrade);
						if(memArray.isEmpty()) {
							JOptionPane.showMessageDialog(null, "해당 조건의 검색 결과가 없습니다.");
						}
						else {
							setVisible(false); 
							new ClientMemberList(memArray,id,pw).setVisible(true); 
						}
					}catch(Exception e1){
						e1.printStackTrace();
					}
				}
				else
					JOptionPane.showMessageDialog(null, "옵션을 선택하세요.");
			}
		});
		faceBtn.setFont(new Font("굴림", Font.BOLD, 15));
		faceBtn.setBounds(344, 125, 91, 23);
		contentPane.add(faceBtn);
		//--------------------------------------------------얼굴 검색-end
		
		// 재산 검색--------------------------------------------------------
		// 재산 검색 Label
		JLabel propLb = new JLabel("\uC7AC\uC0B0\uC73C\uB85C \uAC80\uC0C9");
		propLb.setFont(new Font("굴림", Font.BOLD, 15));
		propLb.setBounds(30, 202, 96, 31);
		contentPane.add(propLb);
		
		// 재산 검색 조건 1, 2, 3
		JRadioButton goldRBtn = new JRadioButton("10\uC5B5 \uC774\uC0C1");
		goldRBtn.setFont(new Font("굴림", Font.BOLD, 15));
		goldRBtn.setBounds(159, 206, 113, 23);
		contentPane.add(goldRBtn);
		
		JRadioButton silverRBtn = new JRadioButton("5\uC5B5 \uC774\uC0C1");
		silverRBtn.setFont(new Font("굴림", Font.BOLD, 15));
		silverRBtn.setBounds(285, 206, 91, 23);
		contentPane.add(silverRBtn);
		
		JRadioButton bronzeRBtn = new JRadioButton("1\uC5B5 \uC774\uC0C1");
		bronzeRBtn.setFont(new Font("굴림", Font.BOLD, 15));
		bronzeRBtn.setBounds(401, 206, 91, 23);
		contentPane.add(bronzeRBtn);
		
		// 재산 검색 Btn
		JButton propBtn = new JButton("\uAC80\uC0C9");
		propBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int propGrade;
				if(goldRBtn.isSelected()) {
					propGrade = 1000000000;
					try {
						SelectMemberDAO memDao = new SelectMemberDAO();
						ArrayList<OpenDoorVO> memArray = memDao.getPropInfo(propGrade);
						if(memArray.isEmpty()) {
							JOptionPane.showMessageDialog(null, "해당 조건의 검색 결과가 없습니다.");
						}
						else {
							setVisible(false); 
							new ClientMemberList(memArray,id,pw).setVisible(true); 
						}
					}catch(Exception e1){
						e1.printStackTrace();
					}
				}
				else if(silverRBtn.isSelected()) {
					propGrade = 500000000; 
					try {
						SelectMemberDAO memDao = new SelectMemberDAO();
						ArrayList<OpenDoorVO> memArray = memDao.getPropInfo(propGrade);
						if(memArray.isEmpty()) {
							JOptionPane.showMessageDialog(null, "해당 조건의 검색 결과가 없습니다.");
						}
						else {
							setVisible(false); 
							new ClientMemberList(memArray,id,pw).setVisible(true); 
						}
					}catch(Exception e1){
						e1.printStackTrace();
					}
				}
				else if(bronzeRBtn.isSelected()) {
					propGrade = 100000000; 
					try {
						SelectMemberDAO memDao = new SelectMemberDAO();
						ArrayList<OpenDoorVO> memArray = memDao.getPropInfo(propGrade);
						if(memArray.isEmpty()) {
							JOptionPane.showMessageDialog(null, "해당 조건의 검색 결과가 없습니다.");
						}
						else {
							setVisible(false); 
							new ClientMemberList(memArray,id,pw).setVisible(true); 
						}
					}catch(Exception e1){
						e1.printStackTrace();
					}
				}
				else
					JOptionPane.showMessageDialog(null, "옵션을 선택하세요.");
			}
		});
		propBtn.setFont(new Font("굴림", Font.BOLD, 15));
		propBtn.setBounds(500, 206, 91, 23);
		contentPane.add(propBtn);
		
		// 재산 RBtn 중복 선택 방지
		ButtonGroup group2 = new ButtonGroup();
		group2.add(goldRBtn);
		group2.add(silverRBtn);
		group2.add(bronzeRBtn);
		
		// --------------------------------------------------------재산 검색-end
		
		// 전부 조회하기 Btn
		JButton allSelectBtn = new JButton("\uC804\uBD80 \uC870\uD68C\uD558\uAE30");
		allSelectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SelectMemberDAO memDao = new SelectMemberDAO();
					ArrayList<OpenDoorVO> memArray = memDao.getClientAllInfo();
					setVisible(false);
					new ClientMemberList(memArray, id, pw).setVisible(true);
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		allSelectBtn.setFont(new Font("굴림", Font.BOLD, 15));
		allSelectBtn.setBounds(478, 425, 135, 38);
		contentPane.add(allSelectBtn);
		
		// 취소 버튼 
		JButton cancelBtn = new JButton("\uCDE8\uC18C");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ClientLogin(id, pw).setVisible(true);
			}
		});
		cancelBtn.setFont(new Font("굴림", Font.BOLD, 15));
		cancelBtn.setBounds(622, 425, 135, 38);
		contentPane.add(cancelBtn);
		
	}
}
