import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.IntStream;

public class Calender {
    // year,month,day
    public void Create(String year, String month) {

        // 月初
        LocalDate beginningOfTheMonth = LocalDate.parse(year + month + "01", DateTimeFormatter.ofPattern("yyyyMMdd"));

        IntStream intStream = IntStream.range(1, beginningOfTheMonth.getDayOfMonth());

    }    
}
