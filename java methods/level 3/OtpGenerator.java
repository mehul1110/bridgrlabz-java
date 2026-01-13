import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class OtpGenerator {
    // Q7: generate 6-digit OTP, generate 10 times, ensure uniqueness
    public static String generateOtp(Random r) {
        int otp = 100000 + r.nextInt(900000);
        return String.valueOf(otp);
    }

    public static boolean uniqueOtps(String[] arr) {
        HashSet<String> s = new HashSet<>();
        for (String x : arr) s.add(x);
        return s.size() == arr.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        String[] otps = new String[10];
        for (int i = 0; i < 10; i++) otps[i] = generateOtp(r);
        System.out.println("Generated OTPs:");
        for (String o : otps) System.out.println(o);
        System.out.println("All unique? " + uniqueOtps(otps));
        sc.close();
    }
}
