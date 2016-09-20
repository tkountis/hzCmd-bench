package gg.cache;

import gg.cache.base.CacheBench;
import global.AssertionException;


public class SizeCheck extends CacheBench {

    public int size=0;

    public void timeStep() throws AssertionException {

        if(cache.size()!=size){
            throw new AssertionException("cache "+cache.getName()+" size "+cache.size()+" != expected "+size);
        }
        setRunning(false);
    }

}