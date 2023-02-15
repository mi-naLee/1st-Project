package findAccountPage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Main;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AfterFindID extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterFindID frame = new AfterFindID(null);
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
	public AfterFindID(String id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 756, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// 안내문구 출력 Label
		JLabel infoLb = new JLabel("고객님의 아이디는 "+id+"입니다.");
		infoLb.setFont(new Font("굴림", Font.BOLD, 18));
		infoLb.setBounds(149, 105, 401, 56);
		contentPane.add(infoLb);
		
		// 로그인 화면으로 돌아가기
		JButton loginPageBtn = new JButton("\uB85C\uADF8\uC778 \uD654\uBA74\uC73C\uB85C \uB3CC\uC544\uAC00\uAE30");
		loginPageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Main().setVisible(true);
			}
		});
		loginPageBtn.setFont(new Font("굴림", Font.BOLD, 20));
		loginPageBtn.setBounds(149, 234, 401, 56);
		contentPane.add(loginPageBtn);
		
	}
}
