class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // structure the graph data structure
        List<Integer>[] graph = new ArrayList[n];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            list.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }

        // actual code
        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            DFS(i, i, graph, list, visited);
        }
        return list;
    }///

    void DFS(int i, int parent, List<Integer>[] graph, List<List<Integer>> list, boolean[] visited) {
        if (i != parent) {
            list.get(i).add(parent);
        }

        for (Integer node : graph[i]) {
            if (!visited[node]) {
                visited[node] = true;
                DFS(node, parent, graph, list, visited);
            }

        }
    }///
}