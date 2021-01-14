// Name: Annie Chen
// Date: 7/2/20

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int sum = 0, digit;

        Scanner in = new Scanner(System.in);

        System.out.print("Please enter an integer between 0 and 1000: ");
        int number = in.nextInt();

        while(true) {
            if(number==0) {
                break;
            }

            digit = number % 10;
            number = number / 10;

            sum += digit;
        }

        System.out.println();
        System.out.printf("The sum of the digits is: %d", sum);
    }
}
