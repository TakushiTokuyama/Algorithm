import java.util.Collections;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

class ChangeDateFormat {

    // 日付の英語表記一覧
    private static final Map<String, String> dateNotations_En = Collections.unmodifiableMap( new HashMap<>()
    {
        {
            put("01", "1st");
            put("02", "2nd");
            put("03", "3rd");
            put("04", "4th");
            put("05", "5th");
            put("06", "6th");
            put("07", "7th");
            put("08", "8th");
            put("09", "9th");
            put("10", "10th");
            put("11", "11th");
            put("12", "12th");
            put("13", "13th");
            put("14", "14th");
            put("15", "15th");
            put("16", "16th");
            put("17", "17th");
            put("18", "18th");
            put("19", "19th");
            put("20", "20th");
            put("21", "21st");
            put("22", "22nd");
            put("23", "23rd");
            put("24", "24th");
            put("25", "25th");
            put("26", "26th");
            put("27", "27th");
            put("28", "28th");
            put("29", "29th");
            put("30", "30th");
            put("31", "31st");
        }
    });

    // 月の英語表記一覧
    private static final Map<String, String> monthNotions_En = Collections.unmodifiableMap(new HashMap<>()
    {
        {
            put("01", "Jan");
            put("02", "Feb");
            put("03", "Mar");
            put("04", "Apr");
            put("05", "May");
            put("06", "Jun");
            put("07", "Jul");
            put("08", "Aug");
            put("09", "Sep");
            put("10", "Oct");
            put("11", "Nov");
            put("12", "Dec");
        }
    });
    
    // 日付書式を日本語表記から英語表記に変換
    public String DateConvertJpToEn(LocalDate inputDate) {

        String result = "";

        // 入力データ yyyy年MM月dd日
        String date = DateTimeFormatter.ofPattern("yyyy年MM月dd日").format(inputDate).replaceAll("[^0-9]", "");

        Integer strLen = date.length();

        result += dateNotations_En.get(date.substring(strLen - 2)) + "-";

        result += monthNotions_En.get(date.substring(strLen - 4, strLen - 2)) + "-";

        result += date.substring(0, strLen - 4);

        System.out.println(result);
        
        return result;
    }
}