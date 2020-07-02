package src.main.dm.chess;

public class Queen extends Piece
{
	 Queen(Color color, PieceSymbol pieceSymbol, PieceTypes pieceType){
		 this.color = color;
		 this.pieceSymbol = pieceSymbol;
		 this.pieceType = pieceType;
	 }
	
	public boolean move_piece (int coordinateX1, int coordinateY1, int coordinateX2, int coordinateY2){
		boolean movePossible = false;
		int coordinateXabs = Math.abs(coordinateX2 - coordinateX1); 
		int coordinateYabs = Math.abs(coordinateY2 - coordinateY1);
		
		if(coordinateXabs == coordinateYabs) {
			Bishop moveDiagonal = new Bishop();
			movePossible = moveDiagonal.move_piece(coordinateX1, coordinateY1, coordinateX2, coordinateY2);
		}else if(coordinateYabs == 0 || coordinateXabs == 0) {
			Rook moveStraight = new Rook();
			movePossible = moveStraight.move_piece(coordinateX1, coordinateY1, coordinateX2, coordinateY2);
		}
		return movePossible;
	}
	
} 