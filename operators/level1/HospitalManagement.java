/*
 * Program for Hospital Management System
 * Demonstrates static, this, final, and instanceof keywords
 */
public class HospitalManagement {
    
    // Static variables shared among all patients
    private static String hospitalName = "City General Hospital";
    private static int totalPatients = 0;
    
    // Instance variables
    private String name;
    private int age;
    private String ailment;
    private final String patientID; // Final - unique identifier

    /*
     * Constructor
     * Uses 'this' to initialize instance variables
     */
    public HospitalManagement(String name, int age, String ailment, String patientID) {
        this.name = name; // 'this' resolves ambiguity
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID; // Final variable initialization
        totalPatients++; // Increment static counter
    }

    // Static method to get total patients
    public static int getTotalPatients() {
        return totalPatients;
    }

    // Display patient details
    public void displayDetails() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
        System.out.println("-------------------------");
    }

    // Safe display using instanceof check
    public static void safeDisplay(Object obj) {
        // Check if object is instance of HospitalManagement
        if (obj instanceof HospitalManagement) {
            HospitalManagement patient = (HospitalManagement) obj;
            patient.displayDetails();
        } else {
            System.out.println("Error: Object is not a HospitalManagement instance");
        }
    }

    public static void main(String[] args) {
        // Create patients
        HospitalManagement p1 = new HospitalManagement("John Doe", 45, "Fever", "PAT001");
        HospitalManagement p2 = new HospitalManagement("Jane Smith", 32, "Fracture", "PAT002");
        
        // Display using instanceof check
        System.out.println("--- Patient 1 ---");
        safeDisplay(p1);
        
        System.out.println("--- Patient 2 ---");
        safeDisplay(p2);
        
        // Display total patients
        System.out.println("Total Patients Admitted: " + HospitalManagement.getTotalPatients());
        
        // Test instanceof with invalid object
        System.out.println("\n--- Testing with invalid object ---");
        safeDisplay(new Double(3.14));
    }
}
