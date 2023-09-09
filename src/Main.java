public class Main {
    static Employee[] employees = new Employee[10];

    public static void addEmployee(Employee newEmployee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                break;
            } else if (employees[i] == employees[employees.length - 1]) {
                System.out.println("База данных работников переполнена.");
            }
        }
    }

    public static void getAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) System.out.println(employee);
        }
    }

    public static double expensesSalary() {
        double expences = 0.0;
        for (Employee employee : employees) {
            if (employee != null) {
                expences += employee.getSalary();
            }
        }
        return expences;
    }

    public static Employee minSalaryEmployee() {
        double minSalary = 0.0;
        int index = 0;
        int k = 1;
        // looking for first non empty cell in employees
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                minSalary = employees[i].getSalary();
                index = i;
                break;
            }
        }
        // looking for index of desired cell in employees
        for (int j = 1; j < employees.length; j++) {
            if (employees[j] != null && minSalary >= employees[j].getSalary()) {
                if (minSalary == employees[j].getSalary()) k++;
                minSalary = employees[j].getSalary();
                index = j;
            }
        }
        // alert message
        if (k > 1) {
            System.out.printf("ВНИМАНИЕ! В базе данных обнаружено %d сотрудников с минимальной зарплатой %.2f руб. \n", k, employees[index].getSalary());
        }
        return employees[index];
    }

    public static Employee maxSalaryEmployee() {
        double maxSalary = 0.0;
        int index = 0;
        int k = 1;
        // looking for first non empty cell in employees
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                maxSalary = employees[i].getSalary();
                index = i;
                break;
            }
        }
        // looking for index of desired cell in employees
        for (int j = 1; j < employees.length; j++) {
            if (employees[j] != null && maxSalary <= employees[j].getSalary()) {
                if (maxSalary == employees[j].getSalary()) k++;
                maxSalary = employees[j].getSalary();
                index = j;
            }
        }
        // alert message
        if (k > 1) {
            System.out.printf("ВНИМАНИЕ! В базе данных обнаружено %d сотрудников с максимальной зарплатой %.2f руб. \n", k, employees[index].getSalary());
        }
        return employees[index];
    }

    public static double averageSalary() {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }
        return (double) Math.round(expensesSalary() / count * 100) / 100;
    }
    public static void printNames() {
        int comma = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                if(comma != 0) System.out.print(", ");
                System.out.printf("%s %s %s", employee.getLastName(), employee.getFirstName(), employee.getMiddleName());
                comma++;
            }
        }
    }

    public static void main(String[] args) {
        addEmployee(new Employee("Елена", "Петровна", "Иванова", 1, 1000.0));
        addEmployee(new Employee("Геннадий", "Иванович", "Молодец", 2, 1200.33));
        addEmployee(new Employee("Василиса", "Ильинична", "Муромова", 1, 1000.0));
        addEmployee(new Employee("Иван", "Иванович", "Иванов", 2, 1800.33));


        getAllEmployees();
        System.out.printf("Расходы на оплату труда составят %.2f руб.\n", expensesSalary());
        System.out.printf("Сотрудник с минимальной зарплатой - %s.\n", minSalaryEmployee());
        System.out.printf("Сотрудник с максимальной зарплатой - %s.\n", maxSalaryEmployee());
        System.out.printf("Средняя зарплата: %.2f руб.\n", averageSalary());
        printNames();
    }
}
