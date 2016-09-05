package hz.ops;

import hz.ops.base.OpsBase;

public class ShutDown extends OpsBase {


    public void timeStep() throws Exception {
        hzInstance.shutdown();
        setRunning(false);
    }

}