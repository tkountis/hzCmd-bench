package hz.map;

import hz.map.base.MapBench;

public class GetStr extends MapBench {

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        map.get(""+k);
    }
}