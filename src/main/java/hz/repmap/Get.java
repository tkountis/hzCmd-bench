package hz.repmap;

import hz.repmap.base.RepMapBench;

public class Get extends RepMapBench {

    public void timeStep() {
        map.get(randomKey());
    }
}