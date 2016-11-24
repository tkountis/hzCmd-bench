package hz.map.multi;

import hz.map.base.MultiMapBench;

public class Clear extends MultiMapBench {
    public void timeStep() {
        getMap().clear();
    }
}