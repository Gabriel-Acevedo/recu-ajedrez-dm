package src.main.dm.chess;

public class Pawn extends Piece{	
	
	public Pawn(Color color, PieceSymbol pieceSymbol, PieceTypes pieceType){
		this.color = color;
		this.pieceSymbol = pieceSymbol;
		this.pieceType = pieceType;
	}
	
	public boolean move_piece(int coordinateX1, int coordinateY1, int coordinateX2, int coordinateY2)		{
		boolean movePossible = this.isMovePossible(coordinateX1, coordinateY1, coordinateX2, coordinateY2);
		return movePossible;
	}
	
	
	private boolean isMovePossible(int coordinateX1, int coordinateY1, int coordinateX2, int coordinateY2) {
		Board board = new Board();
		Piece square[][]= board.getPiecePosition();
		int coordinateXabs = Math.abs(coordinateX2 - coordinateX1);
		int coordinateYabs = Math.abs(coordinateY2 - coordinateY1);
		
		if((coordinateXabs == 1 && coordinateYabs == 0) || (coordinateXabs == 1 && coordinateYabs == 1)){ 	
			boolean flag=false;
			if((square[coordinateX2][coordinateY2] == null) && (coordinateXabs == 1 && coordinateYabs == 0)) {
				flag=true;	
			}else if((coordinateXabs == 1 && coordinateYabs == 1) && square[coordinateX2][coordinateY2] != null) {
				if((square[coordinateX2][coordinateY2].color != board.turn.getcolor())) {
					flag=true;
				}
			}
			if(flag==true) {
				if((board.turn.getcolor() == Color.WHITE && coordinateX2 > coordinateX1) || (board.turn.getcolor() == Color.BLACK && coordinateX2 < coordinateX1)) {
					return true;
				}
			}
		}else if((coordinateXabs == 2) && (coordinateY2 == coordinateY1) && (square[coordinateX2][coordinateY2] == null) && (coordinateX1 == 6 ||coordinateX1 == 1)){ 
			return true;
		}
		return false;
	}
	
}
