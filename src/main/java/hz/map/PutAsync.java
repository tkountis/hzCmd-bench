package hz.map;

import hz.map.base.MapBench;

public class PutAsync extends MapBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        Object v = mapKeyToValue(k);
        map.putAsync(k, v);
    }

}