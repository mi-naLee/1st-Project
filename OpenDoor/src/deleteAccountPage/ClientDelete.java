package deleteAccountPage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginPage.ClientLogin;
import openDoorDAO.DeleteAccountDAO;
import openDoorVo.OpenDoorVO;
import main.Main;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ClientDelete extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientDelete frame = new ClientDelete(null, null);
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
	public ClientDelete(String id, String pw) {//회원 아디삭제
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setText("\uC544\uC774\uB514 \uC785\uB825");
		textField.setBounds(10, 29, 257, 63);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("\uBE44\uBC00\uBC88\uD638 \uC785\uB825");
		textField_1.setBounds(10, 102, 257, 57);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("\uD0C8\uD1F4\uD558\uAE30");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String textValue = textField.getText();
				String textValue2 = textField_1.getText();
				if(textValue.trim().isEmpty()||textValue==null) {
					JOptionPane.showMessageDialog(null, "입력이 필요합니다.");
				}
				else {// 내용이 있을 경우 처리
					try {
						DeleteAccountDAO openDao = new DeleteAccountDAO();
						ArrayList<OpenDoorVO> openArray = openDao.getIdInfo(textValue);
						if(openArray.isEmpty()) {
							JOptionPane.showMessageDialog(null, "아이디나 비밀번호 확인하세요");
						}else {
							
							//삭제
							boolean aa = openDao.delete_ID_PW(textValue,textValue2);
							if(aa) {
							JOptionPane.showMessageDialog(null, textValue+"님 아이디 삭제");
							setVisible(false);// 지금 창 안 보이게
							dispose();
							new AfterClientDelete().setVisible(true);}
							else{JOptionPane.showMessageDialog(null, "아이디나 비밀번호 확인하세요");
							}
						}
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			
			}
		});
		btnNewButton.setBounds(12, 298, 195, 95);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uCDE8\uC18C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);// 지금 창 안 보이게
				new ClientLogin(id, pw).setVisible(true);
			}
		});
		btnNewButton_1.setBounds(290, 301, 211, 88);
		contentPane.add(btnNewButton_1);
	}
}
