class Solution {
    int rows,cols;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows=image.length;
        cols=image[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int currColor=image[sr][sc]; 
        dfs(sr,sc,visited,currColor,color,image);
        return image;
    }

    void dfs(int row,int col,boolean[][] visited,int currColor,int newColor,int[][] image){
        //avoid outofbound exception
        if(row<0 || row>=rows || col<0 ||col>=cols || image[row][col]!=currColor || visited[row][col]) return;
        
        visited[row][col]=true;
        image[row][col]=newColor;

        //neighbours
        dfs(row - 1, col, visited, currColor, newColor, image); //up
        dfs(row + 1, col, visited, currColor, newColor, image); //right
        dfs(row, col - 1, visited, currColor, newColor, image); //down
        dfs(row, col + 1, visited, currColor, newColor, image); //left
    }
}
