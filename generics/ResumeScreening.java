package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * AI-Driven Resume Screening System.
 * Demonstrates Generic Classes, Generic Methods, Bounded Type Parameters, and
 * Wildcards.
 */
public class ResumeScreening {

    public static void main(String[] args) {
        // Create resumes for different roles
        Resume<SoftwareEngineer> devResume = new Resume<>("Alice", new SoftwareEngineer());
        Resume<DataScientist> dataResume = new Resume<>("Bob", new DataScientist());
        Resume<ProductManager> pmResume = new Resume<>("Charlie", new ProductManager());

        // List of resumes (using wildcard for generic type)
        List<Resume<? extends JobRole>> resumeQueue = new ArrayList<>();
        resumeQueue.add(devResume);
        resumeQueue.add(dataResume);
        resumeQueue.add(pmResume);

        System.out.println("--- Resume Screening Pipeline ---");
        screenResumes(resumeQueue);
    }

    /**
     * Method to screen a list of resumes.
     * Uses wildcard to accept a list of Resumes for any JobRole subclass.
     *
     * @param resumes List of resumes to process.
     */
    public static void screenResumes(List<Resume<? extends JobRole>> resumes) {
        for (Resume<? extends JobRole> resume : resumes) {
            resume.processResume();
            // Simulating AI Analysis
            System.out.println("AI Analysis: Match found for " + resume.getJobRole().getRoleName());
            System.out.println("-------------------------------");
        }
    }
}

/**
 * Abstract class representing a Job Role.
 */
abstract class JobRole {
    private String roleName;

    public JobRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    @Override
    public String toString() {
        return roleName;
    }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() {
        super("Software Engineer");
    }
}

class DataScientist extends JobRole {
    public DataScientist() {
        super("Data Scientist");
    }
}

class ProductManager extends JobRole {
    public ProductManager() {
        super("Product Manager");
    }
}

/**
 * Generic class representing a Resume for a specific job role.
 *
 * @param <T> The job role this resume is targeting.
 */
class Resume<T extends JobRole> {
    private String candidateName;
    private T jobRole;

    public Resume(String candidateName, T jobRole) {
        this.candidateName = candidateName;
        this.jobRole = jobRole;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public T getJobRole() {
        return jobRole;
    }

    public void processResume() {
        System.out.println("Processing resume for: " + candidateName + " applied for " + jobRole);
    }
}
