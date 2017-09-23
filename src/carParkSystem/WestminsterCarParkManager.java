package carParkSystem;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.annotation.processing.FilerException;

public class WestminsterCarParkManager extends DateTime implements CarParkManager  {
	//creating global variables
		Scanner input = new Scanner(System.in);
		ArrayList<Vehicle> Slots = new ArrayList<Vehicle>();
		int choise = 0;
		
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//creating westminsterCarPark manager object
		WestminsterCarParkManager obj = new WestminsterCarParkManager();
		obj.printMainMenu();
		
	}

	@Override
	public void printMainMenu() {
		// TODO Auto-generated method stub
		System.out.println("---------- WESTMINSTER CAR PARK MANAGER ---------\n");
		System.out.println("Add New Vehicle ----------------------------- [1]");
		System.out.println("View Currently Parcked vehicles ------------- [2]");
		System.out.println("Delete Vehicle ------------------------------ [3]");
		System.out.println("Display Statics ----------------------------- [4]");
		System.out.println("Print List ---------------------------------- [5]");
		System.out.print("\n Input : - ");
		
		
		
		
		// handling exceptions and input errors
		try {
			
			choise =input.nextInt();
			
			if(choise==1){
				addnewVehicle();
			}else if(choise==2){
				view();
			}else if(choise==3){
				deleteVehicle();
			}else if (choise==4) {
				displayStatic();
			}else if (choise==5) {
				printList();
			}else{
					System.err.println("Wrong  User Input Please Enter The Correct Number");
				
				printMainMenu();
			}
				
		} catch (InputMismatchException e) {
			
			System.out.println("Wrong User Input Please Enter The Correct Number\n");
			
			printMainMenu();
		}
		
			
	}



	@Override
	public void addnewVehicle() {
		
		System.out.println(" Input Vehical Type : - ");
		
		String type = input.next();
		
		
		//checking for empty slots
		if (type.equalsIgnoreCase("car")&& Slots.size()<20) {
			
			System.out.println(" Input Entry date : - ");
			
			String entrydate = input.next();
			
			System.out.println(" Input Entry Time : - ");
			
			String entryTime = input.next();
			//set vehicle details 
			Vehicle vehicleObj = new Car();
			vehicleObj.setType(type);
			vehicleObj.setDate(entrydate);
			vehicleObj.setTime(entryTime);
			vehicleObj.getVehicleID();
			vehicleObj.getVehicleBrand();
			vehicleObj.numberOfDoors();
			vehicleObj.colour();
			//add vehicle to the array list
			Slots.add(vehicleObj);
			
			String all = (vehicleObj.getDate()+":"+vehicleObj.getTime()+":"+vehicleObj.getType()+":"+vehicleObj.getId());
			WriterAndReader WnRobj = new WriterAndReader();
			//call write method to save data to a txt file
			WnRobj.Writter(all);
			System.out.println("Back to main menu -----------------------> [0] \n");
			if(input.nextInt()==0)
			printMainMenu();
			
		}else if (type.equalsIgnoreCase("van")&& Slots.size()<19) {// van takes 2 slots 
			
			System.out.println(" Input Entry date : - ");
			
			String entrydate = input.next();
			
			System.out.println(" Input Entry Time : - ");
			
			String entryTime = input.next();
			
			Vehicle vehicleObj = new Van();
			vehicleObj.setType(type);
			vehicleObj.setDate(entrydate);
			vehicleObj.setTime(entryTime);
			vehicleObj.getVehicleID();
			vehicleObj.getVehicleBrand();
			vehicleObj.cargoVolume();
			
			
			//van uses 2 slots so add van object 2 times to the array list
			Slots.add(vehicleObj);
			Slots.add(vehicleObj);
			
			String all = (vehicleObj.getDate()+":"+vehicleObj.getTime()+":"+vehicleObj.getType()+":"+vehicleObj.getId());
			WriterAndReader WnRobj = new WriterAndReader();
			
			WnRobj.Writter(all);
			WnRobj.Writter(all);
			
			System.out.println("Back to main menu -----------------------> [0] \n");
			if(input.nextInt()==0)
			printMainMenu();
			
		}else if ((type.equalsIgnoreCase("bike")||type.equalsIgnoreCase("motorbike"))&& Slots.size()<20) {
			
			Vehicle vehicleObj = new MotorBike();
			
			System.out.println(" Input Entry date : - ");
			
			String entrydate = input.next();
			
			System.out.println(" Input Entry Time : - ");
			
			String entryTime = input.next();
			
			vehicleObj.setType(type);
			vehicleObj.setDate(entrydate);
			vehicleObj.setTime(entryTime);
			vehicleObj.getVehicleID();
			vehicleObj.getVehicleBrand();
			vehicleObj.engineSize();
			
			Slots.add(vehicleObj);
			
			String all = (vehicleObj.getDate()+":"+vehicleObj.getTime()+":"+vehicleObj.getType()+":"+vehicleObj.getId());
			WriterAndReader WnRobj = new WriterAndReader();
			
			WnRobj.Writter(all);
			System.out.println("Back to main menu -----------------------> [0] \n");
			if(input.nextInt()==0)
			printMainMenu();
			
		}else if(Slots.size()>20){
			System.out.println("Sorry Car Park Is Full");
		}else{
			System.out.println("Wrong User Input Please Enter Car Van Bike or Motorbike");
			addnewVehicle();
		}
			
		
		
		
		
	}



	@Override
	public void deleteVehicle() {
		// TODO Auto-generated method stub
		System.out.println(" Input ID to Remove Vehicle : - ");
		String rID = input.next();
		
		
		for (int i = 0; i < Slots.size(); i++) {
			Vehicle obj = Slots.get(i);
			System.out.println(obj.getId());
			//checking to free a parking slot with given vehicle ID
			if (rID.equalsIgnoreCase(obj.getId())) {
				
				if (obj.getType().equalsIgnoreCase("van")) {
					System.out.println("Enter Date : - ");
					Vehicle van = new Van();
					van.setEndDate(input.next());
					System.out.println("Enter Time : - (Please use \"-\" between hours and minutes)");
					van.setEndtime(input.next());
					cost(van.getEndDate(),obj.getDate(),van.getEndtime(),obj.getTime());
					Slots.remove(i);
					Slots.remove(i);
					
				}else if(obj.getType().equalsIgnoreCase("car")){
					System.out.println("Enter Date : - ");
					Vehicle car = new Car();
					car.setEndDate(input.next());
					System.out.println("Enter Time : - ");
					car.setEndtime(input.next());
					cost(car.getEndDate(),obj.getDate(),car.getEndtime(),obj.getTime());
					Slots.remove(i);
				}else{
					System.out.println("Enter Date : - ");
					Vehicle bike = new MotorBike();
					bike.setEndDate(input.next());
					System.out.println("Enter Time : - ");
					bike.setEndtime(input.next());
					cost(bike.getEndDate(),obj.getDate(),bike.getEndtime(),obj.getTime());
					Slots.remove(i);
				}
					
				
			}else{
				System.out.println(" No ID match --------------------------->");
			}
		}
		
		System.out.println("Back to main menu -----------------------> [0] \n");
		if(input.nextInt()==0)
		printMainMenu();
		
	}



	@Override
	public void view() {
		
		// TODO Auto-generated method stub
		if (Slots.size()==0) {
			System.out.println("No Vehicle Parked yet --------------------------->");
			System.out.println("Back to main menu -----------------------> [0] \n");
			if(input.nextInt()==0)
			printMainMenu();
		} else {
			for (int i = 0; i < Slots.size(); i++) {
				Vehicle obj = Slots.get(i);
				System.out.println("Date - "+obj.getDate()+" Time - "+obj.getTime()+" Type - "+obj.getType()+" ID - "+obj.getId());
				System.out.println();
				
			}
			
		}
		
		System.out.println("Back to main menu -----------------------> [0] \n");
		if(input.nextInt()==0)
		printMainMenu();
		
	}



	@Override
	public void displayStatic() {
		// TODO Auto-generated method stub
		String type;
		float nOfvans=0;
		float nOfCars=0;
		float nOfBikes=0;
		float total=0;
		
		for (int i = 0; i < Slots.size(); i++) {
			Vehicle obj = Slots.get(i);
			type=obj.getType();
			System.out.println(type);
			if(type.equalsIgnoreCase("car")){
				nOfCars++;
			}else if(type.equalsIgnoreCase("van"))
				nOfvans++;
			else if (type.equalsIgnoreCase("bike")||type.equalsIgnoreCase("motorbike")) {
				nOfBikes++;
			}
			
		}
		total = nOfBikes+nOfCars+nOfvans;
		System.out.println("Car Precentage = "+((nOfCars/total)*100)+"%");
		System.out.println("Van Precentage = "+((nOfvans/total)*100)+"%");
		System.out.println("Motorbike Precentage = "+((nOfBikes/total)*100)+"%");
		
		System.out.println("Back to main menu -----------------------> [0] \n");
		if(input.nextInt()==0)
		printMainMenu();
		
		
	}



	@Override
	public void printList() {
		// TODO Auto-generated method stub
		System.out.println(" Input date : - ");
		String specifiedDate = input.next();
		WriterAndReader obj = new WriterAndReader();// create object of Writer and reader class
		obj.Reader(specifiedDate);//pass the given date 
		
		System.out.println("Back to main menu -----------------------> [0] \n");
		if(input.nextInt()==0)
		printMainMenu();
		
		
	}
	

	
	
}
