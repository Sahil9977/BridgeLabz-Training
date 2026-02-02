package smart_city;

@FunctionalInterface
public interface FareCalculator {
    double calculateFare(double distance, double rate);
}
