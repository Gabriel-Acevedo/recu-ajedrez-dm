package src.main.dm.chess;

public class Chess {

	private Game game;
	
	public static void main(String arg[]){
		new Chess().playChess();
	}
		
	private Chess() {
		this.game = new Game();
	}
	
	private void playChess() {
		this.game.intro();
		this.game.play();
	}
	
}
