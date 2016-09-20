package gem.cache;

import gem.cache.base.RegionBench;

public class Get extends RegionBench {

    public void timeStep() {
        region.get(randomKey());
    }
}