package hz.map;

import hz.map.base.MapBench;

public class Fill extends MapBench {

    private int k=0;

    public void timeStep() {
        String key = (String) getKey(k);
        String val = (String) mapKeyToValue(k);
        map.set(key, val);
        k++;
    }

    public boolean isRunning() {
        return k<keyDomain;
    }
}