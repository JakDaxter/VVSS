package inventory.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.Math;

class PartTest {

    @Tag("Tagul")
    @Timeout(1000)
    @RepeatedTest(2)
    void isValidPart() {
        isValidPartBVA(0);
        isValidPartECP(0);
    }
    @DisplayName("BVA")
    @ParameterizedTest(name="assert {0} is ok")
    @ValueSource(ints={1,2,3,4})
    void isValidPartBVA(int ok){
        //BVA
        //Price Valid
        assert (Part.isValidPart("Name1",0.01,10,1,100,"").equals(""));
        //Price not Valid
        assert (Part.isValidPart("Name1",0.01-Math.ulp(1.0),10,1,100,"").equals("The price must be greater than 0. "));
        //InStock Valid
        assert (Part.isValidPart("Name1",0.01+Math.ulp(1.0),1,1,100,"").equals(""));
        //InStock not Valid
        assert (Part.isValidPart("Name1",0.01+Math.ulp(1.0),1-1,0,100,"").equals("Inventory level must be greater than 0. "));

    }
    @DisplayName("ECP")
    @ParameterizedTest(name="assert {0} is ok")
    @ValueSource(ints={1,2,3,4})
    void isValidPartECP(int ok){
        //All valid ecp
        assert (Part.isValidPart("Name1",10.0,10,1,100,"").equals(""));
        //price Not valid
        assert (Part.isValidPart("Name1",-10.0,10,1,100,"").equals("The price must be greater than 0. "));
        //InStock Not Valid
        assert (Part.isValidPart("Name1",10.0,-10,-100,100,"").equals("Inventory level must be greater than 0. "));
        //min>max && InStock>max
        assert (Part.isValidPart("Name1",10.0,10,1,-100,"").equals("The Min value must be less than the Max value. Inventory level is higher than the maximum value. "));

    }
}