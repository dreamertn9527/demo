package dreamertn9527.top.design.lru;

import java.util.LinkedHashMap;

public class LRUCacheTwo extends LinkedHashMap{

	public LRUCacheTwo(int maxSize)
    {
        super(maxSize, 0.75F, true);
        maxElements = maxSize;
    }

    protected boolean removeEldestEntry(java.util.Map.Entry eldest)
    {
        return size() > maxElements;
    }

    private static final long serialVersionUID = 1L;
    
    protected int maxElements;
}
