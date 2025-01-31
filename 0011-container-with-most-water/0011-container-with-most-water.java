class Solution {
    public int maxArea(int[] height) {
        int ar = 1;
        int maxi = Integer.MIN_VALUE;
        int i = 0,j = height.length - 1;
        while(i < j){
            ar = (j - i) * Math.min(height[i],height[j]);
            maxi = Math.max(ar,maxi);
            if(height[i] < height[j]) i++;
            else j--;
        }
        return maxi;
    }
}