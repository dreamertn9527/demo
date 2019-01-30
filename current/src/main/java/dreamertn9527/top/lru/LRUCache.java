package dreamertn9527.top.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 原理：实现双向链表，每次查询数据，新增数据，都放在链表的头部
 *      当超出容量时，删除掉尾部的数据
 */
public class LRUCache<K, V> {

    private Map<Object, LRUNode> cache;

    private LRUNode head;

    private LRUNode tail;

    private Integer capacity;

    public void set(String key, Object value) {
        LRUNode node = cache.get(key);
        if (node != null) {
            node = cache.get(key);
            node.value = value;
            remove(node, false);
        } else {
            node = new LRUNode(key, value);
            if (cache.size() >= capacity) {
                // 每次容量不足时先删除最久未使用的元素
                remove(tail, true);
            }
            cache.put(key, node);
        }
        // 将刚添加的元素设置为head
        setHead(node);
    }

    public Object get(String key) {
        LRUNode node = cache.get(key);
        if (node != null) {
            // 将刚操作的元素放到head
            remove(node, false);
            setHead(node);
            return node.value;
        }
        return null;
    }

    private void setHead(LRUNode node) {
        // 先从链表中删除该元素
        if (head != null) {
            node.next = head;
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
    }

    // 从链表中删除此Node，此时要注意该Node是head或者是tail的情形
    private void remove(LRUNode node, boolean flag) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
        node.next = null;
        node.prev = null;
        if (flag) {
            cache.remove(node.key);
        }
    }

    private LRUCache(){}

    public LRUCache(Integer capacity){
        this.capacity = capacity;
        this.cache = new HashMap<>();
    }

    private static class LRUNode{
        private Object key;

        private LRUNode prev;

        private LRUNode next;

        private Object value;

        public LRUNode(Object K, Object V){
            this.key = K;
            this.value = V;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        LRUNode node = head;
        while (node != null){
            sb.append("{").append(node.key).append(",").append(node.value);
            sb.append("},");
            node = node.next;
        }
        if(sb.length() > 0){
            sb = sb.deleteCharAt(sb.lastIndexOf(","));
        }
        return sb.toString();
    }
}
