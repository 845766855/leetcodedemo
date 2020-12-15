package com.niuke.huawei;


import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int child = sc.nextInt();
            int parent = sc.nextInt();
            if (map.containsKey(parent)) {
                map.get(parent).add(child);
            } else {
                List<Integer> childs = new ArrayList<>();
                childs.add(child);
                map.put(parent, childs);
            }
        }
        int delete = sc.nextInt();
        Node root = new Node(0);
        makeNode(root,map);
//        StringBuilder result = new StringBuilder();
        List<Integer> result = new ArrayList<>();
        deleteNodes(delete,root.children,result);
        result.stream().sorted().forEach(s -> System.out.print(s + " "));

    }

    private static void deleteNodes(int delete, List<Node> childs, List<Integer> result) {
        for (int i = 0; i < childs.size(); i++) {
            Node node = childs.get(i);
            if (node.val == delete) {
//                childs.remove(node);
            } else {
                result.add(node.val);
                deleteNodes(delete,node.children,result);
            }
        }
    }

    private static void makeNode(Node node, Map<Integer, List<Integer>> map) {
        if (map.containsKey(node.val)) {
            List<Integer> childs = map.get(node.val);
            for (int i = 0; i < childs.size(); i++) {
                Node child = new Node(childs.get(i));
                node.children.add(child);
                makeNode(child,map);
            }
        }
    }

    static class Node {
        int val;
        List<Node> children;

        public Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

}
