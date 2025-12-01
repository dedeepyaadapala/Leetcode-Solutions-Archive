class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> moves = new ArrayList<>();
        int n = arr.length;
        int[] idx = new int[n+1];
        for(int i = 0;i < n;i++){
            idx[arr[i]] = i;
        }
        for(int i = n;i > 0;i--){
            if(idx[i] != n-1){
                moves.add(idx[i]+1);
                reverseSubArray(arr,idx,idx[i]);
                moves.add(n);
                reverseSubArray(arr,idx,n-1);
            }
            n--;
        }
        return moves;
    }

    private static void reverseSubArray(int[] arr,int[] idx,int high){
        int low = 0;
        while(low <= high){
            int temp = arr[low];
            arr[low] = arr[high];
            idx[arr[low]] = low;
            arr[high] = temp;
            idx[temp] = high;
            low++;
            high--;
        }
    }
}


// 4231 -> 1324 ->