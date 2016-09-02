package hz.map;

import global.AssertionException;
import hz.map.base.MapBench;

public class Info extends MapBench {

    private boolean running=true;

    public void timeStep() throws AssertionException {

        System.out.println(this);

        String mapName = map.getName();
        System.out.println("map "+mapName);
        System.out.println("map "+mapName+".size()="+map.size());

        for(int i=0; i<map.size(); i++){
            System.out.println(mapName+".get("+i+")="+map.get(i));
            System.out.println(mapName+".isLocked("+i+")="+map.isLocked(i));
        }

        running=false;
    }

    public boolean isRunning() { return running; }

    public boolean isSelfDetermined() {
        return true;
    }
}