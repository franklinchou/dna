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

    private static void enqueueAll(Queue<Integer> q, Set<Integer> adjacents) {
        Iterator<Integer> it = adjacents.iterator();
        while (it.hasNext()) {
            q.add(it.next());
        }
    }

    public static int countTrees(Node[] nodes, int total) {

        int trees = 0;

        boolean visited[] = new boolean[total];

        for (Node n : nodes) {  // Looping through sequentially does not work. Why?
            if (!visited[n.data]) {

                visited[n.data] = true;

                Queue<Integer> q = new LinkedList<>();
                q.add(n.data);

                while (!q.isEmpty()) {
                    int h = q.remove();
                    for (Node n2 : nodes) {
                        visited[h] = true;
                        if (n2.data == h) {
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