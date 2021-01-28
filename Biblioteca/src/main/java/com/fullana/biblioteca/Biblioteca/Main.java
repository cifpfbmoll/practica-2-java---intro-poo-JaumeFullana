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
            System.out.println("1 para añadir libros");
            opcion=sc.nextInt();
            sc.nextLine();
            
            switch (opcion){
                case 1:
                Libro.anadirLibro();
                break;
                
                case 2:
                break;
                
                case 3:
                break;
                
                case 0:
                System.out.println("Adios!");
                break;
                
                default:
                System.out.println("ERROR: Este comando no existe");
                System.out.println("Inserta un comando que exista");
            }
        }
        for (int i=0; i<Biblioteca.listaLibros.size();i++){
        
            System.out.println(Biblioteca.listaLibros.get(i));
        }
    }
    
}
