package leetcode.problems.p0206;

import java.util.logging.Logger;

import leetcode.util.ListNode;

class ReverseLinkedList {

    private static final Logger logger = Logger.getLogger(ReverseLinkedList.class.getName());

    ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next; // Get the next node and assign it temp.
            current.next = prev; // reverse pointer of current (1 -> null) (2 -> 1) ... (5 -> 4)
            prev = current; // For the next iteration, make prev the current
            current = next; // Make current the next node. Eventually null.
        }
        return prev;
    }

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();

        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode reversed = reverseLinkedList.reverseList(node1);
        logger.info("Answer: " + reversed);
    }
}
