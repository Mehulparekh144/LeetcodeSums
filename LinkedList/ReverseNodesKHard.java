public class ReverseNodesKHard {
  public ListNode reverseKGroup(ListNode head, int k){
    ListNode curr = head;

    for (int i = 0; i < k; i++) {
      if(curr == null){
        return head;
      }
      curr = curr.next;
    }

    curr = head;
    ListNode prev = null;
    for (int i = 0; i < k; i++) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;

    }

    head.next = reverseKGroup(curr , k);
    return prev;
  }
}
