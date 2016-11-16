package hz.ops;

import global.AssertionException;
import hz.ops.base.OpsBase;

public class ClusterSafe extends OpsBase {

    public void timeStep() throws Exception {

        if( ! hzInstance.getPartitionService().isClusterSafe() ){
            throw new AssertionException("isClusterSafe()=false");
        }
        setRunning(false);
    }

}