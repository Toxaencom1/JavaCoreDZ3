package app.base;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;


/**
 * Simulates a list of employees

 * Also fill list with objects of the Employee class with random parameters
 */
public class EmployeeList implements Iterable<Employee>{
    //region Field and Static Fields
    /**
     * Static random object
     */
    private static final Random random = new Random();
    /**
     * Number of employees to fabric
     */
    private final int amount;
    /**
     * Comparator object for sort
     */
    private Comparator<Employee> comparator;

    /**
     * List of employees
     */
    private final ArrayList<Employee> employees;
    //endregion

    //region Constructors

    /**
     * Constructor with no arguments
     */
    public EmployeeList() {
        this(1);
    }

    /**
     * Constructor with one argument
     *
     * @param amount number of employees to fabric
     */
    public EmployeeList(int amount) {
        this.amount = amount;
        this.employees = new ArrayList<>();
        fillEmployeeList();
    }

    /**
     * Constructor that creates an object list based on copy of another Employees list
     *
     * @param employees list
     */
    public EmployeeList(ArrayList<Employee> employees) {
        this.employees = employees;
        this.amount = employees.size();
    }
    //endregion

    //region Public and private methods

    /**
     * This method fill employee list
     */
    private void fillEmployeeList() {
        for (int i = 0; i < amount; i++) {
            int value = random.nextInt(3) + 1;
            switch (value) {
                case 1 -> employees.add(Worker.getInstance());
                case 2 -> employees.add(Worker.getInstance()); // для увеличения шанса выпадания работников в штате
                case 3 -> employees.add(Freelancer.getInstance());
            }
        }
    }

    /**
     * Add employee to employees list
     *
     * @param employee object
     */
    public void add(Employee employee) {
        employees.add(employee);
    }

    /**
     * Remove employee from employees list
     *
     * @param index number
     */
    public void remove(int index) {
        employees.remove(index);
    }

    /**
     * This getter method returns employee on index
     *
     * @param index of employee in list
     * @return Employee
     */
    public Employee getEmployeeAt(int index) {
        return employees.get(index);
    }

    /**
     * This getter method returns clone of employees list
     *
     * @return list of employees
     */
    public ArrayList<Employee> getEmployeesListClone() {
        return ((ArrayList<Employee>) employees.clone()); // Unchecked cast, но другой тип list не может быть
    }


    /**
     * Print to console employees information from list
     */
    public void print() {
        for (Employee emp : employees) {
            System.out.println(emp);
        }
        /* Класс ArrayList реализует интерфейс Iterable, и у него есть встроенный итератор.
        Это означает, что можно использовать цикл foreach для перебора элементов ArrayList,
        так как он поддерживает итерацию.*/
    }

    /**
     * Print employees information and information of numbers of workers/freelancers
     *
     * @return format string
     */
    @Override
    public String toString() {
        print();
        return "List of Employees";
    }
    //endregion

    //region Methods to sort

    /**
     * Sort with SalaryComparator
     */
    public void salarySort() {
        this.comparator = new SalaryComparator();
        employees.sort( comparator);
    }

    /**
     * Sort with NameComparator
     */
    public void nameSort() {
        this.comparator = new NameComparator();
        employees.sort(comparator);
    }

    @Override
    public Iterator<Employee> iterator() {
        return employees.iterator();
    }

    //endregion
}
