class Solution {
    public int maximumProduct(int[] nums) {
        int max3=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int max1=Integer.MIN_VALUE;
        int min1=Integer.MAX_VALUE;
        int min2=Integer.MAX_VALUE;
        int pro1=1,pro2=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max3){
                max1=max2;
                max2=max3;
                max3=nums[i];
            }else if(nums[i]>max2){
                max1=max2;
                max2=nums[i];
            }else if(nums[i]>max1){
                max1=nums[i];
            }
            if(nums[i]<min1){
                min2=min1;
                min1=nums[i];
            }else if(nums[i]<min2){
                min2=nums[i];
            }
            pro1=max1*max2*max3;
            pro2=min1*min2*max3;
        }
        return pro1>pro2?pro1:pro2;
    }
}