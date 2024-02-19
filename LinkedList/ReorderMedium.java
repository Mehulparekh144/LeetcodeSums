public class ReorderMedium {

  public ListNode reverseList(ListNode head){
    ListNode curr = head;
    ListNode prev = null;
    ListNode next;
    while(curr !=null){
      next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return prev;
  }

  public void reorderList(ListNode head){
//    First part break the list
    ListNode slow = head;
    ListNode fast = head.next;

    while (fast != null  && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }

//    Reverse the list with head as slow
    ReorderMedium reorder = new ReorderMedium();
    ListNode first = head;
    ListNode second = reorder.reverseList(slow.next);
    slow.next = null;  // Do it to avoid cycle condition

//    Now join first and second heads alternately;
    while(second != null){
      ListNode tmp1 = first.next;
      ListNode tmp2 = second.next;

      first.next = second;
      second.next = tmp1;

      first = tmp1;
      second = tmp2;

    }



  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);

    ReorderMedium reorder  = new ReorderMedium();
    reorder.reorderList(head);

    while(head != null){
      System.out.println(head.val);
      head = head.next;
    }



  }
}
