package gg.cache;

import gg.cache.base.CacheBench;

public class Load extends CacheBench {

    private int key=0;

    public void init(){
        super.init();
    }

    public void timeStep() {
        while(! ignite.affinity(cache.getName()).isPrimary(ignite.cluster().localNode(), key)){
            key++;
        }

        int idx = random.nextInt(valueSet.size());
        Object val = valueSet.get(idx);

        cache.put(key, val);
        key++;
    }

    public boolean isRunning() {
        return key<keyDomain;
    }

    public boolean isSelfDetermined() {
        return true;
    }

    public void cleanup() {
        System.out.println("cache "+cache.getName()+" size="+cache.size());
    }
}