import java.util.Scanner;

public class BoardExample {

    private String[][] boardData;

    public BoardExample() {
        boardData = new String[100][4];
        boardData[0] = new String[]{"1", "winter", "2022.01.27", "게시판에 오신 것을 환영합니다."};
        boardData[1] = new String[]{"2", "winter", "2022.01.27", "올 겨울은 많이 춥습니다."};
    }

    public void list() {
        System.out.println();
        System.out.println("[게시물 목록]");
        System.out.println("-------------------------------------------------------------------");
        System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
        System.out.println("-------------------------------------------------------------------");
        for (String[] data : boardData) {
            if (data != null) {
                System.out.printf("%-6s%-12s%-16s%-40s\n", data[0], data[1], data[2], data[3]);
            }
        }
        mainMenu();
    }

    public void mainMenu() {
        System.out.println();
        System.out.println("-------------------------------------------------------------------");
        System.out.println("메인메뉴 : 1. Create | 2. Read | 3. Clear | 4. Exit");
        System.out.print("메뉴를 선택하세요: ");
        Scanner scanner = new Scanner(System.in);
        String menuNo = scanner.nextLine();
        processMenu(menuNo);
    }

    public void processMenu(String menuNo) {
        switch (menuNo) {
            case "1" -> create();
            case "2" -> read();
            case "3" -> clear();
            case "4" -> exit();
            default -> {
                System.out.println("잘못된 메뉴 번호입니다. 다시 선택해주세요.");
                mainMenu();
            }
        }
    }

    public void create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*** create 메소드 실행됨");
        System.out.print("제목을 입력하세요: ");
        String title = scanner.nextLine();
        System.out.print("내용을 입력하세요: ");
        String content = scanner.nextLine();

        int index = findEmptyIndex();
        if (index != -1) {
            boardData[index] = new String[]{String.valueOf(index + 1), "winter", "2022.01.27", title};
            System.out.println("새로운 게시물이 추가되었습니다.");
        } else {
            System.out.println("더 이상 게시물을 추가할 수 없습니다.");
        }
        list();
    }

    public void read() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*** read 메소드 실행됨");
        System.out.print("조회할 게시물 번호를 입력하세요: ");
        int bno = scanner.nextInt();

        int index = findIndexByBno(bno);
        if (index != -1) {
            System.out.println("게시물 " + bno + "을(를) 출력합니다.");
            System.out.printf("%-6s%-12s%-16s%-40s\n", boardData[index][0], boardData[index][1], boardData[index][2], boardData[index][3]);
        } else {
            System.out.println("해당 번호의 게시물이 없습니다.");
        }
        list();
    }

    public void clear() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*** clear 메소드 실행됨");
        System.out.print("삭제할 게시물 번호를 입력하세요: ");
        int bno = scanner.nextInt();

        int index = findIndexByBno(bno);
        if (index != -1) {
            boardData[index] = null;
            System.out.println("게시물 " + bno + "이(가) 삭제되었습니다.");
        } else {
            System.out.println("해당 번호의 게시물이 없습니다.");
        }
        list();
    }

    public void exit() {
        System.out.println("프로그램을 종료합니다.");
        System.exit(0);
    }

    private int findEmptyIndex() {
        for (int i = 0; i < boardData.length; i++) {
            if (boardData[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private int findIndexByBno(int bno) {
        for (int i = 0; i < boardData.length; i++) {
            if (boardData[i] != null && boardData[i][0].equals(String.valueOf(bno))) {
                return i;
            }
        }
        return -1;
    }
        public static void main(String[] args) {
            BoardExample boardExample = new BoardExample();
            boardExample.list();
    }
}
