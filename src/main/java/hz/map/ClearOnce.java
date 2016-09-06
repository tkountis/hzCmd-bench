package hz.map;

import hz.map.base.MapBench;

public class ClearOnce extends MapBench {

    public void timeStep() {
        map.clear();
        setRunning(false);
    }
}