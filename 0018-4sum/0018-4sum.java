class Solution {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;
        for(int i = 0;i < n-3;i++){
            if(i > 0 && arr[i-1] == arr[i]) continue;            
            for(int j = i+1;j < n-2;j++){
                if(j > i+1 && arr[j] == arr[j-1]) continue;                
                int k = j+1,l = n-1;
                while(k < l){
                    long act = (long)arr[i] + arr[j] + arr[k] + arr[l];
                    if(act == target && !res.contains(Arrays.asList(arr[i],arr[j],arr[k],arr[l]))){
                        res.add(Arrays.asList(arr[i],arr[j],arr[k],arr[l]));
                        k++;
                        l--;
                    while(k < l && arr[k] == arr[k-1]) k++;
                    while(l > k && arr[l] == arr[l+1]) l--;
                    }else if(act < target){
                        k++;
                    }else{
                        l--;
                    }
                }
            }
        }
        return res;
    }
}