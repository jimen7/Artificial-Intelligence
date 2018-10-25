import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		List<Cavern> nodelist = new ArrayList<Cavern>();
		
		List<Integer> filelist = new ArrayList<Integer>();
		
		String csvfile = "H:\\Artificial Intelligence\\Coursework\\Artificial-Intelligence\\input1.cav";
		String line = "";
		String splitby = ",";
		
		
		Scanner scanner = new Scanner(new File(csvfile));
		
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
		
		int numberofcaverns = filelist.get(0);
		
		for (int i=1;i<numberofcaverns*2;i=i+2) {
			Cavern node1 = new Cavern(filelist.get(i),filelist.get(i+1)); 
			nodelist.add(node1);
		}
		
		for (Cavern c : nodelist) {
			System.out.print("("+c.getX()+","+c.getY()+")");	
		}
		
		

	}

}
