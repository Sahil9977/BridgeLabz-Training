package smart_city;

import java.util.List;

public interface TransportService {
    List<String> getSchedules();

    default void printServiceDetails() {
        getSchedules().forEach(System.out::println);
    }
}
