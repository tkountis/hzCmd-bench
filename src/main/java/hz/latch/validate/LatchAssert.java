package hz.latch.validate;

import global.AssertionException;
import hz.latch.base.LatchValidate;

public class LatchAssert extends LatchValidate {

    private boolean running=true;

    public void timeStep() throws AssertionException {

        int firstCount = latchCounts.get(0);
        for (int latchCount : latchCounts) {
            if (firstCount != latchCount) {
                throw new AssertionException("firstCount != latchCount "+firstCount+" != "+latchCount);
            }
        }
        running=false;
    }

    public boolean isRunning() { return running; }

    public boolean isSelfDetermined() {
        return true;
    }
}
