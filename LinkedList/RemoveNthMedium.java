public class RemoveNthMedium
{

  public ListNode reverse(ListNode head){
    ListNode curr = head;
    ListNode prev = null;
    ListNode next;

    while(curr != null){
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return prev;
  }
  public ListNode removeNthFromEnd(ListNode head , int n){
//    BRUTE
//    ListNode reversedHead = reverse(head);
//    ListNode temp = reversedHead;
//    for (int i = 1; i < n ; i++) {
//      temp = temp.next;
//    };
//
//    reversedHead.next = temp.next;
//    temp.next = null;
//
//    return reverse(reversedHead);
    ListNode start =  new ListNode();
    start.next  = head;

    ListNode slow = start;
    ListNode fast = start;

    for (int i = 0; i <= n; i++) {
      fast = fast.next;
    }

    while (fast != null ){
      slow = slow.next;
      fast = fast.next;
    }

    slow.next = slow.next.next;
    return start.next;

  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);

    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    RemoveNthMedium remover = new RemoveNthMedium();
    ListNode removedHead = remover.removeNthFromEnd(head , 2);

    while (removedHead != null){
      System.out.println(removedHead.val);
      removedHead = removedHead.next;
    }
  }
}
