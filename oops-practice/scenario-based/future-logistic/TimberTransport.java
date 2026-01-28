public class TimberTransport extends GoodsTransport {

    private static final double PI = 3.147;

    private float timberLength;
    private float timberRadius;
    private String timberType;
    private float timberPrice;

    public TimberTransport(String transportId, String transportDate, int transportRating,
                           float timberLength, float timberRadius,
                           String timberType, float timberPrice) {
        super(transportId, transportDate, transportRating);
        this.timberLength = timberLength;
        this.timberRadius = timberRadius;
        this.timberType = timberType;
        this.timberPrice = timberPrice;
    }

    public float getTimberLength() {
        return timberLength;
    }

    public void setTimberLength(float timberLength) {
        this.timberLength = timberLength;
    }

    public float getTimberRadius() {
        return timberRadius;
    }

    public void setTimberRadius(float timberRadius) {
        this.timberRadius = timberRadius;
    }

    public String getTimberType() {
        return timberType;
    }

    public void setTimberType(String timberType) {
        this.timberType = timberType;
    }

    public float getTimberPrice() {
        return timberPrice;
    }

    public void setTimberPrice(float timberPrice) {
        this.timberPrice = timberPrice;
    }

    @Override
    public String vehicleSelection() {
        double area = 2 * PI * timberRadius * timberLength;

        if (area < 250)
            return "Truck";
        else if (area <= 400)
            return "Lorry";
        else
            return "MonsterLorry";
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

    public double getTimberRate() {
        if (timberType.equalsIgnoreCase("Premium"))
            return 0.25;
        else if (timberType.equalsIgnoreCase("NonPremium"))
            return 0.15;
        else
            return 0;
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

        double volume = PI * timberRadius * timberRadius * timberLength;
        double price = volume * timberPrice * getTimberRate();
        double tax = price * 0.30;
        double discount = getDiscount(price);
        int vehicleCost = vehiclePrice(vehicleSelection());

        return (float) ((price + tax + vehicleCost) - discount);
    }
}
