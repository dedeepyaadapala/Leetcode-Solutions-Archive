class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int maxi = 0;
        int n = arr.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i < n;i++){
            set.add(arr[i]);
        }
        for(int i = 0;i < n;i++){
            for(int j = i+1;j < n;j++){
                int first = arr[i];
                int second = arr[j];
                int cnt = 2;
                int curr = first + second;
                while(set.contains(curr)){
                    first = second;
                    second = curr;
                    curr = first + second;
                    cnt++;
                }
                maxi = Math.max(maxi,cnt);
            }
        }
        return maxi >= 3 ? maxi : 0;
    }
}