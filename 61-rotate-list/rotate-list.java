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
            tail=tail.next;// it reaches last value 
        }
        //1->2->3->4  k=2  tail =4
        tail.next=head;// 3->1(head)
        k=k%size;//2%4 =2
        int sizeNewtail = size-k;//4-2=2
        ListNode newTail=head;//1(newTail)
        for(int i=1; i<sizeNewtail ;i++){/*
        1<2 true 
        newTail=2
        1->2  and 3->4*/
            newTail=newTail.next;
        }
        ListNode newHead=newTail.next;//newHead=3
        newTail.next=null;//2->null
        //1->2  and 3->4
        return newHead;//3->4->1->2->null
    }
}