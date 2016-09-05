package hz.ops;

import hz.ops.base.OpsBase;

public class ClusterShutDown extends OpsBase {

    public void timeStep() throws Exception {
        hzInstance.getCluster().shutdown();
        setRunning(false);
    }

}