import java.io.*;
import java.util.Arrays;

public class ImageByteArrayDemo {

    public static void main(String[] args) {

        String inputImage = "original.jpg";
        String outputImage = "copy.jpg";

        byte[] imageBytes = null;

        try (
            FileInputStream fis = new FileInputStream(inputImage);
            ByteArrayOutputStream baos = new ByteArrayOutputStream()
        ) {
            int data;
            while ((data = fis.read()) != -1) {
                baos.write(data);
            }

            imageBytes = baos.toByteArray();
            System.out.println("Image converted to byte array.");

        } catch (IOException e) {
            System.out.println("Error reading image: " + e.getMessage());
            return;
        }

        try (
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(outputImage)
        ) {
            int data;
            while ((data = bais.read()) != -1) {
                fos.write(data);
            }

            System.out.println("Byte array written back to image file.");

        } catch (IOException e) {
            System.out.println("Error writing image: " + e.getMessage());
            return;
        }

        // 🔹 Step 3: Verify both files are identical
        try {
            byte[] originalBytes = readAllBytes(inputImage);
            byte[] copiedBytes = readAllBytes(outputImage);

            if (Arrays.equals(originalBytes, copiedBytes)) {
                System.out.println("Verification successful: Images are identical.");
            } else {
                System.out.println("Verification failed: Images are different.");
            }

        } catch (IOException e) {
            System.out.println("Verification error: " + e.getMessage());
        }
    }

    private static byte[] readAllBytes(String fileName) throws IOException {
        try (FileInputStream fis = new FileInputStream(fileName);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            int data;
            while ((data = fis.read()) != -1) {
                baos.write(data);
            }
            return baos.toByteArray();
        }
    }
}
