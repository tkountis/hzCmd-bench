package hz.map.member;

public class Load extends Loader {

    @Override
    public Object getValue(int key) {
        int idx = random.nextInt(valueSet.size());
        return valueSet.get(idx);
    }
}