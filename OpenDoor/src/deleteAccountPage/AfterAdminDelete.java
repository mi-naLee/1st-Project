package deleteAccountPage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;




import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

import openDoorVo.OpenDoorVO;
import main.Main;

public class AfterAdminDelete extends JFrame {//관리자 삭제 완료

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterAdminDelete frame = new AfterAdminDelete(0,null,null);
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
	public AfterAdminDelete(int check,String id,String pw) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 647);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("\uB2E4\uC2DC \uC0AD\uC81C");
		btnNewButton.setBounds(26, 494, 204, 100);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);// 지금 창 안 보이게
				new AdminDelete(id,pw).setVisible(true);;//
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uBA54\uC778 \uD654\uBA74");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);// 지금 창 안 보이게
				new Main().setVisible(true);
			}
		});
		btnNewButton_1.setBounds(503, 492, 195, 105);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("          "+check+"명 지웠습니다");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		lblNewLabel.setBounds(125, 113, 466, 215);
		contentPane.add(lblNewLabel);
	}
}
