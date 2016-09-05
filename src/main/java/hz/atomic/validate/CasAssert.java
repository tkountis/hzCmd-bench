package hz.atomic.validate;

import global.AssertionException;
import hz.atomic.validate.base.AtomicValidate;

public class CasAssert extends AtomicValidate {

    public void timeStep() throws AssertionException {

        for(int i=0; i<count; i++){
            System.out.println( infoStr(i) );
        }

        for(int i=0; i<count; i++){
            if( getAtomic(i).get() != getExpectedIncrement(i) ) {
                throw new AssertionException(infoStr(i));
            }
        }
        setRunning(false);
    }

    public void postPhase() {
        destroy();
    }
}