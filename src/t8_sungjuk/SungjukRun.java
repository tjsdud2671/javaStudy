package t8_sungjuk;

import java.util.Scanner;

public class SungjukRun {
	public static void main(String[] args) {
		
		
		
		boolean run = true;
		while(run) {
			Scanner scanner = new Scanner(System.in);
			SungjukService service = new SungjukService();
			
			System.out.println("\n\t ** 성 적 표 **");
			System.out.println("1:입력 2:전체조회 3:개별조회 4:수정 5:삭제 0:종료");
			int num =scanner.nextInt();
			
			
			switch (num) {
				case 1: //입력
					service.setInput();
					break;
				case 2: //전체조회
					
					break;
				case 3: //개별조회
					
					break;
				case 4: //수정
					
					break;
				case 5: //삭제
					
					break;
				default: 
					run =  false;
				
		}
	}
	}
	
}
