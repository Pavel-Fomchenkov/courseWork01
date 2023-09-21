public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee("Иванова", "Елена", "Петровна", 1, 1050.0);
        employeeBook.addEmployee("Молодец", "Геннадий", "Иванович", 2, 1100.0);
        employeeBook.addEmployee("Муромова", "Василиса", "Ильинична", 1, 1000.0);
        employeeBook.addEmployee("Иванов", "Иван", "Иванович", 3, 1850.0);
        employeeBook.addEmployee("Воробьев", "Евгений", "Карпович", 2, 1200.0);
        employeeBook.addEmployee("Толстой", "Лев", "Николаевич", 4, 1800.0);
        employeeBook.addEmployee("Весёлый", "Алексей", "Алексеевич", 5, 1400.0);
        employeeBook.addEmployee("Петров", "Пётр", "Петрович", 2, 1400.0);

        employeeBook.printEmployees();
        System.out.printf("Расходы на оплату труда составят %.2f руб.\n", employeeBook.expensesSalary());
        System.out.printf("Сотрудник с минимальной зарплатой - %s.\n", employeeBook.minSalaryEmployee());
        System.out.printf("Сотрудник с максимальной зарплатой - %s.\n", employeeBook.maxSalaryEmployee());
        System.out.printf("Средняя зарплата: %.2f руб.\n", employeeBook.averageSalary());
        employeeBook.printNames();
        System.out.println(" ");
        employeeBook.increaseSalary(10);
        employeeBook.printEmployees();
        System.out.printf("Сотрудник с минимальной зарплатой в отделе 2 - %s.\n", employeeBook.minSalaryEmployee(2));
        System.out.printf("Сотрудник с максимальной зарплатой в отделе 2 - %s.\n", employeeBook.maxSalaryEmployee(2));
        System.out.println(employeeBook.expensesSalary(2));
        System.out.println(employeeBook.averageSalary(2));
        employeeBook.increaseSalary(10, 2);
        employeeBook.printEmployees(2);
        employeeBook.printEmployees(employeeBook.employeeWithSalaryLowerOrEqualThen(1000.0));
        employeeBook.printEmployees(employeeBook.employeeWithSalaryHigherOrEqualThen(1850.0));
        employeeBook.deleteEmployee(20);
        employeeBook.editEmployee("Муромова", "Василиса", "Ильинична", 5, 2000.0);
        employeeBook.printEmployeesByDepartment();
    }
}
