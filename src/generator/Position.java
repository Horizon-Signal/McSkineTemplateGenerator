package generator;

public class Position {
	public int x;
	public int y;
	
	public Position(int xPosi, int yPosi) {
		this.x = xPosi;
		this.y = yPosi;
	}
	
	public int getX () {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Position) && (((Position) obj).getX() == this.x) && (((Position) obj).getY() == this.y);
	}
	
	@Override
	public int hashCode() {
		return Integer.parseInt(Integer.toString(this.x) + Integer.toString(this.y));
	}
}
