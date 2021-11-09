import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calender {
    // calender作成
    public void Create(String year, String month) {

        // 月初
        LocalDate beginningOfTheMonth = LocalDate.parse(year + month + "01", DateTimeFormatter.ofPattern("yyyyMMdd"));

        // 月末
        LocalDate lastOfTheMonth = beginningOfTheMonth.plusMonths(1).minusDays(1);

        // 表示開始曜日を求める
        Integer startIndex = beginningOfTheMonth.getDayOfWeek().getValue();

        // 環境依存しない改行コード
        String br = System.getProperty("line.separator");
        
        // calenderに表示する日付を生成する
        List<String> numList = IntStream.range(1, lastOfTheMonth.getDayOfMonth())
                                        .mapToObj(i -> LocalDate.parse(year + month + String.format("%02d", i),
                                                        DateTimeFormatter.ofPattern("yyyyMMdd")).getDayOfWeek().getValue() == 6 ? String.valueOf(i) + br : String.valueOf(i))
                                        .map(i -> i.length() == 1 ? " " + i : i)
                                        .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder(42);

        sb.append(addSpace(startIndex));

        numList.forEach(day -> sb.append(day));

        System.out.print(sb.toString());
    }

    // 空白スペースを追加
    private String addSpace(Integer startIndex) {
        String str = "";
        if(startIndex != 7){
            for(int i = 0; i < startIndex; i++){
                str += "  ";
            }
        }
        return str;
    }
}
