package coursework;

import java.util.Locale;

public class Main {

    //метод main - тесты
    public static void main(String[] args) {
        //Тесты
        EmployeeBook employeeBook = new EmployeeBook();
        //Зиполняем поля книги сотрудников
        employeeBook.addEmployee("Иванов Иван Иванович", 2, 35000);
        employeeBook.addEmployee("Сидоров Пётр Петрович", 1, 36000);
        employeeBook.addEmployee("Петров Дмитрий Сергеевич", 2, 40500);
        employeeBook.addEmployee("Сергеев Олег Дмитриевич", 2, 28700);
        employeeBook.addEmployee("Лидов Марат Исакович", 1, 34900);
        employeeBook.addEmployee("Розин Андрей Гаврилович", 3, 36000);
        employeeBook.addEmployee("Жорин Евгений Михайлович", 1, 78050);
        employeeBook.addEmployee("Кабанов Абрам Романович", 3, 33300);

        //выводим в консоль содержимое всего массива employees[]
        employeeBook.printAllArray();

        //удаляем 3-х сотрудников
        employeeBook.deleteEmployee(2);
        employeeBook.deleteEmployee(5);
        employeeBook.deleteEmployee(6);

        //выводим массив employees
        employeeBook.printAllArray();
        //выводим список всех заполненных полей книги сотрудников без null-полей
        employeeBook.printEmployeeListWithoutNull();

        //добавляем сотрудника (запись делается в пустую ячейку)
        employeeBook.addEmployee("Новиков Любомир Евгеньевич", 4, 56870);
        //выводим список всех заполненных полей книги сотрудников без null-полей
        employeeBook.printEmployeeListWithoutNull();

        //считаем сумму затрат за месяц
        System.out.println("\nСумма затрат на зарплату за месяц: " + employeeBook.calculateSalarySum() + "p.");

        //печатаем имя сотрудника с минимальной зарплатой
        employeeBook.printNameOfMinSalaryEmploee();

        //печатаем имя сотрудника с максимальной зарплатой
        employeeBook.printNameOfMaxSalaryEmploee();

        //расчитываем и выводим среднюю зарплату
        System.out.printf(Locale.US, "Среднее значение зарплат: %.2fр.\n", employeeBook.calculateAverageSalary());

        //печатаем список Ф.И.О. сотрудников
        employeeBook.printNameList();

        //индексируем зарплаты на 10%
        employeeBook.makeSalaryIndexation(10);

        //выводим для проверки список полей книги сотрудников
        employeeBook.printEmployeeListWithoutNull();

        //методы для отделов
        //Ищем и выводим сотрудника с минимальной ЗП для отдела 1
        employeeBook.printMinSalaryEmployeeInDept(1);

        //Ищем и выводим сотрудника с максимальной ЗП для отдела 1
        employeeBook.printMaxSalaryEmployeeInDept(1);

        //считаем и выводим сумму затрат по отделу 1
        System.out.println("Сумма затрат в месяц в отделе: " + employeeBook.calculateDeptSalarySum(1) + "p.");

        //считаем среднюю рарплату по 1 отделу
        System.out.printf(Locale.US, "Средняя зарплата в отделе: %.2fр.\n", employeeBook.calculateAverageDeptSalary(1));

        //индексируем ЗП на 10% для 3 отдела
        employeeBook.makeDeptSalaryIndexation(10, 3);

        //Вывод списка сторудников с ЗП меньше определённого значения
        employeeBook.printEmployeesWithSalaryLessThan(40000);

        //Вывод списка сторудников с ЗП больше или равно определённого значения
        employeeBook.printEmployeesWithSalaryMoreThan(40000);

        //изменяем запись сотрудника
        employeeBook.modifyEmployee("Иванов Иван Иванович",1 ,10000000);

        //выводим список всех заполненных полей книги сотрудников без null-полей
        employeeBook.printEmployeeListWithoutNull();

        //выводим в консоль список отделов и их сотрудников
        employeeBook.printEployeeListByDepartments();
    }
}
