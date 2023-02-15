package openDoorVo;

import java.util.Date;

public class OpenDoorVO {
	
	private String id;
	private String pw;
	private String name;
	private String gender;
	private Date rrn;
	private String job;
	private int prop;
	private String tel;
	private String face;
	private String pwq;
	private String pwa;
	
	public OpenDoorVO() {};
	
	// update 
	public OpenDoorVO(String id1, String pw1, String name2, String gender2, java.sql.Date rrn2, String job2, 
			int prop2,String tel2, String pwq2, String pwa2) {
		super();
		this.id = id1;
		this.pw = pw1;
		this.name = name2;
		this.gender = gender2;
		this.rrn = rrn2;
		this.job = job2;
		this.prop = prop2;
		this.tel = tel2;
		this.pwq = pwq2;
		this.pwa = pwa2;
	}
	
	// select
	public OpenDoorVO(String id, String name, String gender, String job, int prop, String face) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.job = job;
		this.prop = prop;
		this.face = face;
	}
	
	// VO 생성자
	public OpenDoorVO(String id, String pw, String name, String gender, Date rrn, String job, int prop, String tel,
			String face, String pwq, String pwa) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.rrn = rrn;
		this.job = job;
		this.prop = prop;
		this.tel = tel;
		this.face = face;
		this.pwq = pwq;
		this.pwa = pwa;
	}

	// getter/setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getRrn() {
		return rrn;
	}

	public void setRrn(Date rrn) {
		this.rrn = rrn;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getProp() {
		return prop;
	}

	public void setProp(int prop) {
		this.prop = prop;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFace() {
		return face;
	}

	public void setFace(String face) {
		this.face = face;
	}

	public String getPwq() {
		return pwq;
	}

	public void setPwq(String pwq) {
		this.pwq = pwq;
	}

	public String getPwa() {
		return pwa;
	}

	public void setPwa(String pwa) {
		this.pwa = pwa;
	}

}
