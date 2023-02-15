package createAccountPage;

import javax.swing.JOptionPane;

public class PWCheck {

	String pw;

	public PWCheck(String pw) {
		super();
		this.pw = pw;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public boolean check() {
		if(pw==null||pw.length()==0) {
			JOptionPane.showMessageDialog(null, "비밀번호를 입력해주세요");
			return true;
		}else if(!(pw.equals(pw.replace(" ", "")))) {
			JOptionPane.showMessageDialog(null, "공백은 비밀번호에 사용 불가능합니다"
					+"\n다시 입력해주세요");
			return true;
		}else if(pw.length()>32){
			JOptionPane.showMessageDialog(null, "비밀번호는 최대 32자 까지 가능합니다"
				+"\n다시 입력해주세요");
			return true;
		}
		return false;
	}
	
	public int checkInt() {
		if(pw==null||pw.length()==0) {
			
			return 1;
		}else if(!(pw.equals(pw.replace(" ", "")))) {
			
					
			return 2;
		}else if(pw.length()>32){
			
			return 3;
		}
		return 0;
	}
}
