package hz.ops;

import hz.ops.base.OpsBase;

public class HotSnapShot extends OpsBase {

    public void timeStep() throws Exception {
        hzInstance.getCluster().getHotRestartService().backup();
        setRunning(false);
    }

}