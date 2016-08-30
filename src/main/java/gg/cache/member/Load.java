package gg.cache.member;

import gg.cache.base.CacheBench;

public class Load extends CacheBench {

    private int key=0;

    public void init() throws Exception{
        super.init();
    }

    public void timeStep() {

        while(! ignite.affinity(cache.getName()).isPrimary(ignite.cluster().localNode(), key)){
            key++;
        }

        if(key >= keyDomain){
            return;
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
}