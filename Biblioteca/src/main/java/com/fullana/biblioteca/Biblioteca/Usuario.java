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
    private ArrayList <Libro> listaLibrosReservados;
    private int librosReservados;
    //Constructores vacio, completo y copia. Se crea lista de reservas en todos directamente.
    public Usuario() {
        this.listaLibrosReservados=new ArrayList <Libro>();
    }   
    
    public Usuario(String nombre, String apellido1, String apellido2, String NIF, String contrasena) {
        this.setNombre(nombre);
        this.setApellido1(apellido1);
        this.setApellido2(apellido2);
        this.setNIF(NIF);
        this.setContrasena(contrasena);
        this.listaLibrosReservados=new ArrayList <Libro>();
    }
    
    public Usuario(Usuario u1) {
        this.setNombre(u1.getNombre());
        this.setApellido1(u1.getApellido1());
        this.setApellido2(u1.getApellido2());
        this.setNIF(u1.getNIF());
        this.setContrasena(u1.getContrasena());
        this.listaLibrosReservados=new ArrayList <Libro>();
    }
    //Getters y setters
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
        //Control para que la contraseña tenga mas de 8 caracteres
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

    public ArrayList<Libro> getListaLibrosReservados() {
        return listaLibrosReservados;
    }
    
    
    //convierte los valores de un objeto usuario en string, para que sea mas facil imprimir por pantalla
    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", NIF=" + NIF + ", contrasena=" + contrasena + ", librosReservados=" + librosReservados + '}';
    }
    /**
     * Metodo para crear un nuevo Usuario con valores en todos sus atributos, se le
     * pasa una lista de Usuarios por parametro para añadir el usuario creado en ella.
     * 
     * @param listaUsuario ArrayList en la que se guarda el usuario creado.
     */
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
    /**
     * Metodo para eliminar un usuario de la lista de Usuarios que se pasa por parametro,
     * se busca al Usuario en la lista por su nif y una vez localizado es eliminado de ella
     *
     * @param listaUsuario ArrayList de la cual se elimina el Usuario
     */
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
        }
        if (!encontrado){
            System.out.println("No existe ningun usuario con ese NIF"); 
        }
    }
    /**
     * Metodo para "reservar" un libro, se da una ISBN y con esa ISBN se busca en la
     * lista de Libros pasada por parametro un Libro con esa ISBN, una vez encontrado
     * se guarda una copia del objeto, solo con los valores necesarios para identificarlo,
     * en la listaLibrosReservados del Usuario, se modifican librosReservados y lo referente a las copias.
     * 
     * @param listaLibros ArrayList de Libros en la cual se busca y se obtiene el Libro a reservar
     * 
     */
    public void reservarLibro(ArrayList <Libro> listaLibros){
        if (librosReservados<5){
            boolean encontrado=false;
            System.out.println("Escribe la ISBN del libro a reservar");
            String ISBN=sc.nextLine();
            int i=0;
            while (i<listaLibros.size() && !encontrado){
                if (listaLibros.get(i).getISBN().equals(ISBN)){
                    encontrado=true;
                    if ((listaLibros.get(i).getCopiasDisponibles()-1)<0){
                        System.out.println("Lo siento, pero todas las copias del libro estan reservadas actualmente");
                    }
                    else{
                        listaLibros.get(i).setCopiasDisponibles(listaLibros.get(i).getCopiasDisponibles()-1,listaLibros.get(i).getNumeroCopias());
                        System.out.println("El libro "+listaLibros.get(i).getTitulo()+" ha sido reservado con exito");
                        Libro l1=new Libro(listaLibros.get(i));
                        listaLibrosReservados.add(l1);
                        librosReservados++;
                    }
                }
                i++;
            }
            if (!encontrado){
                System.out.println("No hay ningun libro con esa ISBN en el sistema");
            }
        }
        else {
            System.out.println("Lo siento, ya tienes 5 libros reservados, no puedes reservar mas");
        }
    }
    /**
     * Metodo para "devolver" un libro, se da una ISBN y con esa ISBN se busca en la
     * lista de Libros reservados del Usuario el primer Libro con esa ISBN, una vez encontrado
     * se elimina el Libro de la lista y se modifican librosReservados y lo referente a las copias.
     * 
     * @param listaLibros ArrayList de Libros en la cual se busca y se suma a las copiasDisponibles el Libro devuelto.
     * 
     */
    public void devolverLibro(ArrayList <Libro> listaLibros){
        if (librosReservados<1){
            System.out.println("No tienes ningun libro para devolver!");
        }
        else{
            boolean encontrado=false;
            System.out.println("Escribe la ISBN del libro a devolver");
            String ISBN=sc.nextLine();
            int i=0;
            while (i<listaLibrosReservados.size() && !encontrado){
                if (listaLibrosReservados.get(i).getISBN().equals(ISBN)){
                    encontrado=true;
                    System.out.println("El libro "+listaLibrosReservados.get(i).getTitulo()+" ha sido devuelto con exito");
                    listaLibrosReservados.remove(i);
                    librosReservados--;
                    int j=0;
                    boolean encontradoEnBiblioteca=false;
                    while (j<listaLibros.size() && !encontradoEnBiblioteca){
                        if (listaLibros.get(j).getISBN().equals(ISBN)){
                            encontradoEnBiblioteca=true;
                            listaLibros.get(j).setCopiasDisponibles(listaLibros.get(j).getCopiasDisponibles()+1,listaLibros.get(j).getNumeroCopias());
                        }
                        j++;
                    }

                }
                i++;
            }
            if (!encontrado){
                System.out.println("No hay ninguna ISBN como esa en la tu lista de reservados");
            }  
        }
    }
    /**
     * Metodo para mostrar la Lista de Libros reservados por un usuario concreto.
     */
    public void mostrarLibrosReservados(){
        for (int i=0;i<listaLibrosReservados.size();i++){
            System.out.println(listaLibrosReservados.get(i).ReservasToString());
        }
    }
    
    
    
    
    
    
}
