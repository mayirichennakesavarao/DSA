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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1 || head == null){
            return head;
        }
          //skip the first left -1 nodes
        ListNode current = head;
        ListNode prev = null;
        while(true){
            ListNode check = current;
            for(int i=0;i<k;i++){
                if(check == null){
                    return head;
                }
                check = check.next;
            }
        ListNode last = prev;
        ListNode newEnd = current;
        //reverse between left and right
        
        ListNode next = current.next;
        for(int i=0; current != null && i < k;i++){
            current.next = prev;
            prev =current;
            current =next;
            if(next != null){
                next = next.next;
            }
        }
        if(last != null){
            last.next =prev;
        }
        else{
            head = prev;
        }
        newEnd.next = current;
        prev = newEnd;
 }}
}