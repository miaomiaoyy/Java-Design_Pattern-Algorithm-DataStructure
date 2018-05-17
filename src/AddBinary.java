public class AddBinary {
//    Given two binary strings, return their sum (also a binary string).
//
//    For example,
//    a = "11"
//    b = "1"
//    Return "100".

    public static String addBinaryStr(String[] str) {
        if(str == null || str.length == 0 ) {
            return "";
        }
        if(str.length == 1) {
            return str[0];
        }
        if(str.length == 2) {
            return addBinary(str[0],str[1]);
        }
        String temp = addBinary(str[0], str[1]);
        for(int i = 2; i < str.length; i++) {
            temp = addBinary(temp, str[i]);
        }
        return temp;
    }
    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int len1 = a.length() - 1, len2 = b.length() - 1;
        int carry = 0, sum;
        while(len1 >= 0 || len2 >= 0) {
            sum = carry;
            sum += (len1 >= 0 ? a.charAt(len1--) - '0' : 0);
            sum += (len2 >= 0 ? b.charAt(len2--) - '0' : 0);
            carry = sum/2;
            sb.append(sum%2);
        }
        if(carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }



    public static String countAndSay(int n) {
        String res = "1";
        for(int i = 1; i < n; i++) {
            res = read(res);
        }
        return res;
    }
    //1211
    private static String read(String s) {
        int count = 1;
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char target = s.charAt(i); //1//2//1
            count = 1;
            while(i + 1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                count++;//2
                i++;
            }
            res.append(count).append(target); //111221

        }
        return res.toString();
    }


    public static void main(String[] args) {
        //System.out.print(addBinary("11","1"));
        int i = 1, n = 10;
        while(i  < n) {
            System.out.println(countAndSay(i));
            i++;
        }
    }
}
