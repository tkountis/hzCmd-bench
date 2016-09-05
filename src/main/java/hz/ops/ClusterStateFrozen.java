package hz.ops;

import com.hazelcast.cluster.ClusterState;
import hz.ops.base.OpsBase;

public class ClusterStateFrozen extends OpsBase {

    public void timeStep() throws Exception {
        hzInstance.getCluster().changeClusterState(ClusterState.FROZEN);
        setRunning(false);
    }

}