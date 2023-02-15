package openDoorDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.directory.SearchControls;

import openDoorDBCon.*;
import openDoorVo.*;



public class UpdateAccountDAO {
	
	private Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	public UpdateAccountDAO() throws ClassNotFoundException, SQLException {
		con = new OpenDoorDBCon().getConnection();
	}

	// 원래의 회원 정보를 받기 위한 조회
	public ArrayList<OpenDoorVO> lolidpw(String id,String pw) throws SQLException{
		ArrayList<OpenDoorVO> openArray = new ArrayList<OpenDoorVO>();
		String sql = "select * from member where  id = ? and pw = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,id);
		pstmt.setString(2,pw);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String id1 = rs.getString("id");		
			String pw1 = rs.getString("pw");
			String name = rs.getString("name");	
			String gender =rs.getString("gender");
			Date rrn = rs.getDate("rrn");
			String job = rs.getString("job");
			int prop = rs.getInt("prop");
			String tel = rs.getString("tel");
			String pwq = rs.getString("pwq");
			String pwa = rs.getString("pwa");
			
			OpenDoorVO open = new OpenDoorVO(id1,pw1,name,gender,rrn,job,prop,tel,pwq,pwa);
			openArray.add(open);
			
			System.out.println(open);
			
		}
		return openArray;
	}
	
	// 패스워드 변경하기
	public void updatePw(String id, String newPw) throws SQLException {
		
		String sql = "UPDATE MEMBER SET pw = ? WHERE id = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, newPw);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
		
	}

	// job 변경하기
	public void updateJob(String id, String newJob) throws SQLException {
		
		String sql = "UPDATE MEMBER SET job = ? WHERE id = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, newJob);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
		
	}

	// 재산 변경하기
	public void updateProp(String id, int newProp) throws SQLException {
		
		String sql = "UPDATE MEMBER SET prop = ? WHERE id = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, newProp);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
		
	}

	// 연락처 변경하기
	public void updateTel(String id, String newTel) throws SQLException {
		
		String sql = "UPDATE MEMBER SET tel = ? WHERE id = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, newTel);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
		
	}

	// 패스워드 분실 질문 변경하기
	public void updatePwq(String id, String newPwq) throws SQLException {
		
		String sql = "UPDATE MEMBER SET pwq = ? WHERE id = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, newPwq);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
		
	}

	// 패스워드 답 변경하기
	public void updatePwa(String id, String newPwa) throws SQLException {
		
		String sql = "UPDATE MEMBER SET pwa = ? WHERE id = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, newPwa);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
	
	}
	
	// admin - 이름 변경하기
	public void updateName(String id, String inputName) throws SQLException {
		
		String sql = "UPDATE MEMBER SET name = ? WHERE id = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, inputName);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
	
	}
	
	// admin - 성별 변경하기
	public void updateGender(String id, String inputGender) throws SQLException {
		
		String sql = "UPDATE MEMBER SET gender = ? WHERE id = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, inputGender);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
	
	}
	
	// admin - 주민번호 변경하기
	public void updateRrn(String id, String inputRrn) throws SQLException {
		
		String sql = "UPDATE MEMBER SET rrn = to_date(?) WHERE id = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, inputRrn);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
	
	}
	
	// admin - 성별 변경하기
	public void updateFace(String id, String inputFace) throws SQLException {
		
		String sql = "UPDATE MEMBER SET face = ? WHERE id = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, inputFace);
		pstmt.setString(2, id);
		pstmt.executeUpdate();
	
	}
	
}
	
	
	
