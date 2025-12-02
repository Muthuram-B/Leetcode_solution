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
    public ListNode partition(ListNode head, int x) {
        ListNode smallerNode = new ListNode(-1);
        ListNode smaller = smallerNode;
        ListNode largerNode = new ListNode(-1);
        ListNode larger =largerNode;
        ListNode curr=head;
        while(curr!=null){
            if(curr.val<x){
                smaller.next=curr;
                smaller=smaller.next;
            }else{
                larger.next=curr;
                larger=larger.next;
            }
            curr=curr.next;
        }
        smaller.next=largerNode.next;
        larger.next=null;
        return smallerNode.next;
    }
}