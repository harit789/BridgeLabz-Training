package reviews;


class InvalidAgeException extends Exception {

    public InvalidAgeException(String message) {
        super(message);
    }
}

public class CustomException {

    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Invalid Age for Voting");
        } else {
            System.out.println("You can vote");
        }
    }
    
    public static void main(String args[]) {
        try {
            checkAge(17);
        } catch (InvalidAgeException e) {
            System.out.println("Exception : " + e.getMessage());
        }
    }
}
