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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode prev=head;
        ListNode temp=prev.next;

        while(temp!=null){
            if(prev.val==temp.val){ // it checks for adjacent value
                temp=temp.next; // move temp if it is same and skip remaining
                continue;
            }
            prev.next=temp; // map prev to next unique val
            prev=temp; // move prev and temp to find next unique val
            temp=temp.next;
        }
        prev.next=null;  // once end is reached make the last value points to null
        return head; // retur new sorted unique list
    }
}