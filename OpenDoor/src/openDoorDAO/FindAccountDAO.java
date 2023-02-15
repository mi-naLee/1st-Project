package openDoorDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import openDoorDBCon.*;
import openDoorVo.*;

public class FindAccountDAO {

	private Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public FindAccountDAO() throws ClassNotFoundException, SQLException {
		con = new OpenDoorDBCon().getConnection();
	}
	
	// 아이디 찾기 : param(name, tel) , rtn(id)
	public String getId(String inputName, String inputTel) throws SQLException {
		String id = null;
		String sql = "SELECT ID FROM MEMBER WHERE NAME = ? AND TEL = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, inputName);
		pstmt.setString(2, inputTel);
		rs = pstmt.executeQuery();
		
		if(rs.next()) 
			id = rs.getString(1);
		return id;
	}// getId-end------
	
	// 패스워드 찾기 : param(id) , rtn(ArrayList<OpenDoorVO>)
	// 입력한 id가 있는지 확인하고 All 정보 받기
	public ArrayList<OpenDoorVO> getIdInfo(String searchId) throws SQLException{
		ArrayList<OpenDoorVO> memArray = new ArrayList<OpenDoorVO>();
		String sql = "SELECT * FROM MEMBER WHERE id=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, searchId);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String id = rs.getString("id");
			String pw = rs.getString("pw");
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			Date rrn = rs.getDate("rrn");
			String job = rs.getString("job");
			int prop = rs.getInt("prop");
			String tel = rs.getString("tel");
			String face = rs.getString("face");
			String pwq = rs.getString("pwq");
			String pwa = rs.getString("pwa");
			
			OpenDoorVO mem = new OpenDoorVO(id,pw,name,gender,rrn,job,prop,tel,face,pwq,pwa); 
			memArray.add(mem);
		}
		return memArray;
	}// getIdInfo-end------
	
	// 패스워드 찾기 : param(id) , rtn(pwa)
	// 해당 id의 pw 분실 질문의 답 얻기
	public String getPwa(String inputId) throws SQLException {
		String pwa = null;
		String sql = "SELECT PWA FROM MEMBER WHERE ID = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, inputId);
		rs = pstmt.executeQuery();
		
		if(rs.next())
			pwa = rs.getString(1);
		return pwa;
	}

	// 패스워드 찾기 : param(id) , rtn(pw)
	// 해당 id의 비번을 보여주기
	public String getPw(String findId) throws SQLException {
		String pw = null;
		String sql = "SELECT PW FROM MEMBER WHERE ID = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, findId);
		rs = pstmt.executeQuery();
		
		if(rs.next())
			pw = rs.getString(1);
		return pw;
	}
}
