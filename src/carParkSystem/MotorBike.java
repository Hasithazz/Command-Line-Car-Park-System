package carParkSystem;

public class MotorBike extends Vehicle {

	private int engineSize;
	@Override
	void getVehicleID() {
		// TODO Auto-generated method stub
		System.out.print("Enter Vehicle ID : - ");
		setId(input.next());
		System.out.println();
				
	}

	@Override
	void getVehicleBrand() {
		// TODO Auto-generated method stub
		System.out.print("Enter Vehicle Brand : - ");
		setBrand(input.next());
		System.out.println();
		
	}
	
	void engineSize(){
		
			System.out.print("Engine Size : - ");
			setEngineSize(input.nextInt());
		
		
	}
	
	
	/* ---------------------------- getters and setters ------------------------------------*/
	

	public int getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(int engineSize) {
		this.engineSize = engineSize;
	}

}
