import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;

public class main {
	
	static double Euclidian_Distance(Cavern from, Cavern to) {
		double distance;
		distance = Math.sqrt((from.getX()-to.getX())*(from.getX()-to.getX()) + (from.getY()-to.getY())*(from.getY()-to.getY()));
		return distance;
	}
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		List<Cavern> cavernlist = new ArrayList<Cavern>(); //List of all Caverns
		
		List<Integer> filelist = new ArrayList<Integer>(); //List of all the integers of the imported file
		
		List<Integer> connectionList = new ArrayList<Integer>(); //List of all the connections of all caverns(Will be either 0 or 1)
		
		//List<Cavern> path = new ArrayList<Cavern>(); //The path that will be used in the end result
		
		
		//Using the string to read the file and compare
		String line = "";
		String splitby = ",";
		//File path:
		String csvfile = "C:\\Users\\40204497\\Desktop\\Artificial-Intelligence\\input1.cav";
		//String csvfile = "H:\\Artificial Intelligence\\Coursework\\Artificial-Intelligence\\input1.cav";
		//String csvfile = "C:\\Users\\Dimitris\\Desktop\\Artificial Intelligence\\Coursework\\Artificial-Intelligence\\input1.cav";
		
		//Values for A star algorithm
		List<Cavern> openCav = new ArrayList<Cavern>(); //The caverns that have not been checked yet
		List<Cavern> closedCav = new ArrayList<Cavern>(); //The caverns that have been checked
		HashMap<Cavern,Cavern> originalpath = new HashMap<Cavern,Cavern>();
		HashMap<Cavern,Double> gscore = new HashMap<Cavern,Double>(); //The cost of getting from the start to the cavern
		gscore.put(cavernlist.get(0), 0.0);
		HashMap<Cavern,Double> fscore = new HashMap<Cavern,Double>(); //The cost of getting from the start to the goal by passing through this cavern
		fscore.put(cavernlist.get(0), Euclidian_Distance(cavernlist.get(0), cavernlist.get(cavernlist.size()-1)));
		
		
		
		//Reading the file:
		try (BufferedReader br = new BufferedReader(new FileReader(csvfile))) {
			while ((line = br.readLine()) != null) {
				String[] numbers = line.split(splitby);
				
				for(int i=0; i<numbers.length;i++) {
					filelist.add(Integer.parseInt(numbers[i]));
					//System.out.print(filelist.get(i)+",");	
					//System.out.print(numbers[i]+",");	
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		int numberofcaverns = filelist.get(0); //Get number of caverns from the first digit in the file
		
		
		//To get all caverns added to the list:
		for (int i=1,j=1;i<numberofcaverns*2;i=i+2,j++) {
			Cavern node1 = new Cavern(filelist.get(i),filelist.get(i+1),j); 
			cavernlist.add(node1);
		}
		
		
		//To get paths for each cavern, i starts where the coordinates for the caverns finish and goes until the end of the filelist
		for (int i = numberofcaverns*2+1; i<filelist.size();i++) {
			int num = filelist.get(i);
			connectionList.add(num);
		}
		
		
		
		
		
		//Using the boolean for printing out the connection
		boolean check = false;
		//Checking connection for each tavern
		for (int j=0; j<numberofcaverns;j++) {
			for (int i=0; i < cavernlist.size(); i++) {
				
				Cavern c = cavernlist.get(j);
				
				if (connectionList.get(i+cavernlist.size()*j) == 1) {
					c.getNeighboor().add(cavernlist.get(i));
					check = true;
				}
				
				if (check) {
					System.out.print("Cavern " + cavernlist.get(i).getId() + " is connected to Cavern " + c.getId()  + ": YES \n");
				}
				else {
					System.out.print("Cavern " + cavernlist.get(i).getId() + " is connected to Cavern " + c.getId() + ": NO \n");
				}			
				check = false;		
			}
			System.out.print("\n");
		}
		
	
		
		

	}

}
