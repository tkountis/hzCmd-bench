package hz.list;


import hz.list.base.ListBench;

public class Add extends ListBench {

    public  int max=1000000;
    private int count=0;

    public void timeStep() {
        Object val = mapKeyToValue(random.nextInt( keyDomain ));
        list.add(val);
        if(++count >= max){
            setRunning(false);
        }
    }
}