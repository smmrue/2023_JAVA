interface controllable  {
	void play();
	void stop();
}
public class VideoPlayer {
	public static void main(String arg[]) {
		controllable c = new controllable() {
			public void play() {
				System.out.println("play");
			}

			public void stop() {
				System.out.println("stop");
			}
			
		};
		c.play();
		c.stop();
	}
}
