package hz.ops;

import hz.ops.base.OpsBase;

public class ThrowException extends OpsBase {

    public void timeStep() throws Exception {
        running=false;
        throw new java.lang.Exception("ThrowException Requested");
    }

}