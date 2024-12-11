class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        ArrayList<String> li=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        int freq=0;
        for(String word:words){
            freq=map.getOrDefault(word,0);
            map.put(word,freq+1);
        }
        PriorityQueue<String> pq=new PriorityQueue<>(
            (a,b)->{
            if(map.get(a)==map.get(b)) return b.compareTo(a);
            return map.get(a) - map.get(b);
            });
        for(String s:map.keySet()){
            pq.add(s);
            if(pq.size()>k){
                pq.remove();
            }
        }
        for(int i=0;i<k;i++){
            li.add(0,pq.remove());
        }
        // while(pq.size()!=0){
        //     // String one=map.getKey(pq.remove());
        //     li.add(pq.remove());
        // }
        return li;
    }
}