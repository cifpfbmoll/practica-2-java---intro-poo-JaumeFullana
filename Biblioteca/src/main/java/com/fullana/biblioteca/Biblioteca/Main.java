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
public class Main {
    
    public static Scanner sc=new Scanner(System.in);
    /**
     * metodo main del programa, en el se incluyen bucles y switch que llaman a los diferentes modulos de las 
     * diferentes clases del programa, ademas de la creacion de la biblioteca en el principio del programa.
     */
    public static void main(String[] args) {
        //Menu del programa
        System.out.println("Bienvenido al programa de gestion de bibliotecas.");
        System.out.println("Escribe el nombre de la biblioteca");
        String nombreBiblioteca=sc.nextLine();
        Biblioteca biblioteca=new Biblioteca(nombreBiblioteca);
        int opcion=1;
        int opcionGestor;
        System.out.println("Bienvenido al gestor de la bilioteca "+biblioteca.getNombreBiblioteca());
        //bucle para poder realizar acciones hasta que el usuario desee
        while (opcion!=0){
            System.out.println("El programa se divide en dos gestores, el de libros y el de personal");
            System.out.println("Pulsa 1 si deseas acceder al gestor de libros");
            System.out.println("Pulsa 2 si deseas acceder al gestor de personal");
            System.out.println("Pulsa 0 para salir del programa");
            opcion=sc.nextInt();
            sc.nextLine();
            //comprobacion de error
            while (opcion>2 || opcion<0){
                System.out.println("ERROR: esa opcion no existe.");
                System.out.println("Pulsa 1 si deseas acceder al gestor de libros");
                System.out.println("Pulsa 2 si deseas acceder al gestor de personal");
                System.out.println("Pulsa 0 para salir del programa");
                opcion=sc.nextInt();
                sc.nextLine();
            }
            opcionGestor=0;
            //bucle donde transcurren las opciones del gestor de libros
            while (opcion==1 && opcionGestor!=7){
                System.out.println("Que desea hacer?");
                System.out.println("Pulsa 1 para añadir un libro");
                System.out.println("Pulsa 2 para eliminar un libro");
                System.out.println("Pulsa 3 para buscar un libro por su ISBN");
                System.out.println("Pulsa 4 para buscar un libro por su titulo");
                System.out.println("Pulsa 5 para mostrar todos los libros");
                System.out.println("Pulsa 6 para mostrar todos los libros disponibles en este momento");
                System.out.println("Pulsa 7 volver al selector de gestores");
                opcionGestor=sc.nextInt();
                sc.nextLine();

                switch (opcionGestor){
                    case 1:
                    Libro.anadirLibro(biblioteca.getListaLibros());
                    break;

                    case 2:
                    Libro.eliminarLibro(biblioteca.getListaLibros());
                    break;

                    case 3:
                    int posicion=Libro.buscarLibroISBN(biblioteca.getListaLibros());
                    /** interpreta el valor que se devuelve del metodo, siendo este
                     * la posicion de la lista en la que se encuentra el Libro o siendo -1
                     * si no se encuentra en ella.
                     */
                    if (posicion==-1){
                        System.out.println("No tenemos ningun libro con esa ISBN");
                    }
                    else {
                        System.out.println("El libro con esa ISBN se encuentra en la posicion numero "+posicion);
                        System.out.println("y su titulo es: "+biblioteca.getListaLibros().get(posicion).getTitulo());
                    }
                    break;

                    case 4:
                    Libro.buscarLibroTitulo(biblioteca.getListaLibros());
                    break;

                    case 5:
                    biblioteca.mostrarLibros();
                    break;

                    case 6:
                    biblioteca.mostrarLibrosDisponibles();
                    break;

                    case 7:
                    System.out.println("Volvamos al selector de gestores");
                    break;

                    default:
                    System.out.println("ERROR: Este comando no existe");
                    System.out.println("Inserta un comando que exista");
                }
                System.out.println("Pulsa enter para continuar");
                sc.nextLine();
            }
            //bucle donde transcurren las opciones del gestor de personas
            while (opcion==2 && opcionGestor!=3){
                System.out.println("Que desea hacer?");
                System.out.println("Pulsa 1 para añadir una persona al sistema");
                System.out.println("Pulsa 2 para eliminar una persona del sistema");
                System.out.println("Pulsa 3 para salir del gestor de personal");
                opcionGestor=sc.nextInt();
                sc.nextLine();
                switch (opcionGestor){
                    case 1:
                    Persona.añadirPersona(biblioteca.getListaPersonal());   
                    break;
                    
                    case 2:
                    Persona.eliminarPersona(biblioteca.getListaPersonal());
                    break;
                    
                    case 3:
                    System.out.println("Volvamos al selector de gestores");
                    break;

                    default:
                    System.out.println("ERROR: Este comando no existe");
                    System.out.println("Inserta un comando que exista");
                }
                System.out.println("Pulsa enter para continuar");
                sc.nextLine();
            }
        }
        System.out.println("ADIOS!");
    }    
}
