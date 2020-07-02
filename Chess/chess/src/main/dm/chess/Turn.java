package src.main.dm.chess;

public class Turn {

	private Color color;
	
	Turn(){
		this.color = Color.BLACK;
	}
	
	public void change() {
		this.color = Color.values()[(this.color.ordinal() + 1) % 2];
	}
	
	public Color getcolor() {
		return this.color;
	}
	
    @Override
    public String toString() {
        return this.color.name();
    }
}
