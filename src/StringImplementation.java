public class StringImplementation {

    //int last  = Integer.lastValueOf(':');
    public static void main(String[] args) {

        String s = "he:hi:ko:ko";
//        int first = Integer.valueOf(":");
        int second = s.indexOf(':');
        int third = s.indexOf(':', second + 1);
        int last = s.lastIndexOf(':');
        System.out.println(second);
        System.out.println(third);
        System.out.println(last);
        String log = "2";
        int time = Integer.parseInt(log.substring(0, 1));
        int time2 = Integer.valueOf(log.substring(0, 1));
        System.out.println(time + "vs" +time2);
    }

}
