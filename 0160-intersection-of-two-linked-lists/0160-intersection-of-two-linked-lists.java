/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> a = new Stack();
        Stack<ListNode> b = new Stack();
        ListNode ptr = null;

        while(headA != null){
            a.push(headA);
            headA = headA.next;
        }
        while(headB != null){
            b.push(headB);
            headB = headB.next;
        }
        while (!a.isEmpty() && !b.isEmpty()) {
            ListNode r1 = a.pop();
            ListNode r2 = b.pop();

            if (r1 == r2) {
                ptr = r1;
                }
        }
        
        return ptr;
    }
}