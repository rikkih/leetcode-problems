package leetcode.problems.p0021;

import leetcode.util.ListNode;

class MergeTwoSortedLists {
    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        var l13 = new ListNode(8);
        var l12 = new ListNode(5, l13);
        var l11 = new ListNode(3, l12);

        var l22 = new ListNode(4);
        var l21 = new ListNode(1, l22);

        MergeTwoSortedLists merge = new MergeTwoSortedLists();
        merge.merge(l11, l21);
    }
}