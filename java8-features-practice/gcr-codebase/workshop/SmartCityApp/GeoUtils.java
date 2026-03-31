public interface GeoUtils {

    static double calculateDistance(String departure, String destination) {

        if (departure.equalsIgnoreCase("Delhi") && destination.equalsIgnoreCase("Manali")) {
            return 500;
        } else if (departure.equalsIgnoreCase("Delhi") && destination.equalsIgnoreCase("Kasol")) {
            return 650;
        } else if (departure.equalsIgnoreCase("Delhi") && destination.equalsIgnoreCase("Kullu")) {
            return 800;
        } else {
            return 100;
        }
    }
}
