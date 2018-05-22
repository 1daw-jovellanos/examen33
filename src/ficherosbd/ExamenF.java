package ficherosbd;

import java.util.*;
import java.sql.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExamenF {

    public void lineasConPan(String filenameEntrada, String filenameSalida) {
        try (Scanner fi = new Scanner(new FileReader(filenameEntrada));
                PrintWriter fo = new PrintWriter(new FileWriter(filenameSalida))) {
            while (fi.hasNextLine()) {
                String linea = fi.nextLine();
                String t[] = linea.split("\\W+");
                boolean hayPan = false;
                for (String s : t) {
                    if (s.equalsIgnoreCase("pan")) {
                        hayPan = true;
                        break;
                    }
                }
                if (hayPan) {
                    fo.println(linea);
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public String leeListaSerializada(String filenameEntrada) {
        String out = "";
        try (ObjectInputStream fi = new ObjectInputStream(new FileInputStream(filenameEntrada))) {
            ArrayList<Character> l  = (ArrayList<Character>)fi.readObject();
            for (Character c:l) {
                out = out + c;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return out;
    }

    public double losPlanetasCrecen(String url, double radioMin, double radioMax) {
        double r = 0;
        return r;
    }

    public void run() {
        // tus código de prueba aquí.

    }

    public static void main(String[] args) {
        new ExamenF().run();
    }

}
