package carParkSystem;

public class Van extends Vehicle{

	private int cargoVolume;
	
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
	
	void cargoVolume(){
		System.out.print("Cargo Volume : - ");
		setCargoVolume(input.nextInt());
		System.out.println();
	}
	
	
	/* ---------------------------- getters and setters ------------------------------------*/
	
	
	public int getCargoVolume() {
		return cargoVolume;
	}

	public void setCargoVolume(int cargoVolume) {
		this.cargoVolume = cargoVolume;
	}

}
