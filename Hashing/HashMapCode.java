package Hashing;
import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCode {
    static class HashMap<K, V> {
        private class Node {
            K key;
            V value;

            Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int size; // n
        private LinkedList<Node>[] buckets; // N = buckets.length

        @SuppressWarnings("unchecked")
        public HashMap() {
            this.size = 0;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }

        private int hashFunction(K key) {
            int hc = key.hashCode();
            return (hc & 0x7fffffff) % buckets.length;
        }

        private int searchInLL(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;
            for (Node node : ll) {
                if (node.key.equals(key)) {
                    return di;
                }
                di++;
            }

            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node>[] oldBuckets = buckets;
            this.buckets = new LinkedList[2 * oldBuckets.length];
            for (int i = 0; i < 2 * oldBuckets.length; i++) {
                this.buckets[i] = new LinkedList<>();
            }

            this.size = 0;
            for (int i = 0; i < oldBuckets.length; i++) {
                LinkedList<Node> ll = oldBuckets[i];
                for (Node node : ll) {
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di == -1) {
                Node node = new Node(key, value);
                buckets[bi].addLast(node);
                this.size++;
            } else {
                Node node = buckets[bi].get(di);
                node.value = value;
            }

            double lambda = (this.size * 1.0) / buckets.length;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);
            return di != -1;
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                Node removedNode = buckets[bi].remove(di);
                this.size--;
                return removedNode.value;
            }

            return null;
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if (di != -1) {
                return buckets[bi].get(di).value;
            }

            return null;
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (LinkedList<Node> bucket : buckets) {
                for (Node node : bucket) {
                    keys.add(node.key);
                }
            }
            return keys;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 135);
        map.put("China", 200);
        map.put("Pak", 30);
        map.put("US", 20);
        map.put("UK", 10);
        map.put("Nigeria", 5);
        map.put("US", 25);

        System.out.println(map.get("India"));      // 135
        System.out.println(map.get("US"));         // 25
        System.out.println(map.get("UK"));         // 10
        System.out.println(map.get("Nigeria"));    // 5
        System.out.println(map.get("Pak"));        // 30
        System.out.println(map.get("China"));      // 200

        System.out.println(map.containsKey("India"));     // true
        System.out.println(map.containsKey("US"));        // true
        System.out.println(map.containsKey("UK"));        // true
        System.out.println(map.containsKey("Nigeria"));   // true
        System.out.println(map.containsKey("Pak"));       // true
        System.out.println(map.containsKey("China"));     // true

        System.out.println(map.keySet());   // [UK, US, China, Nigeria, Pak, India]
    }
}
