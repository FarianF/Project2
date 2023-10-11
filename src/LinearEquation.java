import java.util.Scanner;

class LinearEquation {
    private double x1, y1, x2, y2;

    public LinearEquation(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double calculateDistance() {
        double dx = x2 - x1;
        double dy = y2 - y1;
        return Math.round(Math.sqrt(dx * dx + dy * dy) * 100.0) / 100.0;
    }

    public String calculateSlopeIntercept() {
        if (x1 == x2) {
            return "Vertical line, x = " + formatDecimal(x1);
        }

        double slope = (y2 - y1) / (x2 - x1);
        double yIntercept = y1 - (slope * x1);

        if (slope == 0) {
            return "Horizontal line, y = " + formatDecimal(yIntercept);
        } else {
            return "y = " + formatFraction(slope) + "x + " + formatDecimal(yIntercept);
        }
    }

    public String calculateCoordinate(double xValue) {
        if (x1 == x2) {
            return "Vertical line, x = " + formatDecimal(x1);
        }

        double yValue = ((y2 - y1) / (x2 - x1)) * (xValue - x1) + y1;
        return "(" + formatDecimal(xValue) + ", " + formatDecimal(yValue) + ")";
    }

    @Override
    public String toString() {
        String distance = formatDecimal(calculateDistance());
        String slopeIntercept = calculateSlopeIntercept();
        return "The two original points: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n" +
                "The equation of the line: " + slopeIntercept + "\n" +
                "The slope: " + formatFraction((y2 - y1) / (x2 - x1)) + "\n" +
                "The y-intercept: " + slopeIntercept + "\n" +
                "The distance between the two points: " + distance;
    }

    private String formatDecimal(double value) {
        return String.format("%.2f", value);
    }

    private String formatFraction(double value) {
        int gcd = greatestCommonDivisor((int) (value * 100), 100);
        return (int) (value * 100 / gcd) + "/" + (100 / gcd);
    }

    private int greatestCommonDivisor(int a, int b) {
        return b == 0 ? a : greatestCommonDivisor(b, a % b);
    }
}

