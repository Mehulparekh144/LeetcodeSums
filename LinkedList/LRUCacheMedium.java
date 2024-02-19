import java.util.HashMap;

public class LRUCacheMedium {

  class Node{
    public int key;
    public int val;
    public Node next;
    public Node prev;

    public Node(int key , int val){
      this.key = key;
      this.val = val;
      this.next = null;
      this.prev = null;
    }

  }
  class LRUCache{
    public int capacity;
    public Node head;
    public Node tail;
    public HashMap<Integer , Node> map = new HashMap<Integer , Node>();

    public LRUCache(int capacity){
      this.capacity = capacity;
      head = tail = new Node(0,0);
      head.next = tail;
      tail.prev = head;
    }

    public int get(int key){
      if(!map.containsKey(key)){
        return -1;
      }
      else{
        Node node = map.get(key);
        put(key , node.val);
        return node.val;
      }
    }

    public void put(int key , int val){
      if(map.containsKey(key)){
        Node node = map.get(key);
        removeNode(node);
        map.remove(node.key);
      } else if (map.size() == capacity) {
        Node node = this.tail.prev;
        removeNode(node);
        map.remove(node.key);
      }

      Node node = new Node(key , val);
      insertAtHead(node);
      map.put(key , node);

    }

    public void insertAtHead(Node node){
      node.next = this.head.next;
      node.prev = this.head;
      node.next.prev = node;
      node.prev.next = node;
    }

    public void removeNode(Node node){
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }

  }

  public static void main(String[] args) {
    LRUCacheMedium lruCacheMedium = new LRUCacheMedium();
    LRUCache lRUCache = lruCacheMedium.new LRUCache(2);
    lRUCache.put(1,1);
    System.out.println("Put done");
    lRUCache.put(2,2);
    System.out.println("Put done");
    System.out.println(lRUCache.get(1));
    lRUCache.put(3,3);
    System.out.println("Put done");
    System.out.println(lRUCache.get(2));
    lRUCache.put(4,4);
    System.out.println("Put done");
    System.out.println(lRUCache.get(1));
    System.out.println(lRUCache.get(3));
    System.out.println(lRUCache.get(4));
  }

}
