/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullana.biblioteca.Biblioteca;

import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Jaume
 */
public class Persona {
    
    public static Scanner sc=new Scanner(System.in);
    //Atributos de Persona
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String NIF;
    private String contrasena;
    //Cosntructores de Persona(Vacio, con todos los atributos y constructor copia)
    public Persona() {
    }

    public Persona(String nombre, String apellido1, String apellido2, String NIF, String contrasena) {
        this.setNombre(nombre);
        this.setApellido1(apellido1);
        this.setApellido2(apellido2);
        this.setNIF(NIF);
        this.setContrasena(contrasena);
    }
    
    public Persona(Persona p1) {
        this.setNombre(p1.getNombre());
        this.setApellido1(p1.getApellido1());
        this.setApellido2(p1.getApellido2());
        this.setNIF(p1.getNIF());
        this.setContrasena(p1.getContrasena());
    }
    //setters y getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        //Comprobacion de que la contraseña del usuario tenga almenos 8 caracteres
        while (contrasena.length()<8){
        System.out.println("La contraseña tiene que ser de 8 caracteres minimo");
        System.out.println("Inserta una nueva contaseña");
        contrasena=sc.nextLine();
        }
        this.contrasena = contrasena;
    }
    //modulo para imprimir los valores de un objeto Persona
    @Override
    public String toString() {
        return "Persona{" + "sc=" + sc + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", NIF=" + NIF + ", contrasena=" + contrasena + '}';
    }
    //modulo que crea y añade valores a un objeto Persona y lo guarda dentro de una lista que se pasa por parametro
    public static void añadirPersona (ArrayList <Persona> listaPersonal){
        System.out.println("Escribe el nombre de la persona:"); 
        String nombre=sc.nextLine();
        System.out.println("Escribe el primer apellido de la persona");
        String apellido1=sc.nextLine();
        System.out.println("Escribe el segundo apellido de la persona");
        String apellido2=sc.nextLine();
        System.out.println("Escribe el NIF de la persona");
        String NIF=sc.nextLine();
        System.out.println("Escribe la contraseña de usuario de esta persona");
        String contrasena=sc.nextLine();
        Persona p1=new Persona(nombre, apellido1, apellido2, NIF, contrasena);
        listaPersonal.add(p1);
    }
    /*modulo que busca una Persona por su NIF en la lista listaPersonal de la biblioteca,
     que se pasa por parametro, y si lo encuentra lo elimina de la lista
    */
    public static void eliminarPersona(ArrayList <Persona> listaPersonal){
        System.out.println("Escribe el NIF de la persona que quieres eliminar del sistema");
        String NIF=sc.nextLine();
        boolean encontrado=false;
        for (int i=0;i<listaPersonal.size();i++){
            if (listaPersonal.get(i).getNIF().equals(NIF)){
                listaPersonal.remove(i);
                encontrado=true;
            }
        }
        if (!encontrado){
            System.out.println("No existe ninguna persona con ese NIF en el sistema");
        }
    }    
}
