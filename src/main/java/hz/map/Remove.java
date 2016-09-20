package hz.map;

import hz.map.base.MapBench;

public class Remove extends MapBench {

    public void timeStep() {
        map.remove(randomKey());
    }
}