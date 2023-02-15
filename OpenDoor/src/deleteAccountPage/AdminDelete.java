package deleteAccountPage;

import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import loginPage.AdminLogin;
import openDoorVo.OpenDoorVO;
import main.Main;
import openDoorDAO.DeleteAccountDAO;
public class AdminDelete extends JFrame {//관리자 삭제

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDelete frame = new AdminDelete(null, null);
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
	public AdminDelete(String id, String pw) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 488);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(26, 75, 213, 68);
		textField.setText("\uC544\uC774\uB514 \uC785\uB825");
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("\uC0AD\uC81C");
		btnNewButton_2.setBounds(408, 40, 206, 136);
		btnNewButton_2.addActionListener(new ActionListener() {
			private GraphicsConfiguration result;

			public void actionPerformed(ActionEvent e) {
				
				String textValue = textField.getText();
				
				if(textValue.trim().isEmpty()||textValue==null) {
					JOptionPane.showMessageDialog(null, "입력이 필요합니다.");
				}
				else {// 내용이 있을 경우 처리
					try {
						DeleteAccountDAO openDao = new DeleteAccountDAO();
						ArrayList<OpenDoorVO> openArray = openDao.getIdInfo(textValue);
						if(openArray.isEmpty()) {
							JOptionPane.showMessageDialog(null, "아이디를 확인하세요");
						}else {
							boolean check = openDao.delete_ID(textValue);//삭제
							int result = 0;
							if(check) {
								result = 1;
							}
							JOptionPane.showMessageDialog(null, textValue+"님 아이디 삭제");
							setVisible(false);// 지금 창 안 보이게
							new AfterAdminDelete(result,id,pw).setVisible(true);// adel2로 이동
						}
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			}		
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\uCDE8\uC18C");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);// 지금 창 안 보이게
				dispose();
				new AdminLogin(id, pw).setVisible(true);
			}
		});
		btnNewButton_3.setBounds(401, 312, 213, 127);
		contentPane.add(btnNewButton_3);
		
	}
}
