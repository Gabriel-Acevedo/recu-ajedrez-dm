package src.main.dm.chess;

import src.main.dm.utils.Console;

public enum Message {
	TITLE("**********CHESS**********"),
	BLACK_PIECES("Capital Letter Pieces Are Black: "),
	WHITE_PIECES("Small Letter Pieces Are White: "),
	ENTER_POSITION_X1("Enter the position x1: "),
	ENTER_POSITION_Y1("Enter the position y1: "),
	ENTER_POSITION_X2("Enter the position x2: "),
	ENTER_POSITION_Y2("Enter the position y2: "),
	MOVE_SUCCESFULL("Sucessfully moved!!"),
	CHECK("CHECK !! BE CAREFUL"),
	CHECKMATE("CHECKMATE !!!! GAME OVER"),
	EMPTY_SPACE("");
	
	private String message;
	private static Console console = new Console();
	
	private Message(String message) {
		this.message = message;
	}
	
	void write() {
		Message.console.write(this.message);
	}
	
	void writeln() {
		Message.console.writeln(this.message);
	}
	
	String getMessage() {
		return this.message;
	}
	
}
