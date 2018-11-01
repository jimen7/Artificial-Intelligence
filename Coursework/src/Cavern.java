import java.util.ArrayList;
import java.util.List;

public class Cavern {
	
	private int id;
	private int x;
	private int y;
	private List<Cavern> neighbors = new ArrayList<Cavern>();
	
	public Cavern(int x, int y) {
		this.x = x;
		this.y=y;
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
	

	
	

}
