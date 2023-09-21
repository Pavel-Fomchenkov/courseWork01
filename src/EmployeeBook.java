import java.util.Arrays;

public class EmployeeBook {
    private Employee[] employees = new Employee[10];

    // add new employee to database
    public void addEmployee(String lastName, String firstName, String middleName, int department, double salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(firstName, middleName, lastName, department, salary);
                return;
            }
        }
        System.out.println("База данных работников переполнена.");
    }

    // delete employee from database
    public void deleteEmployee(int id) {
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

    // edit employee in DB
    public void editEmployee(String lastName, String firstName, String middleName, int newDepartment,
                             double newSalary) {
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            } else if (employee.getLastName().equals(lastName) && employee.getFirstName().equals(firstName) &&
                    employee.getMiddleName().equals(middleName)) {
                employee.setDepartment(newDepartment);
                employee.setSalary(newSalary);
                System.out.printf("Данные сотрудника изменены на %s \n", employee);
                return;
            }
        }
        System.out.println("Введены неверные данные");
    }

    // prints all employees
    public void printEmployees() {
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            } else System.out.println(employee);
        }
    }

    // prints employees from desired department
    public void printEmployees(int department) {
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

    // prints array of employees
    public void printEmployees(Employee... employees) {
        if (employees.length == 0) System.out.println("нет данных");
        if (employees.length > 0) {
            for (Employee e : employees) System.out.println(e);
        }
    }

    // returns sum of employees salaries
    public double expensesSalary() {
        double expences = 0.0;
        for (Employee employee : employees) {
            if (employee != null) {
                expences += employee.getSalary();
            }
        }
        return expences;
    }

    // returns sum of employee's salaries relative to desired department
    public double expensesSalary(int department) {
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

    // returns employee with minimum salary
    public Employee minSalaryEmployee() {
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

    // returns employee with minimum salary from specified department
    public Employee minSalaryEmployee(int department) {
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

    // returns employee with maximum salary
    public Employee maxSalaryEmployee() {
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

    // returns employee with maximum salary from specified department
    public Employee maxSalaryEmployee(int department) {
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

    // returns average salary
    public double averageSalary() {
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                count++;
            }
        }
        return Math.round(expensesSalary() / count * 100) / 100.0;
    }

    // returns average salary in specified department
    public double averageSalary(int department) {
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

    // prints employees full names only separated by comma inline without line break
    public void printNames() {
        boolean comma = false;
        for (Employee employee : employees) {
            if (employee != null) {
                if (comma) System.out.print(", ");
                System.out.printf("%s %s %s", employee.getLastName(), employee.getFirstName(), employee.getMiddleName());
                comma = true;
            }
        }
    }

    // increase all employee's salaries by specified percent
    public void increaseSalary(int percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(Math.round(employee.getSalary() * (100 + percent)) / 100.0);
            }
        }
    }

    // increase employee's salaries by specified percent in one department only
    public void increaseSalary(int percent, int department) {
        for (Employee employee : employees) {
            if (employee == null) {
                break;
            } else if (employee.getDepartment() == department) {
                employee.setSalary(Math.round(employee.getSalary() * (100 + percent)) / 100.0);
            }
        }
    }

    // returns array of employees which salaries is lower than specified
    public Employee[] employeeWithSalaryLowerOrEqualThen(double salary) {
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
            if (indices[i] == 0 && !flag) break;
            selected[i] = employees[indices[i]];
            flag = false;
        }
        return selected;
    }

    // returns array of employees which salaries is higher than specified
    public Employee[] employeeWithSalaryHigherOrEqualThen(double salary) {
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
            if (indices[i] == 0 && !flag) break;
            selected[i] = employees[indices[i]];
            flag = false;
        }
        return selected;
    }

    // prints departments with its employees respectively
    public void printEmployeesByDepartment() {
        int[] departments = new int[employees.length];
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) break;
            for (int j = 0; j < departments.length; j++) {
                if (departments[j] == employees[i].getDepartment()) break;
                if (departments[j] == 0) {
                    departments[j] = employees[i].getDepartment();
                    count++;
                    break;
                }
            }
        }
        Arrays.sort(departments, 0, count);
        for (int k = 0; k < count; k++) {
            System.out.println("Department " + departments[k]);
            printEmployees(departments[k]);
        }
    }
}
