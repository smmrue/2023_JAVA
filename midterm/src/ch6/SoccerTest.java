package ch6;
class Sports {
	String getName() {
		return "아직 결정되지 않음";
	}
	int getPlayers() {
		return 0;
	}
}

class Soccer extends Sports {
	public String getName() {
		 return "축구";
	} 
	
	public int getPlayers() { 
		return 11;
	}
}

public class SoccerTest {
	public static void main(String[] args) {
		Soccer obj = new Soccer();
		System.out.println("경기이름:" + obj.getName());
		System.out.println("경기자수:" + obj.getPlayers());
	}

}
