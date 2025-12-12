class Solution {
    public int[] countMentions(int users, List<List<String>> events) {
        HashMap<Integer,Integer> map = new HashMap<>();
        events.sort((l1,l2) -> {
            int comp = Integer.compare(Integer.valueOf(l1.get(1)),
                                        Integer.valueOf(l2.get(1)));
            if(comp == 0){
                return l1.get(0).equals("OFFLINE") ? -1 : 1;
            }
            return comp;
            });
        for(int i = 0;i < users;i++){
            map.put(i,Integer.MIN_VALUE);
        }
        int[] mentions = new int[users];
        int n = events.size();
        for(int i = 0;i < n;i++){
            if(events.get(i).get(0).equals("MESSAGE")){
                if(events.get(i).get(2).equals("ALL")){
                    for(int j = 0;j < users;j++){
                        mentions[j]++;
                    }
                }else if(events.get(i).get(2).equals("HERE")){
                    for(Map.Entry<Integer,Integer> entry: map.entrySet()){
                        int t = entry.getValue(),ts = Integer.valueOf(events.get(i).get(1));
                        int key = entry.getKey();
                        if(t == Integer.MIN_VALUE){
                            mentions[key]++;
                        }else if(t == Integer.MIN_VALUE || (t != ts && t + 60 <= ts)){
                            mentions[key]++;
                            map.put(key,Integer.MIN_VALUE);
                        }
                    }
                }else{
                    String[] ids = events.get(i).get(2).replaceAll("id","").split(" ");
                    for(String id:ids){
                        mentions[Integer.valueOf(id)]++;
                    }
                }
            }else{
                int k = Integer.valueOf(events.get(i).get(2));
                map.put(k,Math.max(map.get(k),Integer.valueOf(events.get(i).get(1))));
            }
            for(int j = 0;j < users;j++){
                System.out.print(mentions[j]+" ");
            }
            System.out.println();
        }
        return mentions;
    }
}