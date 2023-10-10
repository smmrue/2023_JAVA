package Collection;

import java.util.Scanner;

public class BookArrayListTest {
	
	public static void main(String[] args) {
		BookArrayList bookArrayList = new BookArrayList();
		Scanner scanner = new Scanner(System.in);
		
		Book book1 = new Book(0001, "파우스트");
		Book book2 = new Book(0002, "황무지");
		Book book3 = new Book(0003, "변신");
		Book book4 = new Book(0004, "픽션들");
		Book book5 = new Book(0005, "톨스토이");
		
		bookArrayList.addBook(book1);
		bookArrayList.addBook(book2);
		bookArrayList.addBook(book3);
		bookArrayList.addBook(book4);
		bookArrayList.addBook(book5);
		
		bookArrayList.showAllBook();
		
		System.out.println("도서를 추가할 위치를 입력:");
		int loc = scanner.nextInt();
		System.out.println("책 ID 입력:");
		int ID = scanner.nextInt();
		System.out.println("책 제목 입력:");
		String Title = scanner.next();
		Book newBook = new Book(ID, Title);
		bookArrayList.insertBook(loc, newBook);
		
		bookArrayList.showAllBook();
		
		scanner.close();
	}
}