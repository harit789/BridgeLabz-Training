import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Utility utility = new Utility();

		System.out.println("Enter the transport details:");
		String input = sc.nextLine();

		GoodsTransport goodsTransport = utility.parseDetails(input);

		if (goodsTransport == null) {
			return;
		}

		String objectType = utility.findObjectType(goodsTransport);

		System.out.println("Transport Id: " + goodsTransport.getTransportId());
		System.out.println("Transport Date: " + goodsTransport.getTransportDate());
		System.out.println("Transport Rating: " + goodsTransport.getTransportRating());
		System.out.println("Transport Type: " + objectType);
		System.out.println("Vehicle Used: " + goodsTransport.vehicleSelection());
		System.out.println("Total Charge: " + goodsTransport.calculateTotalCharge());

	}
}
