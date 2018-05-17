import java.util.LinkedList;
import java.util.Queue;

public class MaxareaofIsland {

        public int maxAreaOfIsland(int[][] grid) {
            int h=grid.length,w=h==0?0:grid[0].length;
            if (w==0)return 0;
            int ans=0;
            int[]dirs={1,0,-1,0,1};
            for (int y=0;y<h;++y){
                for (int x=0;x<w;++x){
                    if (grid[y][x]==0)continue;
                    Queue<int[]> q=new LinkedList<>();
                    q.add(new int[]{y,x});
//                log.info("add {},{}", y, x);
                    grid[y][x]=0;
                    int curAns=0;
                    while (!q.isEmpty()){
                        ++curAns;
                        int[]cur=q.remove();
//                    log.info("Remove {}", cur);
                        for (int k=0;k<4;++k){
                            int ny=cur[0]+dirs[k],nx=cur[1]+dirs[k+1];
//                        log.info("ny, nx: {}, {}", ny, nx);
                            if (ny>=0&&ny<h&&nx>=0&&nx<w&&grid[ny][nx]==1){
                                q.add(new int[]{ny,nx});
//                            log.info("add {},{}", ny, nx);
                                grid[ny][nx]=0;
                            }
                        }
                    }
                    ans=Math.max(ans,curAns);
                }
            }
            return ans;

        }






    public int maxAreaOfIsland2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    max = Math.max(max, explore(grid, visited, i, j));
                }
            }
        }
        return max;
    }

    public int explore(int[][] grid, boolean[][] visited, int r, int c) {
        int area = 1;
        if (r - 1 >= 0 && grid[r - 1][c] == 1 && !visited[r - 1][c]) {
            visited[r - 1][c] = true;
            area += explore(grid, visited, r - 1, c);
        }
        if (r + 1 < grid.length && grid[r + 1][c] == 1 && !visited[r + 1][c]) {
            visited[r + 1][c] = true;
            area += explore(grid, visited, r + 1, c);
        }
        if (c - 1 >= 0 && grid[r][c - 1] == 1 && !visited[r][c - 1]) {
            visited[r][c - 1] = true;
            area += explore(grid, visited, r, c - 1);
        }
        if (c + 1 < grid[0].length && grid[r][c + 1] == 1 && !visited[r][c + 1]) {
            visited[r][c + 1] = true;
            area += explore(grid, visited, r, c + 1);
        }
        return area;
    }

}

