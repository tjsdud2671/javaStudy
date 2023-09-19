package t0;

public class HoiwonRun {
	public static void main(String[] args) {
		HoiwonDAO dao = new HoiwonDAO();
		dao.connclose();
		dao.getList();
	}
}
