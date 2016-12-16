package hz.quorum;


import global.AssertionException;

public class QuorumStateCheck extends QuorumBench {

    public boolean present = true;

    public void timeStep() throws Exception {
        if ( quorum.isPresent() != present ) {
            throw new AssertionException(quorum+" isPresent() !="+present);
        }
        setRunning(false);
    }
}