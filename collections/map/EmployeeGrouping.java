package collections.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: Group Objects by Property
 * Given a list of Employee objects, group them by their department using a
 * Map<Department, List<Employee>>.
 * Example: Employees: [Alice (HR), Bob (IT), Carol (HR)] -> Output: HR: [Alice,
 * Carol], IT: [Bob].
 */
public class EmployeeGrouping {

    static class Employee {
        String name;
        String department;

        public Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<String, List<Employee>> grouped = new HashMap<>();
        for (Employee e : employees) {
            grouped.computeIfAbsent(e.department, k -> new ArrayList<>()).add(e);
        }
        return grouped;
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));

        System.out.println("Grouped by Dept: " + groupByDepartment(employees));
    }
}
