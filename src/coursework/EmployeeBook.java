package coursework;

import java.util.Locale;

public class EmployeeBook {
    private final Employee[] employees;
    //private int size;
    public EmployeeBook() {
        this.employees = new Employee[10];
    }
    //метод "добавить сотрудника"
    public void addEmployee(String name, int department, double salary) {
        if (Employee.getEmploeeQty() >= employees.length) {
            System.out.println("Запись добавить невозможно, хранилище заполнено");
        } else {
            Employee newEmloyee = new Employee(name, department, salary);
            employees[newEmloyee.getId()] = newEmloyee;
        }
    }
    //метод "вывести в консоль список сотрудников"
    public void printEmployeeList() {
        System.out.println("\nСписок данных всех сотрудников:");
        for (int i = 0; i < Employee.getEmploeeQty(); i++) {
            System.out.println(employees[i]);
        }
    }
    //метод "посчитать сумму затрат в месяц"
    public double calculateSalarySum() {
        double sum = 0;
        for (int i = 0; i < Employee.getEmploeeQty(); i++) {
            sum = sum + employees[i].getSalary();
        }
        return sum;
    }
    //метод "найти сотрудника с минимальной зарплатой"
    public String getMinSalaryEmploee() {
        double minSalary = employees[0].getSalary();
        int index = 0;
        for (int i = 1; i < Employee.getEmploeeQty(); i++) {
            if (employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                index = i;
            }
        }
        return employees[index].getName();
    }
    //метод "найти сотрудника с максимальной зарплатой"
    public String getMaxSalaryEmploee() {
        double maxSalary = employees[0].getSalary();
        int index = 0;
        for (int i = 1; i < Employee.getEmploeeQty(); i++) {
            if (employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                index = i;
            }
        }
        return employees[index].getName();
    }
    //метод "расчитать среднее значение зарплаты"
    public double calculateAverageSalary() {
        return calculateSalarySum()/Employee.getEmploeeQty();
    }

    //метод "вывести в консоль ФИО всех сотрудников"
    public void printNameList() {
        System.out.println("\nСписок имён всех сотрудников:");
        for (int i = 0; i < Employee.getEmploeeQty(); i++) {
            System.out.println(employees[i].getName());
        }
    }
    //метод "индексация зарплат на заданный процент
    public void makeSalaryIndexation (int indexationPercentage) {
        double increaseRate = 1 + indexationPercentage / 100D;
        for (int i = 0; i < Employee.getEmploeeQty(); i++) {
            employees[i].setSalary(employees[i].getSalary() * increaseRate );
        }
        System.out.println("\nЗарплата проиндексирована на " + indexationPercentage + "%");
    }
    //делаем служебный метод, собирающий массив сотрудников по заданному отделу
    public Employee[] makeDepartmentArray(int department) {
        //собираем массив сотрудника отдела
        int deptEmploeeQty = 0;
        Employee[] deptEmployees = new Employee[Employee.getEmploeeQty()];
        for (int i = 0; i < Employee.getEmploeeQty(); i++) {
            if (employees[i].getDepartment() == department) {
                deptEmployees[deptEmploeeQty] = employees[i];
                deptEmploeeQty++;
            }
        }
        if (deptEmploeeQty == 0) {
            System.out.println("В базе нет сотрудников из отдела " + department);
        }
        //создаём массив без пустых полей и возвращаем его
        Employee[] deptEmployeesModified = new Employee[deptEmploeeQty];
        for (int i = 0; i < deptEmploeeQty; i++) {
            deptEmployeesModified[i] = deptEmployees[i];
        }
        return deptEmployeesModified;
    }
    //метод "вывести в консоль список сотрудников по заданному отделу"
    public void printDepartmentEmployeeList(int department) {
        Employee[] deptEmploees = makeDepartmentArray(department);
        System.out.println("\nСписок сотрудников " + department + " отдела");
        for (int i = 0; i < deptEmploees.length; i++) {
            System.out.printf (Locale.US,"Ф.И.О.: " + deptEmploees[i].getName() +
                    "; зарплата: %.2fр.; id: " + deptEmploees[i].getId() + "\n", deptEmploees[i].getSalary());
        }
    }
    //метод "ищем сотрудника с минимальной зарплатой по отделу"
    public String getMinSalaryEmploeeInDept(int department) {
        Employee[] deptEmploees = makeDepartmentArray(department);
        double minSalary = deptEmploees[0].getSalary();
        int index = 0;
        for (int i = 1; i < deptEmploees.length; i++) {
            if (deptEmploees[i].getSalary() < minSalary) {
                minSalary = deptEmploees[i].getSalary();
                index = i;
            }
        }
        return deptEmploees[index].getName();
    }
    public  String getMaxSalaryEmployeeInDept(int department) {
        Employee[] deptEmployees = makeDepartmentArray(department);
        double maxSalary = deptEmployees[0].getSalary();
        int index = 0;
        for (int i = 1; i < deptEmployees.length; i++) {
            if (deptEmployees[i].getSalary() > maxSalary) {
                maxSalary = deptEmployees[i].getSalary();
                index = i;
            }
        }
        return deptEmployees[index].getName();
    }
    //метод "расчитать сумму затрат по отделу"
    public double calculateDeptSalarySum(int department) {
        Employee[] deptEmployees = makeDepartmentArray(department);
        double sum = 0;
        for (int i = 0; i < deptEmployees.length; i++) {
            sum = sum + deptEmployees[i].getSalary();
        }
        return sum;
    }
    //метод "расчтать среднюю зарплату по отделу"
    public double calculateAverageDeptSalary(int department) {
        Employee[] deptEmployees = makeDepartmentArray(department);
        //условие - если количество людей в отделе совпадает с общим числом сотрудников
        if (deptEmployees.length == Employee.counter) {
            throw new IllegalArgumentException("количество людей в отделе совпадает с общим числом сотрудников");
        } else {
            return calculateDeptSalarySum(department) / deptEmployees.length;
        }
    }
    //метод "индексировать зарплаты по отделу на заданный процент
    public void makeDeptSalaryIndexation (int indexationPercentage, int department) {
        Employee[] deptEmployees = makeDepartmentArray(department);
        double increaseRate = 1 + indexationPercentage / 100D;
        for (int i = 0; i < deptEmployees.length; i++) {
            deptEmployees[i].setSalary(deptEmployees[i].getSalary() * increaseRate );
        }
        System.out.println("\nЗарплата по отделу " + department + "проиндексирована на " + indexationPercentage + "%");
    }
    //метод для вывода списка сотрудников с ЗП меньше заданного значения
    public void printEmployeesWithSalaryLessThan (double edgeSalary) {
        System.out.println("\nСписок сотрудников с зарплатой меньше " + edgeSalary + "р.");
        for (int i = 0; i < Employee.getEmploeeQty(); i++) {
            if (employees[i].getSalary() < edgeSalary) {
                System.out.printf(Locale.US, "id: " + employees[i].getId() + "; Ф.И.О.: " +
                        employees[i].getName() + "; зарплата: %.2fр.\n", employees[i].getSalary());
            }
        }
    }
    //метод для вывода списка сотрудников с ЗП больше заданного значения
    public void printEmployeesWithSalaryMoreThan (double edgeSalary) {
        System.out.println("\nСписок сотрудников с зарплатой больше или равно " + edgeSalary + "р.");
        for (int i = 0; i < Employee.getEmploeeQty(); i++) {
            if (employees[i].getSalary() >= edgeSalary) {
                System.out.printf(Locale.US, "id: " + employees[i].getId() + "; Ф.И.О.: " +
                        employees[i].getName() + "; зарплата: %.2fр.\n", employees[i].getSalary());
            }
        }
    }

}
