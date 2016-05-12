package hz.id;

import hz.id.base.IdGenBench;

public class Gen extends IdGenBench{

    public void timeStep() throws Exception {
        id.newId();
    }

}
