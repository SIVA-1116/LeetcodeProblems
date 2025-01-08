class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        int sum=0;
        int total=0;
        while(left<right){
            sum=nums[left]+nums[right];
            if(sum==k){
                total++;
                left++;
                right--;
            }else if(sum<k){
                left++;
            }else{
                right--;
            }
        }
        return total;
    }
}