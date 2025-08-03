
public class LowCohesionHighCoupling {
    public static void main(String[] args) {
        Employee emp = new Employee("John Doe", "john@example.com", 50000, 5000);
        EmployeeService service = new EmployeeService();
        service.calculateSalary(emp);
        service.saveToDatabase(emp);
        service.sendEmail(emp, "Welcome to the company!");
    }
}


class EmployeeService {
    public void calculateSalary(Employee emp) {
        double salary = emp.getBasic() + emp.getAllowance();
        System.out.println("Salary: " + salary);
    }

    public void saveToDatabase(Employee emp) {
        System.out.println("Saving to DB: " + emp.getName());
    }

    public void sendEmail(Employee emp, String message) {
        System.out.println("Sending email to: " + emp.getEmail() + " - " + message);
    }
}

class Employee {
    private String name;
    private String email;
    private double basic;
    private double allowance;

    public Employee(String name, String email, double basic, double allowance) {
        this.name = name;
        this.email = email;
        this.basic = basic;
        this.allowance = allowance;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public double getBasic() { return basic; }
    public double getAllowance() { return allowance; }
}
