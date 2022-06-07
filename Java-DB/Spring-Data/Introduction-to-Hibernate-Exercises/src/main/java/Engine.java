import entities.*;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Engine implements Runnable {
    private final EntityManager entityManager;
    private BufferedReader reader;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        System.out.print("Please select exercise number: ");
        try {
            int exNum = Integer.parseInt(reader.readLine());
            switch (exNum) {
                case 2 -> changeCasingExTwo();
                case 3 -> containsEmployeeExThree();
                case 4 -> employeeWithSalaryExFour();
                case 5 -> employeesFromDepartmentExFive();
                case 6 -> addNewAddressExSix();
                case 7 -> addressWithEmplCntExSeven();
                case 8 -> employeeWithProjectExEight();
                case 9 -> latestProjectsExNine();
                case 10 -> increaseSalariesExTen();
                case 11 -> findEmplByFirstNameExEleven();
                case 12 -> departmentMaxSalariesExTwelve();
                case 13 -> removeTownExThirteen();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void removeTownExThirteen() throws IOException {
        System.out.print("Please enter town name: ");
        String townName = reader.readLine();

        Town town = entityManager.createQuery("SELECT t FROM Town t " +
                        "WHERE t.name = :target ", Town.class)
                .setParameter("target", townName)
                .getSingleResult();


        int affectedRows = removeAddressesByTownId(town.getId());
        entityManager.getTransaction().begin();
        entityManager.remove(town);
        entityManager.getTransaction().commit();
        System.out.printf("%d address in %s deleted%n", affectedRows, townName);
    }

    private int removeAddressesByTownId(Integer townId) {
        List<Address> addresses = entityManager
                .createQuery("SELECT a FROM Address a " +
                        "WHERE a.town.id = :targetId ", Address.class)
                .setParameter("targetId", townId)
                .getResultList();

        /* TODO: 7.11.2021 г. Case 13 works but we have a problem with self-reference in employee class
            When we try to remove town with name Seattle we have a problem check it and fix it!!!
         */
        entityManager.getTransaction().begin();
        addresses.forEach(entityManager::remove);
        entityManager.getTransaction().commit();
        return addresses.size();
    }

    private void departmentMaxSalariesExTwelve() {
        entityManager.createQuery("SELECT d FROM Department d " +
                        "GROUP BY d.id " +
                        "HAVING MAX(d.manager.salary) NOT BETWEEN 30000 AND 70000 ", Department.class)
                .getResultStream()
                .forEach(department -> {
                    System.out.printf("%s %.2f%n", department.getName(), department.getManager().getSalary());
                });

    }

    private void findEmplByFirstNameExEleven() throws IOException {
        System.out.print("Please enter start string: ");
        String startStr = reader.readLine();
        entityManager.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.firstName LIKE :target ", Employee.class)
                .setParameter("target", startStr + "%")
                .getResultStream()
                .forEach(employee -> {
                    System.out.printf("%s %s - %s - ($%.2f)%n"
                            , employee.getFirstName()
                            , employee.getLastName()
                            , employee.getJobTitle()
                            , employee.getSalary());
                });


    }

    private void increaseSalariesExTen() throws IOException {
        System.out.print("Please enter department ids with delimiter ',' please: ");

        Integer[] targetIds = Arrays.stream(reader.readLine().split(","))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        entityManager.getTransaction().begin();
        entityManager.createQuery("UPDATE Employee e " +
                        "SET e.salary = e.salary + (e.salary * 0.12) " +
                        "WHERE e.department.id IN :target ")
                .setParameter("target", List.of(targetIds))
                .executeUpdate();
        entityManager.getTransaction().commit();

        entityManager.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.id IN :target ", Employee.class)
                .setParameter("target", List.of(targetIds))
                .getResultStream()
                .forEach(employee -> {
                    System.out.printf("%s %s ($%.2f)%n"
                            , employee.getFirstName()
                            , employee.getLastName()
                            , employee.getSalary());
                });
    }

    private void latestProjectsExNine() {
        List<Project> projects = entityManager.createQuery("SELECT p FROM Project p " +
                        "ORDER BY p.startDate DESC ", Project.class)
                .setMaxResults(10)
                .getResultList();

        projects = projects.stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .collect(Collectors.toList());

        for (Project project : projects) {
            System.out.printf("Project name: %s%n", project.getName());
            System.out.printf("        Project Description: %s%n", project.getDescription());
            System.out.printf("        Project Start Date: %s%n", project.getStartDate());
            System.out.printf("        Project Start Date: %s%n", project.getEndDate());

        }
    }

    private void employeeWithProjectExEight() throws IOException {
        System.out.print("Please enter id: ");
        int targetId = Integer.parseInt(reader.readLine());
        Employee employee = entityManager.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.id = :target ", Employee.class)
                .setParameter("target", targetId)
                .getSingleResult();

        System.out.printf("%s %s - %s%n"
                , employee.getFirstName()
                , employee.getLastName()
                , employee.getJobTitle());

        Set<Project> projects = employee.getProjects();
        projects.stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(p -> System.out.printf("      %s%n", p.getName()));

    }

    private void addressWithEmplCntExSeven() {
        entityManager
                .createQuery("SELECT a FROM Address a " +
                        "ORDER BY a.employees.size DESC ", Address.class)
                .setMaxResults(10)
                .getResultStream()
                .forEach(address -> {
                    System.out.printf("%s, %s - %d%n"
                            , address.getText()
                            , address.getTown().getName()
                            , address.getEmployees().size());
                });
    }

    private void addNewAddressExSix() throws IOException {
        System.out.print("Please enter employee last name: ");
        String lastName = reader.readLine();
        System.out.print("Please enter address name: ");
        String addressName = reader.readLine();

        entityManager.getTransaction().begin();
        Address address = addNewAddressInAddresses(addressName);

        Employee employee = entityManager
                .createQuery("SELECT e FROM  Employee e " +
                        "WHERE e.lastName = :l_name ", Employee.class)
                .setParameter("l_name", lastName)
                .setMaxResults(1)
                .getSingleResult();
        employee.setAddress(address);
        entityManager.getTransaction().commit();
    }

    private Address addNewAddressInAddresses(String addressName) {
        Address address = new Address();
        address.setText(addressName);
        entityManager.persist(address);
        return address;
    }

    private void employeesFromDepartmentExFive() throws IOException {
        System.out.print("Please enter department name: ");
        String targetDepartment = reader.readLine();
        entityManager.createQuery("SELECT e FROM Employee e " +
                        "WHERE e.department.name = :target " +
                        "ORDER BY e.salary, e.id ", Employee.class)
                .setParameter("target", targetDepartment)
                .getResultStream()
                .forEach(employee -> {
                    System.out.printf("%s %s from %s - $%.2f%n"
                            , employee.getFirstName()
                            , employee.getLastName()
                            , employee.getDepartment().getName()
                            , employee.getSalary());
                });
    }

    private void employeeWithSalaryExFour() throws IOException {
        System.out.print("Please enter target salary: ");
        BigDecimal targetSalary = BigDecimal.valueOf(Long.parseLong(reader.readLine()));
        entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE e.salary > :target ", Employee.class)
                .setParameter("target", targetSalary)
                .getResultStream()
                .forEach(e -> System.out.println(e.getFirstName()));
    }

    private void containsEmployeeExThree() throws IOException {
        System.out.print("Please enter employee name: ");
        String[] employeeInfo = reader.readLine().split("\\s+");
        String firstName = employeeInfo[0];
        String lastName = employeeInfo[1];
        long result = entityManager.createQuery("SELECT count(e) FROM Employee e " +
                        "WHERE e.firstName = :f_name AND e.lastName = :l_name ", Long.class)
                .setParameter("f_name", firstName)
                .setParameter("l_name", lastName)
                .getSingleResult();

        System.out.println(result == 0L ? "No" : "Yes");
    }

    private void changeCasingExTwo() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("UPDATE Town t " +
                        "SET t.name = upper(t.name) " +
                        "WHERE length(t.name) < 5 ")
                .executeUpdate();
        entityManager.getTransaction().commit();
    }
}
