import java.util.*;

public class parseExp {

        public static String parseTernary(String expression) {
            //  Stack<String> st = new Stack<>();
            if(expression.length() == 1 || !expression.contains("?"))
                return  String.valueOf(expression.charAt(0));
            for(int i = 0; i < expression.length(); i++) {
                if(expression.charAt(i) == 'T') {
                    String substr = expression.substring(2);
                    if(substr.charAt(1) == '?') {
                        return parseTernary(substr);
                    } else {
                        return String.valueOf(substr.charAt(0));
                    }
                }
                if(expression.charAt(i) == 'F') {
                    String substr1 = expression.substring(4);
                    if(substr1.charAt(1) == '?') {
                        return parseTernary(substr1);
                    } else {
                        return String.valueOf(substr1.charAt(2));
                    }
                }
            }
            return "";
        }

        public static int getMaxSquare(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] res = new int[m][n];
            int max = 0;
            for(int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i < 1 || j < 1) {
                        res[i][j] = matrix[i][j];
                    } else {
                        res[i][j] = res[i - 1][j - 1] + getRow(matrix, i) + getCol(matrix, j) + matrix[i][j];
                    }
                        max = Math.max(max, res[i][j]);
                }
            }
            return max;
        }

        private static int getRow(int[][] matrix, int i) {
            int res = 0;
            for(int k = 0; k < i; k++) {
                res += matrix[i][k];
            }
            return res;
        }

        private static int getCol(int[][] matrix, int j) {
            int res = 0;
            for(int k = 0; k < j; k++) {
                res += matrix[k][j];
            }
            return res;
        }


        public static int missingNumber2(int[] nums) {
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] < nums.length && nums[i] >= 0) {
                    nums[nums[i]] *= -1;
                }
            }
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] > 0) {
                    return i;
                }
            }
            return -1;
        }

        public static int missingNumber(int[] nums) {
            int total = 0;
            for(int i = 1; i <= nums.length ;i++ ){
                total += i;
            }
            for(int n : nums){
                total -= n;
            }
            return total;
        }




        public static String[] findSubstringInWraproundString(String p, int k) {
            TreeSet<String> set = new TreeSet<>();
            char[] arr = p.toCharArray();
            for(int i = 0; i < arr.length-k+1; i++){
                    set.add(p.substring(i, i+k));
                }
            String[] result = new String[set.size()];
            int index = 0;
            Iterator<String> iterator = set.iterator();
            while(iterator.hasNext()) {
                String cur = iterator.next();
                result[index++] = cur;
            }
            return result;
        }



        public static int getHighestScore(String[][] input) {
            Map<String, List<Integer>> map = new HashMap<>();
            for(String[] data : input) {
                String name = data[0];
                int score = Integer.parseInt(data[1]);
                if(map.containsKey(name)) {
                    List<Integer> list = map.get(name);
                    list.add(score);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(score);
                    map.put(name, list);
                }
            }
            int max = 0;
            double temp = 0;
            for(List<Integer> res: map.values()) {
                double value = 0;
                int size = res.size();
                for(int i : res) {
                    value += i;
                    temp = value/size;
                }
                max = (int) Math.max(max, Math.floor(temp));
            }
            return max;
        }


        public static int findSecondMin(int[] arr) {
            int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
            for(int i : arr) {
                if(i > max) {
                    secondMax = max;
                    max = i;
                } else if(i > secondMax) {
                    secondMax = i;
                }
            }
            return secondMax;
        }

        public static void main(String[] args) {
           // parseTernary("F?1:2");
            int[][] matrix = {{100, 1, 0}, {0,1,1}, {1,2,1}};
            //int res = getMaxSquare(matrix);
            //System.out.print(res);
            //System.out.print(Arrays.toString(findSubstringInWraproundString("caaab", 2)));
            String[][] input = {{"Bob","88"}, {"Ali","100"}, {"Ali","-10"}, {"Bob","-100"},{"Cac","100"},{"Cac","10"},
                    {"Cac","20"}, {"Cac","-30"},{"Cac","-100"}};
            //System.out.print(getHighestScore(input));
            int[] arr = {1,2,3,4,5};
            //System.out.print(findSecondMin(arr));
            //getMaxSquare(matrix);
            int[] nums = {9,6,4,2,3,5,7,0,1};
            System.out.print(missingNumber(nums));
        }
    }



