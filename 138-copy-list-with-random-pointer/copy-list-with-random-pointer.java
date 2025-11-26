/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        //create a new list with the same values
        Node curr=head;
        while(curr!=null){
            Node newNode=new Node(curr.val);
            newNode.next=curr.next;
            curr.next=newNode;
            curr=newNode.next;
        }
        // to assign the copy of random pointers
        curr=head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }
        /*traverse the new copy by separting the list of orginal and traverse the copy by newHead curr and return the copy of it*/
        curr=head;
        Node newHead=head.next;
        Node newCurr=newHead;
        while(curr!=null){
            curr.next=newCurr.next;
            curr=curr.next;
            if(curr!=null){
                newCurr.next=curr.next;
                newCurr=newCurr.next;
            }
        }
        return newHead;
    }
}