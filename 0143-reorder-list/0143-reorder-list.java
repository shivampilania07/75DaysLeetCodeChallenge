/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        //Algo:-
        // 1.find mid - TC- O(n/2)
        // 2.reverse second half after detaching - TC- O(n/2)
        // 3.insert 2nd list into 1st - TC- O(n/2)

        //TC- O(n) SC-O(n)

        //edge case ---
        if(head == null || head.next == null || head.next.next == null){
            return;
        }

        //step-1 find the middle
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondhead = slow.next;

        //Step-2 Detach the two Linkedlist
        slow.next = null;

        //Step-3 Reverse the LinkedList
        ListNode curr = secondhead;
        ListNode prev = null;

        while(curr != null){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        //Step-4 Insert Node of 2nd list into 1st list
        ListNode t1 = head;
        ListNode t2 = prev;

        while(t2!=null){
            ListNode m1 = t1.next;
            ListNode m2 = t2.next;

            t1.next = t2;
            t2.next = m1;
            t1 = m1;
            t2 = m2;
        }
    }
}