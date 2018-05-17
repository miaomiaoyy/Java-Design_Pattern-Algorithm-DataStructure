//import java.util.*;
//
//public class TreeMap {
//
//    public static void valueUpSort() {
//        // 默认情况，TreeMap按key升序排序
//        Map<String, Integer> map = new TreeMap<String, Integer>();
//        map.put("acb1", 5);
//        map.put("bac1", 3);
//        map.put("bca1", 20);
//        map.put("cab1", 80);
//        map.put("cba1", 1);
//        map.put("abc1", 10);
//        map.put("abc2", 12);
//    }
//
//    public static void keyDownSort() {
//
//
//        Map<String, Integer> map = new TreeMap<String, Integer>(keyComparator);
//        map.put("acb1", 5);
//        map.put("bac1", 3);
//        map.put("bca1", 20);
//        map.put("cab1", 80);
//        map.put("cba1", 1);
//        map.put("abc1", 10);
//        map.put("abc2", 12);
//
//        System.out.println("------------TreeMap按key降序排序--------------------");
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }
//        // TreeMap,按key降序排序
//        // 降序排序比较器
//        Comparator<String> keyComparator = new Comparator<String>() {
//
//            @Override
//            public int compare(String o1, String o2) {
//                // TODO Auto-generated method stub
//                return o2.compareTo(o1);
//            }
//        };
//    }
//}
////
////    // rank by value 升序比较器
////    Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {
////        @Override
////        public int compare(Map.Entry<String, Integer> o1,
////                           Map.Entry<String, Integer> o2) {
////            // TODO Auto-generated method stub
////            return o1.getValue() - o2.getValue();
////        }
////    }
////}
////
//
////        // map转换成list进行排序
////        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
////
////        // 排序
////        Collections.sort(list, valueComparator);
////
////        // 默认情况下，TreeMap对key进行升序排序
////        System.out.println("------------map按照value升序排序--------------------");
////        for(Map.Entry<String, Integer> entry : list) {
////            System.out.println(entry.getKey() + ":" + entry.getValue());
////        }
////    }
////}
