class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] cnt = new int[10];
        for(int i : digits){
            cnt[i]++;
        }
        ArrayList<Integer> lst = new ArrayList<>();
        for(int i =1;i <= 9;i++){
            if(cnt[i] > 0){
                cnt[i]--;
                for(int j = 0;j <= 9;j++){
                    if(cnt[j] > 0){
                        cnt[j]--;
                        for(int k = 0;k < 9;k += 2){
                            if(cnt[k] > 0) lst.add(100*i+10*j+k);
                        }
                        cnt[j]++;
                    }
                }
                cnt[i]++;
            }
        }
        int n = lst.size();
        int[] res = new int[n];
        for(int i = 0;i < n;i++){
            res[i] = lst.get(i);
        }
        return res;
    }
}