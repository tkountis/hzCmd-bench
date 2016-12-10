package hz.ops;

import com.hazelcast.hotrestart.BackupTaskState;
import global.AssertionException;
import hz.ops.base.OpsBase;

public class HotSnapShotEnd extends OpsBase {

    public void timeStep() throws Exception {
        BackupTaskState state = hzInstance.getCluster().getHotRestartService().getBackupTaskStatus().getState();

        if ( state.equals(BackupTaskState.SUCCESS) ) {
            setRunning(false);
        }
        if ( state.equals(BackupTaskState.FAILURE) ) {
            throw new AssertionException("state "+BackupTaskState.FAILURE);
        }
    }
}