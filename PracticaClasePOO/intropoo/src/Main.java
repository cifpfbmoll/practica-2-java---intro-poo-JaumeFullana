package eu.cifpfbmoll.intropoo;

import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) {
        
        Persona p1=new Pesrona();
        Persona p2=new Persona("Jaume", "Fullana", "Piza", 27);
        Persona p3=new Persona(p2);
        
        System.out.println("El nombre de p3 es "+p3.getNombre());
        p3.setNombre("Joan");

        Arraylist <Persona> listaPersonas=new Arraylist <Persona>;

        Persona p4=Persona.solicitarDatosPersona();

    }
}
