//without visited arr solution
class Solution {
    int rows,cols;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        rows=image.length;
        cols=image[0].length;
        int currColor=image[sr][sc]; 
        dfs(sr,sc,currColor,color,image);
        return image;
    }

    void dfs(int row,int col,int currColor,int newColor,int[][] image){
        //avoid outofbound exception
        if(row<0 || row>=rows || col<0 ||col>=cols || image[row][col]!=currColor || image[row][col]==newColor) return;
        
        image[row][col]=newColor;

        //neighbours
        dfs(row - 1, col, currColor, newColor, image); //up
        dfs(row + 1, col, currColor, newColor, image); //right
        dfs(row, col - 1, currColor, newColor, image); //down
        dfs(row, col + 1, currColor, newColor, image); //left
    }
}
