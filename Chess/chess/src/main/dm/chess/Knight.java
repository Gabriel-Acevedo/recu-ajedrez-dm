package src.main.dm.chess;

public class Knight extends Piece {
	
	Knight(Color color, PieceSymbol pieceSymbol, PieceTypes pieceType){
		this.color = color;
		this.pieceSymbol = pieceSymbol;
		this.pieceType = pieceType;
	}
	
	public boolean move_piece(int coordinateX1,int coordinateY1,int coordinateX2,int coordinateY2) {
		boolean movePossible=false;
		Board board = new Board();
		Piece square[][]= board.getPiecePosition();
		int coordinateXabs = Math.abs(coordinateX2 - coordinateX1);
		int coordinateYabs = Math.abs(coordinateY2 - coordinateY1);
		
		if((coordinateXabs == 1 && coordinateYabs == 2) || (coordinateXabs == 2 && coordinateYabs == 1)){
			if(square[coordinateX2][coordinateY2] == null || board.turn.getcolor() != square[coordinateX2][coordinateY2].color) {
				movePossible=true;
			}
		}	
		return movePossible;
	}
}
