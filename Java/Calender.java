import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Calender {

    // 入力年
    private String inputYear;
    
    // 入力月
    private String inputMonth;

    // 曜日
    private String[] dayOfWeeks = {"日", "月", "火", "水", "木", "金", "土"};

    // 環境依存しない改行コード
    private static final String br = System.getProperty("line.separator");

    // 入力年の相関チェックパターン
    private static final Pattern y = Pattern.compile("[1-9]{1}[0-9]{1}[0-9]{1}[0-9]{1}");

    // 入力月の相関チェックパターン
    private static final Pattern m = Pattern.compile("[0-1]{1}[0-2]{1}");
    
    // 標準出力クラス
    private static Scanner sc = new Scanner(System.in);

    // calender作成
    public void Create() {

        // 入力処理
        input();

        // 月初
        LocalDate beginningOfTheMonth = LocalDate.parse(inputYear + inputMonth + "01",
                DateTimeFormatter.ofPattern("yyyyMMdd"));

        // 月末
        LocalDate lastOfTheMonth = beginningOfTheMonth.plusMonths(1).minusDays(1);

        // 表示開始曜日を求める
        Integer firstDayOfWeekValue = beginningOfTheMonth.getDayOfWeek().getValue();

        // calenderに表示する日付を生成する (土)は末尾に改行を挿入
        List<String> viewDays = IntStream.rangeClosed(1, lastOfTheMonth.getDayOfMonth())
                .mapToObj(i -> String.format("%02d", i))
                .map(i -> LocalDate.parse(inputYear + inputMonth + i, DateTimeFormatter.ofPattern("yyyyMMdd"))
                        .getDayOfWeek().getValue() == 6 ? i + br : i)
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder(42);

        sb.append(addSpace(firstDayOfWeekValue));

        // 先頭の0を削除 フォーマットを整える
        viewDays.stream().map(day -> day.startsWith("0") ? "  " + day.substring(1) : " " + day)
                .forEach(day -> sb.append(day));

        for (String dayOfWeek : dayOfWeeks) {
            System.out.print(" " + dayOfWeek);
        }

        System.out.print(br);

        System.out.print(sb.toString() + br);
    }

    // 入力処理
    private void input() {

        do {

            System.out.println("Year:1-9999");

            inputYear = sc.nextLine();

        } while (!y.matcher(inputYear).find());

        do {

            System.out.println("Month:1-12");

            inputMonth = String.format("%02d", sc.nextInt());

        } while (!m.matcher(inputMonth).find());

        sc.close();
    }

    // 空白スペースを追加
    private String addSpace(Integer firstDayOfWeekValue) {

        String str = "";

        if (firstDayOfWeekValue != 7) {
            for (int i = 0; i < firstDayOfWeekValue; i++) {
                str += "   ";
            }
        }
        return str;
    }
}
