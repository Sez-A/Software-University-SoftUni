package CompanyRoster;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());

        Map<String, List<Employee>> departments = new HashMap<>();

        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split("\\s+");

            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String departmentName = input[3];

            Employee employee = null;
            switch (input.length) {
                case 4:
                    employee = new Employee(name, salary, position, departmentName);
                    break;
                case 5:
                    try {
                        int age = Integer.parseInt(input[4]);
                        employee = new Employee(name, salary, position, departmentName, age);
                    } catch (NumberFormatException e) {
                        String email = input[4];
                        employee = new Employee(name, salary, position, departmentName, email);
                    }
                    break;
                default:
                    String email = input[4];
                    int age = Integer.parseInt(input[5]);
                    employee = new Employee(name, salary, position, departmentName, email, age);
                    employees.add(employee);
                    break;
            }
            if (departments.containsKey(departmentName)) {
                List<Employee> workers = departments.get(departmentName);
                workers.add(employee);
                departments.put(departmentName, workers);
            } else {
                List<Employee> employeeList = new ArrayList<>();
                employeeList.add(employee);
                departments.put(departmentName, employeeList);
            }
        }

        double highestSalaries = 0;
        String highestPaidName = "";

        for (Map.Entry<String, List<Employee>> entry : departments.entrySet()) {
            List<Employee> employeeList = entry.getValue();
            double sum = 0;
            for (Employee employee : employeeList) {
                sum += employee.getSalary();
            }

            if (sum > highestSalaries) {
                highestSalaries = sum;
                highestPaidName = entry.getKey();
            }
        }


        for (Map.Entry<String, List<Employee>> en : departments.entrySet()) {
            if (en.getKey().equals(highestPaidName)) {
                System.out.println(String.format("Highest Average Salary: %s", highestPaidName));
                List<Employee> employeeList = departments.get(highestPaidName);
                List<Employee> collect = employeeList
                        .stream()
                        .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                        .collect(Collectors.toList());
                for (Employee employee : collect) {
                    System.out.println(String.format("%s %.2f %s %d"
                            ,employee.getName()
                            ,employee.getSalary()
                            ,employee.getEmail()
                            ,employee.getAge()));

                }
                return;
            }
        }
    }
}
