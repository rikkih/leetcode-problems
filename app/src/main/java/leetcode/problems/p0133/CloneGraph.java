package leetcode.problems.p0133;

import leetcode.util.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * We are going to traverse the graph using dfs, cloning its neighbours and
 * returning them.
 */
public class CloneGraph {

    Node cloneGraph(Node node) {
        Map<Node, Node> nodeToClone = new HashMap<>();

        return node == null ? null : clone(node, nodeToClone);
    }

    Node clone(Node node, Map<Node, Node> nodeToCloneMap) {
        if (nodeToCloneMap.containsKey(node)) {
            return nodeToCloneMap.get(node);
        }

        Node clone = new Node(node.val);
        nodeToCloneMap.put(node, clone);

        for (Node neighbour : node.neighbors) {
            Node clonedNeighbour = clone(neighbour, nodeToCloneMap);
            clone.neighbors.add(clonedNeighbour);
        }

        return clone;
    }

}
