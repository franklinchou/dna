package queue.bfs.counting;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/count-number-trees-forest/
 */
public class TreesInForest {

    private static boolean doneVisiting(boolean vs[]) {
        for (boolean v : vs) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    public static int countTrees(Node2[] nodes, int total) {

        int trees = 0;

        boolean visited[] = new boolean[total];

        for (int i = 0; i < total; i++) {
            if (!visited[i]) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;

                boolean visitedAny = false;

                while (!q.isEmpty()) {
                    int h = q.remove();
                    for (Node2 n : nodes) {
                        if (n.either == h) {
                            visited[n.or] = true;
                            visitedAny = true;
                            q.add(n.or);
                        }
                    }
                }
                if (visitedAny) {
                    trees += 1;
                }
            }
        }
        return trees;
    }
}