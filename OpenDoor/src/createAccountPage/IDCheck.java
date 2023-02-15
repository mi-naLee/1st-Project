package createAccountPage;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import openDoorVo.OpenDoorVO;

public class IDCheck {

	private String id;
	
	private ArrayList<OpenDoorVO> memberlist;

	public IDCheck(String id, ArrayList<OpenDoorVO> memberlist) {
		super();
		this.id = id;
		this.memberlist = memberlist;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<OpenDoorVO> getMemberlist() {
		return memberlist;
	}

	public void setMemberlist(ArrayList<OpenDoorVO> memberlist) {
		this.memberlist = memberlist;
	}

	public boolean check() {

		if(id==null||id.length()==0) {
			JOptionPane.showMessageDialog(null, "아이디를 입력해주세요");
			return true;
		}else if(!(id.equals(id.replace(" ", "")))) {
			JOptionPane.showMessageDialog(null, "공백은 아이디에 사용 불가능합니다"
					+"\n다시 입력해주세요");
			return true;
		}else if(id.length()>32){
			JOptionPane.showMessageDialog(null, "아이디는 최대 32자 까지 가능합니다"
				+"\n다시 입력해주세요");
			return true;
		}else {
			for(OpenDoorVO ODV : memberlist) {
			if(id.equals(ODV.getId())) {

				JOptionPane.showMessageDialog(null, "중복된 아이디 입니다"
						+"\n다시 입력해주세요");
				return true;
			}
		}}
			
		return false;						
	}
	
	public int checkInt() {

		if(id==null||id.length()==0) {
			
			return 1;
		}else if(!(id.equals(id.replace(" ", "")))) {
			
			return 2;
		}else if(id.length()>32){
			
			return 3;
		}else {
			for(OpenDoorVO ODV : memberlist) {
			if(id.equals(ODV.getId())) {
				return 4;
			}
		}}
		return 0;						
	}

}
	


