package stacksandhash.hashing;

import java.util.LinkedList;

/**
 * CustomHashMap - A generic but simple implementation of a hash map.
 * Uses separate chaining (linked lists) to handle collisions.
 */
public class CustomHashMap<K, V> {

    // Node class to store key-value pairs
    private class Node {
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node>[] buckets;
    private int size;
    private static final int INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        this.buckets = new LinkedList[INITIAL_CAPACITY];
        this.size = 0;
    }

    // Hash function to map key to bucket index
    private int getBucketIndex(K key) {
        int hashCode = (key == null) ? 0 : key.hashCode();
        return Math.abs(hashCode) % buckets.length;
    }

    // Insert or update key-value pair
    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new LinkedList<>();
        }

        // Search if key already exists
        for (Node node : buckets[bucketIndex]) {
            if (node.key.equals(key)) {
                node.value = value; // Update
                return;
            }
        }

        // Add new node
        buckets[bucketIndex].add(new Node(key, value));
        size++;
    }

    // Retrieve value by key
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Node> bucket = buckets[bucketIndex];
        if (bucket != null) {
            for (Node node : bucket) {
                if (node.key.equals(key)) {
                    return node.value;
                }
            }
        }
        return null;
    }

    // Remove key-value pair
    public void remove(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Node> bucket = buckets[bucketIndex];
        if (bucket != null) {
            Node target = null;
            for (Node node : bucket) {
                if (node.key.equals(key)) {
                    target = node;
                    break;
                }
            }
            if (target != null) {
                bucket.remove(target);
                size--;
            }
        }
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 22);

        System.out.println("Alice's age: " + map.get("Alice"));
        map.remove("Bob");
        System.out.println("Bob's age after removal: " + map.get("Bob"));
    }
}
