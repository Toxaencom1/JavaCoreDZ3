package app.base;


/**
 *  Descendant class of Employee,

 *  contains id of employee and counter.
 *  Implements the method calculateSalary()
 */
public class Worker extends Employee {
    {
        /*
          Employee id initializer
         */
        id = ++counter;
    }

    /**
     * Counter start value to counting worker employees
     */
    private static int counter = 10000;

    public Worker(String lastName, String firstName, double mciAmount) {
        super(lastName, firstName, mciAmount);
        this.salary = calculateSalary();
    }

    /**
     * Fabric method to create random worker object
     *
     * @return employee object
     */
    public static Employee getInstance() {
        return new Worker(
                lastNames[random.nextInt(lastNames.length)],
                firstNames[random.nextInt(firstNames.length)],
                random.nextInt(20, 300));

    }


    /**
     * Method to calculate employee salary with mci dependency
     *
     * @return salary value
     */
    @Override
    protected double calculateSalary() {
        return mciAmount * SALARY_MIN_VALUE;
    }

    public static int getCounter() {
        return counter;
    }

    @Override
    public String toString() {
        return String.format("id = %d, %10s %-10s; %10s; Average monthly salary" +
                        ": %10.2f ₸, Number of MCI per month = %.0f",
                id, lastName, firstName, this.getClass().getSimpleName(), salary, mciAmount);
    }
}
