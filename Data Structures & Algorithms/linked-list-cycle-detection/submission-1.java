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
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)return false;

        ListNode back = head;
        ListNode front = head;

        while(true){
            if(front==null || front.next == null)return false;
            if(front.next == back) return true;

            back = back.next;
            front = front.next.next;
        }
    }
}
