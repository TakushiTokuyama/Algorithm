import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

class ChangeDateFormat {

    // 日付の英語表記一覧
    private static final Map<String, String> dateNotation_En = new HashMap<>()
    {
        {
            put("01", "1st");
            put("02", "2nd");
            put("03", "3rd");
            put("04", "4th");
            put("05", "5th");
        }
    };

    // 月の英語表記一覧
    private static final Map<String, String> monthNotion_En = new HashMap<>()
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
    };
    
    // 日付書式を日本語表記から英語表記に変換
    public String DateConvertJpToEn(Date inputDate) {

        String result = "";

        String date = new SimpleDateFormat("yyyy年MM月dd日").format(inputDate).replaceAll("[^0-9]", "");

        Integer strLen = date.length();

        result += dateNotation_En.get(date.substring(strLen - 2)) + "-";

        result += monthNotion_En.get(date.substring(strLen - 4, strLen - 2)) + "-";

        result += date.substring(0, strLen - 4);

        System.out.println(result);
        
        return result;
    }

}