package app.base;

import java.util.Random;

public abstract class Employee {
    //region Static Fields
    /**
     * List with male first names
     */
    protected static String[] firstNames = {
            "Александр",
            "Иван",
            "Дмитрий",
            "Андрей",
            "Сергей",
            "Михаил",
            "Артем",
            "Николай",
            "Евгений",
            "Владимир",
            "Алексей",
            "Константин",
            "Павел",
            "Георгий",
            "Максим",
            "Игорь",
            "Анатолий",
            "Валентин",
            "Геннадий",
            "Денис",
            "Евгений",
            "Антон",
            "Илья",
            "Кирилл",
            "Леонид",
            "Руслан",
            "Никита",
            "Олег",
            "Павел",
            "Роман"
    };

    /**
     * List with male last names
     */
    protected static String[] lastNames = {
            "Иванов",
            "Петров",
            "Смирнов",
            "Соколов",
            "Михайлов",
            "Федоров",
            "Морозов",
            "Козлов",
            "Павлов",
            "Новиков",
            "Волков",
            "Соловьев",
            "Васильев",
            "Зайцев",
            "Белов",
            "Абрамов",
            "Серов",
            "Волков",
            "Горбачев",
            "Дмитриев",
            "Ефимов",
            "Валуев",
            "Иванов",
            "Кузнецов",
            "Лебедев",
            "Кудрявцев",
            "Чернов",
            "Орлов",
            "Захарин",
            "Романов"
    };
    /**
     * Static random object
     */
    protected static Random random = new Random();
    /**
     * Static double value with monthly calculation indicator
     */
    protected static final double SALARY_MIN_VALUE = 3450; // == 1 МРП (Месячный расчетный показатель)
    //endregion

    //region Fields
    /**
     * Employee id
     */
    protected int id;
    /**
     * Employee last name
     */
    protected String lastName;
    /**
     * Employee first name
     */
    protected String firstName;
    /**
     * Employee salary
     */
    protected double salary;
    /**
     * Employee number of monthly calculation indicators
     */
    protected double mciAmount; // (Количество месячных расчетных показателей)
    //endregion

    //region Constructors
    public Employee() {
        this.lastName = "#LastName";
        this.firstName = "#FirstName";
    }

    public Employee(String lastName, String firstName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Employee(String lastName, String firstName, double mciAmount) {
        this(lastName, firstName);
        this.mciAmount = mciAmount;
    }
    //endregion

    //region Getters and setters

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        setMciAmount(salary / SALARY_MIN_VALUE);
    }

    public double getMciAmount() {
        return mciAmount;
    }

    public void setMciAmount(double mciAmount) {
        this.mciAmount = mciAmount;
        this.salary = calculateSalary();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    //endregion

    //region Public Methods

    /**
     * Method to calculate employee salary with mci dependency
     *
     * @return salary value
     */
    protected abstract double calculateSalary();
    //endregion
}
