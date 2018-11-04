import java.util.ArrayList;
import java.util.List;

public class Cavern {
	
	private int id;
	private int x;
	private int y;
	private List<Cavern> neighbors = new ArrayList<Cavern>();
	
	public Cavern(int x, int y, int id) {
		this.x = x;
		this.y=y;
		this.id=id;
	}
	
	public List<Cavern> getNeighboor() {
		return neighbors;
		
	}
	
	public int getId() {
		return id;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override 
	public String toString() {
		return this.id + "" ;
	}
	

	
	

}
