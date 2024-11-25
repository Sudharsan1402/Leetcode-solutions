class Solution {
    public int slidingPuzzle(int[][] board) {
        String start = "";
        String target = "123450"; 
        for (int[] row : board) {
            for (int cell : row) {
                start += cell;
            }
        }
 
        int[][] neighbors = {
            {1, 3},       // 0
            {0, 2, 4},    // 1
            {1, 5},       // 2
            {0, 4},       // 3
            {1, 3, 5},    // 4
            {2, 4}        // 5
        };

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) return steps;

                int zeroIndex = current.indexOf('0');
 
                for (int neighbor : neighbors[zeroIndex]) {
                    char[] chars = current.toCharArray(); 
                    char temp = chars[zeroIndex];
                    chars[zeroIndex] = chars[neighbor];
                    chars[neighbor] = temp;

                    String next = new String(chars);
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            steps++;
        }

        return -1;
    }
}