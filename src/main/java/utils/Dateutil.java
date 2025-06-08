package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Dateutil {
    public static String getFormatedDate(int dayfromToday){
        return LocalDate.now().plusDays(dayfromToday).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
