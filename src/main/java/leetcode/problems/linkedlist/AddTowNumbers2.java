package leetcode.problems.linkedlist;

public class AddTowNumbers2 {

    public static void main(String[] args) {

        final ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        final ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode resultNode = new AddTowNumbers2().addTwoNumbers(l1, l2);
        System.out.println(resultNode.val + " -> " + resultNode.next.val + " -> " + resultNode.next.next.val);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode headNode = null;
        ListNode lastNode = null;

        int carry = 0;
        while (l1 != null || l2 != null) {

            int digit1 = l1 != null ? l1.val : 0;
            int digit2 = l2 != null ? l2.val : 0;
            int sum = digit1 + digit2 + carry;
            int newDigit = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(newDigit);
            if (headNode == null) {
                headNode = newNode;
            }
            if (lastNode != null) {
                lastNode.next = newNode;
            }
            lastNode = newNode;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            lastNode.next = new ListNode(carry);
        }
        return headNode;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
