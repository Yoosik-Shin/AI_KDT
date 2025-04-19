package Ex02;

import java.util.ArrayList;

public class Library {

	public static void main(String[] args) {
		
		ArrayList<Book> bookList = new ArrayList<Book>();
		
		bookList.add(new Book( 123123, " 이게 자바냐 ", "감자바", "자바 감자바 ", 33000));
		bookList.add(new Book( 112112, " 정보처리기사 ", "김조은", "국가기술자격", 45000));
		bookList.add(new Book( 123123, " 실무 DB   ", "박디비", "디비디비딥 ", 60000));
		
		System.out.println("########## 조은 스터디 도서관 ##########");
		for (Book book : bookList) {
			System.out.println(book);
		}
	}	
	
}
