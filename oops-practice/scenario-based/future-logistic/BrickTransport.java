public class BrickTransport extends GoodsTransport {

    private float brickSize;
    private int brickQuantity;
    private float brickPrice;

    public BrickTransport(String transportId, String transportDate, int transportRating,
                          float brickSize, int brickQuantity, float brickPrice) {
        super(transportId, transportDate, transportRating);
        this.brickSize = brickSize;
        this.brickQuantity = brickQuantity;
        this.brickPrice = brickPrice;
    }

    public float getBrickSize() {
        return brickSize;
    }

    public void setBrickSize(float brickSize) {
        this.brickSize = brickSize;
    }

    public int getBrickQuantity() {
        return brickQuantity;
    }

    public void setBrickQuantity(int brickQuantity) {
        this.brickQuantity = brickQuantity;
    }

    public float getBrickPrice() {
        return brickPrice;
    }

    public void setBrickPrice(float brickPrice) {
        this.brickPrice = brickPrice;
    }

    public int vehiclePrice(String vehicle) {
        if (vehicle.equalsIgnoreCase("Truck"))
            return 1000;
        else if (vehicle.equalsIgnoreCase("Lorry"))
            return 1700;
        else if (vehicle.equalsIgnoreCase("MonsterLorry"))
            return 3000;
        else
            return 0;
    }

    @Override
    public String vehicleSelection() {
        if (brickQuantity < 300)
            return "Truck";
        else if (brickQuantity <= 500)
            return "Lorry";
        else
            return "MonsterLorry";
    }

    public double getDiscount(double price) {
        if (getTransportRating() == 5)
            return price * 0.20;
        else if (getTransportRating() == 3 || getTransportRating() == 4)
            return price * 0.10;
        else
            return 0;
    }

    @Override
    public float calculateTotalCharge() {
        double price = brickPrice * brickQuantity;
        double tax = price * 0.30;
        int vehicleCost = vehiclePrice(vehicleSelection());
        double discount = getDiscount(price);

        return (float) ((price + tax + vehicleCost) - discount);
    }
}
