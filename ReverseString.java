import java.util.ArrayList;
import java.util.List;

class ReverseString {

    public void reverseString() {
        List<String> strs = new ArrayList<String>() {
            {
                add("S");
                add("I");
                add("N");
                add("B");
                add("U");
                add("N");
                add("S");
                add("H");
                add("I");
            }
        };

        // 入替時に格納用変数
        String c = "";

        // 終了条件
        int str_size = strs.size();

        for (int x = 0; x < str_size / 2; x++) {
            for (int y = 0; y < str_size; y++) {
                c = strs.get(str_size - 1 - y);
                strs.set(str_size - 1 - y, strs.get(y));
                strs.set(y, c);
            }
        }

        System.out.println(strs);
    }
}
