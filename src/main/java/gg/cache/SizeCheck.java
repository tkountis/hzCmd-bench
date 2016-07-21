package gg.cache;

import gg.cache.base.CacheBench;
import global.AssertionException;


public class SizeCheck extends CacheBench {

    private boolean running=true;
    public int size=0;

    public void timeStep() throws AssertionException {

        if(cache.size()!=size){
            throw new AssertionException("map "+cache.getName()+" size "+cache.size()+" != expected "+size);
        }
        running=false;
    }

    public boolean isRunning() { return running; }

    public boolean isSelfDetermined() {
        return true;
    }
}