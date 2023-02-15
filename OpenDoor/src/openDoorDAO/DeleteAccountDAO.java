package openDoorDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import openDoorDBCon.OpenDoorDBCon;
import openDoorVo.OpenDoorVO;

public class DeleteAccountDAO {
	
	private Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null; //전역
	
		public DeleteAccountDAO() throws ClassNotFoundException, SQLException {
			con = new OpenDoorDBCon().getConnection();
		}
		
		public ArrayList<OpenDoorVO> getAllInof() throws SQLException{
			
			ArrayList<OpenDoorVO> openArray = new ArrayList<OpenDoorVO>();
			String sql = "SELECT * FROM MEMBER ORDER BY ID";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String ID = rs.getString("ID");
				String PW = rs.getString("PW");
				String NAME = rs.getString("NAME");
				String GENDER = rs.getString("GENDER");
				Date RRN = rs.getDate("RRN");
				String JOB = rs.getString("JOB");
				int PROP = rs.getInt("PROP");
				String TEL  = rs.getString("TEL");
				String FACE = rs.getString("FACE");
				String PWQ = rs.getString("PWQ");
				String PWA = rs.getString("PWA");
				
				OpenDoorVO vo = new OpenDoorVO(ID,PW,NAME,GENDER,RRN,JOB,PROP,TEL,FACE,PWQ,PWA);
				
				//VO객체에 넣기
				openArray.add(vo); //VO객체 -> collection에 넣기
			}
			return openArray;
		}
		
		public ArrayList<OpenDoorVO> getIdInfo(String searchId) throws SQLException{
			ArrayList<OpenDoorVO> openArray = new ArrayList<OpenDoorVO>();
			String sql = "SELECT * FROM MEMBER WHERE id=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, searchId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("ID");
				String pw = rs.getString("PW");
				String name = rs.getString("NAME");
				String gender = rs.getString("GENDER");
				Date rrn = rs.getDate("RRN");
				String job = rs.getString("JOB");
				int prop = rs.getInt("PROP");
				String tel = rs.getString("TEL");
				String face = rs.getString("FACE");
				String pwq = rs.getString("PWQ");
				String pwa = rs.getString("PWA");
				
				OpenDoorVO vo = new OpenDoorVO(id,pw,name,gender,rrn,job,prop,tel,face,pwq,pwa); 
				openArray.add(vo);
			}
			return openArray;
		}
		
		public boolean delete_ID(String delid) {
			
			String sql = "delete"
					+ " from MEMBER"
					+ " where ID = ?";
			try {
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, delid);
				
				pstmt.executeUpdate();
				
				pstmt.executeUpdate();
		        return true;
			} catch (SQLException e) {
				System.out.println("delete Exeption");
			}
			return false;
		}

public boolean delete_ID_PW(String delid,String delpw) {
	
	String sql = "delete"
			+ " from MEMBER"
			+ " where ID = ? and pw = ?";
	try {
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1, delid);
		pstmt.setString(2, delpw);
		pstmt.executeUpdate();
		
		pstmt.executeUpdate();
        return true;
	} catch (SQLException e) {
		System.out.println("delete Exeption");
	}
	return false;
}
		
}
