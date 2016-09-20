package hz.map;

import hz.map.base.MapBench;

public class ContainsKey extends MapBench {

    public void timeStep() {
        map.containsKey(randomKey());
    }
}