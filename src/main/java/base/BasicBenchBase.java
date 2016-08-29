package base;

import remote.bench.Bench;

import java.util.ArrayList;
import java.util.List;

public abstract class BasicBenchBase implements Bench{

    public String ignore=null;
    private List<Class> ignoreClasses = null;

    public void init() throws Exception{

        if( ignore!=null ){
            ignoreClasses = new ArrayList<Class>();
            for (String className : ignore.split(":")) {
                Class c = Class.forName(className);
                ignoreClasses.add(c);
            }
        }
    }

    public boolean isSelfDetermined() {
        return false;
    }

    public boolean isRunning() {
        return false;
    }

    public List<Class> ignore(){
        return ignoreClasses;
    }
}