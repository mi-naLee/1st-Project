package openDoorDAO;

import java.sql.Connection;
import java.sql.Date; // DAO는 sql 연결이므로 sql.Date 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import openDoorDBCon.*;
import openDoorVo.*;

public class SelectMemberDAO {

	private Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null; 

	public SelectMemberDAO() throws ClassNotFoundException, SQLException {
		con = new OpenDoorDBCon().getConnection();
	}
	
	// DB 정보를 모두 출력 : param(x) , rtn(ArrayList<OpenDoorVO>)
	public ArrayList<OpenDoorVO> getAllInfo() throws SQLException { // 전체 검색
		ArrayList<OpenDoorVO> memArray = new ArrayList<OpenDoorVO>();
		String sql = "SELECT * FROM MEMBER ORDER BY Id";
		
		pstmt = con.prepareStatement(sql);
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
	}// getAllInfo-end-------
	
	// 이름으로 회원 내용 출력하기 : param(name) , rtn(ArrayList<OpenDoorVO>)
	public ArrayList<OpenDoorVO> getNameInfo(String searchName) throws SQLException{
		ArrayList<OpenDoorVO> memArray = new ArrayList<OpenDoorVO>();
		String sql = "SELECT * FROM MEMBER WHERE name=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, searchName);
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
	}// getNameInfo-end-----
	
	// 전화번호로 회원 내용 출력하기 : param(tel) , rtn(ArrayList<OpenDoorVO>)
	public ArrayList<OpenDoorVO> getTelInfo(String searchTel) throws SQLException{
		
		ArrayList<OpenDoorVO> memArray = new ArrayList<OpenDoorVO>();
		String sql = "SELECT * FROM MEMBER WHERE tel=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, searchTel);
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
	}// getTelInfo-end-----
	
	// 외모 조건으로 회원 출력하기 : param(face) , rtn(ArrayList<OpenDoorVO>)
	public ArrayList<OpenDoorVO> getFaceInfo(String faceGrade) throws SQLException{
		ArrayList<OpenDoorVO> memArray = new ArrayList<OpenDoorVO>();
		String sql = "SELECT * FROM MEMBER WHERE face=?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, faceGrade);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String id = rs.getString("id");
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			String job = rs.getString("job");
			int prop = rs.getInt("prop");
			String face = rs.getString("face");
			
			OpenDoorVO mem = new OpenDoorVO(id,name,gender,job,prop,face); 
			memArray.add(mem);
		}
		return memArray;
	}// getFaceInfo-end-----
	
	// 재산 조건으로 회원 출력하기 : param(face) , rtn(ArrayList<OpenDoorVO>)
	public ArrayList<OpenDoorVO> getPropInfo(int propGrade) throws SQLException{
		ArrayList<OpenDoorVO> memArray = new ArrayList<OpenDoorVO>();
		String sql = "SELECT * FROM MEMBER WHERE prop >= ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, propGrade);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String id = rs.getString("id");
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			String job = rs.getString("job");
			int prop = rs.getInt("prop");
			String face = rs.getString("face");
			
			OpenDoorVO mem = new OpenDoorVO(id,name,gender,job,prop,face); 
			memArray.add(mem);
		}
		return memArray;
	}// getPropInfo-end-----
	
	// Client All 출력 : param(x) , rtn(ArrayList<OpenDoorVO>)
	public ArrayList<OpenDoorVO> getClientAllInfo() throws SQLException{
		ArrayList<OpenDoorVO> memArray = new ArrayList<OpenDoorVO>();
		String sql = "SELECT * FROM MEMBER";
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String id = rs.getString("id");
			String name = rs.getString("name");
			String gender = rs.getString("gender");
			String job = rs.getString("job");
			int prop = rs.getInt("prop");
			String face = rs.getString("face");
			
			OpenDoorVO mem = new OpenDoorVO(id,name,gender,job,prop,face); 
			memArray.add(mem);
		}
		return memArray;
	}
	
	// 아이디로 성별 가져오기
	public String getGender(String id) throws SQLException {
		String gender = null;
		String sql = "SELECT gender FROM MEMBER where id = ?";
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		
		if(rs.next())
			gender = rs.getString(1);
		return gender;
	}
}
