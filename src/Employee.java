public class Employee {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private static int counter;
    private final int id;
    private int department;
    private double salary;

    public Employee(String firstName, String middleName, String lastName, int department, double salary) {
        id = ++counter;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("id: %d - %s %s %s, отдел %d, оклад: %.2f", id, lastName, firstName, middleName, department, salary);
    }
}
