// I copied my file from IntelliJ here to see if it worked this way.
import java.util.Scanner;

public class TemperatureConverter {

    public static double convertTemperature(double temperature, String unit) {
        // TODO: students implement this
        double result = 0.0;
        if (unit.equalsIgnoreCase("C")) {
            result = (temperature * 9.0 / 5.0) + 32.0;
        } else if (unit.equalsIgnoreCase("F")) {
            result = (temperature - 32.0) * 5.0 / 9.0;
        }
        return result;
    }



    public static void main(String[] args) {
        // TODO: students implement this
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("Enter a temperature value or type 'stop' to quit: ");
            String tempInput = scanner.nextLine().trim();

            if (tempInput.equalsIgnoreCase("stop")) {
                running = false;
                System.out.println("Program exits gracefully");
            } else {
                if (isValidDouble(tempInput)) {
                    double temperature = Double.parseDouble(tempInput);

                    System.out.print("Prompt the user for the unit (C or F): ");
                    String unit = scanner.nextLine().trim();

                    if (unit.equalsIgnoreCase("C") || unit.equalsIgnoreCase("F")) {
                        double convertedTemp = convertTemperature(temperature, unit);

                        if (unit.equalsIgnoreCase("C")) {
                            System.out.printf("%.2fF is equal to %.2fF%n", temperature, convertedTemp);
                        } else {
                            System.out.printf("%.2fF is equal to %.2fC%n", temperature, convertedTemp);
                        }
                    } else {
                        System.out.println("Error: Unrecognized unit label. Please enter 'C' or 'F'.");
                    }
                } else {
                    System.out.println("Error: Invalid temperature input. Please enter a valid number.");
                }
            }
            System.out.println();
        }
        scanner.close();
    }

    public static boolean isValidDouble(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        int startIndex = 0;
        if (str.charAt(0) == '-'|| str.charAt(0) == '+') {
            if (str.length() == 1) return false;
            startIndex = 1;
        }

        boolean decimalPointFound = false;
        boolean hasDigits = false;
        boolean isValid = true;
        int i = startIndex;

        while (i < str.length() && isValid) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                hasDigits = true;
            } else if (c == '.') {
                if (decimalPointFound) {
                    isValid = false;
                }
                decimalPointFound = true;
            } else {
                isValid = false;
            }
            i++;
        }
        return isValid && hasDigits;

    }

}
