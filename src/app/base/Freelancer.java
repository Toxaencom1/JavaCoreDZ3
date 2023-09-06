package app.base;

public class Freelancer extends Employee {
    {
        /*
          Employee id initializer
         */
        id = ++counter;
    }

    /**
     * Counter start value to counting freelancer employees
     */
    private static int counter = 20000;

    public Freelancer(String lastName, String firstName, double mciAmount) {
        super(lastName, firstName, mciAmount);
        this.salary = calculateSalary();
    }

    /**
     * Fabric method to create random freelancer object
     *
     * @return employee object
     */
    public static Employee getInstance() {
        return new Freelancer(
                lastNames[random.nextInt(lastNames.length)],
                firstNames[random.nextInt(firstNames.length)],
                random.nextDouble(0.250, 1.5));

    }

    /**
     * Method to calculate employee salary with mci dependency
     *
     * @return salary value
     */
    @Override
    protected double calculateSalary() {
        return 20.8 * 8 * (mciAmount * SALARY_MIN_VALUE);
    }


    public static int getCounter() {
        return counter;
    }

    public String toString() {
        return String.format("id = %d, %15s %15s; %10s; Среднемесячная заработная плата: %10.2f ₸," +
                        " Количество МРП в час   = %.03f",
                id, lastName, firstName, this.getClass().getSimpleName(), salary, mciAmount);
    }
}
