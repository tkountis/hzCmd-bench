package hz.ops;

import hz.ops.base.OpsBase;

import java.util.ArrayList;
import java.util.List;

public class Oome extends OpsBase {

    protected List<byte[]> leak = new ArrayList<byte[]>();
    protected int size=10000;

    public void timeStep() throws Exception {
        leak.add(new byte[size]);
    }
}