//package JavaOffer_Solutions;
//
//import com.sun.tools.internal.xjc.reader.gbind.Graph;
//import sun.security.provider.certpath.Vertex;
//
//import java.util.*;
//
//public class Graph_Assignment {
////Q10 The weight?????
//    public static String shortestPath(Graph G, Vertex S) {
//        StringBuilder sb = new StringBuilder();
//        Map<Vertex,Vertex> parent;
//        boolean[] visit;
//        parent.put(null, S);
//        Queue<Vertex> q;
//        q.offer(S);
//        visit[S] = true;
//        while(!q.isEmpty()) {
//            u = q.poll();
//            for(w in G.neighbors && !visit[w]) {
//                q.offer(w);
//                parent.put(u, w);
//            }
//        }
//        visit.fill(false);
//        for(Map.Entry<Vertex, Vertex> entry: parent.entrySet()) {
//            if(!visit[entry.getValue()]) {
//                sb.append(entry.getValue());
//                visit[entry.getValue()] = true;
//            }
//        }
//    }
//
//
////Q9
//
//class Graph {
//    int size;
//    Vertice v;
//    List<Vertice> neighbors;
//}
//
//class Vertice{
//    int val;
//    public List<Edge> adj;
//}
//
//class Edge{
//    Vertice v1;
//    Vertice v2;
//}
//    //Time complexity of above solution is O(V + E) as it does simple DFS for given graph.
//    static List<List<Vertice>> findComponent(Graph G) {
//
//        List<List<Vertice>> res = new ArrayList<>();
//        boolean[] visit = new boolean[G.size];
//        Queue<Vertice> q;
//        while (G.size > count) {
//            List<Vertice> list = new ArrayList<>();
//
//            Vertice v = randomGetoneVertice(G);
//            if (!visit[v]) {
//                q.offer(v);
//                list.add(v);
//                visit[v] = true;
//                count++;
//            }
//            while (!q.isEmpty()) {
//
//                u = q.poll();
//                if (w in G.neighbors && !visit[w]){
//                    list.add(w);
//                    q.offer(w);
//                    visit[w] = true;
//                    count++;
//
//                }
//            }
//            res.add(list);
//        }
//    }
//
//
////03
//
//
////reverse the graph, input is the map of adjacent list,
//// the linear solution is to go through the list and check each vertex, and reverse their <key,value> pair
//
//    static List<Map<Vertex, Vertex>> reverseGraph(List<Map<Vertex, Vertex>> adList) {
//        if(adList == null) {
//            return adList;
//        }
//        List<Map<Vertex, Vertex>> res = new ArrayList<>();
//        for(Map<Vertex, Vertex> map: adList) {
//            Map<Vertex, Vertex> reversedMap = new HashMap<>();
//            for(Map.Entry<Vertex, Vertex> entry : map.entrySet()) {
//                reversedMap.put(entry.getValue(), entry.getKey());//reverse key-value pair
//            }
//            res.add(reversedMap);
//        }
//        return res;
//    }
//
//
//
//
//
//
//// Contributed by Aakash Hasija
//}
