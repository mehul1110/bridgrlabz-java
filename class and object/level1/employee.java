public class employee {

    private String name;
    private int id;
    private double salary;

    public employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Salary: ₹" + salary);
    }

    public static void main(String[] args) {
        employee emp = new employee("Rahul", 101, 55000);
        emp.displayDetails();
    }
}
