/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashSet<Node> vis = new HashSet<>();
        HashMap<Node,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node head = new Node(node.val);
        map.put(node,head);
        q.add(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(!vis.contains(curr)){
                if(!map.containsKey(curr)){
                    map.put(curr,new Node(curr.val));
                }
                Node pres = map.get(curr);
                for(Node nei : curr.neighbors){
                    if(!map.containsKey(nei)){
                        map.put(nei,new Node(nei.val));
                    }
                    q.add(nei);
                    pres.neighbors.add(map.get(nei));
                }
                vis.add(curr);
            }
        }
        return head;
    }
}