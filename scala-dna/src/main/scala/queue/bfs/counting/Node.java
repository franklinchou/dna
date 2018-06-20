package queue.bfs.counting;

import scala.collection.immutable.Set;

public class Node {

    int root;
    private Set<Integer> adjacents;

    public Node(int e, Set<Integer> adjacents) {
        this.root = e;
        this.adjacents = adjacents;
    }

    Set<Integer> getAdjacents() {
        return this.adjacents;
    }
}
