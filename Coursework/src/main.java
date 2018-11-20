import java.io.BufferedReader;
import java.io.File;
//import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//import java.util.Scanner;
import java.util.HashMap;
import java.util.Collections;
import java.util.Date;

public class main {
	
	static double Euclidian_Distance(Cavern from, Cavern to) {
		double distance;
		distance = Math.sqrt((from.getX()-to.getX())*(from.getX()-to.getX()) + (from.getY()-to.getY())*(from.getY()-to.getY()));
		return distance;
	}
	
	static List<Cavern> reconstruct_Path(HashMap<Cavern,Cavern> originPath, Cavern current){
		List<Cavern> totalPath = new ArrayList<Cavern>();
		totalPath.add(current);
		while (originPath.containsKey(current)) {
			current = originPath.get(current);
			totalPath.add(current);
		}
		Collections.reverse(totalPath);
		return (totalPath);
	}
	

	public static void main(String[] args) throws Exception {
		//Time calculation variables;
		long lStartTime = new Date().getTime();
		long lEndTime;
		
		// TODO Auto-generated method stub
		
		List<Cavern> cavernlist = new ArrayList<Cavern>(); //List of all Caverns
		
		List<Integer> filelist = new ArrayList<Integer>(); //List of all the integers of the imported file
		
		List<Integer> connectionList = new ArrayList<Integer>(); //List of all the connections of all caverns(Will be either 0 or 1)
		
		//List<Cavern> path = new ArrayList<Cavern>(); //The path that will be used in the end result
		
		
		//Using the string to read the file and compare
		String line = "";
		String splitby = ",";
		//File path:
		//String csvfile = "C:\\Users\\40204497\\Desktop\\Artificial-Intelligence\\input1.cav";
		//String csvfile = "H:\\Artificial Intelligence\\Coursework\\Artificial-Intelligence\\input1.cav";
		//String csvfile = "C:\\Users\\Dimitris\\Desktop\\Artificial-Intelligence\\input3.cav";
		//String csvfile = "C:\\Users\\40204497\\Desktop\\Artificial-Intelligence\\1000-1.cav";
		
		String cavfile = null;
		if (args.length==1) {
			cavfile = args[0];
		}
		else {
			System.out.print("\nInvalid Argument Error: The program should be run from command line with an argument. Example:\n java -jar Test.jar C:\\Users\\user\\Desktop\\Artificial-Intelligence\\100-1.cav\nWhere Test.jar is the program, and the .cav is the location of the map\n");
			System.exit(1);
		}
		
		//String filePath = "C:\\Users\\40204497\\Desktop\\Artificial-Intelligence\\Batch File Test Environment\\outputfile.csn";
		//String filePath = "H:\\Artificial Intelligence\\OUTPUTTEST\\outputfile.csn";
		FileWriter outputfile = null;
		
		String filePath =  System.getProperty("user.dir");
		//String delSTR = "Coursework";
		//filePath.substring(filePath.length()-10, filePath.length());  //This is to run it from Eclipse ONLY
		filePath += "\\outputfile.csn";
		

			

		//CSVWriter writer = new CSVWriter(outputfile);
		
	//	File file = new File();
		
		//Values for A star algorithm
		List<Cavern> openCav = new ArrayList<Cavern>(); //The caverns that have not been checked yet
		
		List<Cavern> closedCav = new ArrayList<Cavern>(); //The caverns that have been checked
		
		HashMap<Cavern,Cavern> cameFrom = new HashMap<Cavern,Cavern>();
		
		HashMap<Cavern,Double> gscore = new HashMap<Cavern,Double>(); //The cost of getting from the start to the cavern
		
		
		
		HashMap<Cavern,Double> fscore = new HashMap<Cavern,Double>(); //The cost of getting from the start to the goal by passing through this cavern
		
		Double totalDistance=0.0;
		
		Boolean success = false;
		
		
		
		Cavern currentNode = null;  //'This is the node in openCav that has the lowest fscore value
		
		
		
		//Reading the file:
		try (BufferedReader br = new BufferedReader(new FileReader(cavfile))) {
			while ((line = br.readLine()) != null) {
				String[] numbers = line.split(splitby);
				
				for(int i=0; i<numbers.length;i++) {
					filelist.add(Integer.parseInt(numbers[i]));
					//System.out.print(filelist.get(i)+",");	
					//System.out.print(numbers[i]+",");	
				}
			}
		} catch (IOException e) {
			System.out.println("\nInvalid Path\n");
			System.exit(1);
		}
		
		
		
		
		//Atempt1
		
		
		
		
		
		
		
		
		
		
		int numberofcaverns = filelist.get(0); //Get number of caverns from the first digit in the file
		
		
		//To get all caverns added to the list:
		for (int i=1,j=1;i<numberofcaverns*2;i=i+2,j++) {
			Cavern node1 = new Cavern(filelist.get(i),filelist.get(i+1),j); 
			cavernlist.add(node1);
		}
		
		gscore.put(cavernlist.get(0), 0.0);
		
		fscore.put(cavernlist.get(0), Euclidian_Distance(cavernlist.get(0), cavernlist.get(cavernlist.size()-1)));
		
		Cavern goal = cavernlist.get(cavernlist.size()-1);
		openCav.add(cavernlist.get(0));
		
		
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
				//System.out.println(c.getId());
				if (connectionList.get(i+cavernlist.size()*j) == 1) {
					cavernlist.get(i).getNeighboor().add(c);
					//c.getNeighboor().add(cavernlist.get(i));
					check = true;
				}
				
//				if (check) {
//					System.out.print("Cavern " + cavernlist.get(i).getId() + " is connected to Cavern " + c.getId()  + ": YES \n");
//				}
//				else {
//					System.out.print("Cavern " + cavernlist.get(i).getId() + " is connected to Cavern " + c.getId() + ": NO \n");
//				}			
//				check = false;		
			}
			//System.out.print("\n");
		}
		
	
		while (!openCav.isEmpty()) {  //A star loop
			//Cavern l = openCav.get(fscore.(Need to get key with lowest fscore value));

			Double lowestvalue = 100000000000000000000.0;
			
			for (Cavern iteration: openCav) { //Iterate through every object in openCav
				for (Map.Entry<Cavern, Double> entry: fscore.entrySet()) {//iterate through every object in fscore
					
					Cavern key = entry.getKey();
					Double value = entry.getValue();
					
					if (iteration==key) { //if the value from openCav is contained in fscore, compare and set it to be that if it's lower
						if (lowestvalue>value) {
							
							lowestvalue=value;
							currentNode = key;
							
						}
						
					}
				}
				
			}

			
			
			///HERE
		if (currentNode.equals(goal)) {
				//reconstruct_Path(cameFrom, currentNode);
				//System.out.print("FINAL PATH: " + reconstruct_Path(cameFrom, currentNode) + "\nTotal distance: " + totalDistance );
				success = true;
				break;
			}
		else {
			//System.out.print("\n" + "There is no path");
		}
			
			openCav.remove(currentNode);
			closedCav.add(currentNode);
			
			for (Cavern neighbor: currentNode.getNeighboor()) {
				if (closedCav.contains(neighbor)) {
					continue; //Ignore the already evaluated neighbour
				}
				
				double tentative_gScore = gscore.get(currentNode) + Euclidian_Distance(currentNode, neighbor);
				
				if (!openCav.contains(neighbor)) { //Discover a new node
					openCav.add(neighbor);
				}
				else if (tentative_gScore>=gscore.get(neighbor)) {
					continue;
				}
				
				cameFrom.put(neighbor, currentNode);
				gscore.put(neighbor, tentative_gScore);
				fscore.put(neighbor, gscore.get(neighbor)+Euclidian_Distance(neighbor, goal));
				
			}
			
		}
		
		if (success) {
			
			//Calculate the total distance of the path travelled
			for (int j=0; j<reconstruct_Path(cameFrom, currentNode).size()-1;j++) {
				totalDistance += Euclidian_Distance(reconstruct_Path(cameFrom, currentNode).get(j), reconstruct_Path(cameFrom, currentNode).get(j+1));
			}
			
			lEndTime = new Date().getTime();
			long difference = lEndTime - lStartTime;
			
			
			//Print out final path
			//System.out.print("FINAL PATH: " + reconstruct_Path(cameFrom, currentNode) + "\nTotal distance: " + totalDistance +"\nElapsed milliseconds: " + difference );
			System.out.print("\n" + "Path Succesfully found" + "\nTotal distance: " + totalDistance +"\nElapsed milliseconds: " + difference + "\n");
			
			outputfile = new FileWriter(new File(filePath));
			for (int i=0; i<reconstruct_Path(cameFrom, currentNode).size(); i++) {
				Cavern test = reconstruct_Path(cameFrom, currentNode).get(i);
				outputfile.append(test.toString() + " ");
			}
			
			outputfile.close();
		}
		else {
			lEndTime = new Date().getTime();
			long difference = lEndTime - lStartTime;
			System.out.print("\n" + "There is no path"+"\nElapsed milliseconds: " + difference + "\n");
			outputfile = new FileWriter(new File(filePath));
			outputfile.append("0");
			outputfile.close();
		}
		

	}

}
