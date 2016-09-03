package hz.atomic.validate;

import global.AssertionException;
import hz.atomic.validate.base.AtomicValidate;

public class CasAssert extends AtomicValidate {

    private boolean running=true;

    public void timeStep() throws AssertionException {
        for(int i=0; i<count; i++){
            if( getAtomic(i).get() != getExpectedIncrement(i) ) {
                throw new AssertionException(infoStr(i));
            }
        }
        running=false;
    }

    public boolean isRunning() { return running; }

    public boolean isSelfDetermined() {
        return true;
    }
}