public class Node{
    int value;
    int key;
    Node next;
    Node previous;
    public Node(){}
}
class LRUCache {

    HashMap<Integer, Node> cache = new HashMap<>();
    Node head;
    Node tail;
    int capacity;
    public LRUCache(int capacity) {  
        this.capacity = capacity;      
    }
    
    public int get(int key) {
        //Get from list
        Node node = getFromCache(key);
        if(node == null) return -1;
        //Remove node from exisiting position if exists
        Node currentNode = removeFromPosition(node);
        //add to end
        addToEnd(currentNode);
        return node.value;
    }
    
    public void put(int key, int value) {
        
        //Get from list
        Node node = getFromCache(key);
        if(node == null){ 
           if(cache.size() >= capacity){
            Node lru = removeFromPosition(head);
            cache.remove(lru.key);
           }
           Node newNode = new Node();
           newNode.key = key;
           newNode.value = value;
           addToEnd(newNode);
           cache.put(key, newNode);
        }
        else{
            node.value = value;
            Node currentNode = removeFromPosition(node);
            addToEnd(currentNode);
        }

    }

    public Node getFromCache(int key){
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        return null;
    }

    public Node removeFromPosition(Node node){
        if(node.next != null){
            node.next.previous = node.previous;
        }else {    
            tail = node.previous;
        } 
        if(node.previous != null){
            node.previous.next = node.next;
        }else{
            head = node.next; 
        }
        node.previous = null; 
        node.next = null;
        return node;
    }

    public void addToEnd(Node node){
        if(head == null){
            head = node;
        }
        if(tail == null){
            tail = node;
            return;
        }
        node.previous = tail;
        tail.next = node;
        tail = node;
    }
}
