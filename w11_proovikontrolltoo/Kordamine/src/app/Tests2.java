package app;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Tests2 {
    Jook drink = new Jook("water", 1, 1);
    Joogivaat barrel = new Joogivaat(3);
    Joogipudel bottle = new Joogipudel(1.0, BottleType.GLASS, 0.1);

    @Before
    public void init(){
        drink = new Jook("water", 1, 1);
        barrel = new Joogivaat(3);
        bottle = new Joogipudel(1, BottleType.GLASS, 0.1);
    }
    
    @Test
    public void test1(){
        barrel.fillBarrel(drink);
        barrel.fillBottle(bottle);
        assertEquals(2, barrel.getInside(), 0.001);
    }
}