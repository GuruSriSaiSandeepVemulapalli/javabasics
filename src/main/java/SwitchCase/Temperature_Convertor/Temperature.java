package SwitchCase.Temperature_Convertor;

public class Temperature {

    public Temperature(int temp_type, double temp2){
        switch (temp_type){
            case 1:
                celsius_fahrenheit(temp2);
                break;
            case 2:
                fahrenheit_celsius(temp2);
                break;
        }
    }

    private void celsius_fahrenheit(double celsius){
        double fahrenheit = ((celsius * 9) / 5) + 32;
        System.out.println("Fahrenheit Temp: "+ fahrenheit);
    }

    private void fahrenheit_celsius(double fahrenheit){
        double celsius = ((fahrenheit - 32) * 5) / 9;
        System.out.println("Celsius Temp:"+ celsius);
    }

}
