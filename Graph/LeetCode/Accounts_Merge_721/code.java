class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        //adj Map
        Map<String, List<String>> adjMap= new HashMap<>();
        for(List<String> account:accounts){
            String firstEmail = account.get(1);
            for(int i=2;i<account.size();i++){
                String email = account.get(i);
                if(!adjMap.containsKey(firstEmail)){
                    adjMap.put(firstEmail,new ArrayList<>());
                }
                adjMap.get(firstEmail).add(email);
                if(!adjMap.containsKey(email)){          // bidirectional
                    adjMap.put(email,new ArrayList<>());
                }
                adjMap.get(email).add(firstEmail);   
            }
        }

        List<List<String>> res = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for(List<String> account:accounts){
            String firstEmail = account.get(1);
            if(!visited.contains(firstEmail)){
                List<String> subList = new ArrayList<>();
                dfs(subList,visited,adjMap,firstEmail);
                Collections.sort(subList);
                subList.add(0,account.get(0));
                res.add(subList);
            }
        }

        return res;

    }

    private static void dfs(List<String> subList,Set<String> visited,Map<String, List<String>> adjMap,String email){
        visited.add(email);
        subList.add(email);
        if(!adjMap.containsKey(email)){
            return;
        }
        for(String neighbour : adjMap.get(email)){
            if(!visited.contains(neighbour)){
                dfs(subList,visited,adjMap,neighbour); 
            }
        }
    }
}
