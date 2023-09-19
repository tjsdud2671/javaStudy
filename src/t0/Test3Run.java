package t0;

import java.util.Scanner;

public class Test3Run {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Test3DAO t3 = new Test3DAO();
		boolean run = true;
		
		while(run) {
			System.out.print("1.전체조회 2.개별조회 3:종료  ==> ");
			int no = scanner.nextInt();
			
			switch(no) {
				case 1:
					t3.getList();
					break;
				case 2:
					System.out.print("회원명을 입력하세요 >> ");
					String name = scanner.next();
					t3.getSearch(name);
					break;
				default: //변수값이 1,2번 둘 다 아닐경우
					run = false;
			}
			System.out.println("=========================");
		}
		System.out.println("작업끝");
		
		t3.connclose();
		scanner.close();
		
		}
	}

