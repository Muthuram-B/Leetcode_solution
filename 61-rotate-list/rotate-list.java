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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;
        /*Stack<ListNode> stack = new Stack<>();
        ListNode temp=head;
        int size=1;
        while(temp.next!=null){
            stack.push(temp);
            temp=temp.next;
            size+=1;
        }
        int count=0;
        k=k%size;
        while(count<k && stack.size()>0){
            ListNode curr= stack.pop();
            curr.next.next=head;
            head=curr.next;
            curr.next=null;
            count++;
        }
        return head;*/
        //another easy and efficent without an extra space
        ListNode tail=head;
        int size=1;
        while(tail.next!=null){
            size++;
            tail=tail.next;
        }
        tail.next=head;
        k=k%size;
        int sizeNewtail = size-k;
        ListNode newTail=head;
        for(int i=1; i<sizeNewtail ;i++){
            newTail=newTail.next;
        }
        ListNode newHead=newTail.next;
        newTail.next=null;
        return newHead;
    }
}