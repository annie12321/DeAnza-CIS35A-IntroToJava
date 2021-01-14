public class CommissionedEmployee extends Employee {

    private double sales;

    public CommissionedEmployee (String name, double employee_sales) {
        super(name, "commissioned");
        sales = employee_sales;
    }

    public double getSales() {
        return sales;
    }

    public double getWeeklyPay () {
        return 0.20 * sales;
    }
}
