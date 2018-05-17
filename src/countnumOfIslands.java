import java.util.*;

public class countnumOfIslands {


    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, 1, 0, -1};

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rSize = grid.length;
        int cSize = grid[0].length;
        int max = 0;

        for (int r = 0; r < rSize; r++) {
            for (int c = 0; c < cSize; c++) {
                if (grid[r][c] == 1) {
                    max = Math.max(max, helper(r, c, grid));
                }
            }
        }
        return max;
    }

    int helper(int r, int c, int[][] grid) {
        int count = 0;
        grid[r][c] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});

        while (!queue.isEmpty()) {
            count++;
            int[] curr = queue.poll();
            int cr = curr[0];
            int cc = curr[1];
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
                    queue.add(new int[]{nr, nc});
                    grid[nr][nc] = 0;
                }
            }
        }
        return count;
    }


}

class Solution2{

        public static int numDistinctIslands2(int[][] grid) {
            int res = 0;
            Set<List<Integer>> set = new HashSet<>();

            for (int i = 0; i < grid.length; ++i) {
                for (int j = 0; j < grid[0].length; ++j) {
                    if (grid[i][j] == 1) {
                        List<Integer> list = new ArrayList<>();
                        numIslandsHelper(i, j, grid, list);

                        Collections.sort(list);
                        System.out.println(list.size());
                        int diff = list.get(0);
                       // System.out.println(diff);
                        for (int k = 0; k < list.size(); ++k) {
                            list.set(k, list.get(k) - diff);//set(int index, E element)
                            //Replaces the element at the specified position in this list with the specified element (optional operation).
                        }
                        set.add(list);
                        //System.out.println(set);
                    }
                }
            }

            return set.size();
        }

        private static void numIslandsHelper(int i, int j, int[][] grid, List<Integer> list) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
                return;
            }

            list.add(i * grid[0].length + j);
            grid[i][j] = 0;

            numIslandsHelper(i - 1, j, grid, list);
            numIslandsHelper(i + 1, j, grid, list);
            numIslandsHelper(i, j - 1, grid, list);
            numIslandsHelper(i, j + 1, grid, list);
        }

    public static void main(String[] args) {
        int[][] grid= {{1,0,1}, {1,1,0},{0,0,1}};
        System.out.println(numDistinctIslands2(grid));
    }
    }






