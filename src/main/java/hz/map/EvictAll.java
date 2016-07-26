package hz.map;

import hz.map.base.MapBench;

public class EvictAll extends MapBench {

    public void timeStep() {
        map.evictAll();
    }
}