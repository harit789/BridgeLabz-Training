import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class ValidateData {
	public static void main(String args[]) {
		int row = 0;
		try(BufferedReader br = new BufferedReader(new FileReader("data.csv"))){
			String line;
			while((line = br.readLine()) != null) {
				row++;
				String[] columns = line.split(",");
				String email = columns[2].trim();
				String phone = columns[3].trim();
				
				boolean emailValid = validateEmail(email);
				boolean phoneValid = isPhoneNumber(phone);
				
			    if (!emailValid || !phoneValid) {
                    System.out.println("Invalid row at line " + row + ": " + line);

                    if (!emailValid) {
                        System.out.println("  ❌ Invalid Email: " + email);
                    }
                    if (!phoneValid) {
                        System.out.println("  ❌ Invalid Phone Number: " + phone);
                    }
                }
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public static boolean isPhoneNumber(String str) {
		String regex = "[0-9]{10}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		boolean isValid = matcher.matches();
		return isValid;
	}
	public static boolean validateEmail(String str) {
		String regex = "^[a-zA-Z0-9]+@gmail.com$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		boolean isValid = matcher.matches();
		return isValid;
	}
}
