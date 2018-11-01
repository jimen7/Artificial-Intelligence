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
		
		List<Cavern> cavernlist = new ArrayList<Cavern>();
		
		List<Integer> filelist = new ArrayList<Integer>();
		
		//String csvfile = "H:\\Artificial Intelligence\\Coursework\\Artificial-Intelligence\\input1.cav";
		String csvfile = "C:\\Users\\Dimitris\\Desktop\\Artificial Intelligence\\Coursework\\Artificial-Intelligence\\input1.cav";
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
		
		
		//To get location of caverns:
		for (int i=1;i<numberofcaverns*2;i=i+2) {
			Cavern node1 = new Cavern(filelist.get(i),filelist.get(i+1)); 
			cavernlist.add(node1);
		}
		
		
		int tmp=0;
		int loopcavern=0;
		
		
		for (int i=0; i < cavernlist.size(); i=i++) {
			Cavern c = cavernlist.get(tmp);
			
			if (filelist.get(loopcavern)+tmp*numberofcaverns == 1) {
				c.getNeighboor().add(cavernlist.get(loopcavern));
			}
			loopcavern++;
			
			if (loopcavern==numberofcaverns) {
				loopcavern=0;
				tmp++;
			}
		}
		
		
		
		
		
		
		
		//To get paths for each cavern, i starts where the coordinates for the caverns finish and goes until the end of the filelist
		for (int i=numberofcaverns*2+1; i<filelist.size(); i++) {
			
		}
		
		
		
		for (Cavern c : cavernlist) {
			//System.out.print("("+c.getX()+","+c.getY()+")");
		}
		
		
		for (int i=0; i<numberofcaverns; i++) {
			//System.out.print(cav);
			System.out.print(cavernlist.get(i).getNeighboor().size() + "NEXT:");

		}
		
		

	}

}
