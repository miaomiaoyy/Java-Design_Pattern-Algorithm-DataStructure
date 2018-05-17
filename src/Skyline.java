//class Skyline {
//    public List<int[]> getSkyline(int[][] buildings) {
//        List<int[]> res = new ArrayList<>();
//        List<int[]> ht = new ArrayList<>();
//        for(int[] b: buildings){
//            ht.add(new int[]{b[0], -b[2]});
//            ht.add(new int[]{b[1],b[2]});
//        }
//        Collections.sort(ht,(a,b)->{
//            if(a[0]!= b[0])
//                return a[0]-b[0];
//            return a[1]-b[1];
//        });
//
//        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//        pq.add(0);
//        int pre = 0;
//        for(int[] h:ht){
//            if(h[1] < 0){
//                pq.add(-h[1]);
//            }else
//                pq.remove(h[1]);
//
//            int cur = pq.peek();
//            if(cur != pre){
//                res.add(new int[]{h[0],cur});
//                pre = cur;
//            }
//        }
//        return res;
//    }
//}
//
//
