package t6_hoiwon;

import java.util.ArrayList;
import java.util.Scanner;

public class HoiwonRun {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HoiwonDAO dao = new HoiwonDAO();
		boolean run = true;
		String name = "";
		HoiwonVO vo = null;
		
		while(run) {
			System.out.print("1.전체조회  2:개별조회  3.회원가입  4:수정  5:삭제  6:종료 ==> ");
			int no = scanner.nextInt();
			
			switch(no) {
				case 1:
					ArrayList<HoiwonVO> vos = dao.getList(); //전체검색 호출
					
					System.out.println("\t\t** 주 소 록 **");
					System.out.println("=".repeat(38));
					System.out.println("번호\t성명\t나이\t주소\t성별");
					System.out.println("-".repeat(38));
					for(HoiwonVO v : vos) {
						System.out.print(v.getIdx() + "\t");
						System.out.print(v.getName() + "\t");
						System.out.print(v.getAge() + "\t");
						System.out.print(v.getAddress() + "\t");
						System.out.print(v.getGender());
						System.out.println();
					}
					System.out.println("=".repeat(38));
					System.out.println("총회원 : " + vos.size());
					
					break;
				case 2:		// 개별조회
					System.out.print("검색할 회원명을 입력하세요? => ");
					name = scanner.next();
					System.out.println("-".repeat(40));
					
					vo = dao.getSearch(name); //개별검색 호출
					if(vo.getName() != null) {   
						//if(vo != null) {   // vo값은 null값이 되지 않기때문에 이건 의미가 없음.
						//System.out.println(vo);
						System.out.println("번호 : " + vo.getIdx());
						System.out.println("성명 : " + vo.getName());
						System.out.println("나이 : " + vo.getAge());
						System.out.println("주소 : " + vo.getAddress());
						System.out.println("성별 : " + vo.getGender());
					}
					else {
						System.out.println(name + "님 자료가 없습니다.");
					}
					break;
				case 3:  //회원가입
					vo = new HoiwonVO();
					while(true) {
						System.out.println("회원 성명을 입력하세요?");
						name=scanner.next();
						
						// 성명 중복 체크
						vo = dao.getSearch(name); //개별검색 호출
						if(vo.getName() == null) break; 
							System.out.println("같은 이름이 존재합니다. 다시 입력하세요");
						}
				
					vo.setName(name);
					System.out.println("회원 나이를 입력하세요?");
					vo.setAge(scanner.nextInt());
					System.out.println("회원 주소를 입력하세요?");
					vo.setAddress(scanner.next());
					System.out.println("회원 성별을 입력하세요(1:남자, 2:여자)?");
					int gender = scanner.nextInt();
					if(gender == 1) vo.setGender("남자");
					else vo.setGender("여자");
					
					int res = dao.setHoiwonInput(vo);//회원가입메소드 호출
					
					if(res==0)System.out.println("회원가입 실패");
					else System.out.println("회원가입에 성공하셨습니다.");
					break;
					
				case 4:  // 수정
					System.out.print("수정할 회원명을 입력하세요? => ");
					name = scanner.next();
					System.out.println("-".repeat(40));
					
					
					boolean flag = true;
					while(flag) {
						vo = dao.getSearch(name); //개별자료 검색  *중요*
						if(vo.getName() == null) System.out.println(name + "님의 자료가 없습니다.");
						else {
							System.out.println("------------------------------------------------");
							System.out.println("성명 : " + vo.getName());
							System.out.println("나이 : " + vo.getAge());
							System.out.println("주소 : " + vo.getAddress());
							System.out.println("성별 : " + vo.getGender());
							System.out.println("------------------------------------------------");
							System.out.println("수정할 항목의 번호를 입력하세요 : ");
							System.out.print("1:나이  2.주소  3.성별  4.종료  == >  ");
							no = scanner.nextInt();
							
							int age = vo.getAge();
							String address = vo.getAddress();
							String strGender = vo.getGender();
							
							switch(no) {
								case 1:
									System.out.print("수정할 나이를 입력하세요 : ");
									age = scanner.nextInt();
									break;
								case 2:
									System.out.print("수정할 주소를 입력하세요 : ");
									address = scanner.next();
									break;
								case 3:
									System.out.print("수정할 성별을 입력하세요 (1:남자 2:여자): ");
									gender = scanner.nextInt();
									if(gender == 1) strGender = "남자";
									else strGender = "여자";
									break;
									default:
										flag = false;
							}
							
							
							res = dao.setHoiwonUpdate(name,age,address,strGender);
							if(res==0) System.out.println("수정 실패");
							else System.out.println(name + "님 자료가 수정되었습니다.");
						}
					}
					break;
				case 5:  // 삭제처리
					System.out.print("삭제할 회원명을 입력하세요? => ");
					name = scanner.next();
					System.out.println("-".repeat(40));
					vo = dao.getSearch(name); //개별자료 검색  *중요*
					if(vo.getName() == null) System.out.println(name + "님 자료가 없습니다.");
					else {
						dao.setDelete(name);
						System.out.println(name + "님 자료가 삭제되었습니다.");
					}
					
					
					break;
				default:
					run = false;
			}
			System.out.println("===========================================");
		}
		System.out.println("작업끝");
		
		// DB conn객체 close
		dao.connClose();
		
		scanner.close();
	}
}
