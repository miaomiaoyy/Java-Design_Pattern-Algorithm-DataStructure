//package JavaOffer_Solutions;
//
//import sun.misc.Unsafe;
//import sun.security.provider.certpath.Vertex;
//
//import java.util.*;
//
//public class Bipartite {
//    //05
//
//    // Java program to find out whether a given graph is Bipartite or not
//
//        Unsafe
//
//        final static int V = 4;    // No. of Vertices
//        boolean isBipartite(int G,int s) {
//        System.gc();
//
//            Set<Vertex> allVertex = new HashSet<>();
//            for(Vertex v : G) {
//                allVertex.add(v);
//            }
//            Set<Vertex> union = new HashSet<>();
//            Set<Vertex> intersection = new HashSet<>();
//
//            while (!allVertex.isEmpty()) {
//                Vertex u = allVertex.poll();
//               if(intersection.contains(u)) {
//                    for (w in G.neighbors of s){
//                        if (intersection.contains(w)) {
//                            return false;
//                        } else {
//
//                            if (!union.contains(w)) {
//
//                                union.add(w);
//                            }
//                        }
//
//                    }
//               } else {
//                   if (!union.contains(u)) {
//                       union.add(u);
//                       for (w in G.neighbors of s){
//                           if (union.contains(w)) {
//                               return false;
//                           } else {
//                               if (!intersection.contains(w)) {
//                                   intersection.add(w);
//                               }
//                           }
//
//                       }
//                    }
//               }
//            }
//            return true;
//        }
//
////
////       int[] twoDegree(Graph G, Vertex s, int[] degree) {
////            int[] sum = new int[G.size];
////            Queue<Vertex> q = new LinkedList<>();
////             q.offer(s);
////             while(!q.isEmpty()) {
////
////             Vertex u = q.poll();
////             for(w in G.neioghbor) {
////                 sum += degree[w];
////             }
////        }
//
//
//        //cycle detection
//
//           boolean dfs(Graph, G, Vertice s, color[] color) {
//             color.fill(grey);
//             for(w in G.neighbor(s)) {
//                 if(color[u] == grey) {
//                     return true;
//                 }
//                 if(color[u] == while) {
//                     dfs(G,u,color);
//                 }
//                 color[u] = black;
//                 return false;
//             }
//       }
//
//       //8
//
//    int takingCourse(Graph G, int[] indegree) {
//        int semester = 0;
//        Queue<Vertex> q = new Linkedlist<>();
//        for(indegree[v] in G) {
//            if(indegree[v] == 0) {
//                q.offer(v);
//            }
//        }
//        while(!q.isEmpty()) {
//            Vertex v = q.poll();
//            for(w in G.neighbor(v)) {
//                indegree[w]--;
//                if(indegree[w] == 0) {
//                    q.offer(w);
//                }
//            }
//            semester++;
//        }
//        return semester;
//}
//
//
//
////adjecent list calculate twodegree
//    public int[] calculateDegree(Graph(V, E)) {
//
//        int[] twoDegree = new int[V.num];
//        int[] degree = new int[V.num];
//        //calculate degree of each vertex
//        for(v in G.V) {
//            for (w in v.neighbors) {
//                degree[v]++;
//            }
//        }
//        Queue<Vertex> q = new LinkedList<>();
//        boolean[] visit = boolean[V.num];
//        q.offer(v);
//        visit[v] = true;
//        while(!q.isEmpty()) {
//            Vertex v = q.poll();
//            for (w in G.neightbor) {
//                if(!visit[w])) {
//                    twoDegree[v] += degree[w];
//                    q.offer(w);
//                    visit[w] = true;
//                }
//            }
//        }
//        return twoDegree;
//    }
//
//    //semester()
//    public int getSemester(V, E) {
//
//        //calculate degree of each vertex
//        int[] indegree = new indegree[V.num];
//        for(v in V) {
//            for(w in V.neighbor) {
//                if(E(v,w)) {
//                    indegree[w]++;
//                }
//            }
//        }
//
//        int semester = 0;
//        int[] finishTime = new int[V.num];
//        Queue<Vertex> q = new Linkedlist<>();
//        Map<Integer, Set<Vertex>> map = new HashMap<>();
//        for(Vertex v in V) {
//            if(indegree[v] == 0) {
//                q.offer(v);
//                finishTime[v] = 0;
//            }
//        }
//        while(!q.isEmpty()) {
//            Vertex v = q.poll();
//            for(w in G.neighbor(v)) {
//                indegree[w]--;
//                if(indegree[w] == 0) {
//                    q.offer(w);
//                }
//                finishTime[w] = Math.max(finishTime[w], finishTime[v] + 1);
//            }
//            map.putIfAbsent(finishTime[v], new HashSet<>());
//            map.get(finishTime[v]).add(v));
//        }
//        return map.size();
//    }
//
//
//
//
//    {
//        // This function returns true if graph G[V][V] is Bipartite, else false
//        boolean isBipartite(int G[][],int src)
//        {
//            // Create a color array to store colors assigned to all veritces.
//            // Vertex number is used as index in this array. The value '-1'
//            // of  colorArr[i] is used to indicate that no color is assigned
//            // to vertex 'i'.  The value 1 is used to indicate first color
//            // is assigned and value 0 indicates second color is assigned.
//            int colorArr[] = new int[V];
//            for (int i=0; i<V; ++i)
//                colorArr[i] = -1;
//
//            // Assign first color to source
//            colorArr[src] = 1;
//
//            // Create a queue (FIFO) of vertex numbers and enqueue
//            // source vertex for BFS traversal
//            LinkedList<Integer> q = new LinkedList<Integer>();
//            q.add(src);
//
//            // Run while there are vertices in queue (Similar to BFS)
//            while (q.size() != 0)
//            {
//                // Dequeue a vertex from queue
//                int u = q.poll();
//
//                // Return false if there is a self-loop
//                if (G[u][u] == 1)
//                    return false;
//
//                // Find all non-colored adjacent vertices
//                for (int v=0; v<V; ++v)
//                {
//                    // An edge from u to v exists and destination v is
//                    // not colored
//                    if (G[u][v]==1 && colorArr[v]==-1)
//                    {
//                        // Assign alternate color to this adjacent v of u
//                        colorArr[v] = 1-colorArr[u];
//                        q.add(v);
//                    }
//
//                    // An edge from u to v exists and destination v is
//                    // colored with same color as u
//                    else if (G[u][v]==1 && colorArr[v]==colorArr[u])
//                        return false;
//                }
//            }
//            // If we reach here, then all adjacent vertices can
//            //  be colored with alternate color
//            return true;
//        }
//
//
//
//
//        // Driver program to test above function
//        public static void main (String[] args)
//        {
//            int G[][] = {{0, 1, 0, 1},
//                    {1, 0, 1, 0},
//                    {0, 1, 0, 1},
//                    {1, 0, 1, 0}
//            };
//            Bipartite b = new Bipartite();
//            if (b.isBipartite(G, 0))
//                System.out.println("Yes");
//            else
//                System.out.println("No");
//        }
//    }
//
