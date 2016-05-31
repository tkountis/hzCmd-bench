package hz.ops;

import hz.ops.base.OpsBase;

public class ClusterShutDown extends OpsBase {

    public void timeStep() throws Exception {

        System.out.println(this.getClass().getName()+" before hzInstance.getCluster().shutdown();");
        hzInstance.getCluster().shutdown();
        System.out.println(this.getClass().getName()+" after hzInstance.getCluster().shutdown();");
        running=false;
    }

}