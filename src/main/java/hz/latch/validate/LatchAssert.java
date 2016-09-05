package hz.latch.validate;

import global.AssertionException;
import hz.latch.validate.base.LatchValidate;

public class LatchAssert extends LatchValidate {


    public void timeStep() throws AssertionException {

        int firstCount = latchCounts.get(0);
        for (int latchCount : latchCounts) {
            if (firstCount != latchCount) {
                throw new AssertionException("firstCount != latchCount "+firstCount+" != "+latchCount);
            }
        }
        setRunning(false);
    }

}
