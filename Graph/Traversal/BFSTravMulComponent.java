import java.util.*;

class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0;i<V;i++){
          if(!visited[i]){
            bfs(i,res,visited,queue,adj);
          }
        }
        return res;
    }

    public void bfs(int i, List<Integer> res, boolean[] vis, Queue<Integer> queue, ArrayList<ArrayList<Integer>> adj){
        queue.offer(i);
        vis[i]=true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            res.add(node);
            for(int neighbour : adj.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
    }
}
