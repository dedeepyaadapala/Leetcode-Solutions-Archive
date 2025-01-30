class Solution {
    public int threeSumClosest(int[] arr, int target) {
        int ans = Integer.MAX_VALUE;
        Arrays.sort(arr);
        int n = arr.length,sum = 0;
        for(int i = 0;i < n-2;i++){
            int j = i+1,k = n-1;
            while(j < k){
                sum = arr[j] + arr[k];
                if(sum == target - arr[i]){
                    return target;
                }else if(sum < target - arr[i]){
                    j++;
                }else{
                    k--;
                }
                if(Math.abs(target - ans) > Math.abs(target - (arr[i]+sum))){
                    ans = sum + arr[i];
                }
            }
        }
        return ans;
    }
}