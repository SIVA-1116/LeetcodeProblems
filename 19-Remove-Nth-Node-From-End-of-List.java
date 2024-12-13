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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode();
        ListNode current=dummy;
        ListNode count=head;
        int i=0;
        while(count!=null){
            i++;
            count=count.next;
        }
        while(head!=null && i>1){
            if(i==n){
                current.next=new ListNode(head.next.val);
                head=head.next;
            }
                i--;
                current.next=new ListNode(head.val);
                current=current.next;
                head=head.next;
        }
        return dummy.next;
    }
}