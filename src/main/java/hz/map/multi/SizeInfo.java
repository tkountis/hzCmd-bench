package hz.map.multi;

import com.hazelcast.core.IMap;
import global.AssertionException;
import hz.map.base.MultiMapBench;

public class SizeInfo extends MultiMapBench {

    public void timeStep() throws AssertionException {
        System.out.println(this);

        for (IMap map : getMaps()) {
            String name = map.getName();
            System.out.println("map "+name+".size()="+map.size());
        }
        setRunning(false);
    }
}