package hz.map.member;

import global.AssertionException;

public class Validate extends Validator {


    public void validate(int key, Object value) throws Exception {

        Object expectedValue = mapKeyToValue(key);

        if( ! expectedValue.equals(value)){
            throw new AssertionException("key "+key+" value "+value+" != "+expectedValue);
        }
    }
}