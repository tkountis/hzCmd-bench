package hz.map.member;

public class Load extends Loader {

    @Override
    public Object getValue(int key) {
        return mapKeyToValue(key);
    }
}