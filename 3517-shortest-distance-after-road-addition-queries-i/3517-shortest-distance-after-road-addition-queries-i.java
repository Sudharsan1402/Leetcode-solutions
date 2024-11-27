class Solution {
    private class Pair {
        int node;
        int weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private ArrayList<ArrayList<Integer>> initializeGraph(int n) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++)
            adj.get(i).add(i + 1);

        return adj;
    }
    private int dijkstra(ArrayList<ArrayList<Integer>> adj, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight); 
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;
        pq.add(new Pair(0, 0)); 

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int node = curr.node;
            int weight = curr.weight;
            for (int neighbor : adj.get(node)) {
                if (weight + 1 < dist[neighbor]) {
                    dist[neighbor] = weight + 1;
                    pq.add(new Pair(neighbor, dist[neighbor]));
                }
            }
        }

        return dist[n - 1]; 
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        ArrayList<ArrayList<Integer>> adj = initializeGraph(n);
        ArrayList<Integer> results = new ArrayList<>();


        for (int[] query : queries) {
            int u = query[0], v = query[1];
            adj.get(u).add(v); 

            results.add(dijkstra(adj, n));
        }

        int[] answer = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            answer[i] = results.get(i);
        }

        return answer;
    }
}