package hz.ops;

import global.AssertionException;
import hz.ops.base.OpsBase;

public class ClusterSize extends OpsBase {

    public int size=4;

    public void timeStep() throws Exception {

        if(hzInstance.getCluster().getMembers().size() != size){
            throw new AssertionException("cluster size "+hzInstance.getCluster().getMembers().size()+" != expected "+size);
        }
        setRunning(false);
    }

}