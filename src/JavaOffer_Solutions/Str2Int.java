package JavaOffer_Solutions;

public class Str2Int {
    public static int stringToInt(String num) {
        if(num == null || num.length() == 0) {
            throw new NumberFormatException(num);
        }
        char first = num.charAt(0);
        if (first == '-') {
            return parseString(num, 1, true);
        } else if(first == '+') {
            return parseString(num, 1, false);
        } else {
            return parseString(num, 0, false);
        }
    }

    private static int parseString(String num, int index, boolean negative) {
//        int res = 0;
//        for(int i = index; i < num.length(); i++) {
//            res = res * 10 + num.charAt(i) - '0';
//            if(res > Integer.MAX_VALUE) {
//                throw new NumberFormatException(num);
//
//            }
//        }
//        if(negative) {
//            if(res > Integer.MAX_VALUE) {
//                throw new NumberFormatException(num);
//            } else
//            return -res;
//        } else {
//            return res;
//        }
//    }


        if (index >= num.length()) {
            throw new NumberFormatException(num);
        }

        int result;
        long tmp = 0;
        while (index < num.length() && isDigit(num.charAt(index))) {
            tmp = tmp * 10 + num.charAt(index) - '0';
            // 保证求的得的值不超出整数的最大绝对值
//            if(tmp > Integer.MAX_VALUE / 10 ||
//                    (tmp == Integer.MAX_VALUE / 10 && num.charAt(index) - '0' > Integer.MAX_VALUE % 10)) {
//                throw new RuntimeException("Integer Overflow");
//            }
            if (tmp > Integer.MAX_VALUE) {
                throw new NumberFormatException(num);
            }
            index++;
        }

        if (!negative) {
            if (tmp >= Integer.MAX_VALUE) {
                throw new NumberFormatException(num);
            } else {
                result = (int) tmp;
            }
        } else {
            if (tmp == Integer.MAX_VALUE) {
                result = Integer.MAX_VALUE;
            } else {
                result = (int) -tmp;
            }
        }

        return result;
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
//        System.out.println(Integer.parseInt(Integer.MIN_VALUE + ""));
//        System.out.println(0x8000_0000L);
//        System.out.println(stringToInt(""));
        System.out.println(stringToInt("123"));
        System.out.println(stringToInt("+123"));
        System.out.println(stringToInt("-123"));
        System.out.println(stringToInt("1a123"));
        System.out.println(stringToInt("+2147483647377"));
        System.out.println(stringToInt("-21474836478"));
        System.out.println(stringToInt("+21474836489"));
        System.out.println(stringToInt("-21474836480"));
//        System.out.println(stringToInt("+2147483649"));
//        System.out.println(stringToInt("-2147483649"));
//        System.out.println(stringToInt("+"));
//        System.out.println(stringToInt("-"));
    }

}
