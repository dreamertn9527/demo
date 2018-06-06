package dreamertn9527.top.design.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

	// LRU容量
	private int capacity;
	
	// 定义LRUֵ
	private Map<Object, Object> cache;
	
	// LRU构造函数
	public LRUCache(int capatity){
		this.capacity = capatity;
		this.cache = new LinkedHashMap<Object, Object>(capacity, 0.75f, true){

			private static final long serialVersionUID = 1L;

			// 重写removeEldestEntry，去除最近不使用的值
            protected boolean removeEldestEntry(Map.Entry<Object, Object> eldest) {
                return size() > capacity;
            }
		};
	}
	
	public Object get(Object key){
		if(cache.containsKey(key)){
			return cache.get(key);
		} else {
			return -1;
		}
	}
	
	
	public void put(Object key, Object value){
		cache.put(key, value);
	}
	
	
	public String toString(){
		StringBuffer str = new StringBuffer();
		for(Map.Entry<Object, Object> entry : cache.entrySet()){
			str.append("key: "+entry.getKey()+" value: "+entry.getValue()+"\n");
		}
		
		return str.toString();
	}
}
