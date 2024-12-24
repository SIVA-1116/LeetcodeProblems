class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;
        ArrayList<Integer>[] graph=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<>();
        }
        int[] indegree=new int[numCourses];
        for(int i=0;i<n;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];

            graph[v].add(u);
            indegree[u]++;
        }
        int count=0;
        boolean[] visited=new boolean[numCourses];
        int[] ans=new int[numCourses];
        Queue<Integer> que=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0) que.add(i);
        }
        int i=0;
        while(que.size()>0){
            int rem=que.poll();
            count++;
            ans[i]=rem;
            i++;
            visited[rem]=true;

            for(int nbr:graph[rem]){
                if(visited[nbr]==false){
                    indegree[nbr]--;
                    if(indegree[nbr]==0){
                        que.add(nbr);
                    }
                }
            }
        }
        if(count==numCourses) return ans;

        return new int[0];
    }
}