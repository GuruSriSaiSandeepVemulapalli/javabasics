package SwitchCase;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args){

        double d1, d2;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your first number");
        d1 = scanner.nextDouble();

        System.out.println("Enter your second number");
        d2 = scanner.nextDouble();

        System.out.println("Enter an operator (+, -, *, /):");
        char operator = scanner.next().charAt(0);    // looking for operator value at first index

        scanner.close();
        double output = 0;

        switch (operator)
        {
            case '+':
                output = d1 + d2;
                break;
            case '-':
                output = d1 - d2;
                break;
            case '*':
                output = d1 * d2;
                break;
            case '/':
                output = d1 / d2;
                break;
            default:
                System.out.println("You have entered a wrong operator, please enter either one of  +,-,*,/");
        }

        System.out.println(d1+""+operator+""+d2+": "+ output);
    }
}
