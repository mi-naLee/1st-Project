package createAccountPage;

import java.sql.Date;

import javax.swing.JOptionPane;

public class RrnCheck {

	private String rrn;
	
	public RrnCheck(String rrn) {
		super();
		this.rrn = rrn;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	public boolean check() {

		if(rrn.length()!=8) {

			JOptionPane.showMessageDialog(null, "생년월일이 8자리가 아닙니다"
					+"\n다시 입력해주세요");
			return true;
			}
		
		String year = rrn.substring(0,4);
		String month = rrn.substring(4,6);
		String day = rrn.substring(6,8);
		String dd=year+"-"+month+"-"+day;
		
		try{
			Date.valueOf(dd);
		}catch(IllegalArgumentException e){

			JOptionPane.showMessageDialog(null, "잘못된 생년월일입니다"
					+"\n다시 입력해주세요");
			return true;
		}
	
		return false;
	}
	
	public int checkInt() {

		if(rrn.length()!=8) {
			
			return 1;
			}
		
		String year = rrn.substring(0,4);
		String month = rrn.substring(4,6);
		String day = rrn.substring(6,8);
		String dd=year+"-"+month+"-"+day;
		
		try{
			Date.valueOf(dd);
		}catch(IllegalArgumentException e){

			
			return 2;
		}
	
		return 0;
	}
}
