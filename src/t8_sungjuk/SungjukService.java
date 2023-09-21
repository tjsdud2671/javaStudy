package t8_sungjuk;

import java.util.Scanner;

public class SungjukService {

	Scanner scanner = new Scanner(System.in);
	SungjukDAO dao = new SungjukDAO();
	SungjukVO vo = null;
	
	String name ="";
	int res = 0;
	
	//성적입력
	public void setInput() {
		vo = new SungjukVO();
		
		while(true) {
			System.out.println("\n ** 성적 입력 처리");
			
			//동명이인 처리
			while(true) {
				System.out.print ("성명 : " ); 
				String name = scanner.next();
				
				vo =dao.getSearch(name);
				if(vo==null) {
					vo = new SungjukVO();
					vo.setName(name);
					break;
				}
				System.out.println("다시 입력하세요");
			}
			vo.setName(name);
			
			System.out.print("국어 : "); vo.setKor(scanner.nextInt());
			System.out.print("영어 : "); vo.setEng(scanner.nextInt());
			System.out.print("수학 : "); vo.setMat(scanner.nextInt());
			
			res =dao.setInput(vo);
			if(res==0)System.out.println("성적 등록 실패");
			else System.out.println("성적 등록 완료");
			
			System.out.print("계속 하시겠습니까? (y/n)");
			String ans = scanner.next();
			if(ans.toUpperCase().equals("N"))break;
		}
		
	}

}
