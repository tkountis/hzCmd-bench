package hz.map;

import hz.map.base.MapBench;
import utils.Utils;

public class PutRange extends MapBench {

    public int minKeyDomain;
    public int maxKeyDomain;

    public void timeStep() {
        int k = Utils.randInt(random, minKeyDomain, maxKeyDomain);
        Object v = mapKeyToValue(k);
        map.put(k, v);
    }

}