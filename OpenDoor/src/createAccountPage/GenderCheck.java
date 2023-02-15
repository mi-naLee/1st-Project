package createAccountPage;

import javax.swing.JOptionPane;

public class GenderCheck {

	private String gender;
	
	public GenderCheck(String gender) {
		super();
		this.gender = gender;
	}

	public String getGenderN() {
		return gender;
	}

	public void setGenderN(String gender) {
		this.gender = gender;
	}

	public boolean check() {
		if(gender.equals("남")) {
			return false;
		}else if(gender.equals("여")) {
			return false;
		}
		
		JOptionPane.showMessageDialog(null, "성별이 잘못되었습니다"
				+"\n다시 선택해주세요");
		return true;
	}
}
