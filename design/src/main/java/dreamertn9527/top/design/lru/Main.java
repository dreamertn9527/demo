package dreamertn9527.top.design.lru;


public class Main {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		cache.put("1", "1");
		cache.put("2", "2");
		cache.put("3", "3");
		cache.put("4", "4");
		
		System.out.println(cache.get("1"));
		
		System.out.println(cache.toString());
		
		System.out.println(cache.get("3"));
		System.out.println(cache.get("3"));
		
		
		System.out.println(cache.toString());
		
		LRUCacheTwo two = new LRUCacheTwo(2);
		two.put("1", "1");
		two.put("2", "2");
		two.put("3", "3");
		two.put("4", "4");
		
		System.out.println(two.get("1"));
		System.out.println(two.get("2"));
		System.out.println(two.get("3"));
		System.out.println(two.get("4"));
	}
}
