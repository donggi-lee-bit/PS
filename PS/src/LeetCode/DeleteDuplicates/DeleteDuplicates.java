package LeetCode.DeleteDuplicates;

import java.util.Arrays;
import java.util.HashSet;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        if (head.next != null && head.val == head.next.val) {
            return deleteDuplicates(head.next);
        }

        head.next = deleteDuplicates(head.next);
        return head;
    }
}















//public class DeleteDuplicates {
//    public ListNode deleteDuplicates(ListNode head) {
//        if (head == head.next) {
//            return head.next = head.next.next;
//        }
//    }
//
//    public static void main(String[] args) {
//        ListNode n = new ListNode();
//        DeleteDuplicates()
//    }
//}
//
//class Solution {
//    public ListNode deleteDuplicates(ListNode head) {
//        HashSet<Integer> hashSet = new HashSet<>();
//        ListNode prev = null;
//        ListNode now = head;
//        while(now != null){
//            if(hashSet.contains(now.val)){
//                prev.next = now.next;
//            } else {
//                hashSet.add(now.val);
//                prev = now;
//            }
//            now = now.next;
//        }
//        return head;
//    }
//}

//public ListNode deleteDuplicates(ListNode head) {
//    if(head == null)
//        return head;
//
//    if(head.next != null && head.next.val == head.val) {
//        return deleteDuplicates(head.next);
//    }
//
//    head.next = deleteDuplicates(head.next);
//    return head;
//}{



1. head가 null인 경우 null 반환하도록 하고

        2. 한번 prev, current 나눠서 해보세여

        리고 current가 null인지 여부를 생각
        값이 같은 경우 값이 다른 경우