package ficherosbd;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import java.io.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author victor
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExamenFTest {

    static ExamenF examen;
    private static final String URL = "jdbc:h2:tcp://localhost/mem:sistemasolartest";

    public ExamenFTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        examen = new ExamenF();
        char[] array = "Hola".toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : array) {
            list.add(c);
        }
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("prueba1.serial"))) {
            os.writeObject(list);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        array = "Caracola".toCharArray();
        list.clear();
        for (Character c : array) {
            list.add(c);
        }
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("pruebas/prueba2.serial"))) {
            os.writeObject(list);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test(timeout = 5000)
    public void test1LineasConPan() {
        examen.lineasConPan("textopan1.txt", "textopan1.salida.txt");
        assertEquals("La salida no es la esperada", true, ficherosIguales("textopan1.salida.txt", "pruebas/textopan1.salida.txt"));
        examen.lineasConPan("pruebas/lazarillo.txt", "lazarillo.salida.txt");
        assertEquals("La salida no es la esperada", true, ficherosIguales("lazarillo.salida.txt", "pruebas/lazarillo.salida.txt"));
    }

    public boolean ficherosIguales(String f1, String f2) {
        boolean r = true;
        try (Scanner scan1 = new Scanner(new BufferedReader(new FileReader(f1)));
                Scanner scan2 = new Scanner(new BufferedReader(new FileReader(f2)))) {
            while (scan1.hasNextLine() && scan2.hasNextLine() && r) {
                r = scan1.nextLine().equals(scan2.nextLine());
            }
            if (r) {
                r = !scan1.hasNextLine() && !scan2.hasNextLine();
            }

        } catch (FileNotFoundException ex) {
            r = false;
        }
        return r;
    }
    
    // -----------------------------------------------------------------------------------

    
    @Test(timeout = 5000)
    public void test2leeListaSerializada() {
        assertEquals("La salida no es la esperada", "Hola", examen.leeListaSerializada("prueba1.serial"));
        assertEquals("La salida no es la esperada", "Caracola", examen.leeListaSerializada("pruebas/prueba2.serial"));
    }

    // -----------------------------------------------------------------------------------

    @Test(timeout = 5000)
    public void test3LosPlanetasCrecen() throws Exception {
        createDatabase(); // Crea una base de datos idéntica a la de tus pruebas
        assertEquals(196426.0, examen.losPlanetasCrecen(URL, 20000, 30000), 1);
        createDatabase(); // Crea una base de datos idéntica a la de tus pruebas
        assertEquals(196505.0, examen.losPlanetasCrecen(URL, 50000, 70000), 1);
    }

    // --------------------------------------- Métodos auxiliares --------------------------------------
    // Crear base de datos de pruebas y ficheros binarios de pruebas.
    private void createDatabase() throws Exception {
        String sql = "DROP TABLE IF EXISTS planeta;\n"
                + "CREATE TABLE planeta (\n"
                + "    nombre VARCHAR(15) PRIMARY KEY,\n"
                + "    radio DOUBLE\n"
                + ");\n"
                + "INSERT INTO planeta(nombre, radio) VALUES('Mercurio' , 2439);\n"
                + "INSERT INTO planeta(nombre, radio) VALUES('Venus',6051);\n"
                + "INSERT INTO planeta(nombre, radio) VALUES('Tierra',6371);\n"
                + "INSERT INTO planeta(nombre, radio) VALUES('Marte', 3389);\n"
                + "INSERT INTO planeta(nombre, radio) VALUES('Jupiter', 69911);\n"
                + "INSERT INTO planeta(nombre, radio) VALUES('Saturno',58232);\n"
                + "INSERT INTO planeta(nombre, radio) VALUES('Urano', 25362);\n"
                + "INSERT INTO planeta(nombre, radio) VALUES('Neptuno', 24622);\n"
                + "\n"
                + "";
        Class.forName("org.h2.Driver");
        try (Connection conn = DriverManager.getConnection(URL, "sa", "")) {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.execute();
            }
        }
    }

}
