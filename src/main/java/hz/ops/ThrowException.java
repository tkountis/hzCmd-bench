package hz.ops;

import hz.ops.base.OpsBase;

public class ThrowException extends OpsBase {

    public void timeStep() throws Exception {
        setRunning(false);
        throw new java.lang.Exception("ThrowException Requested");
    }

}