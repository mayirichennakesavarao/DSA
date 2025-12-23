/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
   public static int lengthCycle(ListNode head) {
        ListNode  fast = head;
       ListNode  slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                //calculate length
                ListNode  temp=slow;
                int length =0;
                do{
                    temp=temp.next;
                    length++;
                }
                while(temp != slow);
                return length;
            }
        }
        return 0;
    }
    //leetcode question - 142
    public ListNode detectCycle(ListNode  head) {
        int length = 0;
        ListNode  fast = head;
        ListNode  slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                length = lengthCycle(slow);
                break;
            }
        }
        if(length == 0){
            return null;
        }
        //find the start node
        ListNode  f = head;
        ListNode  s = head;
        while(length > 0){
            s =s.next;
            length--;
        }
        while(f != s){
            f = f.next;
            s = s.next;
        }
        return s;

    }
}