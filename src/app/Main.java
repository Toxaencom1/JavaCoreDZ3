package app;

import app.base.Employee;
import app.base.EmployeeList;
import app.base.Worker;
/*
1. Построить три класса (базовый и 2 потомка), описывающих некоторых работников с почасовой оплатой
(один из потомков - Freelancer) и фиксированной оплатой (второй потомок -Worker).
а) Описать в базовом классе абстрактный метод для расчёта среднемесячной заработной платы.
Для «повременщиков» формула для расчета такова: «среднемесячная заработная плата = 20.8 * 8 * почасовая ставка»,
для работников с фиксированной оплатой «среднемесячная заработная плата = фиксированная месячная оплата».
б) Создать на базе абстрактного класса массив/коллекцию сотрудников и заполнить его.
в) ** Реализовать интерфейсы для возможности сортировки массива/коллекции
(обратите ваше внимание на интерфейсы Comparator, Comparable),
добавьте новое состояние на уровне базового типа и создайте свой уникальный компаратор.
г) ** Создать класс, содержащий массив или коллекцию сотрудников (как Worker так и Freelancer),
и реализовать возможность вывода данных с использованием foreach
(подсказка: вам потребуется поработать с интерфейсом Iterable).
 */
public class Main {
    public static void main(String[] args) {
        // Демонстрация возможностей
        EmployeeList employeeList = new EmployeeList(10);
        Employee employeeTest = new Worker("Тахаев", "Антон", 150);
        employeeList.add(employeeTest);
        employeeList.remove(0);
        EmployeeList employeeListSort = new EmployeeList(employeeList.getEmployeesListClone());
        System.out.println(employeeList);
        System.out.println();
        System.out.println("Sort by salary");
        employeeListSort.salarySort();
        employeeListSort.print();
        System.out.println();
        System.out.println("Sort by Last Name / First Name");
        employeeListSort.nameSort();
        employeeListSort.print();
        System.out.println("\nInitial List");
        employeeList.print();
    }
}
