package queue.bfs.counting;

import scala.collection.Iterator;
import scala.collection.immutable.Set;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Count number of trees in an arbitrary number of uni-directional graphs.
 *
 * https://www.geeksforgeeks.org/count-number-trees-forest/
 */
public class TreesInForest {

    private static void enqueueAll(Queue<Node> q, Set<Node> adjacents) {
        Iterator<Node> it = adjacents.iterator();
        while (it.hasNext()) {
            q.add(it.next());
        }
    }

    public static int countTrees(Node[] nodes, int total) {

        int trees = 0;

        boolean visited[] = new boolean[total];

        for (Node source : nodes) {
            if (!visited[source.data]) {

                visited[source.data] = true;

                Queue<Node> q = new LinkedList<>();
                q.add(source);

                while (!q.isEmpty()) {
                    Node h = q.remove();
                    for (Node n2 : nodes) {
                        visited[h.data] = true;
                        if (n2.data == h.data) {
                            enqueueAll(q, n2.getAdjacents());
                        }
                    }
                }
                trees += 1;
            }
        }
        return trees;
    }
}