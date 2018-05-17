//
//import java.util.concurrent.ArrayBlockingQueue;
//
//
//public class MyRateLimit {
//    class Data{
//        char val;
//        public Data(char val) {
//            this.val = val;
//        }
//    }
//
//    private final int TOKEN_SIZE = 4;
//    ArrayBlockingQueue<Data> bq = new ArrayBlockingQueue<>(TOKEN_SIZE);
//
//    public void addTokens() {
//        for (int i = 0; i < TOKEN_SIZE; i++) {
//            bq.offer(new Data('a'));
//        }
//    }
//
//    public boolean getTokens(char[] dataSet) {
//
//
//            int tokenCount = 0;
//            for (int i = 0; i < needTokenNum; i++) {
//                Byte poll = tokenQueue.poll();
//                if (poll != null) {
//                    tokenCount++;
//                }
//            }
//
//            return tokenCount == needTokenNum;
//       ]
//    }
//
//    }
//}
