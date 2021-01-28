/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullana.biblioteca.Biblioteca;

import java.util.Scanner;
/**
 *
 * @author Jaume
 */
public class Persona {
    
    public static Scanner sc=new Scanner(System.in);
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String NIF;
    private String contrasena;

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
        while (contrasena.length()<8){
        System.out.println("La contraseña tiene que ser de 8 caracteres minimo");
        System.out.println("Inserta una nueva contaseña");
        contrasena=sc.nextLine();
        }
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Persona{" + "sc=" + sc + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", NIF=" + NIF + ", contrasena=" + contrasena + '}';
    }
    
    
    
    
    
}
