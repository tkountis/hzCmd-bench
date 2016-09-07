package hz.map.validate;

import hz.map.validate.base.LockValidate;

public class Lock extends LockValidate {

    private int[] increments;

    public void init() throws Exception {
        super.init();
        increments = new int[keyDomain];

        for(int i=0; i<keyDomain; i++){
            map.put(i, 0);
        }
    }

    public void timeStep() {
        int k = random.nextInt(keyDomain);
        map.lock(k);
        incMapIdx(k);
        map.unlock(k);
    }

    public void postPhase() {
        for (int i=0; i<keyDomain; i++) {
            System.out.println("increments["+i+"]="+increments[i]);
            addIncrementFor(i, increments[i]);
        }
    }
}