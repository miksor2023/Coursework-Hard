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




        employeeBook.printAllArray();


        employeeBook.deleteEmployee(2);
        employeeBook.deleteEmployee(5);
        employeeBook.deleteEmployee(6);

        employeeBook.printAllArray();
        employeeBook.printEmployeeListWithoutNull();

        employeeBook.addEmployee("Новиков Любомир Евгеньевич", 4, 56870);

        employeeBook.printEmployeeListWithoutNull();



        System.out.println("\nСумма затрат на зарплату за месяц: " + employeeBook.calculateSalarySum() + "p.");
        employeeBook.printNameOfMinSalaryEmploee();
        employeeBook.printNameOfMaxSalaryEmploee();
        System.out.printf(Locale.US, "Среднее значение зарплат: %.2fр.\n", employeeBook.calculateAverageSalary());
        employeeBook.printNameList();
        employeeBook.makeSalaryIndexation(10);
        employeeBook.printEmployeeListWithoutNull();
        //методы для отдела
        employeeBook.printDepartmentEmployeeList(1);
        employeeBook.printDepartmentEmployeeList(2);
        employeeBook.printDepartmentEmployeeList(3);
        employeeBook.printDepartmentEmployeeList(4);
        employeeBook.printDepartmentEmployeeList(5);
        employeeBook.printMinSalaryEmploeeInDept(2);
        employeeBook.printMaxSalaryEmployeeInDept(2);

        System.out.println("Сумма затрат в месяц в отделе: " + employeeBook.calculateDeptSalarySum(1) + "p.");
        System.out.printf(Locale.US, "Средняя зарплата в отделе: %.2fр.\n", employeeBook.calculateAverageDeptSalary(1));
        employeeBook.printDepartmentEmployeeList(3);
        employeeBook.makeDeptSalaryIndexation(10, 3);
        employeeBook.printDepartmentEmployeeList(3);
        employeeBook.printEmployeesWithSalaryLessThan(40000);
        employeeBook.printEmployeesWithSalaryMoreThan(40000);
    }
}
