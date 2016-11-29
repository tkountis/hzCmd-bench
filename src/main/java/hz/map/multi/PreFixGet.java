package hz.map.multi;

import hz.map.base.MultiMapBench;

import java.util.concurrent.ExecutionException;

public class PreFixGet extends MultiMapBench {

    public String prefix = "A";

    public void timeStep() throws InterruptedException, ExecutionException {
        getMap().get(prefix + randomKey());
    }
}