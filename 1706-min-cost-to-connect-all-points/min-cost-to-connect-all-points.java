class Solution {
    public int minCostConnectPoints(int[][] points) {
        int nodesCount = points.length;
        List<Edge> edges = new ArrayList<>();
        UF uf = new UF(nodesCount);
        for (int i = 0; i < nodesCount; i++) {
            for (int j = i + 1; j < nodesCount; j++) {
                Edge edge = new Edge(i, j, points[i], points[j]);
                edges.add(edge);
            }
        }
        Collections.sort(edges, (x, y) -> Integer.compare(x.weight, y.weight));
        int sum = 0;
        for (Edge edge : edges) {
            int start = edge.start;
            int end = edge.end;
            int weight = edge.weight;
            if (uf.union(start, end)) {
                sum += weight;
            }
        }

        return sum;
    }
}

class UF {
    int[] parent, size;

    public UF(int len) {
        parent = new int[len];
        size = new int[len];
        for (int i = 0; i < len; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public boolean union(int x, int y) {
        int rpsX = find(x);
        int rpsY = find(y);

        if (rpsX == rpsY) {
            return false;
        }

        if (size[rpsX] > size[rpsY]) {
            size[rpsX] += size[rpsY];
            parent[rpsY] = rpsX;
        } else {
            size[rpsY] += size[rpsX];
            parent[rpsX] = rpsY;
        }
        return true;
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

}

class Edge {
    int start, end;
    int weight;

    public Edge(int startIndex, int endIndex, int[] startCoords, int[] endCoords) {
        start = startIndex;
        end = endIndex;
        weight = Math.abs(startCoords[0] - endCoords[0]) + Math.abs(startCoords[1] - endCoords[1]);
    }
}