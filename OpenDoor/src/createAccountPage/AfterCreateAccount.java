package createAccountPage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginPage.ClientLogin;
import main.Main;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AfterCreateAccount extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterCreateAccount frame = new AfterCreateAccount(null, null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public AfterCreateAccount(String id, String pw) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// 환영인사 Label
		JLabel createAcntLb = new JLabel(id+"님 회원가입이 완료되었습니다");
		createAcntLb.setFont(new Font("굴림", Font.BOLD, 15));
		createAcntLb.setBounds(172, 96, 471, 40);
		contentPane.add(createAcntLb);
		
		// 바로 로그인 Btn
		JButton directLoginBtn = new JButton("\uBC14\uB85C \uB85C\uADF8\uC778");
		directLoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ClientLogin(id, pw).setVisible(true);
			}
		});
		directLoginBtn.setFont(new Font("굴림", Font.BOLD, 15));
		directLoginBtn.setBounds(312, 249, 187, 40);
		contentPane.add(directLoginBtn);
		
		// 메인으로 돌아가기 Btn
		JButton rtnMainBtn = new JButton("\uBA54\uC778\uC73C\uB85C \uC774\uB3D9\uD558\uAE30");
		rtnMainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Main().setVisible(true);
			}
		});
		rtnMainBtn.setFont(new Font("굴림", Font.BOLD, 15));
		rtnMainBtn.setBounds(312, 347, 187, 40);
		contentPane.add(rtnMainBtn);
	}
}
