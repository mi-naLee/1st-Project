package createAccountPage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import main.Main;
import openDoorDAO.CreateAccountDAO;
import openDoorVo.OpenDoorVO;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;

public class CreateAccountPage extends JFrame {

	private JPanel contentPane;
	private JTextField IDTextField;
	private JTextField PWTextField;
	private JTextField PWConfirmTextField;
	private JTextField NameTextField;
	private JTextField RRNTextField;
	private final ButtonGroup buttonGroupGender = new ButtonGroup();
	private JTextField JobTextField;
	private JTextField PropTextField;
	private JTextField TelTextField;
	private JTextField PWQTextField;
	private JTextField PWATextField;
	private JTextField PWAConfirmTextField;
	
	String ID;
	String PW;
	String name;
	String gender="";
	String RRNS;
	String job;
	int prop;
	String tel;
	String face=null;
	String PWQ;
	String PWA;
	String genderN;
	String propS;
	String PWConfirm;
	String PWAConfirm;
	int PWSwitch=0; 
	
	JLabel IDCheckLabel = new JLabel("");
	JLabel PWCheckLabel = new JLabel("");
	JLabel PWCCheckLabel = new JLabel("");
	JLabel NameCheckLabel = new JLabel("");
	JLabel RRNCheckLabel = new JLabel("");
	JLabel jobCheckLabel = new JLabel("");
	JLabel propCheckLabel = new JLabel("");
	JLabel telCheckLabel = new JLabel("");
	JLabel telCheckLabel2 = new JLabel("");
	JLabel PWQCheckLabel = new JLabel("");
	JLabel PWACheckLabel = new JLabel("");
	JLabel PWACCheckLabel = new JLabel("");
	
	Scanner sc=new Scanner(System.in);
	
	CreateAccountDAO ODD = new CreateAccountDAO();
	ArrayList<OpenDoorVO> memberlist=ODD.getAllInfo();
	private JPasswordField PWPasswordField;
	private JPasswordField PWCPasswordField;
	
	public static void main(String[] args){
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateAccountPage frame = new CreateAccountPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CreateAccountPage() throws ClassNotFoundException, SQLException {
		setAutoRequestFocus(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1051, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		IDTextField = new JTextField();
		IDTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=0;
			}
		});
		IDTextField.setForeground(Color.LIGHT_GRAY);
		IDTextField.setText("\uC544\uC774\uB514\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		IDTextField.setToolTipText("\uC544\uC774\uB514\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		
		//힌트표시
		new Hint(IDTextField).hint();
		
		IDTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				ID=IDTextField.getText();

				switch(new IDCheck(ID,memberlist).checkInt()) {
				case 1: IDCheckLabel.setText("아이디를 입력해주세요");
				IDCheckLabel.setForeground(Color.red);
					break;
				case 2: IDCheckLabel.setText("공백은 아이디에 사용 불가능합니다");
				IDCheckLabel.setForeground(Color.red);
					break;
				case 3: IDCheckLabel.setText("아이디는 최대 32자 까지 가능합니다");
				IDCheckLabel.setForeground(Color.red);
					break;
				case 4: IDCheckLabel.setText("중복된 아이디 입니다");
				IDCheckLabel.setForeground(Color.red);
					break;
				case 0: IDCheckLabel.setText("사용 가능한 아이디 입니다");
				IDCheckLabel.setForeground(Color.blue);
					break;
				}
			}
		});
		IDTextField.setBounds(12, 29, 137, 21);
		contentPane.add(IDTextField);
		IDTextField.setColumns(10);
		
		JLabel IDLabel = new JLabel("\uC544\uC774\uB514");
		IDLabel.setBounds(12, 10, 57, 15);
		contentPane.add(IDLabel);
		
		JLabel PWLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		PWLabel.setBounds(12, 60, 57, 15);
		contentPane.add(PWLabel);
		
		PWTextField = new JTextField();
		
		PWTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=1;
			}
		});
		PWTextField.setVisible(false);
		PWTextField.setText("\uBE44\uBC00\uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		
		PWTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				PW=PWTextField.getText();
				switch(new PWCheck(PW).checkInt()) {
				case 1: PWCheckLabel.setText("비밀번호를 입력해주세요");
				PWCheckLabel.setForeground(Color.red);
					break;
				case 2: PWCheckLabel.setText("공백은 비밀번호에 사용 불가능합니다");
				PWCheckLabel.setForeground(Color.red);
					break;
				case 3: PWCheckLabel.setText("비밀번호는 최대 32자 까지 가능합니다");
				PWCheckLabel.setForeground(Color.red);
					break;
				case 0: PWCheckLabel.setText("사용 가능한 비밀번호 입니다");
				PWCheckLabel.setForeground(Color.blue);
					break;
				}
			}
		});

		new Hint(PWTextField).hint();
		PWTextField.setToolTipText("\uBE44\uBC00\uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWTextField.setForeground(Color.LIGHT_GRAY);
		PWTextField.setBounds(12, 85, 159, 21);
		contentPane.add(PWTextField);
		PWTextField.setColumns(10);
		
		JLabel PWConfirmLabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		PWConfirmLabel.setBounds(12, 116, 97, 15);
		contentPane.add(PWConfirmLabel);
		
		PWConfirmTextField = new JTextField();
		PWConfirmTextField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				PWConfirm=PWConfirmTextField.getText();
				if(PW.equals(PWConfirm)) {
					PWCCheckLabel.setText("비밀번호가 일치합니다");
					PWCCheckLabel.setForeground(Color.blue);
				}else {
				PWCCheckLabel.setText("비밀번호가 일치하지 않습니다");
				PWCCheckLabel.setForeground(Color.red);
				}
			}
		});
		PWConfirmTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=2;
			}
		});
		PWConfirmTextField.setVisible(false);
		new Hint(PWConfirmTextField).hint();
		PWConfirmTextField.setToolTipText("\uBE44\uBC00\uBC88\uD638\uB97C \uC7AC\uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWConfirmTextField.setForeground(Color.LIGHT_GRAY);
		PWConfirmTextField.setText("\uBE44\uBC00\uBC88\uD638\uB97C \uC7AC\uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWConfirmTextField.setBounds(12, 141, 159, 21);
		contentPane.add(PWConfirmTextField);
		PWConfirmTextField.setColumns(10);
		
		JLabel NameLabel = new JLabel("\uC774\uB984");
		NameLabel.setBounds(12, 172, 57, 15);
		contentPane.add(NameLabel);
		
		NameTextField = new JTextField();
		NameTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=0;
			}
		});
		NameTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				name=NameTextField.getText();
				switch(new LengthCheck(name).checkInt()) {
				case 1: NameCheckLabel.setText("이름을 입력해주세요");
				NameCheckLabel.setForeground(Color.red);
					break;
				case 2: NameCheckLabel.setText("이름은 최대 32자 까지 가능합니다");
				NameCheckLabel.setForeground(Color.red);
					break;
				case 0: NameCheckLabel.setText("체크 완료");
				NameCheckLabel.setForeground(Color.blue);
				}
			}
		});
		new Hint(NameTextField).hint();
		NameTextField.setToolTipText("\uC774\uB984\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		NameTextField.setForeground(Color.LIGHT_GRAY);
		NameTextField.setText("\uC774\uB984\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		NameTextField.setBounds(12, 197, 137, 21);
		contentPane.add(NameTextField);
		NameTextField.setColumns(10);
		
		JLabel GenderLabel = new JLabel("\uC131\uBCC4");
		GenderLabel.setBounds(12, 228, 57, 15);
		contentPane.add(GenderLabel);
		
		JLabel RRNLabel = new JLabel("\uC0DD\uB144\uC6D4\uC77C(8\uC790\uB9AC\uB85C \uC785\uB825\uD574\uC8FC\uC138\uC694)");
		RRNLabel.setBounds(12, 284, 188, 15);
		contentPane.add(RRNLabel);
		
		RRNTextField = new JTextField();
		RRNTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=0;
			}
		});
		RRNTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				RRNS=RRNTextField.getText();
				switch(new RrnCheck(RRNS).checkInt()) {
				case 1: RRNCheckLabel.setText("생년월일이 8자리가 아닙니다");
				RRNCheckLabel.setForeground(Color.red);
					break;
				case 2: RRNCheckLabel.setText("잘못된 생년월일입니다");
				RRNCheckLabel.setForeground(Color.red);
					break;

				case 0: RRNCheckLabel.setText("체크 완료");
				RRNCheckLabel.setForeground(Color.blue);
					break;
				}
			}
		});
		new Hint(RRNTextField).hint();
		RRNTextField.setToolTipText("\uC608\uC2DC : 19990101");
		RRNTextField.setForeground(Color.LIGHT_GRAY);
		RRNTextField.setText("\uC608\uC2DC : 19990101");
		RRNTextField.setBounds(12, 309, 116, 21);
		contentPane.add(RRNTextField);
		RRNTextField.setColumns(10);
		
		JRadioButton MaleRadioButton = new JRadioButton("\uB0A8");
		MaleRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(MaleRadioButton.isSelected()) {
					gender="남";
				}
			}
		});

		buttonGroupGender.add(MaleRadioButton);
		MaleRadioButton.setBounds(7, 249, 37, 23);
		contentPane.add(MaleRadioButton);
		
		JRadioButton FemaleRadioButton = new JRadioButton("\uC5EC");
		FemaleRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(FemaleRadioButton.isSelected()) {
					gender="여";
				}
			}
		});
		buttonGroupGender.add(FemaleRadioButton);
		FemaleRadioButton.setBounds(48, 249, 37, 23);
		contentPane.add(FemaleRadioButton);
		
		JLabel JobLabel = new JLabel("\uC9C1\uC5C5");
		JobLabel.setBounds(478, 10, 57, 15);
		contentPane.add(JobLabel);
		
		JobTextField = new JTextField();
		JobTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=0;
			}
		});
		JobTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				job=JobTextField.getText();
				switch(new LengthCheck(job).checkInt()) {
				case 1: jobCheckLabel.setText("직업을 입력해주세요");
				jobCheckLabel.setForeground(Color.red);
					break;
				case 2: jobCheckLabel.setText("직업은 최대 32자 까지 가능합니다");
				jobCheckLabel.setForeground(Color.red);
					break;
				case 0: jobCheckLabel.setText("체크 완료");
				jobCheckLabel.setForeground(Color.blue);
				}
			}
		});
		new Hint(JobTextField).hint();
		JobTextField.setToolTipText("\uC9C1\uC5C5\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		JobTextField.setForeground(Color.LIGHT_GRAY);
		JobTextField.setText("\uC9C1\uC5C5\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		JobTextField.setBounds(478, 29, 137, 21);
		contentPane.add(JobTextField);
		JobTextField.setColumns(10);
		
		JLabel PropLabel = new JLabel("\uC7AC\uC0B0 (\uB2E8\uC704 : \uC6D0)");
		PropLabel.setBounds(478, 60, 97, 15);
		contentPane.add(PropLabel);
		
		PropTextField = new JTextField();
		PropTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=0;
			}
		});
		PropTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				propS=PropTextField.getText();
				switch(new PropCheck(propS).checkInt()) {
				case 1: propCheckLabel.setText("재산은 숫자만 입력이 가능합니다");
				propCheckLabel.setForeground(Color.red);
					break;
				
				case 0: propCheckLabel.setText("체크 완료");
				propCheckLabel.setForeground(Color.blue);
				}
			}
		});
		new Hint(PropTextField).hint();
		PropTextField.setToolTipText("\uC7AC\uC0B0\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PropTextField.setForeground(Color.LIGHT_GRAY);
		PropTextField.setText("\uC7AC\uC0B0\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PropTextField.setBounds(478, 85, 137, 21);
		contentPane.add(PropTextField);
		PropTextField.setColumns(10);
		
		JLabel TelLabel = new JLabel("\uC804\uD654\uBC88\uD638('\uD558\uC774\uD508(-)'\uC744 \uD3EC\uD568\uD55C 13\uC790\uB9AC\uB85C \uC785\uB825\uD574\uC8FC\uC138\uC694)");
		TelLabel.setBounds(478, 116, 329, 15);
		contentPane.add(TelLabel);
		
		TelTextField = new JTextField();
		TelTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=0;
			}
		});
		TelTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				tel=TelTextField.getText();
				switch(new TelCheck(tel).checkInt()) {
				case 1: telCheckLabel.setText("전화번호 형식이 알맞지 않습니다");
				telCheckLabel.setForeground(Color.red);
				telCheckLabel2.setText("'하이픈(-)'을 포함한 13자리로 작성해주세요");
				telCheckLabel2.setForeground(Color.red);
					break;
				
				case 0: telCheckLabel.setText("체크 완료");
				telCheckLabel.setForeground(Color.blue);
				telCheckLabel2.setText("");
				}
			}
		});
		new Hint(TelTextField).hint();
		TelTextField.setToolTipText("\uC608\uC2DC : 010-1234-5678");
		TelTextField.setForeground(Color.LIGHT_GRAY);
		TelTextField.setText("\uC608\uC2DC : 010-1234-5678");
		TelTextField.setBounds(478, 141, 137, 21);
		contentPane.add(TelTextField);
		TelTextField.setColumns(10);
		
		JLabel PWQLabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uBD84\uC2E4\uC2DC \uC9C8\uBB38");
		PWQLabel.setBounds(478, 228, 137, 15);
		contentPane.add(PWQLabel);
		
		PWQTextField = new JTextField();
		PWQTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=0;
			}
		});
		PWQTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				PWQ=PWQTextField.getText();
				switch(new LengthCheck(PWQ).checkInt()) {
				case 1: PWQCheckLabel.setText("질문을 입력해주세요");
				PWQCheckLabel.setForeground(Color.red);
					break;
				case 2: PWQCheckLabel.setText("질문은 최대 32자 까지 가능합니다");
				PWQCheckLabel.setForeground(Color.red);
					break;
				case 0: PWQCheckLabel.setText("체크 완료");
				PWQCheckLabel.setForeground(Color.blue);
				}
			}
		});
		new Hint(PWQTextField).hint();
		PWQTextField.setToolTipText("\uC9C8\uBB38\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWQTextField.setForeground(Color.LIGHT_GRAY);
		PWQTextField.setText("\uC9C8\uBB38\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWQTextField.setBounds(478, 250, 292, 21);
		contentPane.add(PWQTextField);
		PWQTextField.setColumns(10);
		
		JLabel PWALabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uBD84\uC2E4 \uC9C8\uBB38\uC5D0 \uB300\uD55C \uB2F5");
		PWALabel.setBounds(478, 284, 180, 15);
		contentPane.add(PWALabel);
		
		PWATextField = new JTextField();
		PWATextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=0;
			}
		});
		PWATextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				PWA=PWATextField.getText();
				switch(new LengthCheck(PWA).checkInt()) {
				case 1: PWACheckLabel.setText("답을 입력해주세요");
				PWACheckLabel.setForeground(Color.red);
					break;
				case 2: PWACheckLabel.setText("답은 최대 32자 까지 가능합니다");
				PWACheckLabel.setForeground(Color.red);
					break;
				case 0: PWACheckLabel.setText("체크 완료");
				PWACheckLabel.setForeground(Color.blue);
				}
			}
		});
		new Hint(PWATextField).hint();
		PWATextField.setToolTipText("\uB2F5\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWATextField.setForeground(Color.LIGHT_GRAY);
		PWATextField.setText("\uB2F5\uC744 \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWATextField.setBounds(478, 309, 292, 21);
		contentPane.add(PWATextField);
		PWATextField.setColumns(10);
		
		JLabel PWAConfirmLabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uBD84\uC2E4 \uC9C8\uBB38\uC5D0 \uB300\uD55C \uB2F5 \uD655\uC778");
		PWAConfirmLabel.setBounds(478, 340, 205, 15);
		contentPane.add(PWAConfirmLabel);
		
		PWAConfirmTextField = new JTextField();
		PWAConfirmTextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=0;
			}
		});
		PWAConfirmTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				PWAConfirm=PWAConfirmTextField.getText();
				if(PWAConfirm.equals(PWA)) {
					PWACCheckLabel.setText("체크 완료");
					PWACCheckLabel.setForeground(Color.blue);}
				else {
					PWACCheckLabel.setText("답이 일치하지 않습니다");
					PWACCheckLabel.setForeground(Color.red);
				}
			}
		});
		new Hint(PWAConfirmTextField).hint();
		PWAConfirmTextField.setToolTipText("\uB2F5\uC744 \uC7AC\uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWAConfirmTextField.setForeground(Color.LIGHT_GRAY);
		PWAConfirmTextField.setText("\uB2F5\uC744 \uC7AC\uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWAConfirmTextField.setBounds(478, 365, 292, 21);
		contentPane.add(PWAConfirmTextField);
		PWAConfirmTextField.setColumns(10);
		
		JButton createAccountBtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		createAccountBtn.addMouseListener(new MouseAdapter() {
			ArrayList<OpenDoorVO> memberlist=ODD.getAllInfo();
			public void mouseClicked(MouseEvent e) {
				
				if(PW==null||PWConfirm==null||PWA==null||PWAConfirm==null) {
					JOptionPane.showMessageDialog(null, "입력하지 않은 정보가 있습니다"
							+"\n다시 확인해주세요");
					return;
				}
				else if(!(PW.equals(PWConfirm))) {
					JOptionPane.showMessageDialog(null, "'비밀번호'와 '비밀번호 확인'이 일치하지 않습니다"
							+"\n다시 확인해주세요");
					return;
				}else if(!(PWA.equals(PWAConfirm))) {
					JOptionPane.showMessageDialog(null, "'비밀번호 분실 질문에 대한 답'과\n'비밀번호 분실 질문에 대한 답 확인'이 일치하지 않습니다"
							+"\n다시 확인해주세요");
					return;
				}
				
				//id입력
				if(new IDCheck(ID,memberlist).check()
						||new PWCheck(PW).check()
						||new LengthCheck(name).check()
						||new LengthCheck(job).check()
						||new LengthCheck(PWA).check()
						||new LengthCheck(PWQ).check()
						||new GenderCheck(gender).check()
						||new RrnCheck(RRNS).check()
						||new PropCheck(propS).check()
						||new TelCheck(tel).check()) {
					return;
				}

				//회원등록
				boolean createAccount = ODD.insert(ID,PW,name,gender,RRNS,job,propS,tel,face,PWQ,PWA);
				
				if(createAccount) {
					String id = IDTextField.getText();
					String pw = PWTextField.getText();
					JOptionPane.showMessageDialog(null, "회원가입 성공");
					setVisible(false);
					new AfterCreateAccount(id, pw).setVisible(true);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "회원가입 실패");
				}
			}
		});
		createAccountBtn.setBounds(183, 487, 97, 23);
		contentPane.add(createAccountBtn);
		
		JButton cancelButton = new JButton("\uCDE8\uC18C");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Main().setVisible(true);
			}
		});
		cancelButton.setBounds(478, 487, 97, 23);
		contentPane.add(cancelButton);
		
		JToggleButton PasswordToggleButton = new JToggleButton("\uBE44\uBC00\uBC88\uD638 \uD45C\uC2DC");
		PasswordToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PasswordToggleButton.isSelected()) {
					PWTextField.setForeground(Color.black);
					PWConfirmTextField.setForeground(Color.black);
					new Hint(PWTextField).hint();
					new Hint(PWConfirmTextField).hint();
					PWTextField.setVisible(true);
					PWConfirmTextField.setVisible(true);
					if(PWSwitch==1) {
						PWTextField.requestFocus();
					}else if(PWSwitch==2) {
						PWConfirmTextField.requestFocus();
					}
					PW=PWPasswordField.getText();
					PWConfirm=PWCPasswordField.getText();
					PWTextField.setText(PW);
					PWConfirmTextField.setText(PWConfirm);

					PWPasswordField.setVisible(false);
					PWCPasswordField.setVisible(false);
					
				}else if(PasswordToggleButton.isSelected()==false) {
					PWPasswordField.setForeground(Color.black);
					PWCPasswordField.setForeground(Color.black);
					new Hint(PWPasswordField).hint();
					new Hint(PWCPasswordField).hint();
					PWPasswordField.setVisible(true);
					PWCPasswordField.setVisible(true);
					if(PWSwitch==1) {
						PWPasswordField.requestFocus();
					}else if(PWSwitch==2) {
						PWCPasswordField.requestFocus();
					}
					PW=PWTextField.getText();
					PWConfirm=PWConfirmTextField.getText();
					PWPasswordField.setText(PW);
					PWCPasswordField.setText(PWConfirm);
					
					PWTextField.setVisible(false);
					PWConfirmTextField.setVisible(false);
				}
			}
		});
		PasswordToggleButton.setBounds(75, 56, 109, 23);
		contentPane.add(PasswordToggleButton);
		
		PWPasswordField = new JPasswordField();
		PWPasswordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=1;
			}
		});
		PWPasswordField.setToolTipText("\uBE44\uBC00\uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWPasswordField.setBounds(12, 85, 159, 21);
		contentPane.add(PWPasswordField);
		PWPasswordField.setText("\uBE44\uBC00\uBC88\uD638\uB97C \uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWPasswordField.setForeground(Color.LIGHT_GRAY);
		PWPasswordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				PW=PWPasswordField.getText();
				switch(new PWCheck(PW).checkInt()) {
				case 1: PWCheckLabel.setText("비밀번호를 입력해주세요");
				PWCheckLabel.setForeground(Color.red);
					break;
				case 2: PWCheckLabel.setText("공백은 비밀번호에 사용 불가능합니다");
				PWCheckLabel.setForeground(Color.red);
					break;
				case 3: PWCheckLabel.setText("비밀번호는 최대 32자 까지 가능합니다");
				PWCheckLabel.setForeground(Color.red);
					break;
				case 0: PWCheckLabel.setText("사용 가능한 비밀번호 입니다");
				PWCheckLabel.setForeground(Color.blue);
					break;
				}
			}
		});
		new Hint(PWPasswordField).hint();
		
		PWCPasswordField = new JPasswordField();
		PWCPasswordField.setToolTipText("\uBE44\uBC00\uBC88\uD638\uB97C \uC7AC\uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWCPasswordField.setText("\uBE44\uBC00\uBC88\uD638\uB97C \uC7AC\uC785\uB825\uD574\uC8FC\uC138\uC694");
		PWCPasswordField.setBounds(12, 141, 159, 21);
		contentPane.add(PWCPasswordField);
		PWCPasswordField.setForeground(Color.LIGHT_GRAY);
		PWCPasswordField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				PWConfirm=PWCPasswordField.getText();
				if(PW.equals(PWConfirm)) {
					PWCCheckLabel.setText("비밀번호가 일치합니다");
					PWCCheckLabel.setForeground(Color.blue);
				}else {
				PWCCheckLabel.setText("비밀번호가 일치하지 않습니다");
				PWCCheckLabel.setForeground(Color.red);
				}
			}
		});
		PWCPasswordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				PWSwitch=2;
			}

		});
		new Hint(PWCPasswordField).hint();
		
		IDCheckLabel.setBounds(161, 32, 292, 15);
		contentPane.add(IDCheckLabel);
		
		PWCheckLabel.setBounds(183, 88, 270, 15);
		contentPane.add(PWCheckLabel);
		
		PWCCheckLabel.setBounds(183, 144, 270, 15);
		contentPane.add(PWCCheckLabel);
		
		NameCheckLabel.setBounds(161, 200, 292, 15);
		contentPane.add(NameCheckLabel);
		
		RRNCheckLabel.setBounds(140, 312, 313, 15);
		contentPane.add(RRNCheckLabel);
		
		jobCheckLabel.setBounds(627, 32, 396, 15);
		contentPane.add(jobCheckLabel);
		
		propCheckLabel.setBounds(627, 88, 396, 15);
		contentPane.add(propCheckLabel);
		
		telCheckLabel.setBounds(626, 144, 397, 18);
		contentPane.add(telCheckLabel);
		
		telCheckLabel2.setBounds(627, 172, 396, 15);
		contentPane.add(telCheckLabel2);
		
		PWQCheckLabel.setBounds(782, 253, 241, 15);
		contentPane.add(PWQCheckLabel);
		
		PWACheckLabel.setBounds(782, 312, 241, 15);
		contentPane.add(PWACheckLabel);
		
		PWACCheckLabel.setBounds(782, 368, 241, 15);
		contentPane.add(PWACCheckLabel);
	}
}
