package createAccountPage;

import javax.swing.JOptionPane;

public class TelCheck {

	private String tel;

	public TelCheck(String tel) {
		super();
		this.tel = tel;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public boolean check() {

		if(tel.length()!=13) {

			JOptionPane.showMessageDialog(null, "전화번호 형식이 알맞지 않습니다"
					+"'하이픈(-)'을 포함한 13자리로 작성해주세요");
			return true;
			}
		else if(!(tel.substring(3,4).equals("-")&tel.substring(8,9).equals("-"))) {

			JOptionPane.showMessageDialog(null, "전화번호 형식이 알맞지 않습니다"
					+"'하이픈(-)'을 포함한 13자리로 작성해주세요");
			return true;
		}
		
		try{
			Integer.parseInt(tel.substring(0,3));
			Integer.parseInt(tel.substring(4,8));
			Integer.parseInt(tel.substring(9,13));
		}catch(IllegalArgumentException e){

			JOptionPane.showMessageDialog(null, "전화번호 형식이 알맞지 않습니다"
					+"'하이픈(-)'을 포함한 13자리로 작성해주세요");
			return true;
		}
	
		return false;
	}
	
	public int checkInt() {

		if(tel.length()!=13) {
			
			return 1;
			}
		else if(!(tel.substring(3,4).equals("-")&tel.substring(8,9).equals("-"))) {

			return 1;
		}
		try{
			Integer.parseInt(tel.substring(0,3));
			Integer.parseInt(tel.substring(4,8));
			Integer.parseInt(tel.substring(9,13));
		}catch(IllegalArgumentException e){
			return 1;
		}
		return 0;
	}
}
