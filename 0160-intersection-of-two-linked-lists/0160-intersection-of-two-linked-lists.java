/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode dummy1 = headA;
        ListNode dummy2 = headB;
        HashSet<ListNode> set = new HashSet<>();

        while (dummy1 != null) {
            set.add(dummy1);
            dummy1=dummy1.next;
        }

        while(dummy2!=null){
            if(set.contains(dummy2)){
                return dummy2;
            }
            dummy2=dummy2.next;
        }

        return null;
    }
}