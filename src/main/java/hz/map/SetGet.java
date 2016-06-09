package hz.map;

import hz.map.base.MapBench;

public class SetGet extends MapBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        Object v = mapKeyToValue(k);
        map.set(k, v);
        map.get(k);
    }
}