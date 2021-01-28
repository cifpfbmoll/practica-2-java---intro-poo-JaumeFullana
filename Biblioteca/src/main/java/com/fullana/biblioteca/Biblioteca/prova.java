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
public class prova {
    
    public static Scanner sc=new Scanner(System.in);
    
    
    public static void main(String[] args){
        
        System.out.println("Escribe el nombre de la biblioteca:");
        String nombreBiblioteca=sc.nextLine();
        
        while((Character.getType(nombreBiblioteca.charAt(0)))!=1){
            System.out.println("El nombre de la biblioteca debe empezar en mayuscula");
            System.out.println("Escribe el nombre de la biblioteca:");
            nombreBiblioteca=sc.nextLine();
        }
        System.out.println(nombreBiblioteca);
    }
}


