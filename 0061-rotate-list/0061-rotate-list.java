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
        if(head == null || head.next == null || k == 0) return head;
        int l =1;
        ListNode first = head;
        while(first.next != null){
            first = first.next;
            l++;
        }
        first.next = head;
        k = k % l;
        k = l - k;
        while(k-- > 0){
            first = first.next;
        }
        head = first.next;
        first.next = null;
        return head;
        
    }
}