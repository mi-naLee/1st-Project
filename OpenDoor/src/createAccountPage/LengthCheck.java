package createAccountPage;

import javax.swing.JOptionPane;

public class LengthCheck {

	private String str;
	
	public LengthCheck(String str) {
		super();
		this.str = str;
	}

	public String getName() {
		return str;
	}

	public void setName(String str) {
		this.str = str;
	}

	public boolean check() {
		if(str==null||str.length()==0) {
			JOptionPane.showMessageDialog(null, "입력하지 않은 정보가 있습니다");
			return true;
		}else if(str.replace(" ", "").length()==0) {
			JOptionPane.showMessageDialog(null, "입력하지 않은 정보가 있습니다");
			return true;
		}
		else if(str.length()>32) {

			JOptionPane.showMessageDialog(null, "최대 32자까지 입력 가능합니다"
					+"\n다시 입력해주세요");
			return true;
		}
		return false;
	}
	
	public int checkInt() {
		if(str==null||str.length()==0) {
			return 1;
		}else if(str.replace(" ", "").length()==0) {
			return 1;
		}
		else if(str.length()>32) {
			return 2;
		}
		return 0;
	}
	
	
}
