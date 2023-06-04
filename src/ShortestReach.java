import java.util.Arrays;
import java.util.LinkedList;

public class ShortestReach {
    public static class Graph {
        private Node[] nodes;
        private static int EDGE_DISTANCE = 6;

        public Graph(int size) {

        }
        private class Node {
            private int[] neighbors;
        }
        private Node getNode(int id) {
            return nodes[id];
        }

        public void addEdge(int first, int second) {

        }

        public int[] shortestReach(int startId) {
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(startId);

            int[] distance = new int[nodes.length];
            Arrays.fill(distance, -1);
            distance[startId] = 0;

            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int neighbor : nodes[node].neighbors) {
                    if (distance[neighbor] == -1) {
                        distance[neighbor] = distance[neighbor] + EDGE_DISTANCE;
                        queue.add(neighbor);
                    }
                }
            }

            return distance;
        }
    }

    public static void main(String[] args) {

    }
}
