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

    public Object get(Object key){
        LRUNode node = cache.get(key);
        if(node != null){
            remove(tail);
            setHead(node);
            cache.put(key, node);
            return node.value;
        }

        return null;
    }

    public void set(Object key, Object value){
        LRUNode node = cache.get(key);
        if(node != null){
            node.value = value;
        } else {
            node = new LRUNode(key, value);
            if(cache.size() >= capacity){
                remove(tail);
            }
        }

        cache.put(key, node);
        setHead(node);
    }

    private void remove(LRUNode node){
        if(head.next == null){
            head = null;
        } else {
            tail.pre.next = null;
        }
        tail = tail.pre;

        cache.remove(node.key);
    }

    private void setHead(LRUNode node){
        if(head != null){
            node.next = head;
            head.pre = node;
        }
        head = node;

        if(tail == null){
            tail = node;
        }
    }

    private LRUCache(){}

    public LRUCache(Integer capacity){
        this.capacity = capacity;
        this.cache = new HashMap<>();
    }

    private static class LRUNode{
        private Object key;

        private LRUNode pre;

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
        sb.append("size: ").append(cache.size()).append("\n");
        sb.append("head: ").append("{").append(head.key).append(",").append(head.value).append("}").append("\n");
        for(Map.Entry<Object, LRUNode> entry : cache.entrySet()){
            sb.append("{").append(entry.getValue().key).append(",").append(entry.getValue().value);
            sb.append("},");
        }
        if(sb.length() > 0){
            sb = sb.deleteCharAt(sb.lastIndexOf(","));
        }
//        // 3
//        System.out.println(head.value);
//        // 4
//        System.out.println(head.next.value);
//        System.out.println(tail.value);

        return sb.toString();
    }
}
