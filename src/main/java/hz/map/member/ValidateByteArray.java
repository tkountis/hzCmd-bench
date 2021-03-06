package hz.map.member;

import global.AssertionException;

import java.util.Arrays;

public class ValidateByteArray extends Validator {


    public void validate(int key, Object value) throws Exception {

        Object keyObj = getKey(key);
        Object expectedValue = mapKeyToValue(key);

        if ( ! Arrays.equals( (byte[]) expectedValue, (byte[]) value ) ){

            throw new AssertionException("key "+keyObj+" value "+value+" != "+expectedValue);
        }
    }
}