package hz.map;

import hz.map.base.MapBench;

public class Get extends MapBench {

    public void timeStep() {
        map.get(randomKey());
    }
}