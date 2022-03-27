/***
@author shetu2153@gmail.com
Problem: Delete Node in a Linked List
Leetcode Problem Number: 237
****/

public class LeetcodeProblem237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    
}
