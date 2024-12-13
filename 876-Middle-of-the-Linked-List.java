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
    public ListNode middleNode(ListNode head) {
        ListNode dummy=new ListNode();
        ListNode current=dummy;
        ListNode count=head;
        int i=0;
        while(count!=null){
            i++;
            count=count.next;
        }
        int mid=0,j=1;
            mid=i/2+1;
            while(j<=i && head!=null){
                if(j>=mid){
                    current.next=new ListNode(head.val);
                    current=current.next;
                }
                head=head.next;
                j++;
            }
        
        // }else{
        //     mid=i/2+1;
        //     while(j<=i && head!=null){
        //         if(j>=mid){
        //             current.next=new ListNode(head.val);
        //             current=current.next;
        //         }
        //         head=head.next;
        //         j++;
        //     }
        // }

        return dummy.next;
    }
}