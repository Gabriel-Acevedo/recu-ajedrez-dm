package src.main.dm.chess;

public class Bishop extends Piece {	
	
	Bishop(Color color, PieceSymbol pieceSymbol, PieceTypes pieceType){
		this.color = color;
		this.pieceSymbol = pieceSymbol;
		this.pieceType = pieceType;
	}
	Bishop(){}
	
	public boolean move_piece(int coordinateX1,int coordinateY1,int coordinateX2,int coordinateY2) {
		boolean movePossible = this.isMovePossible(coordinateX1, coordinateY1, coordinateX2, coordinateY2);
		return movePossible;
	}
	
	private boolean isMovePossible(int coordinateX1,int coordinateY1,int coordinateX2,int coordinateY2) {
		Board board = new Board();
		Piece square[][]= board.getPiecePosition();
		int coordinateXabs = Math.abs(coordinateX2-coordinateX1);
		int coordinateYabs = Math.abs(coordinateY2-coordinateY1);
		if(coordinateXabs == coordinateYabs) {
			int count=1;
			while(count <= coordinateXabs) {	
				int row,col;
				if(coordinateX2 < coordinateX1 && coordinateY2 < coordinateY1) {		
					row=coordinateX1 - count;
					col=coordinateY1 - count;
				}else if(coordinateX2<coordinateX1 && coordinateY2>coordinateY1) {		
					row=coordinateX1 - count;
					col=coordinateY1 + count;
				}else if(coordinateX2>coordinateX1 && coordinateY2<coordinateY1) {		
					row=coordinateX1 + count;
					col=coordinateY1 - count;
				}else {						
					row=coordinateX1 + count;
					col=coordinateY1 + count;
				}
				if(square[row][col] == null) {
					count++;
				}else  {
					count--;
					break;
				}
			}
			if(square[coordinateX2][coordinateY2] == null && count == coordinateXabs+1) {
				return true;
			}else if(square[coordinateX2][coordinateY2] != null && count == coordinateXabs-1 && board.turn.getcolor() != square[coordinateX2][coordinateY2].color) {
				return true;
			}
		}
		return false;
	}
	
}		
