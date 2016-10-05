package coherence;

import coherence.base.CacheBench;

public class Get extends CacheBench {

    public void timeStep() {
        cache.get(randomKey());
    }
}