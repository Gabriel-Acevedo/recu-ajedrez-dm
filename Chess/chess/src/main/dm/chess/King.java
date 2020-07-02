package src.main.dm.chess;

public class King extends Piece {
	
	King(Color color, PieceSymbol pieceSymbol, PieceTypes pieceType){		
		this.color = color;
		this.pieceSymbol = pieceSymbol;
		this.pieceType = pieceType;
	}
	
	public  boolean move_piece(int coordinateX1,int coordinateY1,int coordinateX2,int coordinateY2){
		boolean movePossible=false;
		Board board = new Board();
		Piece square[][]= board.getPiecePosition();
		int coordinateXabs = Math.abs(coordinateX2 - coordinateX1);
		int coordinateYabs = Math.abs(coordinateY2 - coordinateY1);
		
		if((coordinateXabs == 1 && coordinateYabs == 0) || (coordinateXabs == 0 && coordinateYabs == 1) || (coordinateXabs == 1 && coordinateYabs == 1)){
			if(square[coordinateX2][coordinateY2]==null) {
				movePossible=true;
			}
			else if((board.turn.getcolor() != square[coordinateX2][coordinateY2].color) && (square[coordinateX2][coordinateY2] != null)) {
				movePossible=true;
			}	
		}
		return movePossible;
	}  
	
	
} 
