package carParkSystem;

public class Car extends Vehicle {

	private int doors;
	private String colour;
	
	@Override
	void getVehicleID() {
		// TODO Auto-generated method stub
		System.out.print("Enter Vehicle ID : - ");
		String id = input.next();
		setId(id);
		System.out.println();
				
	}

	@Override
	void getVehicleBrand() {
		// TODO Auto-generated method stub
		System.out.print("Enter Vehicle Brand : - ");
		String brand = input.next();
		setBrand(brand);
		System.out.println();
	}
	
	void numberOfDoors() {
		System.out.print("Number Of Doors : - ");
		int nOd = input.nextInt();
		setDoors(nOd);
		System.out.println();
		
		
	}
	 void colour() {
		System.out.print("Vehicle Colour : - ");
		String colour = input.next();
		 setColour(colour);
		 System.out.println();
		
		
	}

	/* ---------------------------- getters and setters ------------------------------------*/
	 
	 public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	

	
	
}
