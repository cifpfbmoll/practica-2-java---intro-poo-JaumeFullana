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
 * @author Jaume
 */
public class Biblioteca {
    
    public static Scanner sc=new Scanner (System.in);
    private String nombreBiblioteca;
    private ArrayList <Libro> listaLibros=new ArrayList <Libro>();
    private ArrayList <Persona> listaPersonal=new ArrayList <Persona>();

    public Biblioteca() {
    }

   
    public Biblioteca(String nombreBiblioteca) {
        this.setNombreBiblioteca(nombreBiblioteca);
    }

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        while((Character.getType(nombreBiblioteca.charAt(0)))!=1){
            System.out.println("El nombre de la biblioteca debe empezar en mayuscula");
            System.out.println("Escribe bien el nombre de la biblioteca:");
            nombreBiblioteca=sc.nextLine();
        }
        this.nombreBiblioteca = nombreBiblioteca;
    }

    public ArrayList<Libro> getListaLibros() {
        
        return listaLibros;
    }

    public ArrayList<Persona> getListaPersonal() {
        return listaPersonal;
    }
    
    public void mostrarLibros(){
        
        for (int i=0;i<listaLibros.size();i++){
            System.out.println(listaLibros.get(i).toString());
        }
    }
    
        public void mostrarLibrosDisponibles(){
        
        for (int i=0;i<listaLibros.size();i++){
            if (listaLibros.get(i).getCopiasDisponibles()>0){
                System.out.println(listaLibros.get(i).toString());
            }
        }
    }

    



}
