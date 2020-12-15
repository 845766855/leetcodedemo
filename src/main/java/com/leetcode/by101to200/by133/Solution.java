package com.leetcode.by101to200.by133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Node,Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node clone = new Node(node.val);
        map.put(node,clone);
        for (Node node1 : node.neighbors) {
            clone.neighbors.add(cloneGraph(node1));
        }
        return clone;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node = new Node(2);
        Node res = solution.cloneGraph(node);
    }
}

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
