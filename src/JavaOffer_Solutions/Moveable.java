//package JavaOffer_Solutions;
//
//import java.util.*;
//
//public  class FindReachable {
//    Graph g = new Graph();
//    boolean reachable = false;
//    int count = 0;
//
//    class Vertex {
//        int cost;
//        int adjId;
//        int id;
//        Vertex(int cost) {
//            this.cost = cost;
//        }
//    }
//
//    class Graph {
//        int size; //scc numbers
//        int nov;//no of vertexes
//        LinkedList<Vertex> adjs[];
//        boolean visit[];
//        Graph() {
//            this.size = size;
//            adjs = new LinkedList[size];
//            for(int i = 0 ; i < size; i++) {
//                adjs[i] = new LinkedList<>();
//            }
//            visit = new boolean[size];
//        }
//
//    }
//    private int[] cost(Graph g) {
//    int[] cost = new int[g.nov];
//    int[] sum = new int[g.nov];
//        for(LinkedList adj : g.adjs) {
//            Iterator<Vertex> it = adj.iterator();
//            while (it.hasNext()) {
//                cost[it.next().id] = it.next().cost;
//                sum[it.next().id] += it.next().cost;
//                cost[it.next().id] = Math.min(sum[it.next().id], cost[it.next().id]);
//            }
//        }
//        return cost;
//    }
//
//    private boolean findReachable(Graph g) {
//        Graph ReveredGraph = reverse (g); //get reversed graph
//        Vertex maxFinishTimeVertex = DFScalculateFinishTime(ReveredGraph); //DFS Rg to find the vertex with max finish time
//        g.visit[maxFinishTimeVertex.id] = true;
//        count++;
//        for(LinkedList adj : g.adjs) {
//            Iterator<Vertex> it = adj.iterator();
//            while (it.hasNext()) {
//                DFS(it.next(), maxFinishTimeVertex);
//            }
//        }
//        return reachable;
//
//    }
//
//    private boolean touchOnce(Graph g, Vertex source) {
//        g.visit[source.id] = true;
//        count++;
//        Iterator ite = g.adjs[source.adjId].iterator();
//        while (ite.hasNext()) {
//            Vertex next = (Vertex) ite.next();
//            if (g.visit[next.id]) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//
//
//
//    private  LinkedList<Vertex>[] findSCC(Graph g, Vertex source) {
//        int scc = 0;
//        int count = 0;
//        while(nov == count) {
//            visit[source] = true;
//            count++;
//            list.add(source);
//            LinkedList<Vertex>[] adjs;
//            LinkedList<Vertex> list = new LinkedList<>();
//            for (w in source.neighbor in g){
//                count++;
//                list.add(w);
//            }
//            scc++;
//            adjs[scc] = list;
//        }
//        return adjs;
//    }
//
//        Iterator ite = g.adjs[vertex.adjId].iterator();
//        while (ite.hasNext()) {
//            Vertex next = (Vertex) ite.next();
//            if (count == g.nov) {
//                reachable = true;
//                return;
//            } else if (!g.visit[next.id]) {
//                DFS(next, source);
//            }
//        }
//    }
//
//    private void DFS(Vertex vertex, Vertex source) {
//        g.visit[vertex.id] = true;
//        count++;
//        Iterator ite = g.adjs[vertex.adjId].iterator();
//        while (ite.hasNext()) {
//            Vertex next = (Vertex) ite.next();
//            if (count == g.nov) {
//                reachable = true;
//                return;
//            } else if (!g.visit[next.id]) {
//                DFS(next, source);
//            }
//        }
//    }
//
//
//    //Assignment 9
//
//    //01 matrix
//    boolean simpleCycle(int[][] graph, int n) {
//        for (int u = 1; u < n; u++) {
//            for (w in neighbor(u)) {
//                relax(dist, u, w);
//            }
//        }
//
//        for(int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                if (dist[i,j] >=2){
//                    return true;
//                }
//            }
//        }
//        return false;
//
//    }
//
//
////BF shortest path
//    void BF(Graph g, int[] dist) {
//        for (int i = 1; i < n - 1; i++) {
//            for (int u = 1; u < n; u++) {
//                for (w in neighbor(u)) {
//                    relax(dist, u, w);
//                }
//            }
//        }
//    }
//    private void relax(int[] dist, Vertex u, Vertex w) {
//        if(dist[u] + Wuw < dist[w]) {
//            dist[w] = dist[u] + Wuw;
//        }
//    }
//
////BFS find how many ways from u to v
//    public int numOfShortestPath(int[][] graph, int u, int v) {
//        Queue<Integer> q = new LinkedList<>();
//        int count = 0;
//        q.offer(u);
//        while(!q.isEmpty()) {
//            int u = q.poll();
//            for(w in u.neighbors) {
//                if(w == v) {
//                    count++;
//                }
//                if(graph[u][w] == 1) {
//                    q.offer(w);
//                }
//            }
//        }
//        return count;
//    }
//
//    public boolean isShortestPath(int[][] graph, int s, int v) {
//        Queue<Integer> q = new LinkedList<>();
//        q.offer(s);
//        while (!q.isEmpty()) {
//            int u = q.poll();
//            for (w in u.neighbors) {
//                if (dist[u][w] + dist[w][v] < dist[u][v]) {
//                    return false;
//                } else {
//                    q.offer(w);
//                }
//            }
//        }
//        return true;
//    }
//
//
//    public int bellmanFord(Graph g, int k) {
//        for(int i = 0; i < k; i++) {
//            for(u = 1; u < n; u++) {
//                for(v in neighbors(u)) {
//                    relax(u, v);
//                }
//            }
//        }
//    }
//    private void relax(int[] dist, Vertex u, Vertex w) {
//        if(dist[u] + Wuw < dist[w]) {
//            dist[w] = dist[u] + Wuw;
//        }
//    }
//
//    public int[] dj(Graph g, Vertex s, int n) {
//       // int[] best = new int[n];
//        int[] dist = new int[n];
//        count = 0;
//        Arrays.fill(dist, Integer.MIN_VALUE);
//        HashSet<Integer> setVisit = new HashSet<>();
//        HashSet<Integer> setAll = new HashSet<>();
//        while(!setVisit.contains(u)) {
//            for(setAll.contains(u) && !setVisit.contains(u)) {
//                setVisit.add(u);
//                for(v in neighbors(u)) {
//                    dist[v] = Math.min(dist[v], g[u][v] + dist[u]);
//                }
//            }
//        }
//        return best;
//    }
////10
//    public int[] bestPath(Graph g, Vertex s, int n) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int[] best = new int[n];
//        int[] dist = new int[n];
//        count = 0;
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        Arrays.fill(best, Integer.MAX_VALUE);
//        HashSet<Integer> setVisit = new HashSet<>();
//        HashSet<Integer> setAll = new HashSet<>();
//        while(!setVisit.contains(u)) {
//            for(setAll.contains(u) && !setVisit.contains(u)) {
//                setVisit.add(u);
//                count++;
//                for(v in neighbors(u)) {
//                    dist[v] = Math.min(dist[v], g[u][v] + dist[u]);
//
//                    best[v] = Math.min(count, map.getOrDefault(dist[v], count));
//                    map.put(dist[v], best[v]);
//                }
//            }
//        }
//        return best;
//    }
//
////9 all pair
//    public List<String> shortestPathV0(Graph g, Vertex s, Vertex v0, int n) {
//        List<String> res = new ArrayList<>();//store all paths
//        int[] dist = new int[n];
//        int[] parent = new int[n];
//        //from u -> v0 use BF
//
//        for (int i = 0; i < n; i++) {
//            for (u = 1; u < n; u++) {
//                for (v in neighbors(u)) {
//                    relax(dist, u, v);
//                    parent[v] = u;
//                }
//            }
//        }
//
//        // from v0 -> w use DJ
//        int[] dist = new int[n];
//        Arrays.fill(dist, Integer.MIN_VALUE);
//        HashSet<Integer> setVisit = new HashSet<>();
//        HashSet<Integer> setAll = new HashSet<>();
//        while (!setVisit.contains(v0)) {
//            for (setAll.contains(v0) && !setVisit.contains(v0)) {
//                setVisit.add(v0);
//                for (k in neighbors(v0)) {
//                    relax(dist, v0, k);
//                }
//            }
//        }
//        //track the path from path array
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < parent.length; i++) {
//            int[] P = new int[n];
//            for(int u = 0; u < n; u++) {
//                P[u] = u;//init the parent to itself first
//                while(parent[u] != u) {
//                    P[u] = parent[u];
//                    sb.append(u + "->");
//                }
//            }
//        }
//        sb.setLength(sb.length() - 1);
//        res.add(sb.toString());
//    }
//
//        private void relax(int[] dist, Vertex u, Vertex w) {
//            if(dist[u] + Wuw < dist[w]) {
//                dist[w] = dist[u] + Wuw;
//                parent[w] = u;
//            }
//        }
//
//
//
//
//    private void relax(int[] dist, Vertex u, Vertex w) {
//        if(dist[u] + Wuw < dist[w]) {
//            dist[w] = dist[u] + Wuw;
//        }
//    }
//
//
//    //8 output dist[u][u] all pair
//    public int shortestCyclePath(Graph g, int n) {
//        int[][] dist = new int[n][n];
//        int res = Integer.MAX_VALUE;
//        Arrays.fill(dist, Integer.MAX_VALUE);
//        for(int i = 0; i < n; i++) {
//            for(int u = 0; u < n; u++) {
//                for(v = 0; v < n; v++) {
//                    if (dist[u][i] + dist[i][v] < dist[u][v]) {
//                        dist[u][v] = dist[u][i] + dist[i][v];
//                        if (u == v) {
//                            res = Math.min(res, dist[u][v]);
//                        }
//                    }
//                }
//            }
//        }
//        return res;
//    }
//}
//
