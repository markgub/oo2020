package app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Tests {
    
    IonClass H = new IonClass("H", 1, 1);
    IonClass NO3 = new IonClass("NO3", 62, -1);

    @Test
    public void test1(){
        assertEquals("H", H.getName());
    }

    @Test
    public void test2(){
        assertEquals("H", NO3.getName());
    }

    @Test
    public void test3(){
        assertEquals("NO3", NO3.getName());
        assertEquals(-1, NO3.getCharge());
        assertEquals(62, NO3.getAMass(), 0.01);
    }
}