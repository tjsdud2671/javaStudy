package sql;

public class CakeVO {
	private String mid;
	private String pwd;
	private String name;
	private String phonenumber;
	
	private String strYY;
	private String strMM;
	private String strDD;
	String getMid() {
		return mid;
	}
	void setMid(String mid) {
		this.mid = mid;
	}
	String getPwd() {
		return pwd;
	}
	void setPwd(String pwd) {
		this.pwd = pwd;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	String getPhonenumber() {
		return phonenumber;
	}
	void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	String getStrYY() {
		return strYY;
	}
	void setStrYY(String strYY) {
		this.strYY = strYY;
	}
	String getStrMM() {
		return strMM;
	}
	void setStrMM(String strMM) {
		this.strMM = strMM;
	}
	String getStrDD() {
		return strDD;
	}
	void setStrDD(String strDD) {
		this.strDD = strDD;
	}
	@Override
	public String toString() {
		return "CakeVO [mid=" + mid + ", pwd=" + pwd + ", name=" + name + ", phonenumber=" + phonenumber + ", strYY="
				+ strYY + ", strMM=" + strMM + ", strDD=" + strDD + "]";
	}
	
	
	
}