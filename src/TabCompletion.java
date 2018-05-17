public class TabCompletion {
    //在terminal里输入文件名的一部分然后按tab补全，求能找到target文件要输入string的最短长度

        public static String removeKdigits(String num, int k) {
            StringBuilder sb = new StringBuilder();
            for(char c : num.toCharArray()) {
                while(k > 0 && sb.length() != 0 && sb.charAt(sb.length() - 1) > c) {
                    sb.setLength(sb.length() - 1);
                    k--;
                }
                if(sb.length() != 0 || c != '0') sb.append(c);  // Only append when it is not leading zero
            }
            if(k >= sb.length()) return "0";
            sb.setLength(sb.length() - k);  // use all remaining k
            return sb.toString();
        }


        public static String longestCommonPrefix(String[] strs) {
            StringBuilder sb = new StringBuilder();
            int min = Integer.MAX_VALUE;
            for(String s : strs) {
                min = Math.min(min, s.length());
            }
            for(int i = 0; i < min; i++) {
                char c = strs[0].charAt(i);
                sb.append(c);
                for(String s: strs) {
                    if(s.charAt(i) != c){
                        sb.setLength(sb.length() - 1);
                        break;
                    }
                }
            }
            return sb.toString();
        }

        private static int getSum(int a, int b) {
            System.out.println(b<<1);
            System.out.println(a<<1);
            return (b==0? a:getSum(a^b, (a&b)<<1)); //be careful about the terminating condition;

        }


    public static String reverseWords(String s) {
        if(s == " " || s == "" || s.length() == 0) return "";
        char[] arr = s.toCharArray();
        reverse(arr, 0, arr.length - 1);
        int end = arr.length - 1;
        for(int i = arr.length - 1; i >= 0; i--) {
            if(arr[i] == ' ') {
                reverse(arr, i+1, end);
                end = i - 1;
            }
        }
        reverse(arr, 0, end);
        return String.valueOf(arr);
    }

    private static void reverse(char[] arr, int i , int j) {
        while(i < j) {
            char c = arr[i];
            arr[i] = arr[j];
            arr[j] = c;
            i++;
            j--;
        }
    }



        public static void main(String[] args) {
            removeKdigits("12376129", 3);

//            String[] strs = {"a","b","c"};
//            longestCommonPrefix(strs);
           // System.out.print(getSum(1,2));
            //System.out.print(reverseWords("the sky is blue"));
        }
    }

