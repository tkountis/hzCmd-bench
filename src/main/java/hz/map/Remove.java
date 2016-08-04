package hz.map;

import hz.map.base.MapBench;

public class Remove extends MapBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        map.remove(k);
    }
}