package t10_sale;

public class SaleVO {
	private int idx;
	private String pName;
	private int ea;
	private String pDate;
	
	private int salePrice;

	int getIdx() {
		return idx;
	}

	void setIdx(int idx) {
		this.idx = idx;
	}

	String getpName() {
		return pName;
	}

	void setpName(String pName) {
		this.pName = pName;
	}

	int getEa() {
		return ea;
	}

	void setEa(int ea) {
		this.ea = ea;
	}

	String getpDate() {
		return pDate;
	}

	void setpDate(String pDate) {
		this.pDate = pDate;
	}

	int getSalePrice() {
		return salePrice;
	}

	void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}

	@Override
	public String toString() {
		return "SaleVO [idx=" + idx + ", pName=" + pName + ", ea=" + ea + ", pDate=" + pDate + ", salePrice=" + salePrice
				+ "]";
	}

		


	
}
