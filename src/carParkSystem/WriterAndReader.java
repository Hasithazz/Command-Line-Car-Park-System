package carParkSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class WriterAndReader {
	
	File file = new File("carpark.txt");
	PrintWriter pw = null;
	FileWriter fw = null;
	Scanner sc = null;
	
	void Writter (String all){
		
		try {
			fw = new FileWriter(file,true);
			pw = new PrintWriter(fw);
			pw.println(all);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			pw.close();
		}
		
	}
	void Reader (String date){
		
		WestminsterCarParkManager obj = new WestminsterCarParkManager();
		
		try {
			
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				String text = sc.nextLine();
				String[] parts= text.split(":");
				if (parts[0].equals(date)) {
					System.out.println("Vehicle Found ----------------->");
					System.out.println("Vehicle Type = "+parts[2]);
					System.out.println("Vehicle ID = "+parts[3]);
				} else {

				}
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
