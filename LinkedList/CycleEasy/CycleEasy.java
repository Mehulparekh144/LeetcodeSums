package CycleEasy;

public class CycleEasy {
  public boolean hasCycle(CycleListNode head){
    CycleListNode slow = head;
    CycleListNode fast = head;

    while(fast != null && fast.next !=null){
      slow = slow.next;
      fast = fast.next.next;

      if(slow == fast){
        return true;
      }
    }

    return false;
  }

  public static void main(String[] args) {

    CycleListNode head = new CycleListNode(1);
    head.next = new CycleListNode(2);
    head.next.next = new CycleListNode(3);
    head.next.next.next = new CycleListNode(4);

    // Uncomment the following line to create a cycle for testing
     head.next.next.next.next = head.next;

     CycleEasy cycleEasy = new CycleEasy();
     boolean hasCycle =cycleEasy.hasCycle(head);

    System.out.println(hasCycle);
  }


}

