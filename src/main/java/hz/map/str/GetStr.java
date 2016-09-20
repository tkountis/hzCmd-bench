package hz.map.str;

import hz.map.str.base.StrMapBench;

public class GetStr extends StrMapBench {

    public void timeStep() {
        map.get(randomKey());
    }
}