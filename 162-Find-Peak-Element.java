class Solution {
    public int findPeakElement(int[] nums) {
         if (nums.length == 1) return 0; 

        for (int i = 0; i < nums.length; i++) {
            boolean leftCheck = (i == 0 || nums[i] > nums[i - 1]);
            boolean rightCheck = (i == nums.length - 1 || nums[i] > nums[i + 1]);

            if (leftCheck && rightCheck) {
                return i; 
            }
        }
        return -1;
    }
}