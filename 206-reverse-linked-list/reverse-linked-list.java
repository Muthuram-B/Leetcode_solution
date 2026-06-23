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
    public ListNode reverseList(ListNode head) {
        // stack based approach
        // if you want to maintain the orginal linked list state 

// push the value in stack and then retrieve it as a Node and return it

 Stack<Integer> stack=new Stack<>();
 while(head!=null){
    stack.push(head.val);
    head=head.next;
 }

 ListNode reverselist=new ListNode(-1);
 ListNode ptr=reverselist;

 while(!stack.isEmpty()){
    ptr.next=new ListNode(stack.pop());
    ptr=ptr.next;
 }
 return reverselist.next; 
    }
}