/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

import java.util.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author victor
 */
public class ExamenHTest {
    
    public ExamenHTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }

    @Test
    public void testArrobaArroba() {
        Collection<CharSequence> coleccion = new ArrayList<>();
        coleccion.add(new String("Roma"));
        coleccion.add(new StringBuffer("Madrid"));
        coleccion.add(new StringBuilder("Berlín"));
        coleccion.add(new StringBuilder("fin"));
        coleccion.add(new StringBuilder("Lisboa"));
                
        ExamenH instance = new ExamenH();
        instance.arrobaArroba(coleccion);
        assertEquals("Ha cambiado la cantidad de elementos de la colección", 5, coleccion.size());
        Iterator<CharSequence> iter = coleccion.iterator();
        CharSequence cs = iter.next();
        assertEquals("Resultado no es el esperado",true, cs.toString().equals("Roma") && cs instanceof String );
        cs = iter.next();
        assertEquals("Resultado no es el esperado",true, cs.toString().equals("Madrid") && cs instanceof StringBuffer);
        cs = iter.next();
        assertEquals("Resultado no es el esperado",true, cs.toString().equals("Berlín@@") && cs instanceof StringBuilder );
        cs = iter.next();
        assertEquals("Resultado no es el esperado",true, cs.toString().equals("fin") && cs instanceof StringBuilder );
        cs = iter.next();
        assertEquals("Resultado no es el esperado",true, cs.toString().equals("Lisboa") && cs instanceof StringBuilder );

    }

    
}
