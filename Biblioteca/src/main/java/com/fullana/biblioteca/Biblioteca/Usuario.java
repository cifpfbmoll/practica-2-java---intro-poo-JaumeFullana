/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullana.biblioteca.Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author jaume
 */
public class Usuario {
    
    public static Scanner sc=new Scanner(System.in);
    //Atributos de la clase usuario
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String NIF;
    private String contrasena;
    private int librosReservados;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido1, String apellido2, String NIF, String contrasena) {
        this.setNombre(nombre);
        this.setApellido1(apellido1);
        this.setApellido2(apellido2);
        this.setNIF(NIF);
        this.setContrasena(contrasena);
    }
    
    public Usuario(Usuario u1) {
        this.setNombre(u1.getNombre());
        this.setApellido1(u1.getApellido1());
        this.setApellido2(u1.getApellido2());
        this.setNIF(u1.getNIF());
        this.setContrasena(u1.getContrasena());
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
        while (contrasena.length()!=8){
            System.out.println("La contraseña tiene que ser de 8 caracteres minimo!");
            System.out.println("Inserte una nueva");
            contrasena=sc.nextLine();
        }
        this.contrasena = contrasena;
    }

    public int getLibrosReservados() {
        return librosReservados;
    }
    
    

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", NIF=" + NIF + ", contrasena=" + contrasena + ", librosReservados=" + librosReservados + '}';
    }
    
    public static void anadirUsuario (ArrayList <Usuario> listaUsuario){
        System.out.println("Escribe el nombre del usuario");
        String nombre=sc.nextLine();
        System.out.println("Escribe el primer apellido del usuario");
        String apellido1=sc.nextLine();
        System.out.println("Escribe el segundo apellido del usuaro");
        String apellido2=sc.nextLine();
        System.out.println("Escribe el NIF del usuario");
        String NIF=sc.nextLine();
        System.out.println("Escribe la contraseña de usuario, tiene que ser de almenos 8 caracteres");
        String contrasena=sc.nextLine();
        Usuario u1=new Usuario(nombre, apellido1, apellido2, NIF, contrasena);
        listaUsuario.add(u1);        
    }
    
    public static void eliminarUsuario (ArrayList <Usuario> listaUsuario){
        boolean encontrado=false;
        System.out.println("Dame el NIF del usuario que quieres eliminar");
        String NIF=sc.nextLine();
        for (int i=0; i<listaUsuario.size(); i++){
            if (listaUsuario.get(i).getNIF().equals(NIF)){
                listaUsuario.remove(i);
                System.out.println("El usuario ha sido eliminado");
                encontrado=true;
            }
        if (!encontrado){
            System.out.println("No existe ningun usuario con ese NIF"); 
        }
        }
    }
    
    public void reservarLibro(ArrayList <Libro> listaLibros){
        if (librosReservados<5){
            boolean encontrado=false;
            System.out.println("Escribe la ISBN del libro a reservar");
            String ISBN=sc.nextLine();
            for (int i=0; i<listaLibros.size(); i++){
                if (listaLibros.get(i).getISBN().equals(ISBN)){
                    encontrado=true;
                    if ((listaLibros.get(i).getCopiasDisponibles()-1)<0){
                        System.out.println("Lo siento, pero todas las copias del libro estan reservadas actualmente");
                    }
                    else{
                        listaLibros.get(i).setCopiasDisponibles(listaLibros.get(i).getCopiasDisponibles()-1,listaLibros.get(i).getNumeroCopias());
                        System.out.println("El libro "+listaLibros.get(i).getTitulo()+" ha sido reservado con exito");
                        librosReservados++;
                    }
                }
            }
            if (!encontrado){
                System.out.println("No hay ningun libro con esa ISBN en el sistema");
            }
        }
        else {
            System.out.println("Lo siento, ya tienes 5 libros reservados, no puedes reservar mas");
        }
    }
    
    
    
    
    
    
    
}
