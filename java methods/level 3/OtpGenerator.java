import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

/*
 * Program to generate distinct OTPs
 * Ensures generated OTPs are unique
 */
public class OtpGenerator {

    public static String generateOtp(Random r) {
        // Generate random number between 100000 and 999999
        int otp = 100000 + r.nextInt(900000);
        return String.valueOf(otp);
    }

    public static boolean uniqueOtps(String[] arr) {
        // Use HashSet to check uniqueness
        HashSet<String> s = new HashSet<>();
        // Add elements to set
        for (String x : arr) s.add(x);
        // If size of set equals array length, all elements are unique
        return s.size() == arr.length;
    }

    public static void main(String[] args) {
        // Initialize Scanner and Random
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        
        String[] otps = new String[10];
        
        // Generate 10 OTPs
        for (int i = 0; i < 10; i++) otps[i] = generateOtp(r);
        
        // Display OTPs
        System.out.println("Generated OTPs:");
        for (String o : otps) System.out.println(o);
        
        // Check for uniqueness
        System.out.println("All unique? " + uniqueOtps(otps));
        
        // Close Scanner
        sc.close();
    }
}
