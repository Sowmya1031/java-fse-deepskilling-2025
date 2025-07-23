import java.util.Scanner;

public class FinancialForecast {

    // Recursive Method
    public static double forecastRecursive(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return forecastRecursive(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    // Iterative Method
    public static double forecastIterative(double presentValue, double growthRate, int years) {
        double futureValue = presentValue;
        for (int i = 1; i <= years; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Financial Forecasting Tool");

        System.out.print("Enter Present Value (Rs.): ");
        double presentValue = scanner.nextDouble();

        System.out.print("Enter Annual Growth Rate (%): ");
        double ratePercent = scanner.nextDouble();
        double growthRate = ratePercent / 100.0;

        System.out.print("Enter Number of Years: ");
        int years = scanner.nextInt();

        // Recursive Method
        double futureValueRecursive = forecastRecursive(presentValue, growthRate, years);

        // Iterative Method
        double futureValueIterative = forecastIterative(presentValue, growthRate, years);

        System.out.printf("\nFuture Value (Recursive): Rs: %.2f\n", futureValueRecursive);
        System.out.printf("Future Value (Iterative - Optimized): Rs: %.2f\n", futureValueIterative);

        scanner.close();
    }
}
