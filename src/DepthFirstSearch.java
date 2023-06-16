import java.util.LinkedList;
import java.util.Stack;

public class DepthFirstSearch {
    // 깊이 우선 탐색은 탐색에 있어서 보다 깊은 것을 우선적으로 하여 탐색하는 알고리즘
    // BFS에서는 Queue가 사용되었다면 DFS에서는 Stack이 사용된다.
    public static class Graph{
        class Node{
            int data;
            boolean marked;
            LinkedList<Node> adjacent;

            public Node(int data) {
                this.data = data;
                this.marked = false;
                this.adjacent = new LinkedList<Node>();
            }
        }
        Node[] nodes;

        Graph(int size) {
            nodes = new Node[size];
            for (int i = 0; i < size; i++) {
                nodes[i] = new Node(i);
            }
        }

        void addEdge(int i1, int i2) {
            Node n1 = nodes[i1];
            Node n2 = nodes[i2];
            if (!n1.adjacent.contains(n2)) {
                n1.adjacent.add(n2);
            }
            if (!n2.adjacent.contains(n1)) {
                n2.adjacent.add(n1);
            }
        }

        void dfs() {
            dfs(0);
        }

        void dfs(int index) {
            Node root = nodes[index];
            Stack<Node> stack = new Stack<>();
            root.marked = true;
            while (!stack.isEmpty()) {
                Node r = stack.pop();
                for (Node node : r.adjacent) {
                    if (node.marked == false) {
                        node.marked = true;
                        stack.push(node);
                    }
                }
                visit(r);
            }
        }

        void dfsR(Node r) {
            if(r == null) return;
            r.marked = true;
            visit(r);
            for (Node node : r.adjacent) {
                if (node.marked == false) {
                    dfsR(node);
                }
            }
        }

        void dfsR(int index) {
            Node r = nodes[index];
            dfsR(r);
        }
        void dfsR() {
            dfsR(0);
        }

        void visit(Node n) {
            System.out.println(n.data + " ");
        }
    }

    public static void main(String[] args) {
        
    }
}
