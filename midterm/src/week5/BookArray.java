package week5;

public class BookArray {

	public static void main(String[] args) {
		Book[] library = new Book[5];
		
		library[0] = new Book("파우스트", "괴테");
		library[1] = new Book("황무지", "엘리엇");
		library[2] = new Book("변신", "카프카");
		library[3] = new Book("픽션들", "보르헤스");
		library[4] = new Book("톨스토이", "안나 카레나");
		
		for (int i = 0; i <library.length; i ++) {
			library[i].showBookInfo();
		}
		
		for (int i = 0; i <library.length; i ++) {
			System.out.println(library[i]);
		}

	}

}
