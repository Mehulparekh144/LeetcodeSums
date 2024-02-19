import java.util.List;

public class ReverseLLEasy {
//  ITERATIVE METHOD

//  public ListNode reverseList(ListNode head) {
//    ListNode curr = head;
//    ListNode prev = null;
//    ListNode next;
//    while (curr != null){
//      next = curr.next;
//      curr.next = prev;
//      prev = curr;
//      curr = next;
//    }
//
//    return prev;
//  }

//  RECURSIVE METHOD
  public ListNode reverseList(ListNode head){
    ReverseLLEasy reverser = new ReverseLLEasy();
    return reverser.helper(null , head);
  }
  public ListNode helper(ListNode prev , ListNode curr){
    if(curr != null){
      ListNode next = curr.next;
      curr.next = prev;
      return helper(curr , next);
    }
    else{
      return prev;
    }

  }

  public static void main(String[] args){
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);

    ReverseLLEasy reverser = new ReverseLLEasy();
    ListNode reversedHead = reverser.reverseList(head);

    while(reversedHead != null){
      System.out.println(reversedHead.val);
      reversedHead = reversedHead.next;

    }
  }

}