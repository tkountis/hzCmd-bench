package hz.atomic.validate;

import global.AssertionException;
import hz.atomic.base.AtomicValidate;

public class CasAssert extends AtomicValidate {

    private boolean running=true;

    public void timeStep() throws AssertionException {
        if(totalInc.get() != atomic.get()){
            throw new AssertionException(totalInc.getName()+" "+totalInc.get()+" != "+atomic.getName()+" "+" "+atomic.get());
        }
        running=false;
    }

    public boolean isRunning() { return running; }

    public boolean isSelfDetermined() {
        return true;
    }
}