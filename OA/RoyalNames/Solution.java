import java.util.*;

public class Solution{
    String[][] romans = {{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                         {"X", "XX", "XXX", "XL", "L"}}; 

    private int romanToInt(String roman){
        int num = 0;
        int weight = 10;
        //System.out.print("roman:" + roman);
        for(int i = romans.length - 1; i >= 0; --i){
            for(int j = romans[i].length - 1; j >= 0; --j){
                if(roman.startsWith(romans[i][j])){
                    num += weight * (j + 1);
                    roman = roman.substring(romans[i][j].length());
                    break;
                }
            }
            weight = weight / 10;
        }
        //System.out.println(", num:" + num);
        return num;
    }

    private class nameComparator implements Comparator<String>{
        public int compare(String x, String y){
            String[] nameX = x.split(" ");
            String[] nameY = y.split(" ");
            if(nameX[0].equals(nameY[0])){
                return (romanToInt(nameX[1]) - romanToInt(nameY[1]));
            }
            else{
                return nameX[0].compareTo(nameY[0]);
            }
        }
    }

    public void getSortedList(String[] names){
        Arrays.sort(names, new nameComparator()); 
    }

    public static void main(String[] args){
        String[] names = {"Louis XIII", "Louis IX", "Louis XXI", "Alex V", "Davis XLIX"};
        Solution sol = new Solution();
        
        System.out.println("Names before sorted: " + Arrays.toString(names));
        sol.getSortedList(names);
        System.out.println("Names after sorted: " + Arrays.toString(names));
    }
}
