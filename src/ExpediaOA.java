import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//double存string 保证精度
public class ExpediaOA {
    public static List<String> helpBoss(String[] origGoods, Double[] origPrice, String[] fakeGoods, Double[] fakePrice) {
        List<String> goodList = new ArrayList<>();
        Map<String, String> nameList = new HashMap<>();
        for(String s :origGoods) {
            nameList.put(s, s.substring(0,2));
        }
        Map<String, Double> map = new HashMap<>();
        for(int i = 0; i < origGoods.length; i++) {
            map.put(nameList.get(origGoods[i]), origPrice[i]);
        }
        for(int i = 0 ;i  < fakeGoods.length; i++) {
            if(map.containsKey(nameList.get(fakeGoods[i]))) {
                if(map.get(nameList.get(fakeGoods[i])) != fakePrice[i]) {
                    goodList.add(fakeGoods[i]);
                }
            }
        }
        return goodList;
    }

    public static void main(String[] args) {
        String[] org = {"Apple", "Orange", "Peanut","water"};
        Double[] price =  {11.22, 20.12, 54.2, 3.21};
        String[] change = {"Hi", "Orange", "Peanut", "water"};
        Double[] price2 = {9.8, 20.12, 31.9, 7.9};
        for(String s:helpBoss(org, price, change, price2)) {
            System.out.println(s);
        }
    }
}
