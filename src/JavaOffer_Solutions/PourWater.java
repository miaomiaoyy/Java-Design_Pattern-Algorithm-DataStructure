//package JavaOffer_Solutions;
//
//
//import javax.swing.plaf.nimbus.State;
//import java.util.HashSet;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Set;
//
//
//
//
//
//public class PourWater {
//    final int CAP_X = 10;
//    final int CAP_Y = 10;
//    final int CAP_Z = 10;
//
//
//    class Vertex{
//        int x,y,z;
//        int cx, cy, cz;
//        Vertex(int x, int y, int z) {
//            this.x = x;
//            this.y = y;
//            this.z = z;
//            cx = CAP_X;
//            cy = CAP_Y;
//            cz = CAP_Z;
//
//        }
//    }
//    enum State {
//        X,Y,Z;
//    }
//
//    public boolean pour(Vertex S) {
//        Queue<Vertex> q = new LinkedList<>();
//        Set<Vertex> set = new HashSet<>();
//        q.offer(S);
//        set.add(S);
//        while(!q.isEmpty()) {
//            Vertex top = q.poll();
//            if(top.y != 2 || top.z != 2) {
//                if(top.y != 0) {
//                    q.offer(pourWaterHelper(top.x, top.y, top.z, State.Y, State.X));
//                    q.offer(pourWaterHelper(top.x, top.y, top.z, State.Y, State.Z));
//                } else if(top.z != 0) {
//                    q.offer(pourWaterHelper(top.x, top.y, top.z, State.Z, State.X));
//                    q.offer(pourWaterHelper(top.x, top.y, top.z, State.Z, State.Y));
//                } else if(top.x != 0) {
//                    q.offer(pourWaterHelper(top.x, top.y, top.z, State.X, State.Y));
//                    q.offer(pourWaterHelper(top.x, top.y, top.z, State.X, State.Z));
//                }
//            } else{
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private Vertex pourWaterHelper(int x, int y, int z, State Recstate, State PourState) {
//        if(Recstate == State.X) {
//            if(PourState == State.Y) {
//                if (x < CAP_X) {
//                    y = (x + y) - CAP_X;
//                    x = (x + y) > 10 ? 10 : (x + y);
//                }
//            } else {
//                if (x < CAP_X) {
//                    z = (x + z) - CAP_X;
//                    x = (x + z) > 10 ? 10 : (x + z);
//                }
//            }
//        } else if(Recstate == State.Y) {
//            if(PourState == State.X) {
//                if(y < CAP_Y) {
//                    x = (x + y) - CAP_Y;
//                    y = (x + y) > 10 ? 10 : (x + y);
//                }
//            } else {
//                if(y < CAP_Y) {
//                    z = (z + y) - CAP_Y;
//                    y = (z + y) > 10 ? 10 : (z + y);
//                }
//            }
//        } else {
//            if(PourState == State.X) {
//                if(z < CAP_Z) {
//                    x = (z + x) - CAP_Z;
//                    z = (z + x) > 10 ? 10 : (z + x);
//                }
//            } else {
//                if(z < CAP_Z) {
//                    y = (z + y) - CAP_Z;
//                    z = (z + y) > 10 ? 10 : (z + y);
//                }
//            }
//        }
//        return new Vertex(x, y, z);
//    }
//
//
//    public boolean SCC(Graph g) {
//
//    }
//
//}
