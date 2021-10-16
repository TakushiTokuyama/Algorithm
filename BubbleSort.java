import java.util.ArrayList;
import java.util.List;

// バブルソート
class BubbleSort {
    public void bubbleSort() {
        // 5,4,2,6
        List<Integer> numbers = new ArrayList<Integer>() {
            {
                add(5);
                add(4);
                add(2);
                add(6);
            }
        };

        // 入れ替えの時に使用する変数
        int x = 0;

        // ループ回数
        int N = numbers.size() - 1;

        while (N != 0) {
            // 隣接した値を比較して並べ替える
            for (int i = 0; i < N; i++) {

                // リスト内の比較終了条件
                if (i == N - 1) {
                    N--;
                    break;
                }

                // 値の入れ替え処理
                if (numbers.get(i) > numbers.get(i + 1)) {
                    x = numbers.get(i + 1);
                    numbers.set(i + 1, numbers.get(i));
                    numbers.set(i, x);
                } else {
                    System.out.println("何もしない");
                }
            }
        }

        System.out.println(numbers);
    }
}