package hz.ops;

import hz.ops.base.OpsBase;

public class ClusterVersion extends OpsBase {

    public String version;

    public void timeStep() throws Exception {
        //hzInstance.getCluster().getClusterVersion().(version);
        setRunning(false);
    }

}