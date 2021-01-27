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
    private ArrayList <Libro> listaLibros=new ArrayList <Libro>();
    private  ArrayList <Persona> listaPersonal=new ArrayList <Persona>();

    public Biblioteca() {
    }

   
    public Biblioteca(String nombreBiblioteca, ArrayList<Libro> listaLibros, ArrayList<Persona> listaPersonal) {
        this.setNombreBiblioteca(nombreBiblioteca);
    }

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    public ArrayList<Persona> getListaPersonal() {
        return listaPersonal;
    }

    
    
    
    
}