import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {

        int capacity;
        Map<Integer,Integer> record;

        public LRU(int capacity) {
            this.capacity = capacity;
            record = new LinkedHashMap<>();
        }

        // TC: O(1)
        public int get(int key) {
            if(!record.containsKey(key))
                return -1;
            //Since we treat "get()" as an event (as it helps us understand how recently a 'key' was accessed), we need a                     // 'remove-add' operation on "record" to record the key's order of access.
            Integer val = record.get(key);
            record.remove(key);
            record.put(key,val);
            return val;
        }

        // TC: O(1)
        public void put(int key, int value) {

            if(record.containsKey(key))
                record.remove(key);
            if(record.size() == capacity) {
                Iterator itr = record.keySet().iterator();
                if(itr.hasNext()) {
                    // Removing the top element of the map (As technically, it appeared before rest of the members of the map.)
                    Integer key_toRm = (Integer) itr.next();
                    record.remove(key_toRm);
                }
            }
            record.put(key,value); // Added at the record's tail.
        }

    public static void main(String[] args) {
            LRU lru = new LRU(3);
            lru.put(1,1);
            lru.put(2,2);
            lru.put(3,3);
            lru.get(2);
    }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

