package queue.bfs.counting;

import scala.collection.immutable.Set;

public class Node {

    int data;

    // refactor to Set<Node>
    private Set<Integer> adjacents;

    public Node(int e, Set<Integer> adjacents) {
        this.data = e;
        this.adjacents = adjacents;
    }

    Set<Integer> getAdjacents() {
        return this.adjacents;
    }
}
