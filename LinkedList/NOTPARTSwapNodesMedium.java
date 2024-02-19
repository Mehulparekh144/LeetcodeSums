import CopyLLMedium.Node;

public class NOTPARTSwapNodesMedium {

  public ListNode reverse(ListNode head){
    ListNode curr = head;
    ListNode prev = null;

    while(curr != null){
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }

    return prev;
  }
  public ListNode swapPairs(ListNode head) {
    ListNode dummy = new ListNode(0, head);
    ListNode prev = dummy;
    ListNode current = head;

    while(current != null && current.next != null ){
//      Assign Pointers
      ListNode nxtPair = current.next.next;
      ListNode second = current.next;

//      Reverse this pair
      second.next = current;
      current.next = nxtPair;
      prev.next = second;

//      Update the pointers
      prev = current;
      current = nxtPair;
    }

    return dummy.next;

  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);

    NOTPARTSwapNodesMedium swapper = new NOTPARTSwapNodesMedium();
    ListNode newHead = swapper.swapPairs(head);

    while(newHead != null){
      System.out.println(newHead.val);
      newHead = newHead.next;
    }

  }
}
