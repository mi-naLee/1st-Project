package createAccountPage;

import javax.swing.JOptionPane;

public class PropCheck {

	String propS;

	public PropCheck(String propS) {
		super();
		this.propS = propS;
	}

	public String getPropS() {
		return propS;
	}

	public void setPropS(String propS) {
		this.propS = propS;
	}
	
	public boolean check() {
		try {
			Integer.parseInt(propS);
		}catch(NumberFormatException e){
		
			JOptionPane.showMessageDialog(null, "����� ���ڸ� �Է����ּ���");
			return true;
		}
		return false;
	}
	
	public int checkInt() {
		try {
			Integer.parseInt(propS);
		}catch(NumberFormatException e){
		
			return 1;
		}
		return 0;
	}
}
