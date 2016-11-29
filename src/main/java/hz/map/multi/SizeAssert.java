package hz.map.multi;

import com.hazelcast.core.IMap;
import global.AssertionException;
import hz.map.base.MultiMapBench;

public class SizeAssert extends MultiMapBench {

    public int size=0;

    public void timeStep() throws AssertionException {
        for (IMap map : getMaps()) {

            if(map.size()!=size){
                throw new AssertionException(map.getName()+".size()!="+size);
            }

        }
        setRunning(false);
    }
}