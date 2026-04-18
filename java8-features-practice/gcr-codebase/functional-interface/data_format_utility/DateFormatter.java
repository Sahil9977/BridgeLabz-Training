package functional_interface.data_format_utility;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public interface DateFormatter {

    static String formatDate(LocalDate date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return date.format(formatter);
    }
}
