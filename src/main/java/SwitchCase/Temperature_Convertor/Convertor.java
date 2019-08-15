package SwitchCase.Temperature_Convertor;

import java.util.Scanner;

public class Convertor {

    public static void main(String args[]){
        int choice;
        double temp;
        Scanner input = new Scanner(System.in);
        System.out.println("1 : Celsius to Fahrenheit \n2 : Fahrenheit to Celsius");
        System.out.println("Enter your choice:");
        choice = Integer.parseInt(input.nextLine());
        System.out.println("Enter the temperature value:");
        temp = Double.parseDouble(input.nextLine());
        new Temperature(choice,temp);
    }
}
