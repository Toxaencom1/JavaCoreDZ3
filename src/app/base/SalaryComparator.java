package app.base;

import java.util.Comparator;

/**
 * Comparator class for sort by salary
 */
public class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o1.salary, o2.salary);
    }
}
