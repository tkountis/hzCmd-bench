package hz.map;

import hz.map.base.MapBench;

public class Put extends MapBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        Object v = mapKeyToValue(k);
        map.put(k, v);
    }

}