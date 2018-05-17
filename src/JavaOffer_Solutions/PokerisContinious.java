package JavaOffer_Solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PokerisContinious {
    //从扑克牌中随机抽5张牌，判断是不是一个顺子，
    // 即这5张牌是不是连续的。2～10为数字本身， A为1。
    // J为11、Q为12、 为13。小王可以看成任意数字


    public static boolean isJake(int[] poker) {
        int countO = 0;
        int countOther = 0;
        if(poker == null || poker.length != 5) {
            return false;
        }
        Arrays.sort(poker);
        for(int i : poker) {
            if(i == 0) {
                countO++;
            }
        }
        for(int i = 1; i < poker.length; i++) {
            if(poker[i] == 0 || poker[i - 1] == 0 || poker[i] - poker[i - 1] == 1) {
                continue;
            }
            else if(poker[i] > poker[i - 1] + 1) {
                countOther += poker[i] - poker[i - 1] - 1;
                System.out.println(countOther);
            }
        }
        return countOther<=countO;
    }

    public static void main(String[] args) {
        int[] numbers1 = {1, 3, 2, 5, 4};
        System.out.println(isJake(numbers1));
        int[] numbers2 = {1, 3, 2, 6, 4};
        System.out.println(isJake(numbers2));
        int[] numbers3 = {0, 3, 2, 6, 4};
        System.out.println(isJake(numbers3));

        int[] numbers4 = {0, 3, 1, 6, 4};
        System.out.println(isJake(numbers4));
        int[] numbers5 = {1, 3, 0, 5, 0};
        System.out.println(isJake(numbers5));
        int[] numbers6 = {1, 3, 0, 7, 0};
        System.out.println(isJake(numbers6));
        int[] numbers7 = {1, 0, 0, 5, 0};
        System.out.println(isJake(numbers7));
    }
}
