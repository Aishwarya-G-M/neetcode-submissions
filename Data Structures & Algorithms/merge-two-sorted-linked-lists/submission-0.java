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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode newTempHead = dummy;
        ListNode node1 = list1;
        ListNode node2 = list2;

        while(node1!= null && node2!=null){
            if(node1.val <= node2.val){
                dummy.next = node1;
                while(node1!=null && node1.val <=node2.val){
                    node1 = node1.next;
                }
                while(dummy.next!=node1){
                    dummy = dummy.next;
                }
            }else{
                dummy.next = node2;
                while(node2!=null && node2.val <= node1.val){
                    node2 = node2.next;
                }
                while(dummy.next!=node2){
                    dummy = dummy.next;
                }
            }
        }

        if(node1==null){
            dummy.next = node2;
        }else{
            dummy.next = node1;
        }
        return newTempHead.next;
    }
}