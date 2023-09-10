public class Main {
    static Employee[] employees = new Employee[10];

    public static void addEmployee(String lastName, String firstName, String middleName, int department, double salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(firstName, middleName, lastName, department, salary);
                break;
            } else if (employees[i] == employees[employees.length - 1]) {
                System.out.println("База данных работников переполнена.");
            }
        }
    }

    public static void deleteEmployee(int id) {
        int i = 0;
        boolean flag = false;
        for (; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getId() == id) {
                flag = true;
                System.out.printf("Работник %s удален. \n", employees[i]);
                break;
            }
        }
        if (flag) {
            for (; i < employees.length && employees[i] != null; i++) {
                if (i == employees.length - 1) {
                    employees[i] = null;
                    return;
                } else employees[i] = employees[i + 1];
            }
            return;
        }
        System.out.printf("Работник c id: %d не найден.\n", id);
    }

    public static void editEmployee(String lastName, String firstName, String middleName, int newDepartment, double newSalary) {
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            } else if (employee.getLastName().equals(lastName) && employee.getFirstName().equals(firstName) &&
            employee.getMiddleName().equals(middleName)){
            employee.setDepartment(newDepartment);
            employee.setSalary(newSalary);
                System.out.printf("Данные сотрудника изменены на %s \n", employee);
                return;
            }
        }
        System.out.println("Введены неверные данные");
    }


    public static void printEmployees() {
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            } else System.out.println(employee);
        }
    }

    public static void printEmployees(int department) {
        boolean hasEmployee = false;
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            } else if (employee.getDepartment() == department) {
                hasEmployee = true;
                System.out.printf("id: %d - %s %s %s, оклад: %.2f\n",
                        employee.getId(), employee.getLastName(), employee.getFirstName(), employee.getMiddleName(), employee.getSalary());
            }
        }
        if (!hasEmployee) System.out.printf("Работники из отдела %d не найдены.\n", department);
    }

    public static void printEmployees(Employee... employees) {
        if (employees.length == 0) System.out.println("нет данных");
        if (employees.length > 0) {
            for (Employee e : employees) System.out.println(e);
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

    public static double expensesSalary(int department) {
        double expences = 0.0;
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            } else if (employee.getDepartment() == department) {
                expences += employee.getSalary();
            }
        }
        return expences;
    }


    public static Employee minSalaryEmployee() {
        double minSalary = employees[0].getSalary();
        int index = 0;
        int k = 0;
        for (int i = 1; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            } else if (minSalary > employees[i].getSalary()) {
                minSalary = employees[i].getSalary();
                index = i;
            }
        }
        for (Employee employee : employees) {
            if (employee == null) break;
            if (employee.getSalary() == minSalary) k++;
        }
        if (k > 1) {
            System.out.printf("ВНИМАНИЕ! В базе данных обнаружено %d сотрудников с минимальной зарплатой %.2f руб. \n", k, employees[index].getSalary());
        }
        return employees[index];
    }

    public static Employee minSalaryEmployee(int department) {
        double minSalary = 0.0;
        int index = 1;
        int k = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            } else if (employees[i].getDepartment() == department && (minSalary > employees[i].getSalary() || minSalary == 0.0)) {
                minSalary = employees[i].getSalary();
                index = i;
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) break;
            if (employees[i].getDepartment() == department && employees[i].getSalary() == minSalary) k++;
        }
        if (k > 1) {
            System.out.printf("ВНИМАНИЕ! В отделе %d обнаружено %d сотрудников с минимальной зарплатой %.2f руб. \n", department, k, employees[index].getSalary());
        }
        return employees[index];
    }


    public static Employee maxSalaryEmployee() {
        double maxSalary = employees[0].getSalary();
        int index = 0;
        int k = 0;
        for (int i = 1; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            } else if (maxSalary < employees[i].getSalary()) {
                maxSalary = employees[i].getSalary();
                index = i;
            }
        }
        for (Employee employee : employees) {
            if (employee == null) break;
            if (employee.getSalary() == maxSalary) k++;
        }
        if (k > 1) {
            System.out.printf("ВНИМАНИЕ! В базе данных обнаружено %d сотрудников с максимальной зарплатой %.2f руб. \n", k, employees[index].getSalary());
        }
        return employees[index];
    }

    public static Employee maxSalaryEmployee(int department) {
        double maxSalary = 0.0;
        int index = 0;
        int k = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            } else if (employees[i].getDepartment() == department && maxSalary < employees[i].getSalary()) {
                maxSalary = employees[i].getSalary();
                index = i;
            }
        }
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) break;
            if (employees[i].getDepartment() == department && employees[i].getSalary() == maxSalary) k++;
        }
        if (k > 1) {
            System.out.printf("ВНИМАНИЕ! В отделе %d обнаружено %d сотрудников с максимальной зарплатой %.2f руб. \n", department, k, employees[index].getSalary());
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
        return Math.round(expensesSalary() / count * 100) / 100.0;
    }

    public static double averageSalary(int department) {
        int count = 0;
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            } else if (employee.getDepartment() == department) {
                count++;
            }
        }
        return Math.round(expensesSalary(department) / count * 100) / 100.0;
    }

    public static void printNames() {
        boolean comma = false;
        for (Employee employee : employees) {
            if (employee != null) {
                if (comma) System.out.print(", ");
                System.out.printf("%s %s %s", employee.getLastName(), employee.getFirstName(), employee.getMiddleName());
                comma = true;
            }
        }
    }

    public static void increaseSalary(int percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(Math.round(employee.getSalary() * (100 + percent)) / 100.0);
            }
        }
    }

    public static void increaseSalary(int percent, int department) {
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            } else if (employee.getDepartment() == department) {
                employee.setSalary(Math.round(employee.getSalary() * (100 + percent)) / 100.0);
            }
        }
    }

    public static Employee[] employeeWithSalaryLowerOrEqualThen(double salary) {
        int[] indices = new int[employees.length];
        int indicesLength = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            } else if (employees[i].getSalary() <= salary) {
                indices[indicesLength] = i;
                indicesLength++;
            }
        }
        Employee[] selected = new Employee[indicesLength];
        if (indicesLength == 0) return selected;
        boolean flag = true;
        for (int i = 0; i < indices.length; i++) {
            if (indices.length == 0 || indices[i] == 0 && !flag) break;
            selected[i] = employees[indices[i]];
            flag = false;
        }
        return selected;
    }

    public static Employee[] employeeWithSalaryHigherOrEqualThen(double salary) {
        int[] indices = new int[employees.length];
        int indicesLength = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                break;
            } else if (employees[i].getSalary() >= salary) {
                indices[indicesLength] = i;
                indicesLength++;
            }
        }
        Employee[] selected = new Employee[indicesLength];
        if (indicesLength == 0) return selected;
        boolean flag = true;
        for (int i = 0; i < indices.length; i++) {
            if (indices.length == 0 || indices[i] == 0 && !flag) break;
            selected[i] = employees[indices[i]];
            flag = false;
        }
        return selected;
    }

    public static void main(String[] args) {
        addEmployee("Иванова", "Елена", "Петровна", 1, 1050.0);
        addEmployee("Молодец", "Геннадий", "Иванович", 2, 1100.0);
        addEmployee("Муромова", "Василиса", "Ильинична", 1, 1000.0);
        addEmployee("Иванов", "Иван", "Иванович", 3, 1850.0);
        addEmployee("Воробьев", "Евгений", "Карпович", 2, 1200.0);
        addEmployee("Толстой", "Лев", "Николаевич", 4, 1800.0);
        addEmployee("Весёлый", "Алексей", "Алексеевич", 5, 1400.0);
        addEmployee("Петров", "Пётр", "Петрович", 2, 1400.0);

        printEmployees();
        System.out.printf("Расходы на оплату труда составят %.2f руб.\n", expensesSalary());
        System.out.printf("Сотрудник с минимальной зарплатой - %s.\n", minSalaryEmployee());
        System.out.printf("Сотрудник с максимальной зарплатой - %s.\n", maxSalaryEmployee());
        System.out.printf("Средняя зарплата: %.2f руб.\n", averageSalary());
        printNames();
        System.out.println(" ");
        increaseSalary(10);
        printEmployees();
        System.out.printf("Сотрудник с минимальной зарплатой в отделе 2 - %s.\n", minSalaryEmployee(2));
        System.out.printf("Сотрудник с максимальной зарплатой в отделе 2 - %s.\n", maxSalaryEmployee(2));
        System.out.println(expensesSalary(2));
        System.out.println(averageSalary(2));
        increaseSalary(10, 2);
        printEmployees(2);
        printEmployees(employeeWithSalaryLowerOrEqualThen(1000.0));
        printEmployees(employeeWithSalaryHigherOrEqualThen(1850.0));
        deleteEmployee(20);
        editEmployee("Муромова", "Василиса", "Ильинична", 10, 2000.0);
    }
}
