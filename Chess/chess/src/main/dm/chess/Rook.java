package src.main.dm.chess;

public class Rook extends Piece { 
	
	Rook(Color color, PieceSymbol pieceSymbol, PieceTypes pieceType){
		this.color = color;
		this.pieceSymbol = pieceSymbol;
		this.pieceType = pieceType;
	}
	Rook(){}
	
	public boolean move_piece(int coordinateX1, int coordinateY1, int coordinateX2, int coordinateY2) {		
		boolean movePossible= this.isPossibleMove(coordinateX1, coordinateY1, coordinateX2, coordinateY2);
		return movePossible;
	}
	
	private boolean isPossibleMove(int coordinateX1,int coordinateY1, int coordinateX2,int coordinateY2) {
		int coordinateXabs = Math.abs(coordinateX2 - coordinateX1);	
		int coordinateYabs = Math.abs(coordinateY2 - coordinateY1);
		Board board = new Board();
		Piece square[][] = board.getPiecePosition();

		if((coordinateXabs == 0 && coordinateYabs != 0)||(coordinateXabs != 0 && coordinateYabs == 0)) {
			int count=1;
			while(count <= coordinateXabs) {	
				int row,column;
				if(coordinateX2 < coordinateX1 && coordinateY2 == coordinateY1) {		
					row = coordinateX1 - count;
					column = coordinateY1;
				}else if(coordinateX2 > coordinateX1 && coordinateY2 == coordinateY1) {
					row=coordinateX1 + count;
					column = coordinateY1;
				}else if(coordinateX2 == coordinateX1 && coordinateY2 < coordinateY1) {
					row = coordinateX1;
					column = coordinateY1 - count;
				}else {						
					row = coordinateX1;
					column = coordinateY1 + count;
				}
				if(square[row][column] == null) {
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
