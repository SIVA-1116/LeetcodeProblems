class Solution {
    public int firstMissingPositive(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        Set<Integer> set=new HashSet<>();
        for(int i:nums){
            if(i>0 && set.add(i)){
                pq.add(i);
            }
        }
        int i=0,n=pq.size();
        while(pq.size()!=0){
            i++;
            if(i==pq.poll()){
                continue;
            }else{
                return i;
            }
            
        }
        
        if(pq.size()==0) return n+1;
        // for(int i=1;pq.size()!=0;i++){
        //     if(i==pq.poll()){
        //         continue;
        //     }else{
        //         return i;
        //     }
        // }
        return -1;
    }
}