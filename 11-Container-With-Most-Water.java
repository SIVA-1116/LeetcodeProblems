class Solution {
    public int maxArea(int[] height) {
        int width,area,minheight;
        int maxarea=0;
        int left=0;
        int right=height.length-1;
        while(left<right){
            minheight=Math.min(height[left],height[right]);
            width=right-left;
            area=width*minheight;
            maxarea=Math.max(area,maxarea);
            if(height[left]<height[right])
            {
                left++;
            }else{
                right--;
            }
        }
        
        return maxarea;

    }
}