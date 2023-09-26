package sql;

import java.util.Calendar;

public class CakeService {
	CakeVO vo = null;
	
	//오늘날짜 구하기
	public CakeVO getDefaultDate() {
		vo = new CakeVO();
		
		Calendar cal = Calendar.getInstance();
		vo.setStrYY(cal.get(Calendar.YEAR)+"");
		vo.setStrMM(cal.get(Calendar.MONTH)+1+"");
		vo.setStrYY(cal.get(Calendar.DATE)+"");
		
		return vo;
	}
}
