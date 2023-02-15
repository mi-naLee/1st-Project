package openDoorDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import openDoorDBCon.OpenDoorDBCon;
import openDoorVo.OpenDoorVO;

public class CreateAccountDAO {

	private Connection con;
	PreparedStatement pstmt=null;
	ResultSet rs = null;
	
	public CreateAccountDAO() throws ClassNotFoundException, SQLException {
		con = new OpenDoorDBCon().getConnection();
	}
	
	public ArrayList<OpenDoorVO> getAllInfo() throws SQLException{
		ArrayList<OpenDoorVO> memberList = new ArrayList<OpenDoorVO>();
		String sql = "select * from MEMBER";
		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String ID=rs.getString("id");
			String PW=rs.getString("pw");
			String name=rs.getString("name");
			String gender=rs.getString("gender");
			Date rrn=rs.getDate("rrn");
			String job=rs.getString("job");
			int prop=rs.getInt("prop");
			String tel=rs.getString("tel");
			String face=rs.getString("face");
			String PWQ=rs.getString("pwq");
			String PWA=rs.getString("pwa");
			
			OpenDoorVO ODV = new OpenDoorVO(ID,PW,name,gender,rrn,job,prop,tel,face,PWQ,PWA);
			
			memberList.add(ODV);
		}
		return memberList;
	}
	
	public boolean insert
	(String ID,
	String PW,
	String name,
	String gender,
	String RRNS,
	String job,
	String propS,
	String tel,
	String face,
	String PWQ,
	String PWA) {
		String sql = "insert into MEMBER values(?,?,?,?,to_date(?),?,?,?,?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, ID);
			pstmt.setString(2, PW);
			pstmt.setString(3, name);
			pstmt.setString(4, gender);
			pstmt.setString(5, RRNS);
			pstmt.setString(6, job);
			pstmt.setInt(7, Integer.parseInt(propS));
			pstmt.setString(8, tel);
			pstmt.setString(9, face);
			pstmt.setString(10, PWQ);
			pstmt.setString(11, PWA);
		
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("insert Exception");
			return false;
		}
		return true;
		
	}
}
