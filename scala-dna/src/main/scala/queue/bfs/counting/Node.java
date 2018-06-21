package queue.bfs.counting;

import scala.collection.immutable.Set;

public class Node {

    int data;

    // refactor to Set<Node>
    private Set<Node> adjacents;

    public Node(int e, Set<Node> adjacents) {
        this.data = e;
        this.adjacents = adjacents;
    }

    public Node(int e) {
        this.data = e;
    }

    Set<Node> getAdjacents() {
        return this.adjacents;
    }
}
