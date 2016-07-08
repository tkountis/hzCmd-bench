package hz.map;

import global.AssertionException;
import hz.map.base.MapBench;


public class SizeCheck extends MapBench {

    private boolean running=true;
    public int size;

    public void timeStep() throws AssertionException {

        if(map.size()!=size){
            throw new AssertionException("map "+map.getName()+" size "+map.size()+" != expected "+size);
        }
        running=false;
    }

    public boolean isRunning() { return running; }

    public boolean isSelfDetermined() {
        return true;
    }
}