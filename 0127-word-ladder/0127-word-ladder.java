class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        for(String s : wordList) set.add(s);
        q.add(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair p = q.poll();
            char[] s = p.s.toCharArray();
            int n = s.length;
            for(int i = 0;i < n;i++){
                char temp = s[i];
                for(char j = 'a';j <= 'z';j++){
                    s[i] = j;
                    String str = new String(s);
                    if(set.contains(str)){
                        if(str.equals(endWord)) return p.cnt+1;
                        q.add(new Pair(str,p.cnt+1));
                        set.remove(str);
                    }
                }
                s[i] = temp;
            }
        }
        return 0;
    }
}

class Pair{
    String s;
    int cnt;
    Pair(String s,int cnt){
        this.s = s;
        this.cnt = cnt;
    }
}