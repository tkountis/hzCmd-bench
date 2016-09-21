package hz.map.sql.predicate;

import hz.map.base.MapBench;


public class AddIndex extends MapBench {

    public String field;
    public boolean ordered=true;

    public void timeStep() throws Exception {
        map.addIndex(field, ordered);
        setRunning(false);
    }
}