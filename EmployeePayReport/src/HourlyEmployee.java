public class HourlyEmployee extends Employee {

    private int hours;
    private double rate;

    public HourlyEmployee (String name, int employee_hours, double employee_rate) {
        super(name, "hourly");
        hours = employee_hours;
        rate = employee_rate;
    }

    public int getHours() {
        return hours;
    }

    public double getRate() {
        return rate;
    }

    public double getWeeklyPay () {
        if (hours >= 40) {
            return (hours % 40) * rate + (hours - 40) * rate * 2;
        }
        return hours * rate;
    }
}
