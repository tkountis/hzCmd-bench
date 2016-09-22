package hz.list;


import hz.list.base.ListBench;

public class Get extends ListBench {

    public void timeStep() {
        list.get( random.nextInt( keyDomain ) );
    }
}