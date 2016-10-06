package hz.map;

import hz.map.base.MapBench;

public class Fill extends MapBench {

    private int k=0;

    public void timeStep() {
        Object key =  getKey(k);
        Object val =  mapKeyToValue(k);
        map.set(key, val);
        k++;
    }

    public boolean isRunning() {
        return k<keyDomain;
    }
}