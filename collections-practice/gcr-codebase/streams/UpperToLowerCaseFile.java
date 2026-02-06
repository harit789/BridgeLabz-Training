import java.io.*;

public class UpperToLowerFilter {

    public static void main(String[] args) {

        String inputFile = "input.txt";
        String outputFile = "output.txt";

        try (
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));

            BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"))
        ) {

            String line;

            while ((line = br.readLine()) != null) {
                bw.write(line.toLowerCase());
                bw.newLine();
            }

            System.out.println("File converted successfully.");

        } catch (IOException e) {
            System.out.println("File processing error: " + e.getMessage());
        }
    }
}
