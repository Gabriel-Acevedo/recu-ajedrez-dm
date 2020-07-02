package src.main.dm.chess;

import src.main.dm.utils.Console;

public class Game{
	
	private static Board board;
	private static Console console;
	
	public Game() {
		board = new Board();
		console = new Console();
	}
	
	public void intro() {
		Message.TITLE.writeln();
		Message.BLACK_PIECES.writeln();
		Message.WHITE_PIECES.writeln();
		Message.EMPTY_SPACE.writeln();
	}
	
	public void play(){
		Board board=new Board();
		board.createBoard();
		board.showBoard();
		while(true) {			
			Message.EMPTY_SPACE.writeln();
			System.out.println(board.turn + " Piece Turn -- ");
			int playerMovements[] = enterMovement();
			try {
				movePieceOnBoard(playerMovements);				
			}catch(NullPointerException e) {
				Message.EMPTY_SPACE.writeln();
				Error.NO_PIECE_SELECTED.writeln();
				Message.EMPTY_SPACE.writeln();
				board.showBoard();
			}
		}	
	}	
	
	
	private int[] enterMovement() {
		int positionX1 = 0;
		int positionY1 = 0;
		int positionX2 = 0;
		int positionY2 = 0;
		positionX1 = this.console.readInt(Message.ENTER_POSITION_X1.getMessage());
		positionY1 = this.console.readInt(Message.ENTER_POSITION_Y1.getMessage());
		positionX2 = this.console.readInt(Message.ENTER_POSITION_X2.getMessage());
		positionY2 = this.console.readInt(Message.ENTER_POSITION_Y2.getMessage());		
		return new int[] {positionX1, positionY1, positionX2, positionY2};
	}
	
	
	private void movePieceOnBoard(int[] playerMovements) {
		Piece piece = board.getPieceLocation(playerMovements[0], playerMovements[1]);
		if(piece.color == board.turn.getcolor()) {	
			boolean isMovePossible = piece.move_piece(playerMovements[0], playerMovements[1], playerMovements[2], playerMovements[3]);
			if(isMovePossible == false) {
				Message.EMPTY_SPACE.writeln();
				Error.WRONG_POSITION.writeln();
				Message.EMPTY_SPACE.writeln();
			}else {
				board.changeTurn();
				board.setPiecePosition(playerMovements[2], playerMovements[3], piece);
				board.setPiecePosition(playerMovements[0], playerMovements[1], null);
				board.changeTurn();
				boolean isKingChecked = isKingChecked();
				if(isKingChecked == true) {
					isGameFinished();					
				}else {
					if(isKingChecked != true) {		
						board.setPiecePosition(playerMovements[2], playerMovements[3], piece);
						board.setPiecePosition(playerMovements[0], playerMovements[1], null);
						Message.EMPTY_SPACE.writeln();
						Message.MOVE_SUCCESFULL.writeln();
						Message.EMPTY_SPACE.writeln();
						board.changeTurn();
								
					}else {
						Error.ONLY_KING_MOVE_IN_CHECK.writeln();
					}
								
				}	
			}
				board.showBoard();
		}else {
			Message.EMPTY_SPACE.writeln();
			Error.ENEMY_PIECE.writeln();
		}
	}
	
	
	private static int[] getEnemyKingsPosition(){
		
		int positionX = 0; 
		int positionY = 0;
		
		for(int i = 0; i < 8; i++) {	
			for(int j = 0; j < 8; j++) {
				
				if(board.getPiecePosition()[i][j]!=null) {
					if(board.getPiecePosition()[i][j].color!=board.turn.getcolor() && board.getPiecePosition()[i][j].pieceType == PieceTypes.KING) {
						positionX = i;
						positionY = j;
					}
				}	
			}
		}
		return new int[] {positionX, positionY};		
	}
	
	
	public static boolean isKingChecked() {
		boolean isKingChecked=false;
		int enemyKingPosition[] = getEnemyKingsPosition();

		boolean isAttackToKingPossible =false;
		for(int i=0;i<8;i++) {		
			for(int j=0;j<8;j++) {
				if(board.getPiecePosition()[i][j] != null && (board.getPiecePosition()[i][j].color != board.getPiecePosition()[enemyKingPosition[0]][enemyKingPosition[1]].color)) {
					isAttackToKingPossible = board.getPiecePosition()[i][j].move_piece(i, j, enemyKingPosition[0], enemyKingPosition[1]);
					if(isAttackToKingPossible == true) {
						isKingChecked = true;
						break;
					}
				}
			}
		}
		return isKingChecked;
	}
	
	public static boolean isCheckMate() {	
		boolean isCheckMate;
		Board board=new Board();
		isCheckMate = verifyCheckMate();
		if(isCheckMate == true) {
			return false;
		}else {
			return true;
		}
	}
	
	
	private static boolean verifyCheckMate() {
		boolean isCheckMate=false;
		for(int i=0;i<8;i++) {	
			for(int j=0;j<8;j++) {	
			Piece piece = board.getPiecePosition()[i][j];		
			if(piece != null) {
					for(int k = 0; k < 8; k++) {
						for(int m = 0; m < 8; m++) {
							board.changeTurn();							
							boolean  isMovePossible = false;
							if(piece.color == board.turn.getcolor()) {
								isMovePossible = piece.move_piece(i, j, k, m);
							}
							if(isMovePossible == true) {	
								board.setPiecePosition(k, m, piece);
								board.setPiecePosition(i, j, null);
								board.changeTurn();
								boolean isKingChecked = isKingChecked();
								if(isKingChecked == true) {
								}else {
									isCheckMate = true;
								}
								board.setPiecePosition(k, m, null);
								board.setPiecePosition(i, j, piece);
							}else {
								board.changeTurn();
							}	
						}
					}
							
				}
			
			}
		}
		return isCheckMate;
	}		
	
	
	private void isGameFinished() {
		boolean check_mate = isCheckMate();
		if(check_mate==true) {
			Message.EMPTY_SPACE.writeln();
			Message.CHECKMATE.writeln();
			Message.EMPTY_SPACE.writeln();
			System.exit(0);
		}else {
			Message.EMPTY_SPACE.writeln();
			Message.CHECK.writeln();
			Message.EMPTY_SPACE.writeln();
			board.changeTurn();
		}
	}
	
		
}		
