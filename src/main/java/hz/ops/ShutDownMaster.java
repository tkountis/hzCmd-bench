package hz.ops;

import com.hazelcast.core.Member;
import hz.ops.base.OpsBase;


public class ShutDownMaster extends OpsBase {

    public void timeStep() throws Exception {

        Member master = hzInstance.getCluster().getMembers().iterator().next();
        boolean isMaster = hzInstance.getCluster().getLocalMember().equals(master);

        if(isMaster){
            hzInstance.shutdown();
        }
        setRunning(false);
    }

}