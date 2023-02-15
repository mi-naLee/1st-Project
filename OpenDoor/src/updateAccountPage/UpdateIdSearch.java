package updateAccountPage;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import loginPage.AdminLogin;
import openDoorDAO.FindAccountDAO;
import openDoorVo.OpenDoorVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

// ********************** Admin 계정이 회원 수정시 id로 수정할 회원을 찾기 위한 Page
public class UpdateIdSearch extends JFrame {

	private JPanel contentPane;
	private JTextField idTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateIdSearch frame = new UpdateIdSearch(null, null);
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
	public UpdateIdSearch(String id, String pw) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// 아이디 Label
		JLabel idLb = new JLabel("\uD68C\uC6D0\uC758 \uC544\uC774\uB514 \uC785\uB825");
		idLb.setFont(new Font("굴림", Font.BOLD, 17));
		idLb.setBounds(246, 157, 203, 57);
		contentPane.add(idLb);
		
		// 아이디 입력받을 Txt
		idTxt = new JTextField();
		idTxt.setBounds(246, 215, 203, 57);
		contentPane.add(idTxt);
		idTxt.setColumns(10);
		
		// 아이디 검색 Btn 클릭시 결과 표시 Label
		JLabel infoLb = new JLabel("");
		infoLb.setFont(new Font("굴림", Font.ITALIC, 15));
		infoLb.setBounds(221, 295, 256, 48);
		contentPane.add(infoLb);
		
		// 해당 아이디의 회원 수정 Btn
		JButton updateBtn = new JButton("\uD68C\uC6D0 \uC218\uC815\uD558\uAE30");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inputId = idTxt.getText();
				if(inputId.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "수정할 회원의 아이디를 입력해 주세요.");
				}else {
					try {// findDAO에 id로 모든 정보를 받는 method가 존재하므로 해당 DAO를 사용
						FindAccountDAO findDao = new FindAccountDAO(); 
						ArrayList<OpenDoorVO> arr = findDao.getIdInfo(inputId);
						if(arr.isEmpty()) {
							JOptionPane.showMessageDialog(null, "해당 아이디가 존재하지 않습니다.");
						}else {
							setVisible(false);
							new AdminUpdate(arr, id, pw).setVisible(true);
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
					
				}
			}
		});
		updateBtn.setFont(new Font("굴림", Font.BOLD, 15));
		updateBtn.setBounds(274, 361, 154, 48);
		contentPane.add(updateBtn);
		
		// 되돌아가기 Btn
		JButton rtnBtn = new JButton("\uB418\uB3CC\uC544\uAC00\uAE30");
		rtnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new AdminLogin(id, pw).setVisible(true);
			}
		});
		rtnBtn.setFont(new Font("굴림", Font.BOLD, 15));
		rtnBtn.setBounds(274, 445, 154, 48);
		contentPane.add(rtnBtn);
	}
}
