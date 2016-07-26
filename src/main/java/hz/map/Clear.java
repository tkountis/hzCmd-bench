package hz.map;

import hz.map.base.MapBench;

public class Clear extends MapBench {

    public void timeStep() {
        map.clear();
    }
}