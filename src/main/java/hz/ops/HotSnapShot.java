package hz.ops;

import hz.ops.base.OpsBase;

public class HotSnapShot extends OpsBase {


    public void timeStep() throws Exception {
        //HotRestartBackupService hot = hzInstance
        setRunning(false);
    }

}