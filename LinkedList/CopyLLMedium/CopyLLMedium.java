package CopyLLMedium;

import java.util.HashMap;

public class CopyLLMedium {

  public Node copyRandomList(Node head){
    HashMap<Node , Node> map = new HashMap<Node, Node>();
    Node current = head;

    while(current != null){
      Node copy = new Node(current.val);
      map.put(current , copy);
      current = current.next;
    }

    current = head;
    while(current != null){
      Node copy = map.get(current);
      copy.next = map.get(current.next);
      copy.random = map.get(current.random);
      current = current.next;
    }

    return map.get(head);
  }

  public static void main(String[] args) {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);

    node1.next = node2;
    node2.next = node3;

    node1.random = node3;
    node2.random = node1;
    node3.random = node2;

    CopyLLMedium copyLLMedium = new CopyLLMedium();

    Node copiedHead = copyLLMedium.copyRandomList(node1);

    System.out.println("Original LL");
    while(node1 != null){
      System.out.print(node1.val + " -> " );
      node1 = node1.next;
    }

    System.out.println("\nCopied LL");
    while(copiedHead != null){
      System.out.print(copiedHead.val + " -> " );
      copiedHead = copiedHead.next;
    }

  }
}
