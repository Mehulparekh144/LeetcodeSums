public class AddTwoMedium {

  public ListNode addTwoNumbers(ListNode l1 , ListNode l2){
    ListNode dummy = new ListNode();
    ListNode current = dummy;
    int carry = 0;

    while(l1 != null || l2!= null ){
      int val1;
      int val2;
      if(l1 !=null){
        val1 = l1.val;
      } else{
        val1 = 0;
      }

      if(l2 != null){
        val2 = l2.val;
      }
      else{
        val2 = 0;
      }

      int digit = val1 + val2 + carry;
      carry = digit/10;
      digit = digit%10;
      current.next = new ListNode(digit);
      current = current.next;

      if(l1 != null){
        l1 = l1.next;
      } else {
        l1 = null;
      }

      if(l2 != null){
        l2 = l2.next;
      }
      else{
        l2 = null;
      }

    }

    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);

    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);

    AddTwoMedium adder = new AddTwoMedium();
    ListNode result = adder.addTwoNumbers(l1,l2);

    while(result != null){
      System.out.println(result.val);
      result = result.next;
    }
  }

}
