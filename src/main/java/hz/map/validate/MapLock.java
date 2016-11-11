package hz.map.validate;

import hz.map.validate.base.LockValidate;

public class MapLock extends LockValidate {

    private int[] increments;

    public void init() throws Exception {
        super.init();
        increments = new int[keyDomain];

        //for(int i=0; i<keyDomain; i++){
        //    map.put(getKey(i), 0);
        //}
    }

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        Object key = getKey(k);
        map.lock(key);
        incMapIdx(k);
        increments[k]++;
        map.unlock(key);
    }

    public void postPhase() {
        for (int i=0; i<keyDomain; i++) {
            System.out.println("increments["+i+"]="+increments[i]);
            addIncrementFor(i, increments[i]);
        }
    }
}