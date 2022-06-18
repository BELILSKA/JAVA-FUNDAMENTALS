package ObjectsAndClasses.MoreExercises;

import java.util.*;

public class P01CompanyRoster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Employee>> departments = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");

            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];

            Employee employee = new Employee(name,salary,position,department);

            if (data.length == 5) {
                if (data[4].contains("@")) {
                    employee.email = data[4];
                } else {
                    employee.setAge(Integer.parseInt(data[4]));
                }
            } else if (data.length == 6) {
                employee.setEmail(data[4]);
                employee.setAge(Integer.parseInt(data[5]));
            }

            if (!departments.containsKey(department)) {
                departments.put(department, new ArrayList<>());
                departments.get(department).add(employee);
            } else {
                departments.get(department).add(employee);
            }
        }

        departments.entrySet().stream().sorted((a, b) -> {
            double avrFirst = a.getValue().stream().mapToDouble(Employee::getSalary).average().orElse(Double.NaN);
            double avrSecond = b.getValue().stream().mapToDouble(Employee::getSalary).average().orElse(Double.NaN);
            return Double.compare(avrSecond, avrFirst);

        }).limit(1).forEach(e -> {
            System.out.printf("Highest Average Salary: %s%n", e.getKey());
            e.getValue().stream().sorted((a,b) -> Double.compare(b.getSalary(), a.getSalary())).forEach(o -> System.out.println(String.format("%s %.2f %s %d", o.getName(), o.getSalary(), o.getEmail(), o.getAge())));
        });



    }
    static class Employee {
        String name;
        double salary;
        String position;
        String department;
        String email;
        int age;

        public Employee(String name, double salary, String position, String department) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.department = department;
            this.email = "n/a";
            this.age = -1;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public String getEmail() {
            return email;
        }

        public int getAge() {
            return age;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}

