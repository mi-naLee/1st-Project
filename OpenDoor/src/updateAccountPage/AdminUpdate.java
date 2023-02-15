package updateAccountPage;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import loginPage.AdminLogin;
import openDoorDAO.UpdateAccountDAO;
import openDoorVo.OpenDoorVO;

public class AdminUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField pwTxt;
	private JTextField nameTxt;
	private JTextField rrnTxt;
	private JTextField jobTxt;
	private JTextField propTxt;
	private JTextField telTxt;
	private JTextField pwqTxt;
	private JTextField pwaTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminUpdate frame = new AdminUpdate(null, null, null);
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
	public AdminUpdate(ArrayList<OpenDoorVO> arr, String id, String pw) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String memId = arr.get(0).getId();
		
		// 회원의 아이디를 표시할 Label
		JLabel idLb = new JLabel(memId+"님의 회원정보");
		idLb.setFont(new Font("굴림", Font.BOLD, 15));
		idLb.setBounds(292, 40, 246, 43);
		contentPane.add(idLb);
		
		// 패스워드 Label
		JLabel pwLb = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pwLb.setFont(new Font("굴림", Font.BOLD, 15));
		pwLb.setBounds(39, 135, 68, 36);
		contentPane.add(pwLb);
		
		// input 패스워드 Txt
		pwTxt = new JTextField();
		pwTxt.setBounds(110, 135, 173, 36);
		contentPane.add(pwTxt);
		pwTxt.setColumns(10);
		
		// 이름 Label
		JLabel nameLb = new JLabel("\uC774\uB984");
		nameLb.setFont(new Font("굴림", Font.BOLD, 15));
		nameLb.setBounds(39, 234, 68, 33);
		contentPane.add(nameLb);
		
		// input 이름 Txt
		nameTxt = new JTextField();
		nameTxt.setBounds(110, 234, 173, 33);
		contentPane.add(nameTxt);
		nameTxt.setColumns(10);
		
		// 성별 Label
		JLabel genderLb = new JLabel("\uC131\uBCC4");
		genderLb.setFont(new Font("굴림", Font.BOLD, 15));
		genderLb.setBounds(39, 322, 68, 33);
		contentPane.add(genderLb);
		
		// choice 남자 RadioBtn
		JRadioButton genderMRBtn = new JRadioButton("\uB0A8");
		genderMRBtn.setFont(new Font("굴림", Font.BOLD, 15));
		genderMRBtn.setBounds(110, 324, 56, 28);
		contentPane.add(genderMRBtn);
		
		// choice 여자 RadioBtn
		JRadioButton genderFRBtn = new JRadioButton("\uC5EC");
		genderFRBtn.setFont(new Font("굴림", Font.BOLD, 15));
		genderFRBtn.setBounds(189, 324, 56, 28);
		contentPane.add(genderFRBtn);
		
		// 성별 중복 설정 방지
		ButtonGroup group = new ButtonGroup();
		group.add(genderMRBtn);
		group.add(genderFRBtn);
		
		// 주민번호 Label
		JLabel rrnLb = new JLabel("\uC8FC\uBBFC\uBC88\uD638");
		rrnLb.setFont(new Font("굴림", Font.BOLD, 15));
		rrnLb.setBounds(39, 399, 68, 33);
		contentPane.add(rrnLb);
		
		// input 주민번호 Txt
		rrnTxt = new JTextField();
		rrnTxt.setBounds(110, 399, 173, 33);
		contentPane.add(rrnTxt);
		rrnTxt.setColumns(10);
		
		// 직업 Label
		JLabel jobLb = new JLabel("\uC9C1\uC5C5");
		jobLb.setFont(new Font("굴림", Font.BOLD, 15));
		jobLb.setBounds(39, 493, 68, 33);
		contentPane.add(jobLb);
		
		// input 직업 txt
		jobTxt = new JTextField();
		jobTxt.setBounds(110, 493, 173, 33);
		contentPane.add(jobTxt);
		jobTxt.setColumns(10);
		
		// 재산 Label
		JLabel propLb = new JLabel("\uC7AC\uC0B0");
		propLb.setFont(new Font("굴림", Font.BOLD, 15));
		propLb.setBounds(408, 135, 68, 36);
		contentPane.add(propLb);
		
		// input 재산 Txt
		propTxt = new JTextField();
		propTxt.setBounds(477, 136, 170, 36);
		contentPane.add(propTxt);
		propTxt.setColumns(10);
		
		// 전화번호 Label
		JLabel telLb = new JLabel("\uC804\uD654\uBC88\uD638");
		telLb.setFont(new Font("굴림", Font.BOLD, 15));
		telLb.setBounds(408, 234, 68, 33);
		contentPane.add(telLb);
		
		// input 전화번호 Txt
		telTxt = new JTextField();
		telTxt.setBounds(475, 234, 172, 33);
		contentPane.add(telTxt);
		telTxt.setColumns(10);
		
		// 외모 Label
		JLabel faceLb = new JLabel("\uC678\uBAA8");
		faceLb.setFont(new Font("굴림", Font.BOLD, 15));
		faceLb.setBounds(408, 322, 40, 24);
		contentPane.add(faceLb);
		
		// choice 외모 상 Txt
		JRadioButton upFaceRBtn = new JRadioButton("\uC0C1");
		upFaceRBtn.setFont(new Font("굴림", Font.BOLD, 15));
		upFaceRBtn.setBounds(477, 320, 47, 28);
		contentPane.add(upFaceRBtn);
		
		// choice 외모 중 Txt
		JRadioButton middleFaceRBtn = new JRadioButton("\uC911");
		middleFaceRBtn.setFont(new Font("굴림", Font.BOLD, 15));
		middleFaceRBtn.setBounds(528, 320, 56, 28);
		contentPane.add(middleFaceRBtn);
		
		// choice 외모 하 Txt
		JRadioButton lowFaceRBtn = new JRadioButton("\uD558");
		lowFaceRBtn.setFont(new Font("굴림", Font.BOLD, 15));
		lowFaceRBtn.setBounds(588, 322, 59, 23);
		contentPane.add(lowFaceRBtn);
		
		// 외모 중복 선택 방지
		ButtonGroup group2 = new ButtonGroup();
		group2.add(upFaceRBtn);
		group2.add(middleFaceRBtn);
		group2.add(lowFaceRBtn);
		
		// 비밀번호 질문 Label
		JLabel pwqLb = new JLabel("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30 \uC9C8\uBB38");
		pwqLb.setFont(new Font("굴림", Font.BOLD, 15));
		pwqLb.setBounds(331, 399, 145, 33);
		contentPane.add(pwqLb);
		
		// input 비밀번호 질문 Txt
		pwqTxt = new JTextField();
		pwqTxt.setBounds(477, 399, 310, 33);
		contentPane.add(pwqTxt);
		pwqTxt.setColumns(10);
		
		// 비밀번호 답 Label
		JLabel pwaLb = new JLabel("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30 \uB2F5");
		pwaLb.setFont(new Font("굴림", Font.BOLD, 15));
		pwaLb.setBounds(331, 493, 145, 33);
		contentPane.add(pwaLb);
		
		// input 비밀번호 답 Txt
		pwaTxt = new JTextField();
		pwaTxt.setBounds(477, 493, 310, 33);
		contentPane.add(pwaTxt);
		pwaTxt.setColumns(10);
		
		// 회원의 정보 띄우기
		try {
			pwTxt.setText(arr.get(0).getPw());
			nameTxt.setText(arr.get(0).getName());
			String gender = arr.get(0).getGender();
			if(gender.equals("남")) {
				genderMRBtn.setSelected(true);
			}else {
				genderFRBtn.setSelected(true);
			}
			StringBuilder builder = new StringBuilder();
			builder.append(arr.get(0).getRrn().toString());
			rrnTxt.setText(builder.toString());
			jobTxt.setText(arr.get(0).getJob());
			StringBuilder builder2 = new StringBuilder();
			builder2.append(arr.get(0).getProp());
			propTxt.setText(builder2.toString());
			telTxt.setText(arr.get(0).getTel());
			// face는 null 값이 들어갈 경우도 있어 설정하지 않음
			pwqTxt.setText(arr.get(0).getPwq());
			pwaTxt.setText(arr.get(0).getPwa());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		// 변경하기 Btn
		JButton okBtn = new JButton("\uBCC0\uACBD\uD558\uAE30");
		okBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputPw = pwTxt.getText();
				String inputName = nameTxt.getText();
				String inputGender = null;
				if(genderMRBtn.isSelected()) {
					inputGender = "남";
				}else if(genderFRBtn.isSelected()) {
					inputGender = "여";
				}
				String inputRrn = rrnTxt.getText(); // date 변환 필요
				String inputJob = jobTxt.getText();
				int inputProp = Integer.parseInt(propTxt.getText());
				String inputTel = telTxt.getText();
				String inputFace = null;
				if(upFaceRBtn.isSelected()) {
					inputFace = "상";
				}else if(middleFaceRBtn.isSelected()) {
					inputFace = "중";
				}else if(lowFaceRBtn.isSelected()) {
					inputFace = "하";
				}
				String inputPwq = pwqTxt.getText();
				String inputPwa = pwaTxt.getText();
				
				if(inputPw.trim().isEmpty()||inputName.trim().isEmpty()||
						(!genderMRBtn.isSelected()&&!genderFRBtn.isSelected()) ||
						inputRrn.trim().isEmpty()||inputJob.trim().isEmpty()||
						inputProp==0||inputTel.trim().isEmpty()||
						(!upFaceRBtn.isSelected()&&!middleFaceRBtn.isSelected()&&!lowFaceRBtn.isSelected())||
						inputPwq.trim().isEmpty()||inputPwa.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "빈 조건을 확인하세요");
				}else {
					try {
						UpdateAccountDAO upDao = new UpdateAccountDAO();
						upDao.updatePw(memId, inputPw);
						upDao.updateName(memId, inputName);
						upDao.updateGender(memId, inputGender);
						upDao.updateRrn(memId, inputRrn);
						upDao.updateJob(memId, inputJob);
						upDao.updateProp(memId, inputProp);
						upDao.updateTel(memId, inputTel);
						upDao.updateFace(memId, inputFace);
						upDao.updatePwq(memId, inputPwq);
						upDao.updatePwa(memId, inputPwa);
						JOptionPane.showMessageDialog(null, "변경이 완료되었습니다.");
						setVisible(false);
						new AfterAdminUpdate(id, pw).setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					} 
				}
			}
		});
		okBtn.setFont(new Font("굴림", Font.BOLD, 14));
		okBtn.setBounds(688, 135, 99, 36);
		contentPane.add(okBtn);
		
		// 되돌아가기 Btn
		JButton rtnBtn = new JButton("\uCDE8\uC18C\uD558\uAE30");
		rtnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminLogin(id, pw).setVisible(true);
			}
		});
		rtnBtn.setFont(new Font("굴림", Font.BOLD, 15));
		rtnBtn.setBounds(688, 234, 99, 33);
		contentPane.add(rtnBtn);
		
	}
}
