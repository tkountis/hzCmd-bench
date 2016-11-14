package hz.map.listener;

import global.AssertionException;
import hz.map.base.MapBench;

public class EntryUpdate extends MapBench {

    public int updateTime=30;
    private EntryUpdateCounter counter= new EntryUpdateCounter();

    public void init() throws Exception{
        super.init();
        map.addEntryListener(counter, true);
    }

    public void timeStep() throws AssertionException {
        if(!counter.updatedIn(updateTime)){
            throw new AssertionException(map.getName()+"="+map.size()+" "+counter.toString());
        }
    }

}