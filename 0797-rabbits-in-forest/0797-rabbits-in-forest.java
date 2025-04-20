class Solution {
    public int numRabbits(int[] answers) {
        int cnt = 0, n = answers.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            if(map.getOrDefault(answers[i],answers[i]+1) == answers[i]+1){
                map.put(answers[i],0);
                cnt += answers[i]+1;
            }
            map.put(answers[i],map.get(answers[i])+1);
        }
        return cnt;
    }
}