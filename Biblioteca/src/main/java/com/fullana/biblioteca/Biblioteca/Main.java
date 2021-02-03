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
        System.out.println("Bienvenido al gestor de la bilioteca "+biblioteca.getNombreBiblioteca());
        System.out.println("Ahora pasemos a crear un usuario para gestionar la biblioteca");
        Persona.añadirPersona(biblioteca.getListaPersonal());
        System.out.println("Bienvenido "+biblioteca.getListaPersonal().get(0).getNombre()+"!");
        int opcion;
        int opcionGestor;
        int privilegios=1;
        int opcionSesion;
        String NIFUsuarioActivo="";
        //bucle para poder realizar acciones hasta que se desee
        while (privilegios!=0){
            //while de interfaz de empleado
            while (privilegios==1){
                System.out.println("El programa se divide en dos gestores, el de libros y el de personas");
                System.out.println("Pulsa 1 si deseas acceder al gestor de libros");
                System.out.println("Pulsa 2 si deseas acceder al gestor de personas");
                System.out.println("Pulsa 0 para salir de la sesion");
                opcion=sc.nextInt();
                sc.nextLine();
                //comprobacion de error
                while (opcion>2 || opcion<0){
                    System.out.println("ERROR: esa opcion no existe.");
                    System.out.println("Pulsa 1 si deseas acceder al gestor de libros");
                    System.out.println("Pulsa 2 si deseas acceder al gestor de personas");
                    System.out.println("Pulsa 0 para salir de la sesion");
                    opcion=sc.nextInt();
                    sc.nextLine();
                }
                opcionGestor=0;
                //bucle donde transcurren las opciones del gestor de libros
                while (opcion==1){
                    System.out.println("Que desea hacer?");
                    System.out.println("Pulsa 1 para añadir un libro");
                    System.out.println("Pulsa 2 para eliminar un libro");
                    System.out.println("Pulsa 3 para buscar un libro por su ISBN");
                    System.out.println("Pulsa 4 para buscar un libro por su titulo");
                    System.out.println("Pulsa 5 para mostrar todos los libros");
                    System.out.println("Pulsa 6 para mostrar todos los libros disponibles en este momento");
                    System.out.println("Pulsa 7 para reservar un libro para un usuario de la biblioteca");
                    System.out.println("Pulsa 8 volver al selector de gestores");
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
                        System.out.println("Inserta el NIF del usuario para el que va a reservar el libro");
                        String NIF=sc.nextLine();
                        int i=0;
                        boolean encontrado=false;
                        while (i<biblioteca.getListaUsuario().size() && !encontrado){
                            if (biblioteca.getListaUsuario().get(i).getNIF().equals(NIF)){
                                encontrado=true;
                                biblioteca.getListaUsuario().get(i).reservarLibro(biblioteca.getListaLibros());
                            } 
                            i++;
                        }
                        if(!encontrado){
                            System.out.println("No existe ningun usuario de la biblioteca que tenga ese NIF"); 
                        }
                        break;

                        case 8:
                        System.out.println("Volvamos al selector de gestores entonces");
                        opcion=9;
                        break;

                        default:
                        System.out.println("ERROR: Este comando no existe");
                        System.out.println("Inserta un comando que exista");
                    }
                    System.out.println("Pulsa enter para continuar");
                    sc.nextLine();
                }
                //bucle donde transcurren las opciones del gestor de personas
                while (opcion==2){
                    System.out.println("Que desea hacer?");
                    System.out.println("Pulsa 1 para añadir un administrador al sistema");
                    System.out.println("Pulsa 2 para eliminar un administrador del sistema");
                    System.out.println("Pulsa 3 para añadir un usuario al sistema");
                    System.out.println("Pulsa 4 para eliminar un usuario del sistema");
                    System.out.println("Pulsa 5 para volver al selector de gestores");
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
                        Usuario.anadirUsuario(biblioteca.getListaUsuario());
                        break;
                        
                        case 4:
                        Usuario.eliminarUsuario(biblioteca.getListaUsuario());
                        break;

                        case 5:
                        System.out.println("Hasta la proxima");
                        opcion=9;
                        break;

                        default:
                        System.out.println("ERROR: Este comando no existe");
                        System.out.println("Inserta un comando que exista");
                    }
                    System.out.println("Pulsa enter para continuar");
                    sc.nextLine();
                }
                if (opcion==0){
                    System.out.println("Volvamos al selector de gestores entonces");
                    privilegios=9;
                }
            }
            //while de interfaz de usuario
            while (privilegios==2){
                System.out.println("Que desea hacer?");
                System.out.println("Pulsa 1 para buscar un libro por su ISBN");
                System.out.println("Pulsa 2 para buscar un libro por su titulo");
                System.out.println("Pulsa 3 para mostrar todos los libros");
                System.out.println("Pulsa 4 para mostrar todos los libros disponibles en este momento");
                System.out.println("Pulsa 5 para reservar un libro");
                System.out.println("Pulsa 6 para salir de la sesion");
                opcionGestor=sc.nextInt();
                sc.nextLine();

                switch (opcionGestor){
                    case 1:
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

                    case 2:
                    Libro.buscarLibroTitulo(biblioteca.getListaLibros());
                    break;

                    case 3:
                    biblioteca.mostrarLibros();
                    break;

                    case 4:
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                    
                    case 5:
                    int i=0;
                    boolean encontrado=false;
                    while (i<biblioteca.getListaUsuario().size() && !encontrado){
                        if (biblioteca.getListaUsuario().get(i).getNIF().equals(NIFUsuarioActivo)){
                            biblioteca.getListaUsuario().get(i).reservarLibro(biblioteca.getListaLibros());
                            System.out.println(biblioteca.getListaUsuario().get(i).toString());
                            encontrado=true;
                        } 
                        i++;
                    }
                    break;
 
                    case 6:
                    System.out.println("Hasta la proxima!");
                    privilegios=9;
                    break;

                    default:
                    System.out.println("ERROR: Este comando no existe");
                    System.out.println("Inserta un comando que exista");
                }
                System.out.println("Pulsa enter para continuar");
                sc.nextLine();   
            }
            //Opciones de inicio de sesion o para salir del programa
            System.out.println("MENU DE INICIO DE SESION");
            System.out.println("Inserta 1 para inciar sesion si eres parte del personal");
            System.out.println("Inserta 2 para iniciar sesion si eres un usuario de la biblioteca");
            System.out.println("Inserta 0 para salir del programa");
            opcionSesion=sc.nextInt();
            sc.nextLine();
            if (opcionSesion==1){
                System.out.println("Inserta tu NIF");
                String NIF=sc.nextLine();
                System.out.println("Inserta tu contraseña");
                String contrasena=sc.nextLine();
                int i=0;
                boolean encontrado=false;
                while (i<biblioteca.getListaPersonal().size() && !encontrado){
                    if(biblioteca.getListaPersonal().get(i).getNIF().equals(NIF)){
                        encontrado=true;
                        boolean salir=false;
                        while (!(biblioteca.getListaPersonal().get(i).getContrasena().equals(contrasena)) && !salir){
                            System.out.println("La contraseña es incorrecta, inserta la contraseña correcta.");
                            System.out.println("Si quieres salir del inicio de sesion apriete enter");
                            contrasena=sc.nextLine();
                            if (contrasena.equals("")){
                                salir=true;
                                privilegios=9;
                            }
                            
                        }
                        if(biblioteca.getListaPersonal().get(i).getNIF().equals(NIF) && biblioteca.getListaPersonal().get(i).getContrasena().equals(contrasena)){
                            privilegios=1;
                            System.out.println("Bienvenido "+biblioteca.getListaPersonal().get(i).getNombre());
                        }
                    }
                    i++;
                }
                if (!encontrado){
                    System.out.println("No hay ningun usuario del personal con ese NIF");
                }
            }   
            else if(opcionSesion==2){
                System.out.println("Inserta tu NIF");
                String NIF=sc.nextLine();
                System.out.println("Inserta tu contraseña");
                String contrasena=sc.nextLine();
                int i=0;
                boolean encontrado=false;
                while (i<biblioteca.getListaUsuario().size() && !encontrado){
                    if(biblioteca.getListaUsuario().get(i).getNIF().equals(NIF)){
                        encontrado=true;
                        boolean salir=false;
                        while (!(biblioteca.getListaUsuario().get(i).getContrasena().equals(contrasena)) && !salir){
                            System.out.println("La contraseña es incorrecta, inserta la contraseña correcta.");
                            System.out.println("Si quieres salir del inicio de sesion apriete enter");
                            contrasena=sc.nextLine();
                            if (contrasena.equals("")){
                                salir=true;
                                privilegios=9;
                            }
                            
                        }
                        if(biblioteca.getListaUsuario().get(i).getNIF().equals(NIF) && biblioteca.getListaUsuario().get(i).getContrasena().equals(contrasena)){
                            privilegios=2;
                            System.out.println("Bienvenido "+biblioteca.getListaUsuario().get(i).getNombre());
                            NIFUsuarioActivo=biblioteca.getListaUsuario().get(i).getNIF();
                        }
                    }
                    i++;
                }
                if (!encontrado){
                    System.out.println("No hay ningun usuario con ese NIF");
                }
            } 
            else if (opcionSesion==0){
                System.out.println("ADIOS!");
                privilegios=0;
            } 
            else{
                System.out.println("ERROR: Esta opcion no existe");
                privilegios=9;
            }
        }
    }    
}
