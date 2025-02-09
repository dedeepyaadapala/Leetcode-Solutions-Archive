class NumberContainers {
    HashMap<Integer,Integer> lst;
    HashMap<Integer,TreeSet<Integer>> map;
    public NumberContainers() {
        lst = new HashMap<>();
        map = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(lst.containsKey(index)){
            TreeSet<Integer> l = map.get(lst.get(index));
            l.remove(index);
            if(l.size() == 0) map.remove(lst.get(index));
        }
        lst.put(index,number);
        if(!map.containsKey(number)){
            map.put(number,new TreeSet<>());
        }
        map.get(number).add(index);
    }
    
    public int find(int number) {
        if(map.containsKey(number)){
            TreeSet<Integer> l = map.get(number);
            return l.getFirst();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */