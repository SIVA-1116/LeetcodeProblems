class Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int maxpro=nums[0];
        int minpro=nums[0];
        int result=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]<0){
                int temp=maxpro;
                maxpro=minpro;
                minpro=temp;
            }
            maxpro=Math.max(nums[i],nums[i]*maxpro);
            minpro=Math.min(nums[i],nums[i]*minpro);

            result=Math.max(result,maxpro);
        }
        return result;
    }
}