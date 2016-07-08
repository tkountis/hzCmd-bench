package hz.map;

import global.AssertionException;
import hz.map.base.MapBench;


public class SizeCheck extends MapBench {

    public int size;

    public void timeStep() throws AssertionException {

        if(map.size()!=size){
            throw new AssertionException("map "+map.getName()+" size "+map.size()+" != expected "+size);
        }
    }

    public boolean isRunning() { return false; }

    public boolean isSelfDetermined() {
        return true;
    }
}