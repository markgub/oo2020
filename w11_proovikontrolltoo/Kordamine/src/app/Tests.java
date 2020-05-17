package app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Tests {
    Jook drink = new Jook("water", 1, 1);
    Joogipudel bottle = new Joogipudel(1.0, BottleType.GLASS, 0.1);

    @Before
    public void init(){
        drink = new Jook("water", 1, 1);
        bottle = new Joogipudel(1, BottleType.GLASS, 0.1);
    }
    
    @Test
    public void test1(){
        assertEquals(65, bottle.wholeMass(), 0.001);
    }

    @Test
    public void test2(){
        bottle.fillBottle(drink);
        assertEquals(66, bottle.wholeMass(), 0.001);
    }
}