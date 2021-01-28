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
    
    public static void main(String[] args) {
        
        System.out.println("Bienvenido a su gestor de biblioteca!");
        System.out.println("Escribe el nombre de la biblioteca");
        String nombreBiblioteca=sc.nextLine();
        Biblioteca biblioteca=new Biblioteca(nombreBiblioteca);
        int opcion=1;
        System.out.println("Ahora tiene diferentes opciones para empezar a manejar su gestor");
        
        while (opcion!=0){
            System.out.println("Que desea hacer");
            System.out.println("0 para salir del gestor (salir del programa)");
            System.out.println("1 para añadir un libro");
            System.out.println("2 para eleminar un libro");
            System.out.println("3 para buscar un libro por su ISBN");
            opcion=sc.nextInt();
            sc.nextLine();
            
            switch (opcion){
                case 1:
                Libro.anadirLibro(biblioteca.getListaLibros());
                break;
                
                case 2:
                Libro.eliminarLibro(biblioteca.getListaLibros());
                break;
                
                case 3:
                int posicion=Libro.buscarLibroISBN(biblioteca.getListaLibros());
                if (posicion==-1){
                    System.out.println("No tenemos ningun libro con esa ISBN");
                }
                else {
                    System.out.println("El libro con esa ISBN se encuentra en la posicion numero "+posicion);
                    System.out.println("y su titulo es: "+biblioteca.getListaLibros().get(posicion).getTitulo());
                }
                break;
                
                case 0:
                System.out.println("Adios!");
                break;
                
                default:
                System.out.println("ERROR: Este comando no existe");
                System.out.println("Inserta un comando que exista");
            }
        }
        
        for (int i=0; i<biblioteca.getListaLibros().size();i++){
        
            System.out.println(biblioteca.getListaLibros().get(i));
        }
    }
    
}
