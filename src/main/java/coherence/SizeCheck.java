package coherence;

import coherence.base.CacheBench;
import global.AssertionException;


public class SizeCheck extends CacheBench {

    public int size=0;

    public void timeStep() throws AssertionException {

        if(cache.size()!=size){
            throw new AssertionException("map "+cache+" size "+cache.size()+" != expected "+size);
        }
        setRunning(false);
    }
}