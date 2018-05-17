//package OA.RoyalNames;
//
//import java.util.*;
//
//class RomanName{
//    String[][] romans = {{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
//                         {"X", "XX", "XXX", "XL", "L"}};
//
//
//    private int roman2Int(String s) {
//        int[] nums = new int[s.length()];
//        for(int i=0;i<s.length();i++){
//            switch (s.charAt(i)){
//                case 'L':
//                    nums[i]=50;
//                    break;
//                case 'X' :
//                    nums[i]=10;
//                    break;
//                case 'V':
//                    nums[i]=5;
//                    break;
//                case 'I':
//                    nums[i]=1;
//                    break;
//            }
//        }
//        int sum=0;
//        for(int i=0;i<nums.length-1;i++){
//            if(nums[i]<nums[i+1])
//                sum-=nums[i];
//            else
//                sum+=nums[i];
//        }
//        return sum+nums[nums.length-1];
//    }
//
//
//    private int romanToInt(String roman){
//        int num = 0;
//        int weight = 10;
//        //System.out.print("roman:" + roman);
//        for(int i = romans.length - 1; i >= 0; --i){
//            for(int j = romans[i].length - 1; j >= 0; --j){
//                if(roman.startsWith(romans[i][j])){
//                    num += weight * (j + 1);
//                    roman = roman.substring(romans[i][j].length());
//                    break;
//                }
//            }
//            weight = weight / 10;
//        }
//        //System.out.println(", num:" + num);
//        return num;
//    }
//
//    private class nameComparator implements Comparator<String>{
//        public int compare(String x, String y){
//            String[] name1 = x.split(" ");
//            String[] name2 = y.split(" ");
//            if(name1[0].equals(name2[0])){
//                return (roman2Int(name1[1]) - f(name2[1]));
//            }
//            else{
//                return name1[0].compareTo(name2[0]);
//            }
//        }
//    }
//
//    public void getSortedList(String[] names){
//        Arrays.sort(names, new nameComparator());
//    }
//
//    public static void main(String[] args){
//        String[] names = {"Louis XIII", "Louis IX", "Louis XXI", "Alex V", "Davis XLIX"};
//        RomanName sol = new RomanName();
//
//        System.out.println("Names before sorted: " + Arrays.toString(names));
//        sol.getSortedList(names);
//        System.out.println("Names after sorted: " + Arrays.toString(names));
//    }
//}
