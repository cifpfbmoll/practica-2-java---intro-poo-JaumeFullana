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
 * @author mmful
 */
public class Biblioteca {
    
    public static Scanner sc=new Scanner (System.in);
    private String nombreBiblioteca;
    private ArrayList <Libro> listaLibros;
    private  ArrayList <Persona> listaPersonal;

    public Biblioteca() {
    }

    public Biblioteca(ArrayList<Libro> listaLibros, ArrayList<Persona> listaPersonal) {
        this.listaLibros = listaLibros;
        this.listaPersonal = listaPersonal;
    }

    
    
    public Biblioteca(String nombreBiblioteca, ArrayList<Libro> listaLibros, ArrayList<Persona> listaPersonal) {
        this.setNombreBiblioteca(nombreBiblioteca);
        this.listaLibros = listaLibros;
        this.listaPersonal = listaPersonal;
    }
    
        public Biblioteca(Biblioteca bibl) {
        this.setNombreBiblioteca(bibl.getNombreBiblioteca());
        this.listaLibros = listaLibros;
        this.listaPersonal = listaPersonal;
    }

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
    }

    
    
    
    
}
