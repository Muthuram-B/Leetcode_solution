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
        /*Original:  7  -> 13 -> 11
After:     7' -> 7c -> 13 -> 13c -> 11 -> 11c
           (c means copy)
Step-by-step (with example)
Initial:

text
Copy code
curr = 7

7 -> 13 -> 11 -> null
Iteration 1 (curr = 7)

java
Copy code
Node newNode = new Node(curr.val);  // newNode = copy of 7
newNode.next = curr.next;           // newNode.next = 13
curr.next = newNode;                // 7 -> 7c -> 13
curr = newNode.next;                // curr = 13
List now:

text
Copy code
7 -> 7c -> 13 -> 11
Iteration 2 (curr = 13)

java
Copy code
newNode = copy of 13
newNode.next = 11
curr.next = newNode;        // 13 -> 13c -> 11
curr = newNode.next;        // curr = 11
List now:

text
Copy code
7 -> 7c -> 13 -> 13c -> 11
Iteration 3 (curr = 11)

java
Copy code
newNode = copy of 11
newNode.next = null
curr.next = newNode;     // 11 -> 11c
curr = newNode.next;     // curr = null (stop)
Final structure after first loop:

text
Copy code
7  -> 7c -> 13 -> 13c -> 11 -> 11c -> null
↑     ↑     ↑     ↑     ↑     ↑
org   copy  org   copy  org   copy*/
        Node curr=head;
        while(curr!=null){
            Node newNode=new Node(curr.val);
            newNode.next=curr.next;
            curr.next=newNode;
            curr=newNode.next;
        }
        // to assign the copy of random pointers
        /*here we assign the random values using the newNode we created
        Recall randoms:

7.random = null
13.random = 7
11.random = 13


After first loop, structure:

7  -> 7c -> 13 -> 13c -> 11 -> 11c


Iteration 1 (curr = 7)

curr.random = null → if fails → no change

curr = curr.next.next → curr = 7c.next = 13

Iteration 2 (curr = 13)

curr.random = 7 (original 7)

curr.next = 13c (copy)

curr.random.next = 7.next = 7c (copy of 7)

curr.next.random = curr.random.next;
// 13c.random = 7c


curr = curr.next.next → curr = 13c.next = 11

Iteration 3 (curr = 11)

curr.random = 13

curr.next = 11c

curr.random.next = 13c

11c.random = 13c;


End result:

7c.random = null

13c.random = 7c

11c.random = 13c ✅

We’ve now set all random pointers on the copied nodes correctly.*/
        curr=head;
        while(curr!=null){
            if(curr.random!=null){
                curr.next.random=curr.random.next;
            }
            curr=curr.next.next;
        }
        /*traverse the new copy by separting the list of orginal and traverse the copy by newHead curr and return the copy of it*/
        /*separate the copy list from the original list
        We now have:

7  -> 7c -> 13 -> 13c -> 11 -> 11c -> null
org  copy  org   copy  org   copy


We want to unlink them into two separate lists:

Original: 7 -> 13 -> 11

Copy: 7c -> 13c -> 11c

Variables

curr → walks original nodes.

newCurr → walks copy nodes.

newHead → head of copied list (head.next, i.e., first copy).

Step-by-step

Initially:

curr = 7
newHead = 7c
newCurr = 7c


Loop 1:

curr.next = newCurr.next;  // 7.next = 13  (skip 7c)
curr = curr.next;          // curr = 13
if (curr != null) {
    newCurr.next = curr.next; // 7c.next = 13c
    newCurr = newCurr.next;   // newCurr = 13c
}


Lists now:

Original: 7 -> 13 -> 11 -> 11c

Copy: 7c -> 13c -> 11c

Loop 2:

curr = 13
newCurr = 13c

curr.next = newCurr.next; // 13.next = 11
curr = curr.next;         // curr = 11

if (curr != null) {
    newCurr.next = curr.next; // 13c.next = 11c
    newCurr = newCurr.next;   // newCurr = 11c
}


Loop 3:

curr = 11
newCurr = 11c

curr.next = newCurr.next;  // 11.next = null
curr = curr.next;          // curr = null
if (curr != null) { ... }  // skipped


Final:

Original list: 7 -> 13 -> 11 -> null

Copy list (starting at newHead): 7c -> 13c -> 11c -> null

✅ newHead is your deep-copied list.*/
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