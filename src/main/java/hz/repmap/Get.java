package hz.repmap;

import hz.repmap.base.RepMapBench;

public class Get extends RepMapBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        map.get(k);
    }
}