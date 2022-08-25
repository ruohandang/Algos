import java.util.Arrays;

public class MyHashMap<K, V> {


    // node is a static class of HashMap
    public static class Node<K, V>{
        final K key;
        V value;
        Node<K, V> next;
        Node(K key, V value){
            this.key = key;
            this.value = value;
        }
        public K getKey(){
            return key;
        }
        public V getValue(){
            return value;
        }
        public void setValue(V value){
            this.value = value;
        }
    }

    // global constant
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private static final int SCALE_FACTOR = 2;

    private Node<K, V>[] array;
    private int size; // how many key-value pairs are actually stored in the hashmap
    private float loadFactor;// determine when to rehash

    public MyHashMap(){
        this.array = (Node<K,V>[]) new Node[DEFAULT_CAPACITY];
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }
    public MyHashMap(int cap, float loadFactor){
        if(cap<=0){
            throw  new IllegalArgumentException();
        }
        this.array = (Node<K,V>[]) new Node[cap];
        this.loadFactor = loadFactor;
        this.size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        Arrays.fill(this.array, null);
        size = 0;
    }
    private int hash(K key){
        if(key==null) return 0;
        return key.hashCode() & 0X7FFFFFFF;
    }

    private int getIndex(K key){
        return hash(key)%array.length;
    }

    private boolean equalsValue(V v1, V v2){
        return v1 == v2 || v1 != null && v1.equals(v2);
    }

    // traverse whole array to find the value
    public boolean containsValue(V v){
        if(isEmpty()) return false;
        for(Node<K,V> node: array){
            if(equalsValue(node.value, v)){
                return true;
            }
            node = node.next;
        }
        return false;
    }
    private boolean equalsKey(K k1, K k2){
        return k1 == k2 || k1 != null && k1.equals(k2);
    }

    private boolean containsKey(K key){
        int index = getIndex(key);
        Node<K, V> node = array[index];
        while (node != null){
            if(equalsKey(node.key, key)){
                return true;
            }
            node = node.next;
        }
        return false;
    }
    public V get(K key){
        int index = getIndex(key);
        Node<K, V> node = array[index];
        while (node != null){
            if(equalsKey(node.key, key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    // insert/ update
    public V put(K key, V value){
        int index = getIndex(key);
        Node<K, V> head = array[index];
        Node<K, V> node = head;
        while (node!=null){
            if(equalsKey(node.key, key)){
                V result = node.value;
                node.value = value;

            }
            node = node.next;
        }
        //
        // append the new node before the head and update the new head insert operation
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = head;
        array[index] = newNode; // this is new head
        size++;
        if(needRehashing()){
            rehashing();
        }
        return null;
    }



    private boolean needRehashing() {
        // float loadFactor
        float ratio = (size+0.0f) / array.length;
        return ratio >= loadFactor;
    }

    private void rehashing() {
        // new doubled size array
        // for each node in the old array. put to the new array
        Node<K, V>[] oldArray = array;
        array = (Node<K, V>[]) (new Node[array.length * SCALE_FACTOR]);
        // now array is new array
        for(Node<K,V> node : oldArray){
            while (node !=null){
                Node<K, V> next = node.next;
                int index = getIndex(node.key); // get the new index cuz array length changed to new array length!!!!
                node.next = array[index];
                array[index] = node; // put the node to the index
                node = next; // iterate the linked list to put all nodes from the top to the bottom

            }
        }
    }

    public V remove(K key){
        int index = getIndex(key);
        Node<K, V> node = array[index];
        Node<K, V> prev = null;
        while (node != null){
            if(equalsKey(node.key, key)){
                if(prev != null){
                    prev.next = node.next; // a node which is not head
                }else{
                    array[index] = node.next; // the head is the node we wanted to remove
                }
                size--;
                return node.value;
            }
            prev = node;
            node = node.next;
        }
        return null;
    }

}
