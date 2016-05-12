package hz.map;

import hz.map.base.MapBench;

public class ContainsKey extends MapBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        map.containsKey(k);
    }
}