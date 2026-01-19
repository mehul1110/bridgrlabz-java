import java.util.ArrayList;

/*
 * Problem 6: Hospital, Doctors, and Patients (Association and Communication)
 * Demonstrates association and communication between doctors and patients
 */

// Patient class
class Patient {
    private String name;
    private int age;
    private String ailment;

    public Patient(String name, int age, String ailment) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
    }

    public String getName() {
        return name;
    }

    public String getAilment() {
        return ailment;
    }

    public void displayInfo() {
        System.out.println("  Patient: " + name + ", Age: " + age + ", Ailment: " + ailment);
    }
}

// Doctor class
class Doctor {
    private String name;
    private String specialization;
    private ArrayList<Patient> patients;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    // Communication method
    public void consult(Patient patient) {
        patients.add(patient);
        System.out.println("\n--- Consultation ---");
        System.out.println("Dr. " + name + " (" + specialization + ")");
        System.out.println("Consulting with: " + patient.getName());
        System.out.println("Ailment: " + patient.getAilment());
        System.out.println("Prescription provided");
    }

    public void displayPatients() {
        System.out.println("\nDr. " + name + "'s Patients:");
        for (Patient p : patients) {
            p.displayInfo();
        }
    }

    public String getName() {
        return name;
    }
}

// Hospital class
public class HospitalDoctors {
    private String hospitalName;
    private ArrayList<Doctor> doctors;
    private ArrayList<Patient> patients;

    public HospitalDoctors(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Dr. " + doctor.getName() + " joined " + hospitalName);
    }

    public void registerPatient(Patient patient) {
        patients.add(patient);
        System.out.println(patient.getName() + " registered at " + hospitalName);
    }

    public static void main(String[] args) {
        // Create hospital
        HospitalDoctors hospital = new HospitalDoctors("City Hospital");

        // Create doctors
        Doctor d1 = new Doctor("Smith", "Cardiology");
        Doctor d2 = new Doctor("Johnson", "Neurology");

        // Create patients
        Patient p1 = new Patient("Alice", 45, "Heart Pain");
        Patient p2 = new Patient("Bob", 32, "Headache");
        Patient p3 = new Patient("Carol", 28, "Migraine");

        // Add to hospital
        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        hospital.registerPatient(p1);
        hospital.registerPatient(p2);
        hospital.registerPatient(p3);

        // Doctor-Patient consultations (association and communication)
        d1.consult(p1);
        d2.consult(p2);
        d2.consult(p3);

        // Display doctor's patients
        d2.displayPatients();
    }
}
