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
    
    public static void anadirLibro(ArrayList <Libro> listaLibros){
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
        int numeroCopias=sc.nextInt();
        lbr.setNumeroCopias(numeroCopias);
        sc.nextLine();
        System.out.println("Inserta el numero de copias disponibles del libro");
        int numeroCopiasDisponibles=sc.nextInt();
        while(numeroCopias<numeroCopiasDisponibles){
            System.out.println("Es imposible que haya disponibles mas copias de las que tenemos");
            System.out.println("Inserte el numero correcto, porfavor");
            numeroCopiasDisponibles=sc.nextInt();
        }
        lbr.setCopiasDisponibles(numeroCopiasDisponibles);
        sc.nextLine();
        listaLibros.add(lbr);
    }
    
    public static void eliminarLibro (ArrayList <Libro> listaLibros){
        
        boolean encontrado=false;
        System.out.println("Escribe la ISBN del libro");
        String isbn=sc.nextLine();
        for (int i=0; i<listaLibros.size();i++){
            
            if (isbn.equals(listaLibros.get(i).getISBN())){
                encontrado=true;
                if( (listaLibros.get(i).getNumeroCopias())!=(listaLibros.get(i).getCopiasDisponibles()) ){
                    System.out.println("Lo siento, no se puede eliminar un libro reservado");
                }
                else{
                    System.out.println("Procedo a eliminar el libro: "+(listaLibros.get(i).getTitulo()));
                    listaLibros.remove(i);
                }
            }   
        }
        if (!encontrado){
            System.out.println("No hay ningun libro con esa ISBN");
        }
        
    }
    
    public static int buscarLibroISBN (ArrayList <Libro> listaLibros){
        System.out.println("Escribe la ISBN del libro");
        String isbn=sc.nextLine();
        int posicion=-1;
        for (int i=0; i<listaLibros.size();i++){
            
            if (isbn.equals(listaLibros.get(i).getISBN())){
                posicion=listaLibros.lastIndexOf(listaLibros.get(i));
            }
        }
        return posicion;
    }
    
    
    
    
        
    
    
}
