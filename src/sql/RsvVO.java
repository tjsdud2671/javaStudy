package sql;

public class RsvVO {
	private String reserv;

	String getReserv() {
		return reserv;
	}

	void setReserv(String reserv) {
		this.reserv = reserv;
	}

	@Override
	public String toString() {
		return "RsvVO [reserv=" + reserv + "]";
	}
	
	
}
