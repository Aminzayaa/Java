package java2_06_abstract;

public class StartPlayer {
	public static void main(String[] args) {
		Player cdPlayer = new CDPlayer(); // CDPlayer instance of
		Player dvdPlayer = new DVDPlayer(); // DVDPlayer instance of
		cdPlayer.repeat(3); // CDPlayer boot ( repeat 3 times )
		dvdPlayer.repeat(3); // DVDPlayer boot ( repeat 3 times )
	}
}
