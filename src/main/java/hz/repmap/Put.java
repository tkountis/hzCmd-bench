package hz.repmap;

import hz.repmap.base.RepMapBench;

public class Put extends RepMapBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        Object v = mapKeyToValue(k);
        map.put(k, v);
    }

}