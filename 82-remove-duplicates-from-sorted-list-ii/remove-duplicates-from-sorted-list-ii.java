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
        ListNode dummy=new ListNode(0);
        dummy.next=head;
              
            
        
        ListNode prev=dummy;
        ListNode curr=head;
        while(curr!=null){
            if(curr.next!=null && curr.val==curr.next.val){
                while(curr.next!=null && curr.val==curr.next.val){
                    curr=curr.next;
                }
                prev.next=curr.next;
            }else{
                prev=prev.next;
            }
            curr=curr.next;
        }

        return dummy.next;
    }
}
/*/* to make the traversal easier
        that is it can be make a duplicate copy*/
        /* 1->1->2->3
        prev=0
        curr=1
        while(curr!=null){
            if(1==1){
                while(1==1)
                cur=cur.next;
                while(1==1) cur=cur.next
                while(1!=2) {}
                prev.next=curr.next
                1->2
                prev=2
                curr=2
          while(curr!=null){
            if(2!=3)
            prev.next=3
            2->3
            prev=3
            curr=3

            Ans:2->3*/