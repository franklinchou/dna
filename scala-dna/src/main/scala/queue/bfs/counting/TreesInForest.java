package queue.bfs.counting;

import scala.collection.Iterator;
import scala.collection.immutable.Set;

import java.util.LinkedList;
import java.util.Queue;


/**
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

        for (int i = 0; i < total; i++) {
            if (!visited[i]) {

                visited[i] = true;

                Queue<Integer> q = new LinkedList<>();
                q.add(i);

                while (!q.isEmpty()) {
                    int h = q.remove();
                    for (Node n : nodes) {
                        visited[h] = true;
                        if (n.root == h) {
                            enqueueAll(q, n.getAdjacents());
                        }
                    }
                }
                trees += 1;
            }
        }
        return trees;
    }
}