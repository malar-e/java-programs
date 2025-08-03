public class HighCohesionLowCoupling {
    public static void main(String[] args) {
        Employee emp = new Employee("Malar", "malar@example.com", 25000, 5000);

        SalaryCalculator salaryCalculator = new SalaryCalculator();
        double salary = salaryCalculator.calculate(emp);
        System.out.println("Salary: " + salary);

        DatabaseService dbService = new DatabaseService();
        dbService.save(emp);

        EmailService emailService = new EmailService();
        emailService.send(emp.getEmail(), "Your payslip is ready.");
    }
}


class SalaryCalculator {
    public double calculate(Employee emp) {
        return emp.getBasic() + emp.getAllowance();
    }
}

class DatabaseService {
    public void save(Employee emp) {
        System.out.println("Saving to DB: " + emp.getName());
    }
}

class EmailService {
    public void send(String email, String message) {
        System.out.println("Sending email to: " + email + " - " + message);
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
