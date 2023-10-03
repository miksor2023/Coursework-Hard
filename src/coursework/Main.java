package coursework;

import java.util.Locale;

public class Main {

    //метод main - тесты
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        employeeBook.addEmployee("Иванов Иван Иванович", 2, 35000);
        employeeBook.addEmployee("Сидоров Пётр Петрович", 1, 36000);
        employeeBook.addEmployee("Петров Дмитрий Сергеевич", 2, 40500);
        employeeBook.addEmployee("Сергеев Олег Дмитриевич", 2, 28700);
        employeeBook.addEmployee("Лидов Марат Исакович", 1, 34900);
        employeeBook.addEmployee("Розин Андрей Гаврилович", 3, 36000);
        employeeBook.addEmployee("Жорин Евгений Михайлович", 1, 78050);
        employeeBook.addEmployee("Кабанов Абрам Романович", 3, 33300);
        employeeBook.printEmployeeList();
        System.out.println("\nСумма затрат на зарплату за месяц: " + employeeBook.calculateSalarySum() + "p.");
        System.out.println("Сотрудник с минимальной зарплатой: " + employeeBook.getMinSalaryEmploee());
        System.out.println("Сотрудник с максимальной зарплатой: " + employeeBook.getMaxSalaryEmploee());
        System.out.printf(Locale.US, "Среднее значение зарплат: %.2fр.\n", employeeBook.calculateAverageSalary());
        employeeBook.printNameList();
        employeeBook.makeSalaryIndexation(10);
        employeeBook.printEmployeeList();
        employeeBook.printDepartmentEmployeeList(1);
        System.out.println("\nСотрудник с минимальной зарплатой в отделе: " + employeeBook.getMinSalaryEmploeeInDept(1));
        System.out.println("Сотрудник с максимальной зарплатой в отделе: " + employeeBook.getMaxSalaryEmployeeInDept(1));
        System.out.println("Сумма затрат в месяц в отделе: " + employeeBook.calculateDeptSalarySum(1) + "p.");
        System.out.printf(Locale.US, "Средняя зарплата в отделе: %.2fр.\n", employeeBook.calculateAverageDeptSalary(1));
        employeeBook.makeDeptSalaryIndexation(10, 1);
        employeeBook.printDepartmentEmployeeList(1);
        employeeBook.printEmployeesWithSalaryLessThan(40000);
        employeeBook.printEmployeesWithSalaryMoreThan(40000);
    }
}
