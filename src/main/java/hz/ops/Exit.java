package hz.ops;

import hz.ops.base.OpsBase;

public class Exit extends OpsBase {

    public void timeStep() throws Exception {
        System.exit(0);
    }
}