class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        long score = 0;
        int n = instructions.length;
        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        while(i < n){
            if(set.contains(i)) break;
            if(instructions[i].equals("jump")){
                if(i+values[i] >= n || i+values[i] < 0){
                    break;
                }else{
                    set.add(i);
                    i = i+values[i];
                }
            }else{
                set.add(i);
                score += values[i];
                i++;
            }
        }
        return score;
    }
}