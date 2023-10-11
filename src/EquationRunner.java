import java.util.Scanner;

public class EquationRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Linear Equation Calculator!");
        System.out.println("Please enter the first coordinate (x1, y1) in the format (x, y): ");
        String input = scanner.nextLine();

        // Remove parentheses and split using the comma
        input = input.replace("(", "").replace(")", "");
        String[] coordinates1 = input.split(",");

        double x1 = Double.parseDouble(coordinates1[0].trim());
        double y1 = Double.parseDouble(coordinates1[1].trim());

        System.out.println("Please enter the second coordinate (x2, y2) in the format (x, y): ");
        input = scanner.nextLine();

        // Remove parentheses and split using the comma
        input = input.replace("(", "").replace(")", "");
        String[] coordinates2 = input.split(",");

        double x2 = Double.parseDouble(coordinates2[0].trim());
        double y2 = Double.parseDouble(coordinates2[1].trim());

        LinearEquation equation = new LinearEquation(x1, y1, x2, y2);
        System.out.println("\nResults:\n" + equation);

        System.out.print("Enter an x value to find the corresponding y value (e.g., 2.0): ");
        double xValue = Double.parseDouble(scanner.nextLine());
        String coordinate = equation.calculateCoordinate(xValue);
        System.out.println("The corresponding coordinate is " + coordinate);
    }
}
