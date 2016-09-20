package hz.map.str;

import hz.map.str.base.StrMapBench;

public class FillStr extends StrMapBench {

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