class Solution {
    int rows;
    int cols;

    public int numIslands(char[][] grid) {
        int count =0;
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    count++;
                    dfs(visited,i,j,grid);
                }
            }
        }
        return count;
    }

    public void dfs(boolean[][] visited,int row,int col,char[][] grid){
        if(row<0 || row>=rows || col<0 || col>=cols || grid[row][col]=='0' || visited[row][col]) return;
        visited[row][col] = true;

        //neighbours
        dfs(visited,row-1,col,grid); //up
        dfs(visited,row,col+1,grid); //right
        dfs(visited,row+1,col,grid); //down
        dfs(visited,row,col-1,grid); //left
    }
}
