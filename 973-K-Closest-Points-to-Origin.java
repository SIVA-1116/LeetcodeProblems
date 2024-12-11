class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->{
            int d1=a[0]*a[0]+a[1]*a[1];
            int d2=b[0]*b[0]+b[1]*b[1];
            return d2-d1;}
        );
        for(int[] point:points){
            pq.add(point);
            if(pq.size()>k){
                pq.remove();
            }
        }
        int [][] arr=new int[k][2];
        for(int i=0;i<k;i++){
            int[] dis=pq.remove();
            arr[i][0]=dis[0];
            arr[i][1]=dis[1];
        }
        return arr;
    }
}