import java.util.*;

public class BrickWall {

    public static int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> row : wall) {
            int sum = 0;
            for(int i = 0; i < row.size(); i++) {
                sum += row.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int min = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            min = Math.max(min, entry.getValue());
        }
        return wall.size() - min;
    }

    public static void main(String[] args) {
        List<Integer> row1 = Arrays.asList(1,2,2,1);
        List<Integer> row2 =  Arrays.asList(3,1,2);
        List<Integer> row3 =  Arrays.asList(1,3,2);
        List<Integer> row4 =  Arrays.asList(2,4);
        List<Integer> row5 =  Arrays.asList(3,1,2);
        List<Integer> row6 =  Arrays.asList(1,3,1,1);
        List<List<Integer>> wall = Arrays.asList(row1, row2, row3, row4,row5,row6);
        leastBricks(wall);
    }
}
