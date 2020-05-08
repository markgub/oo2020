package app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Tests2 {
    
    IonClass H = new IonClass("vesinik", 1, 1);
    IonClass NO3 = new IonClass("nitraat", 62, -1);
    MatterClass HNO3 = new MatterClass(H, NO3);

    IonClass Ca = new IonClass("kaltsium", 40.07, 2);
    IonClass Cl = new IonClass("kloriid", 35.45, -1);
    MatterClass CaCl = new MatterClass(Ca, Cl);

    @Test
    public void test1(){
        assertEquals("vesiniknitraat", HNO3.getName());
    }

    @Test
    public void test2(){
        assertEquals(63, HNO3.getMass(), 0.01);
    }

    //Järgmised 2 peavadki ebaõnnestuda
    @Test
    public void test3(){
        assertEquals("kaltsiumkloriid", CaCl.getName());
    }

    @Test
    public void test4(){
        assertEquals(75.52, CaCl.getMass(), 0.001);
    }

}