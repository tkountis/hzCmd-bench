package hz.map;

import hz.map.base.MapBench;

public class FillStr extends MapBench {

    public void timeStep() {
        for(int k=0; k<keyDomain; k++){
            Object v = mapKeyToValue(k);
            map.set(""+k, ""+v);
        }
        setRunning(false);
    }
}