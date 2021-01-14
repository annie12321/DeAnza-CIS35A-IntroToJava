public class Employee {

    private String name;
    private String type;
    private int hours;
    private double sales;
    private double rate;
    private double weekly_pay;
    private String bonus;

    public Employee(String employee_name, String employee_type){
        name = employee_name;
        type = employee_type;
        hours = 0;
        sales = 0;
        rate = 0;
        weekly_pay = 0;
        bonus = "";
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getHours() {
        return hours;
    }

    public double getSales() {
        return sales;
    }

    public double getRate() {
        return rate;
    }

    public double getWeeklyPay() {
        return weekly_pay;
    }

    public boolean getBonus() {
        return false;
    }
}
