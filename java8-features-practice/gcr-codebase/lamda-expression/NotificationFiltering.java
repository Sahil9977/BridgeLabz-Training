package lamda_expression;

import java.util.*;
import java.util.function.*;

public class NotificationFiltering {
	public static void main(String[] args) {
        List<String> alerts = Arrays.asList(
            "Critical: Heart rate drop",
            "Routine: Scheduled Checkup",
            "Critical: Oxygen level low",
            "Low: Appointment Reminder"
        );

        Predicate<String> criticalFilter = alert -> alert.startsWith("Critical");

        alerts.stream().filter(criticalFilter).forEach(System.out::println);
    }

}
