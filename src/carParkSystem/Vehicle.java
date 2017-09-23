package carParkSystem;

import java.util.Scanner;

public  abstract class Vehicle {
	
	

	Scanner input = new Scanner(System.in);
	
	private String id;
	private String brand;
	private String type;
	private String date;
	private String time;
	private String endDate;
	private String endtime;
	
	
	abstract void getVehicleID();
	
	abstract void getVehicleBrand();
	
	void numberOfDoors(){}
	
	void colour(){}
	
	void cargoVolume(){}
	
	 void engineSize(){}
	
	
	
	/* ---------------------------- getters and setters ------------------------------------*/
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	
}
