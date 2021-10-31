import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

class ChangeDateFormat {

    // 日付の英語表記一覧
    private static final Map<String, String> dateNotation_En = new HashMap<>(){
        {
            put("1","1st");
        }
    };
    
    public String DateConvert(Date date) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println(dateFormat.format(date));

        return "";
    }

}