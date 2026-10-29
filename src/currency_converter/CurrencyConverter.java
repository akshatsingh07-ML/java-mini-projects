package currency_converter;
import java.util.*;

public class CurrencyConverter {
    static double conversion(double amt, double a, double b) {
        double inr = 0;
        if (a == 1) inr = amt;
        else if (a == 2) inr = amt * 95.35;
        else if (a == 3) inr = amt * 106.16;
        else if (a == 4) inr = amt * 126.85;

        // Step 2: Convert INR to target currency
        if (b == 1) return inr;
        else if (b == 2) return inr / 95.35;
        else if (b == 3) return inr / 106.16;
        else return inr / 126.85;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("1. Continue");
            System.out.println("2. Terminate");
            int ch = sc.nextInt();
            if (ch == 2) break;
            if (ch != 1) {
                System.out.println("Invalid choice!");
                continue;
            }
            System.out.println("Select currency of input amount:");
            System.out.println("1. INR");
            System.out.println("2. USD");
            System.out.println("3. EUR");
            System.out.println("4. GBP");
            int a = sc.nextInt();

            System.out.println("Select currency to convert to:");
            System.out.println("1. INR");
            System.out.println("2. USD");
            System.out.println("3. EUR");
            System.out.println("4. GBP");
            int b = sc.nextInt();

            System.out.print("Enter amount: ");
            double amt = sc.nextDouble();

            if (a < 1 || a > 4 || b < 1 || b > 4 || amt < 0) {
                System.out.println("Invalid input!");
            } else {
                double result = CurrencyConverter.conversion(amt, a, b);
                System.out.printf("Converted amount: %.2f%n", result);
            }
        }
        System.out.println("------------THANK YOU------------");
        sc.close();
    }
}