/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author victor
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class PortatilTest {
    Portatil p1, p2, p3;

    public PortatilTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
        p1 = new Portatil(2, "core2duo", 16);
        p2 = new Portatil(2, "Core2Duo", 16.00001);
        p3 = new Portatil(4, "i5", 15.2);
    }

    @Test(timeout = 5000)
    public void test1aConstructorYGetters() {

    }

    @Test(timeout = 5000)
    public void test1bGetPrecioSeguro() {
        assertEquals(56, p1.getPrecioSeguro(), 0.01);
        assertEquals(59.4, p3.getPrecioSeguro(), 0.01);
    }
    
    @Test(timeout = 5000)
    public void test1cToString() {
        assertEquals("Portatil. Memoria: 2 GB; CPU modelo core2duo; Tamaño: 16.0 pulgadas.", p1.toString());
        assertEquals("Portatil. Memoria: 4 GB; CPU modelo i5; Tamaño: 15.2 pulgadas.", p3.toString());
    }

    @Test(timeout = 5000)
    public void test1dEquals() {
        assertEquals(true, p1.equals(p2));
        assertEquals(false, p1.equals(new Ordenador(2,"core2duo")));
    }

    
}
