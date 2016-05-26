package hz.ops;

import hz.ops.base.OpsBase;

import java.util.List;

public class Oome extends OpsBase {

    protected List<byte[]> leak;
    protected int size=10000;

    public void timeStep() throws Exception {
        leak.add(new byte[size]);
    }
}