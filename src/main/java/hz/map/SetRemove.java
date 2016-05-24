package hz.map;

import hz.map.base.MapBench;

public class SetRemove extends MapBench {

    public void timeStep() {
        int k = random.nextInt();
        Object v = mapKeyToValue(k);
        map.set(k, v);
        map.remove(k);
    }
}