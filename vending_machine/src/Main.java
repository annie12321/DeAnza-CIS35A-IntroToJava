// Name: Annie Chen
// Date: 7/6/20

import java.util.Scanner;

public class Main {

    private static double totalMoney;
    private static int choice;
    private static String item;
    private static int[] stock = new int[] {2,2,2};
    private static double[] prices = new double[] {1.25,0.85,0.95};

    private static void getMoney() {
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter how many quarters you want to use: ");
        int quarters = in.nextInt();

        System.out.print("Please enter how many dimes you want to use: ");
        int dimes = in.nextInt();

        System.out.print("Please enter how many nickels you want to use: ");
        int nickels = in.nextInt();

        totalMoney = Math.round((quarters * 0.25 + dimes * 0.1 + nickels * 0.05) * 100.0) / 100.0;
    }

    private static boolean takeOrder() {
        Scanner in = new Scanner(System.in);

        System.out.println("Please choose one of the following snacks and enter its number:");
        System.out.println("   (0)Potato Chips--$1.25   (1)Cookies--$0.85   (2)Candy--$0.95");

        if (!in.hasNextInt()) {
            System.out.println("Not an integer. Please choose something on the menu again and enter its number.");
            System.out.println();
            return false;
        }

        choice = in.nextInt();

        if (choice > 2 || choice < 0) {
            System.out.println("Not an option. Please choose a snack on the menu again and enter its number.");
            System.out.println();
            return false;
        }
        else if (choice == 0) {
            item = "potato chips";
        }
        else if (choice == 1) {
            item = "cookies";
        }
        else {
            item = "candy";
        }

        if(inStock(choice) && enoughMoney(totalMoney,choice)) {
            double change = Math.round((totalMoney - prices[choice]) * 100.0) / 100.0;
            System.out.println("Please take your " + item + ". Your change is " + (int) Math.floor(change) + " dollar(s) and " + Math.round((change % 1) * 100) + " cents.");
            stock[choice]--;
        }
        else if (!inStock(choice)) {
            System.out.println("Sold out. Please make another choice.");
            System.out.println();
            return false;
        }
        else {
            System.out.println("Not enough money for this snack. Dispensing $" + totalMoney + ". Re-enter coins if you want to buy something else.");
            return true;
        }

        return true;
    }

    private static boolean inStock(int food) {
        return stock[food] > 0;
    }

    private static boolean enoughMoney(double money, int food) {
        return money >= prices[food];
    }

    public static void main(String[] args) {
        boolean vendingMachineOn = true;

        while(vendingMachineOn) {
            getMoney();
            boolean succeed = false;
            while(!succeed){
                succeed = takeOrder();
            }

            if (stock[0] == 0 && stock[1] == 0 && stock[2] == 0) {
                vendingMachineOn = false;
            }
        }
        System.out.println();
        System.out.println("All snacks are out of stock. Please restock the vending machine.");

    }
}
