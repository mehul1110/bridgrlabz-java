import java.util.ArrayList;

/*
 * Problem 7: Hospital Patient Management
 * Demonstrates abstract classes, interfaces, encapsulation, and polymorphism
 */

// Interface
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract class
abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Getters
    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    // Abstract method
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        if (diagnosis != null) {
            System.out.println("Diagnosis: " + diagnosis);
        }
    }
}

// Concrete class 1
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge = 200.0;
    private ArrayList<String> records;

    public InPatient(String patientId, String name, int age, int daysAdmitted) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.records = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
        System.out.println("Record added");
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records:");
        for (String record : records) {
            System.out.println("- " + record);
        }
    }
}

// Concrete class 2
class OutPatient extends Patient implements MedicalRecord {
    private int consultations;
    private double consultationFee = 50.0;
    private ArrayList<String> records;

    public OutPatient(String patientId, String name, int age, int consultations) {
        super(patientId, name, age);
        this.consultations = consultations;
        this.records = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return consultations * consultationFee;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
        System.out.println("Record added");
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records:");
        for (String record : records) {
            System.out.println("- " + record);
        }
    }
}

public class HospitalPatient {
    public static void main(String[] args) {
        ArrayList<Patient> patients = new ArrayList<>();
        
        InPatient inPatient = new InPatient("IP001", "Alice", 45, 5);
        inPatient.setDiagnosis("Pneumonia");
        inPatient.addRecord("Admitted on 2024-01-15");
        inPatient.addRecord("X-ray taken");
        
        OutPatient outPatient = new OutPatient("OP001", "Bob", 32, 3);
        outPatient.setDiagnosis("Fever");
        outPatient.addRecord("Consultation on 2024-01-16");

        patients.add(inPatient);
        patients.add(outPatient);

        // Polymorphism
        System.out.println("=== Patient Billing ===");
        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Bill Amount: $" + patient.calculateBill());
            
            if (patient instanceof MedicalRecord) {
                ((MedicalRecord) patient).viewRecords();
            }
            System.out.println("-------------------------");
        }
    }
}
