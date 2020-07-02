package src.main.dm.chess;

public class Board{		
	
	static Piece piecePosition[][] = new Piece[8][8];
	
	static Turn turn = new Turn();
		
		public void createBoard(){	  
			createWhitePieces();
			createBlackPieces();																		
		}
		
		
		private void createWhitePieces() {
			for(int i=0;i<8;i++){
				Pawn pawn_obj= new Pawn(Color.WHITE, PieceSymbol.p, PieceTypes.PAWN);	
				piecePosition[1][i]=pawn_obj;
			}			
			for(int i=0;i<=7;i+=7) {
				Rook rook_obj=new Rook(Color.WHITE, PieceSymbol.r, PieceTypes.ROOK);
				piecePosition[0][i]=rook_obj; 
			}
			for(int i=1;i<=6;i+=5) {
				Knight knight_obj=new Knight(Color.WHITE, PieceSymbol.n, PieceTypes.KNIGHT);
				piecePosition[0][i]=knight_obj; 
			}
			for(int i=2;i<=5;i++) {
				Bishop bishop_obj=new Bishop(Color.WHITE, PieceSymbol.b, PieceTypes.BISHOP);
				piecePosition[0][i]=bishop_obj; 
			}
			King king_obj=new King(Color.WHITE, PieceSymbol.k, PieceTypes.KING);
			Queen queen_obj=new Queen(Color.WHITE, PieceSymbol.q, PieceTypes.QUEEN);
					piecePosition[0][3]=king_obj; 
					piecePosition[0][4]=queen_obj;
		}
	
		private void createBlackPieces() {
			for(int i=0;i<8;i++){
				Pawn pawn_obj= new Pawn(Color.BLACK, PieceSymbol.P, PieceTypes.PAWN);		
				piecePosition[6][i]=pawn_obj;				
			}
			for(int i=0;i<=7;i+=7) {
				Rook rook_obj=new Rook(Color.BLACK, PieceSymbol.R, PieceTypes.ROOK);
				piecePosition[7][i]=rook_obj; 
			}
			for(int i=1;i<=6;i+=5) {
				Knight knight_obj=new Knight(Color.BLACK, PieceSymbol.N, PieceTypes.KNIGHT);
				piecePosition[7][i]=knight_obj; 
			}
			for(int i=2;i<=5;i++) {
				Bishop bishop_obj=new Bishop(Color.BLACK, PieceSymbol.B, PieceTypes.BISHOP);
				piecePosition[7][i]=bishop_obj; 
			}
			King black_king_obj=new King(Color.BLACK, PieceSymbol.K, PieceTypes.KING);
			Queen black_queen_obj=new Queen(Color.BLACK, PieceSymbol.Q, PieceTypes.QUEEN);
			piecePosition[7][4]=black_king_obj; 
			piecePosition[7][3]=black_queen_obj;	
		}
		
		
		public void showBoard(){
			for(int i=0;i<8;i++){
				for(int j=0;j<8;j++){
					if(piecePosition[i][j]!=null) {
						System.out.printf(piecePosition[i][j].pieceSymbol+"  ");
					}else {
						System.out.printf('-'+"  ");
					}
				}
				System.out.println();;
			}
		}
	
		
		public static void changeTurn() {
			turn.change();
		}
		
		public Piece getPieceLocation(int p,int q){ 
			return piecePosition[p][q];
		}
		
		public Piece[][] getPiecePosition(){ 
			return piecePosition;
		 }
		
		public void setPiecePosition(int c,int d, Piece type){  
			piecePosition[c][d] = type;
		}
			
		public void setTurn(Turn turn)		{
			this.turn = turn;
		}

		public Turn getTurn(){	
			return turn;
		}
			
								
}

