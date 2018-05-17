//public class PathofIsland {
//
//    private int m;
//    private int n;
//
//    public  String numIslands(char[][] grid) {
//
//        m = grid.length;
//        if(m == 0) return "";
//        n = grid[0].length;
//        String path = "";
//        dfs(grid,0,0,path);
//
//        return path;
//    }
//
//    public void dfs(char[][] grid, int i, int j, Stirng s){
//        if(i >= m||j >= n) return;
//
//         dfs(grid,i,j + 1,s + String.valueOf(grid[i][j]));
//         dfs(grid,i + 1,j,s + grid[i][j]);
//
//    }
//
//
//    public static void main(String[] args) {
//        PathofIsland pathofIsland = new PathofIsland();
//        char[][] grid = new char[2][2];
//        grid[0][0] = '1';
//        grid[0][1] = '2';
//        grid[1][0] = '3';
//        grid[1][1] = '4';
//        System.out.println(pathofIsland.numIslands(grid));
//    }
//}
