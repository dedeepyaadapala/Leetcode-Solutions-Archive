class Trie {
    Trie[] ch;
    int cnt;
    boolean isEnd;
    public Trie() {
        ch = new Trie[26];
        for(int i = 0;i < 26;i++){
            ch[i] = null;
        }
        this.cnt = 0;
        this.isEnd = false;
    }
    
    public void insert(String word) {
        Trie root = this;
        int n = word.length();
        for(int i = 0;i < n;i++){
            int idx = word.charAt(i)-'a';
            if(root.ch[idx] == null){
                root.ch[idx] = new Trie();
            }
            root = root.ch[idx];
            root.cnt++;
        }
        root.isEnd = true;
    }
    
    public boolean search(String word) {
        int n = word.length();
        Trie root = this;
        for(int i = 0;i < n;i++){
            int idx = word.charAt(i) - 'a';
            if(root.ch[idx] == null){
                return false;
            }
            root = root.ch[idx];
        }
        return root.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        int n = prefix.length();
        Trie root = this;
        for(int i = 0;i < n;i++){
            int idx = prefix.charAt(i) - 'a';
            if(root.ch[idx] == null){
                return false;
            }
            root = root.ch[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */