import java.util.*;

public class Alien_Dict {
//分析
// 对于这种要确定顺序的问题，拓扑排序是一种很好的方法。
// 对于每一个单词，找到他与上一个单词第一个不同的字母，L[i]和C[i]，可以确定，L[i]排在C[i]前面。因此在图中的表现为，L[i] -> C[i]。
// 执行拓扑排序，首先找到所有入度为0的字母。
// 放入Queue中，然后依次取出，对于每一个取出的节点，找到他所有的连接的节点，将他们的入度都减1，然后把所有入度为0的节点加入Queue中。
// 然后在Graph中删除这个取出的节点。直到graph的size为0
// 若Queue中已经没有可以取出的节点，但是graph的size不是零，说明图中存在环，这时候输出invalid。


    public String alienOrder(String[] words) {
        //构建图，使用一个hash表来存graph,
        Map<Character, List<Character>> graph = new HashMap<Character, List<Character>>();
        //使用一个数组来存每一个字母的入度
        int[] degree = new int[26];

        StringBuilder result = new StringBuilder();

        if (words.length == 0) {
            return result.toString();
        }

        //把所有出现过的字母先添加到图中
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char key = words[i].charAt(j);
                if (!graph.containsKey(key)) {
                    graph.put(key, new LinkedList<Character>());
                }
            }
        }


        //构建图
        for (int i = 1; i < words.length; i++) {
            int j = 0;
            int k = 0;
            String last = words[i - 1];
            String current = words[i];
            while (j < last.length() && k < current.length()) {
                char p = last.charAt(j);
                char c = current.charAt(k);
                if (p != c) {
                    //在邻接表中添加被指向的节点
                    List<Character> children = graph.get(p);
                    children.add(c);
                    //把被指向的节点的入度+1；
                    degree[c - 'a']++;
                    break;
                } else {
                    j++;
                    k++;
                }
            }
        }

        if (graph.size() == 0) {
            return result.toString();
        }

        Queue<Character> q = new LinkedList<Character>();

        for (int i = 0; i < degree.length; i++) {
            //添加所有入度为0的节点到Queue
            char key = (char) ('a' + i);
            if (degree[i] == 0 && graph.containsKey(key)) {
                q.offer(key);
            }
        }
        while (q.size() > 0) {
            char next = q.poll();
            List<Character> children = graph.get(next);
            result.append(next);
            graph.remove(next);
            for (Character c : children) {
                degree[c - 'a']--;
                if (degree[c - 'a'] == 0) {
                    q.offer(c);
                }
            }
        }

        //如果图中还有节点，说明有环，返回invalid输出
        if (graph.size() > 0) {
            return "";
        }

        return result.toString();
    }
}

