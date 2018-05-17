//import java.util.ArrayList;
//import java.util.List;
//
//public class AddOperator {
//    private static final String[] ops = {"+", "-", "*"};
//    public static List<String> addOperators(String num, int target) {
//        //dfs try every possible operator
//        List<String> res = new ArrayList<>();
//        dfs(res, num, target, 0, 0, "");
//        return res;
//    }
//
//    private static void dfs(List<String> res, String num, int target, int sum, int start, String temp) {
//        if(target == sum) {
//            res.add(temp);
//            return;
//        }
//
//            for (int i = start; i < num.length(); i++) {
//                int n1 = (int) (num.charAt(i) - '0');
//                //int n1 = Integer.parseInt(num.charAt(i));  //this will avoid the result like "+2*3" why????
//                if (i == 0) {
//                    dfs(res, num, target, n1, i + 1, temp + n1);
//                } else {
//                    dfs(res, num, target, sum + n1, i + 1, temp + "+" + n1);
//                    dfs(res, num, target, sum - n1, i + 1, temp + "-" + n1);
//                    dfs(res, num, target, sum * n1, i + 1, temp + "*" + n1);
//                }
//            }
//        }
//
//
//
//
//    public static List<Integer> diffWaysToCompute(String input) {
//        List<Integer> res = new ArrayList<Integer>();
//        for (int i = 0; i < input.length(); i++) {
//            char c = input.charAt(i);
//            if (c == '-' || c == '+' || c == '*') {
//                String a = input.substring(0, i);
//                String b = input.substring(i + 1);
//                List<Integer> al = diffWaysToCompute(a);
//                List<Integer> bl = diffWaysToCompute(b);
//                for (re x : al) {
//                    for (int y : bl) {
//                        if (c == '-') {
//                            res.add(x - y);
//                        } else if (c == '+') {
//                            res.add(x + y);
//                        } else if (c == '*') {
//                            res.add(x * y);
//                        }
//                    }
//                }
//            }
//        }
//        if (res.size() == 0) res.add(Integer.valueOf(input));
//        return res;
//    }
//
//    public static void main(String[] args) {
//        String num = "1+2*3";
//        //addOperators(num,6);
//        System.out.print(diffWaysToCompute(num));
//    }
//}
//
