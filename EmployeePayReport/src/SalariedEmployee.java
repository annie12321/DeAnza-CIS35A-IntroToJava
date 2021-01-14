public class SalariedEmployee extends Employee {

    private double salary;
    private String bonus;

    public SalariedEmployee (String name, double employee_salary, String employee_bonus) {
        super(name, "salaried");
        salary = employee_salary;
        bonus = employee_bonus;
        if (employee_bonus.equals("yes")) {
            salary *= 1.1;
        }
    }

    public boolean getBonus() {
        return bonus.equals("yes");
    }

    public double getWeeklyPay () {
        return salary / 4;
    }

}
