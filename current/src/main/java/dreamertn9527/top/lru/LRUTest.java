package dreamertn9527.top.lru;

public class LRUTest {

    public static void main(String[] args) {
        LRUCache<String, Integer> lruCache = new LRUCache<>(5);

        lruCache.set("a", 1);
        lruCache.set("b", 2);
        lruCache.set("c", 3);
        lruCache.set("d", 4);

        lruCache.get("d");
        lruCache.get("c");

        lruCache.set("e", 5);
        lruCache.set("f", 6);
        lruCache.get("c");

        System.out.println(lruCache.toString());

    }
}
