package homework;

import java.util.Scanner;

public class SungjukRun {
 public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	SungjukService service = new SungjukService();
	boolean run = true;
	while(run) {
		System.out.println("\n\t** 성 적 표 **");
		System.out.println("메뉴선택 (1:입력 2:전체조회 3:개별조회 4:수정 5:삭제 0:종료)");
		int no = scanner.nextInt();
		
		switch (no) {
			case 1://입력
				service.setInput();
				break;
			case 2://전체조회
				service.setList();
				
				break;
			case 3://개별조회
				service.setSearch();
				
				break;
			case 4://수정
				service.setUpdate();
				break;
			case 5://삭제
				
				break;
	
			default:
				run = false;
	 }
  }
 }
}
