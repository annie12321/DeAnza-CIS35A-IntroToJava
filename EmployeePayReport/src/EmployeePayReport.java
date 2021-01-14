import java.text.DecimalFormat;
import java.util.Scanner;

public class EmployeePayReport {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("How many employees' salaries would you like to calculate?");
        int numEmployees = in.nextInt();

        Employee[] myEmployees = new Employee[numEmployees];

        for (int i = 0; i < numEmployees; i ++) {
            System.out.println("Employee First Name: ");
            String name = in.next();

            System.out.println("Employee Last Name: ");
            name = name + " " + in.next();

            System.out.println("Type of Employee (c-commissioned, s-salaried, h-hourly): ");
            String type = in.next();

            if (type.equals("s")) {
                System.out.println("Employee Monthly Salary: ");
                double salary = in.nextDouble();

                System.out.println("Give a 10% bonus? (yes/no): ");
                String bonus = in.next();

                myEmployees[i] = new SalariedEmployee(name, salary, bonus);
            }
            else if (type.equals("h")) {
                System.out.println("Hours worked this week: ");
                int hours = in.nextInt();

                System.out.println("Hourly Rate: ");
                double rate = in.nextDouble();

                myEmployees[i] = new HourlyEmployee(name, hours, rate);
            }
            else if (type.equals("c")) {
                System.out.println("Money made in sales this week: ");
                double sales = in.nextDouble();

                myEmployees[i] = new CommissionedEmployee(name, sales);
            }
        }

        DecimalFormat df = new DecimalFormat("0.00");
        double sum = 0;

        System.out.printf("%-15s %-13s %-10s %-10s %-10s %-20s", "Name", "Class", "Hours", "Sales", "Rate", "Weekly Pay");
        System.out.println();
        System.out.println("===========================================================================");
        for(int i = 0; i < numEmployees; i ++){
            if (myEmployees[i].getType().equals("salaried")) {
                if (myEmployees[i].getBonus()) {
                    System.out.format("%-15s %-47s %-22s",
                            myEmployees[i].getName(), myEmployees[i].getType(), "$" + df.format(myEmployees[i].getWeeklyPay()) + "*");
                    sum+=myEmployees[i].getWeeklyPay();
                }
                else {
                    System.out.format("%-15s %-47s %-22s",
                            myEmployees[i].getName(), myEmployees[i].getType(), "$" + df.format(myEmployees[i].getWeeklyPay()));
                    sum+=myEmployees[i].getWeeklyPay();
                }
            }
            else if (myEmployees[i].getType().equals("hourly")) {
                System.out.format("%-15s %-13s %-21s %-10s %-22s",
                        myEmployees[i].getName(), myEmployees[i].getType(), myEmployees[i].getHours(), "$" + df.format(myEmployees[i].getRate()), "$" + df.format(myEmployees[i].getWeeklyPay()));
                sum+=myEmployees[i].getWeeklyPay();
            }
            else {
                System.out.format("%-15s %-24s %-22s %-22s",
                        myEmployees[i].getName(), myEmployees[i].getType(), myEmployees[i].getSales(), "$" + df.format(myEmployees[i].getWeeklyPay()));
                sum+=myEmployees[i].getWeeklyPay();
            }
            System.out.println();
        }
        System.out.println("===========================================================================");
        System.out.println("TOTAL $" + df.format(sum));
        System.out.println("*A 10% bonus is awarded");

    }
}
