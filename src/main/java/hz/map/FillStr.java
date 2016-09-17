package hz.map;

import hz.map.base.MapBench;

public class FillStr extends MapBench {

    private int key=0;

    public void timeStep() {
        Object v = mapKeyToValue(key);
        map.set(""+key, ""+v);
        key++;
    }

    public boolean isRunning() {
        return key<keyDomain;
    }
}