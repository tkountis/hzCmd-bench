package hz.atomic;

import global.AssertionException;
import hz.atomic.base.AtomicCheckBench;

public class CasCheck extends AtomicCheckBench {

    private boolean running=true;

    public void timeStep() throws AssertionException {
        if(totalInc.get() != atomic.get()){
            throw new AssertionException(totalInc.getName()+" "+totalInc.get()+" != "+atomic.getName()+" "+" "+atomic.get());
        }
        running=false;
    }

    public void cleanup() {
        atomic.destroy();
        totalInc.destroy();
    }

    public boolean isRunning() { return running; }

    public boolean isSelfDetermined() {
        return true;
    }
}