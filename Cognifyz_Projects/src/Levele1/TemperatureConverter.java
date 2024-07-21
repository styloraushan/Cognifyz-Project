package Levele1;

import java.util.Scanner;

public class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();

      
        System.out.print("Enter the unit of measurement (C for Celsius, F for Fahrenheit): ");
        char unit = scanner.next().charAt(0);

       
        if (unit == 'C' || unit == 'c') {
            double fahrenheit = celsiusToFahrenheit(temperature);
            System.out.printf("%.2f°C is %.2f°F%n", temperature, fahrenheit);
        } else if (unit == 'F' || unit == 'f') {
            double celsius = fahrenheitToCelsius(temperature);
            System.out.printf("%.2f°F is %.2f°C%n", temperature, celsius);
        } else {
            System.out.println("Invalid unit of measurement. Please enter C for Celsius or F for Fahrenheit.");
        }

        scanner.close();
    }

   
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

   
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
