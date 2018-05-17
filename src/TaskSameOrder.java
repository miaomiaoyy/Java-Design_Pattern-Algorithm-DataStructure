import java.util.*;

public class TaskSameOrder {
    public static String taskOrderSame(int[] tasks, int cooldown) {
        //use map to store task and its next available time
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int curTime = 0;
        for(int task : tasks ){
            if(map.containsKey(task)) {
                int taskTime = map.get(task);

                if (taskTime > curTime) {
                    for (int i = 0; i < taskTime - curTime; i++) {
                        sb.append(" _ ->");
                    }
                    curTime = taskTime;//means we have consumed this time to finish task
                }
            }
            map.put(task, curTime + cooldown + 1);
            sb.append(task).append("->");
            curTime++;
        }
         sb.setLength(sb.length() - 2);
        return sb.toString();
    }

//print the task
    public static String leastInterval(char[] tasks, int n) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for(char task: tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        List<Map.Entry<Character, Integer> > waiting = new ArrayList<>();

        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character,Integer> a, Map.Entry<Character, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });
        pq.addAll(map.entrySet());
        int time = 0;
        while(!pq.isEmpty() || !waiting.isEmpty()) {
            if(time % (n + 1) == 0) {
                pq.addAll(waiting);
                waiting.clear();
            }
            if(!pq.isEmpty()) {
                Map.Entry<Character, Integer> cur = pq.poll();
                sb.append(cur.getKey());
                map.put(cur.getKey(), cur.getValue() - 1);

                if(cur.getValue() > 0)
                {
                    waiting.add(cur);
                }
            } else {
                sb.append('*');
            }
            time++;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        int []tasks = new int[]{1,2,3,1,1,2,3,1,1,1};
        char[] taskArray = new char[] {'A','B','A','C','A','D','B','A'};
        System.out.println(leastInterval(taskArray, 2));
        int cool = 1;
        System.out.print(taskOrderSame(tasks, cool));
    }
}
