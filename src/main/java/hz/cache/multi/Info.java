package hz.cache.multi;

import com.hazelcast.cache.ICache;
import global.AssertionException;
import hz.cache.base.MultiCacheBench;

public class Info extends MultiCacheBench {

    private boolean running=true;

    public void timeStep() throws AssertionException {
        System.out.println(this);

        for (ICache cache : getCaches()) {
            String name = cache.getName();
            System.out.println("cache "+name);
            System.out.println("cache "+name+".size()="+cache.size());
        }
        setRunning(false);
    }
}