package app.base;

import java.util.Comparator;

/**
 * Comparator class for sort by last and first name
 */
public class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        int res = o1.getLastName().compareTo(o2.getLastName());
        if (res == 0) {
            return o1.getFirstName().compareTo(o2.getFirstName());
        }
        return res;
    }
}
