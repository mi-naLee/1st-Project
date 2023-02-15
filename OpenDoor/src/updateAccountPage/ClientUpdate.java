package updateAccountPage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginPage.ClientLogin;
import openDoorDAO.UpdateAccountDAO;
import openDoorVo.OpenDoorVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ClientUpdate extends JFrame {

	private JPanel a111;
	private JTextField pwTex;
	private JTextField pwconfirmTxt;
	private JTextField job;
	private JTextField prop;
	private JTextField tel;
	private JTextField pwq;
	private JTextField pwa;
	private JTextField pwaconfirm;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientUpdate frame = new ClientUpdate(null,null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ClientUpdate(String id, String pw)  {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		a111 = new JPanel();
		a111.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(a111);
		a111.setLayout(null);
		
		// id - Label
		JLabel idLabel = new JLabel("\uC544\uC774\uB514");
		idLabel.setBounds(12, 27, 80, 37);
		a111.add(idLabel);
		
		// password - txt 
		pwTex = new JTextField();
		pwTex.setBounds(12, 74, 143, 37);
		a111.add(pwTex);
		pwTex.setColumns(10);
		
		// passwordConfirm - txt
		pwconfirmTxt = new JTextField();
		pwconfirmTxt.setColumns(10);
		pwconfirmTxt.setBounds(12, 134, 143, 37);
		a111.add(pwconfirmTxt);
		
		// name - Label
		JLabel nameLabel = new JLabel("\uC774\uB984");
		nameLabel.setBounds(12, 205, 80, 37);
		a111.add(nameLabel);
		
		// gender - Label
		JLabel genderbel = new JLabel("\uC131\uBCC4");
		genderbel.setHorizontalAlignment(SwingConstants.CENTER);
		genderbel.setBounds(12, 279, 80, 37);
		a111.add(genderbel);
		
		// rrn(주민번호) - Label
		JLabel rrnLabel = new JLabel("\uC8FC\uBBFC\uBC88\uD638 \uC55E\uC790\uB9AC");
		rrnLabel.setBounds(12, 391, 127, 37);
		a111.add(rrnLabel);
		
		// job - Txt
		job = new JTextField();
		job.setColumns(10);
		job.setBounds(315, 27, 189, 37);
		a111.add(job);
		
		// prop(재산) - txt
		prop = new JTextField();
		prop.setColumns(10);
		prop.setBounds(315, 87, 189, 37);
		a111.add(prop);
		
		// tel - txt
		tel = new JTextField();
		tel.setColumns(10);
		tel.setBounds(315, 148, 189, 37);
		a111.add(tel);
		
		// pwq - txt
		pwq = new JTextField();
		pwq.setColumns(10);
		pwq.setBounds(315, 266, 189, 37);
		a111.add(pwq);
		
		// pwa - txt
		pwa = new JTextField();
		pwa.setColumns(10);
		pwa.setBounds(315, 328, 189, 37);
		a111.add(pwa);
		
		// pwaConfirm - txt
		pwaconfirm = new JTextField();
		pwaconfirm.setColumns(10);
		pwaconfirm.setBounds(315, 391, 189, 37);
		a111.add(pwaconfirm);
		
		// 기타 직업~비밀번호 분실 답 라벨까지 -------------------------------
		JLabel jobbelLabel = new JLabel("\uC9C1\uC5C5");
		jobbelLabel.setBounds(516, 27, 80, 37);
		a111.add(jobbelLabel);
		
		JLabel propbelLabel = new JLabel("\uC7AC\uC0B0");
		propbelLabel.setBounds(516, 85, 80, 37);
		a111.add(propbelLabel);
		
		JLabel telbelLabel = new JLabel("\uC804\uD654\uBC88\uD638");
		telbelLabel.setBounds(516, 148, 80, 37);
		a111.add(telbelLabel);
		
		JLabel pwqbelLAbel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30 \uC9C8\uBB38");
		pwqbelLAbel.setBounds(516, 266, 116, 37);
		a111.add(pwqbelLAbel);
		
		JLabel pwableLAbel = new JLabel("\uC9C8\uBB38 \uB2F5");
		pwableLAbel.setBounds(516, 328, 80, 37);
		a111.add(pwableLAbel);
		
		JLabel pwaconfirmbelLAbel = new JLabel("\uC9C8\uBB38\uB2F5 \uC7AC\uD655\uC778");
		pwaconfirmbelLAbel.setBounds(516, 391, 80, 37);
		a111.add(pwaconfirmbelLAbel);
		//-------------------------------기타 직업~비밀번호 분실 답 라벨까지-end
		
		try {
			UpdateAccountDAO memDAO = new UpdateAccountDAO();
			ArrayList<OpenDoorVO> memVO = memDAO.lolidpw(id, pw);  
			idLabel.setText(memVO.get(0).getId());
			pwTex.setText(memVO.get(0).getPw());
			nameLabel.setText(memVO.get(0).getName());
			genderbel.setText(memVO.get(0).getGender());
			
			StringBuilder builder = new StringBuilder();
			builder.append(memVO.get(0).getRrn().toString());
			
			// String rrn1 = memVO.get(0).toString();
			rrnLabel.setText(builder.toString());
			job.setText(memVO.get(0).getJob());
			
			StringBuilder builder2 = new StringBuilder();
			builder2.append(memVO.get(0).getProp());
			//String prop1 = memVO.get(0).toString();
			prop.setText(builder2.toString());
			tel.setText(memVO.get(0).getTel());
			pwq.setText(memVO.get(0).getPwq());
			pwa.setText(memVO.get(0).getPwa());
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JButton ok = new JButton("\uD68C\uC6D0\uC815\uBCF4\uBCC0\uACBD");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String newPw = pwTex.getText();
				String PwConfirm = pwconfirmTxt.getText();
				String newJob = job.getText();
				String newPropstr = prop.getText();
				int newProp = Integer.parseInt(prop.getText());
				String newTel = tel.getText();
				String newPwq = pwq.getText();
				String newPwa = pwa.getText();
				String PwaConfirm = pwaconfirm.getText();
				if(!(newPw.equals(PwConfirm))){
					JOptionPane.showMessageDialog
					(null,"'비밀번호가 일치하지 않습니다.");
				}else if(!(newPw.equals(PwConfirm))) {
					JOptionPane.showMessageDialog
					(null,"질문의 답이 일치하지 않습니다.");

				}else if(newPw.trim().isEmpty() || PwConfirm.trim().isEmpty() || newJob.trim().isEmpty()
						|| newPropstr.trim().isEmpty() || newTel.trim().isEmpty()
						|| newPwa.trim().isEmpty() || newPwa.trim().isEmpty() || PwaConfirm.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null,"빈칸을 입력하세요");
				}else {
					try {
						UpdateAccountDAO upDao = new UpdateAccountDAO();
						upDao.updatePw(id, newPw);
						upDao.updateJob(id, newJob);
						upDao.updateProp(id, newProp);
						upDao.updateTel(id, newTel);
						upDao.updatePwq(id, newPwq);
						upDao.updatePwa(id, newPwa);
						JOptionPane.showMessageDialog(null, "변경이 완료되었습니다.");
						setVisible(false);
						new AfterClientUpdate(id, newPw).setVisible(true);
					
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				}
			});
		ok.setBounds(112, 474, 151, 57);
		a111.add(ok);
		
		JButton end = new JButton("\uCDE8\uC18C");
		end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ClientLogin(id, pw).setVisible(true);	
			}
		});
		end.setBounds(334, 474, 151, 57);
		a111.add(end);
		
		JLabel pwbel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pwbel.setBounds(165, 74, 80, 37);
		a111.add(pwbel);
		
		JLabel pwqabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		pwqabel.setBounds(167, 134, 80, 37);
		a111.add(pwqabel);
		
	}
}
