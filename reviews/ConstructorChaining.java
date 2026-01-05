package reviews;

class Vehicle{
	int vehicleId;
	String vehicleModel;
	
	public Vehicle(int vehicleId, String vehicleModel) {
		this.vehicleId  = vehicleId;
		this.vehicleModel = vehicleModel;
	}
	
	public void display() {
		System.out.println("Vehicle Id : " + vehicleId);
		System.out.println("Vahicle Model : " + vehicleModel);
	}
}

class Car extends Vehicle{
	String carName;
	
	public Car(int vehicleId, String vehicleModel, String carName) {
		super(vehicleId, vehicleModel);
		this.carName = carName;
	}
	public void display() {
		super.display();
		System.out.println("Car name : " + carName);
	}
}
public class ConstructorChaining {
	public static void main(String args[]) {
		Vehicle maruti = new Car(101, "maruti", "Maruti800");
		maruti.display();
	}
}
