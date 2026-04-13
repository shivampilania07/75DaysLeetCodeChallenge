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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //Step:-1 Find size of the List
        int size = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }

        //Edge Case - when n == size of linkedlist that means remove first element
        if(n == size){
            head = head.next;
            return head;
        }

        //Step 2:- Now, find index of that node to remove from starting
        int i = 1;
        int indexfromStart = size - n;
        
        //Step 3:- Now remove the node 
        ListNode prev = head;
        while(i<indexfromStart){
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return head;
    }
}