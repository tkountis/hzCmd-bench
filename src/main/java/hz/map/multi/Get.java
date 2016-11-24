package hz.map.multi;

import hz.map.base.MultiMapBench;

import java.util.concurrent.ExecutionException;

public class Get extends MultiMapBench {

    public int timeout=0;

    public void timeStep() throws InterruptedException, ExecutionException {
        getMap().get(randomKey());
    }
}