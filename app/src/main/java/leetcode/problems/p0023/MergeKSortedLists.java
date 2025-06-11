package leetcode.problems.p0023;

import leetcode.util.ListNode;

import java.util.PriorityQueue;

/**
 * For each {@link ListNode} in the list, we can add its elements to a tracked Min Heap.
 *
 * After iterating over all ListNodes, we can poll the Min Heap and create a new Linked List.
 *
 * Insertion into a Heap is at worst O(logn)
 * If N is the total length of all lists,u
 * then the complexity of this is O(logN)
 *
 * So this scaled logarithmically with the combined length of the lists.
 */
class MergeKSortedLists {

    ListNode mergeLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (ListNode listNode: lists) {
            traverseAndHeapifyListNode(listNode, minHeap);
        }

        ListNode head = new ListNode();
        ListNode current = head;

        while (!minHeap.isEmpty()) {
            current.next = new ListNode(minHeap.poll());
            current = current.next;
        }
        return head.next;
    }

    void traverseAndHeapifyListNode(ListNode listNode, PriorityQueue<Integer> minHeap) {
        ListNode current = listNode;

        while (current != null) {
            minHeap.offer(current.val);
            current = current.next;

        }
    }

}
