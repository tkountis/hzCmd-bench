package hz.map.validate;

import global.AssertionException;
import hz.map.validate.base.LockValidate;

public class MapLockAssert extends LockValidate {

    public void timeStep() throws AssertionException {

        for (int i=0; i<keyDomain; i++) {
            System.out.println(getInfoFor(i));
        }

        for (int i=0; i<keyDomain; i++) {
            if( getIncrementFor(i) != (Integer) map.get(getKey(i)) ){
                throw new AssertionException(getInfoFor(i));
            }
        }

        for (int i=0; i<keyDomain; i++) {
            if( map.isLocked(getKey(i)) ){
                throw new AssertionException(map.getName()+".isLocked("+i+")==true");
            }
        }
        setRunning(false);
    }
}