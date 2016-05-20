package hz.map;

import hz.map.base.MapBench;

public class GetAsync extends MapBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        map.getAsync(k);
    }
}