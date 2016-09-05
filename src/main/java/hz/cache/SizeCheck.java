package hz.cache;

import global.AssertionException;
import hz.cache.base.CacheBench;


public class SizeCheck extends CacheBench {

    public int size=0;

    public void timeStep() throws AssertionException {

        if(cache.size()!=size){
            throw new AssertionException("map "+cache.getName()+" size "+cache.size()+" != expected "+size);
        }
        setRunning(false);
    }
}