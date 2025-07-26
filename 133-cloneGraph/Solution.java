import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
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

    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        if (node.neighbors.size() == 0)
            return new Node(1);

        int[] visited = new int[101];
        int i = 1;
        int mx = 1;

        Map<Integer, Node> nodeMap = new HashMap<>();
        Map<Integer, Node> orgMap = new HashMap<>();

        while (i != mx + 1) {
            visited[node.val] = 1;
            orgMap.put(node.val, node);

            if (!nodeMap.containsKey(node.val)) {
                Node clone = new Node(Integer.valueOf(node.val));
                nodeMap.put(node.val, clone);
            }

            Node clone = nodeMap.get(node.val);
            int nextIndex = i + 1;
            Node next = null;

            for (Node n : node.neighbors) {
                mx = Math.max(n.val, mx);        

                if (!nodeMap.containsKey(n.val)) {
                    Node sibClone = new Node(Integer.valueOf(n.val));
                    nodeMap.put(n.val, sibClone);
                    orgMap.put(n.val, n); 
                }

                clone.neighbors.add(nodeMap.get(n.val));
            }

            if (orgMap.containsKey(nextIndex))
                next = orgMap.get(nextIndex);

            if (next == null) {
                if (node.neighbors.size() == 0)
                    clone.neighbors.add(nodeMap.get(1));

                break;
            }

            node = next;
            i++;

        }

        return nodeMap.get(1);

    }
}