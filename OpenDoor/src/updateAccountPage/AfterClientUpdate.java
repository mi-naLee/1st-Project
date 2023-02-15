package updateAccountPage;

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

public class AfterClientUpdate extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterClientUpdate frame = new AfterClientUpdate(null, null);
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
	public AfterClientUpdate(String id, String pw) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// 변경 완료 문구 Label
		JLabel okInfoLb = new JLabel("\uBCC0\uACBD\uC774 \uC644\uB8CC\uB418\uC5C8\uC2B5\uB2C8\uB2E4.");
		okInfoLb.setFont(new Font("굴림", Font.BOLD, 20));
		okInfoLb.setBounds(251, 117, 222, 48);
		contentPane.add(okInfoLb);
		
		// 로그인 페이지로 이동 Btn
		JButton rtnBtn = new JButton("\uB85C\uADF8\uC778 \uD398\uC774\uC9C0");
		rtnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new ClientLogin(id, pw).setVisible(true);
			}
		});
		rtnBtn.setFont(new Font("굴림", Font.BOLD, 15));
		rtnBtn.setBounds(289, 300, 133, 48);
		contentPane.add(rtnBtn);
		
		// 메인으로 이동 Btn
		JButton mainBtn = new JButton("\uBA54\uC778 \uD398\uC774\uC9C0");
		mainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Main().setVisible(true);
			}
		});
		mainBtn.setFont(new Font("굴림", Font.BOLD, 15));
		mainBtn.setBounds(289, 405, 133, 48);
		contentPane.add(mainBtn);
	}
}
