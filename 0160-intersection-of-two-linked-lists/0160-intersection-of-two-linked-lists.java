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
        while(headA != null){
            a.push(headA);
            headA = headA.next;
  
        }
        while(headB != null){
            b.push(headB);
            headB = headB.next;
        }

        ListNode ptr = null;
        while(!a.empty() && !b.empty()){
            ListNode r1 = a.pop();
            ListNode r2 = b.pop();

            if(r1.equals(r2)){
                ptr = r2;

            }
            
            
        }
        return ptr;


        
        
    }
}