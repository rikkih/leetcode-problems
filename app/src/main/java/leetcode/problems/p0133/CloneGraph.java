package leetcode.problems.p0133;

import leetcode.util.Node;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * For the current node, add its value and neighbours to the current node.
 * Enqueue the neighbours to the queue.
 * Add the
 */
public class CloneGraph {

    Node cloneGraph(Node node) {

        if (node == null) return null;

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);

        Node clone = new Node(node.val);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            visited.add(current);

            for (Node neighbour : current.neighbors) {
                if (visited.contains(neighbour)) {
                    continue;
                }
                clone.neighbors.add(neighbour);
                queue.offer(neighbour);
            }

            clone.val = current.val;

        }

        return clone;
    }

}
