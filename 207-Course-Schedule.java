class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=prerequisites.length;
        int[] indegree=new int[numCourses];
        ArrayList<Integer>[] graph=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            int u=prerequisites[i][0];
            int v=prerequisites[i][1];
            graph[u].add(v);
            indegree[v]++;
        }
        int count=0;
        boolean[] visited=new boolean[numCourses];
        Queue<Integer> que=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                que.add(i);
            }
        }
        while(que.size()>0){
            int rem=que.poll();
            count++;
            visited[rem]=true;

            for(int nbr:graph[rem]){
                if(visited[nbr]==false){
                    indegree[nbr]--;
                    if(indegree[nbr]==0) que.add(nbr);
                }
            }
        }
        if(count==numCourses) return true;

        return false;
    }
}