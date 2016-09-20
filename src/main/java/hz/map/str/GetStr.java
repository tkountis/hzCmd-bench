package hz.map.str;

import hz.map.base.MapBench;

public class GetStr extends MapBench {

    public void timeStep() {
        map.get(""+randomKey());
    }
}