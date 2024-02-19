import java.util.ArrayList;
import java.util.Arrays;

public class MergeKSortedHard {

  public ListNode mergeTwoLists(ListNode list1 , ListNode list2){
    if(list1 == null){
      return list2;
    }

    if(list2 == null){
      return list1;
    }

    if(list1.val < list2.val){
      list1.next = mergeTwoLists(list1.next , list2);
      return list1;
    }

    else{
      list2.next = mergeTwoLists(list1 , list2.next);
      return list2;
    }
  }
  public ListNode mergeKLists(ListNode[] lists){
    ArrayList<ListNode> newList = new ArrayList<>(Arrays.asList(lists));
    if (newList.size() == 0 ){
      return  null;
    }

    while(newList.size() > 1){
      ArrayList<ListNode> mergedLists = new ArrayList<ListNode>();
      for (int i = 0; i < newList.size(); i+=2) {
        ListNode l1 = newList.get(i);
        ListNode l2 = i+1 < newList.size() ? newList.get(i+1) : null;
        mergedLists.add(mergeTwoLists(l1,l2));

      }
      newList = mergedLists;
    }

    return newList.get(0);

  }

  public static void main(String[] args) {
    MergeKSortedHard merger = new MergeKSortedHard();

    ListNode[] lists = new ListNode[3];
    lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
    lists[1] = new ListNode(1, new ListNode(3, new ListNode(6)));
    lists[2] = new ListNode(2, new ListNode(7, new ListNode(8)));

    ListNode result = merger.mergeKLists(lists);

    // Print the merged list
    while(result !=null){
      System.out.println(result.val)
      ;
      result = result.next;
    }
  }
}
