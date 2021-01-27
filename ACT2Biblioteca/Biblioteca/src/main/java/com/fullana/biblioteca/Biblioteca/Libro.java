/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fullana.biblioteca.Biblioteca;

import java.util.Scanner;
/**
 *
 * @author mmful
 */
public class Libro {
    
    public static Scanner sc=new Scanner(System.in);
    private static int contadorLibros;
    private String ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private int numeroCopias;
    private int copiasDisponibles;

    public Libro() {
        contadorLibros++;
    }

    public Libro(String ISBN, String titulo, String autor, String editorial, int numeroCopias, int copiasDisponibles) {
        contadorLibros++;
        this.setISBN(ISBN);
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setEditorial(editorial);
        this.setNumeroCopias(numeroCopias);
        this.setCopiasDisponibles(copiasDisponibles);
    }
    
        public Libro(Libro lbr) {
        contadorLibros++;
        this.setISBN(lbr.getISBN());
        this.setTitulo(lbr.getTitulo());
        this.setAutor(lbr.getAutor());
        this.setEditorial(lbr.getEditorial());
        this.setNumeroCopias(lbr.getNumeroCopias());
        this.setCopiasDisponibles(lbr.getCopiasDisponibles());
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getNumeroCopias() {
        return numeroCopias;
    }

    public void setNumeroCopias(int numeroCopias) {
        while (numeroCopias<1){
            System.out.println("El numero de copias no puede ser menor que 1!");
            System.out.println("Inserta el numero de copias del libro:");
            numeroCopias=sc.nextInt();
            sc.nextLine();
        }
        this.numeroCopias = numeroCopias;
    }

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public void setCopiasDisponibles(int copiasDisponibles) {
        this.copiasDisponibles = copiasDisponibles;
    }

    @Override
    public String toString() {
        return "Libro{" + "ISBN=" + ISBN + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", numeroCopias=" + numeroCopias + ", copiasDisponibles=" + copiasDisponibles + '}';
    }
    
    public static Libro anadirLibro(){
        Libro lbr=new Libro();
        System.out.println("Inserta la ISBN del libro");
        lbr.setISBN(sc.nextLine());
        System.out.println("Inserta el titulo del libro");
        lbr.setTitulo(sc.nextLine());
        System.out.println("Inserta el autor del libro");
        lbr.setAutor(sc.nextLine());
        System.out.println("Inserta la editorial del libro");
        lbr.setEditorial(sc.nextLine());
        System.out.println("Inserta el numero de copias del libro");
        lbr.setNumeroCopias(sc.nextInt());
        sc.nextLine();
        System.out.println("Inserta el numero de copias disponibles del libro");
        lbr.setISBN(sc.nextLine());
        sc.nextLine();
        return lbr;
    }
    
    
    
        
    
    
}
