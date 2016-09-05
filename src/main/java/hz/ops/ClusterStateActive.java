package hz.ops;

import hz.ops.base.OpsBase;

public class ClusterStateActive extends OpsBase {

    public void timeStep() throws Exception {
        hzInstance.getCluster().changeClusterState(com.hazelcast.cluster.ClusterState.ACTIVE);
        setRunning(false);
    }

}