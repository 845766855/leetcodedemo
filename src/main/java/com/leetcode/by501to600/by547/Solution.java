package com.leetcode.by501to600.by547;

public class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        boolean [] visited = new boolean[provinces];
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) {
                dfs(isConnected,visited,provinces,i);
                circles++;
            }
        }
        return circles;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int provinces, int i) {
        for (int j = 0; j < provinces; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
//                dfs(isConnected, visited, provinces, j);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
        System.out.println(solution.findCircleNum(new int[][]{{1,0,0},{0,1,0},{0,0,1}}));
    }
}
