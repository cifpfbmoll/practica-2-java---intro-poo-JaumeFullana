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
        int privilegios=1;
        int opcionSesion;
        String [] listaInicioSesion;
        String NIFUsuarioActivo="";
        //bucle para poder realizar acciones hasta que se desee
        while (privilegios!=0){
            if (privilegios==1){
                privilegios = menuAdministrador(privilegios, biblioteca);
            }
            else if (privilegios==2){
                privilegios = menuUsuario(privilegios, biblioteca, NIFUsuarioActivo);
            }
            //Opciones de inicio de sesion o para salir del programa
            System.out.println("MENU DE INICIO DE SESION");
            System.out.println("Inserta 1 para inciar sesion si eres parte del personal");
            System.out.println("Inserta 2 para iniciar sesion si eres un usuario de la biblioteca");
            System.out.println("Inserta 0 para salir del programa");
            opcionSesion=sc.nextInt();
            sc.nextLine();
            //inicio de sesion de administrador
            if (opcionSesion==1){
                privilegios = menuInicioSesionAdministrador(biblioteca, privilegios);
            } 
            //inicio de sesion de usuario
            else if(opcionSesion==2){
                listaInicioSesion = menuInicioSesionUsuario(biblioteca, privilegios, NIFUsuarioActivo);
                NIFUsuarioActivo=listaInicioSesion[1];
                privilegios=Integer.parseInt(listaInicioSesion[0]);
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
    /**
     * Metodo de un menu de inicio de sesion para usuarios normales, recibe por parametros un int privilegios para despues ser devuelto
     * con el valor correspondiente, un String NIFUsuarioActivo que despues sera devuelto tambien con el numero del usuario que haya logeado y
     * un objeto Biblioteca del cual se usa el atributo listaUsuarios, que es un ArrayList de Usuarios, para ver si existe 
     * un Usuario con ese NIF y luego comprobar si la contraseña introducida es la correcta(una vez comprobado,
     * y si es correcto, devuelve 1, si es incorrecto se sigue ejecutando hasta que el usuario quiere, cuando no quiere, si sigue
     * siendo incorrecto, devuelve 9).
     * 
     * @param biblioteca Objeto de la clase Biblioteca.
     * @param privilegios int que hace referencia a que puede hacer el usuario conectado(administrador o usuario normal).
     * @param NIFUsuarioActivo String que es el NIF del usuario que esta en la sesion actualmente.
     * @return listaInicioSesion Array creada para poder almacenar y devolver el int privilegios y el String NIFUsuarioActivo.
     */
    public static String[] menuInicioSesionUsuario(Biblioteca biblioteca, int privilegios, String NIFUsuarioActivo){
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
        String privilegiosString=Integer.toString(privilegios);
        String[] listaInicioSesion={privilegiosString,NIFUsuarioActivo};
        return listaInicioSesion;
    }
    
    /**
     * Metodo de un menu de inicio de sesion para administradores, recibe por parametros un int privilegios para despues ser devuelto y
     * un objeto Biblioteca del cual se usa el atributo listaPersonal, que es un ArrayList de personas, para ver si existe 
     * un administrador(Persona ) con ese NIF y luego comprobar si la contraseña introducida es la correcta(una vez comprobado,
     * y si es correcto, devuelve 1, si es incorrecto se sigue ejecutando hasta que el usuario quiere, cuando no quiere, si sigue
     * siendo incorrecto, devuelve 9).
     * 
     * @param biblioteca Objeto de la clase Biblioteca.
     * @param privilegios int que hace referencia a que puede hacer el usuario conectado(administrador o usuario normal).
     * @return privilegios int que hace referencia a que puede hacer el usuario conectado(administrador o usuario normal).
     */
    public static int menuInicioSesionAdministrador(Biblioteca biblioteca, int privilegios) {
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
        return privilegios;
    }
    /**
     * Metodo de un menu de las diferentes opcion de un Usuario de la biblioteca, recibe por parametro un int
     * privilegios para poder entrar en el bucle, el objeto biblioteca de la clase Biblioteca para poder entrar
     * en su instancia con los diferentes metodos y la String NIFUsuarioActivo para poder saber que usuario es
     * el que esta en la sesion (Devuelve un int privilegios).
     * 
     * @param privilegios int que hace referencia a que puede hacer el usuario conectado(administrador o usuario normal).
     * @param biblioteca Objeto de la clase Biblioteca.
     * @param NIFUsuarioActivo String que es el NIF del usuario que esta en la sesion actualmente.
     * @return privilegios int que hace referencia a que puede hacer el usuario conectado(administrador o usuario normal).
     */
    public static int menuUsuario(int privilegios, Biblioteca biblioteca, String NIFUsuarioActivo) {
        int opcionGestor;
        //while de interfaz de usuario, gestiona Libros
        while (privilegios==2){
            System.out.println("Que desea hacer?");
            System.out.println("Pulsa 1 para buscar un libro por su ISBN");
            System.out.println("Pulsa 2 para buscar un libro por su titulo");
            System.out.println("Pulsa 3 para mostrar todos los libros");
            System.out.println("Pulsa 4 para mostrar todos los libros disponibles en este momento");
            System.out.println("Pulsa 5 para reservar un libro");
            System.out.println("Pulsa 6 para devolver un libro");
            System.out.println("Pulsa 7 para que se muestren los libros que tienes reservados");
            System.out.println("Pulsa 8 para salir de la sesion");
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
                            encontrado=true;
                        }
                        i++;
                    }
                    break;
                    
                case 6:
                    i=0;
                    encontrado=false;
                    while (i<biblioteca.getListaUsuario().size() && !encontrado){
                        if (biblioteca.getListaUsuario().get(i).getNIF().equals(NIFUsuarioActivo)){
                            biblioteca.getListaUsuario().get(i).devolverLibro(biblioteca.getListaLibros());
                            encontrado=true;
                        }
                        i++;
                    }
                    break;
                    
                case 7:
                    i=0;
                    encontrado=false;
                    while (i<biblioteca.getListaUsuario().size() && !encontrado){
                        if (biblioteca.getListaUsuario().get(i).getNIF().equals(NIFUsuarioActivo)){
                            biblioteca.getListaUsuario().get(i).mostrarLibrosReservados();
                            encontrado=true;
                        }
                        i++;
                    }
                    
                    break;
                    
                case 8:
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
        return privilegios;
    }
    /**
     * Metodo de un menu para administradores para entrar a los diferentes gestores de la biblioteca, recibe por parametro un int
     * privilegios para poder entrar en el bucle y el objeto biblioteca de la clase Biblioteca para poder poder pasarlo
     * por parametro a otras funciones(Devuelve un int privilegios).
     * 
     * @param privilegios int que hace referencia a que puede hacer el usuario conectado(administrador o usuario normal).
     * @param biblioteca Objeto de la clase Biblioteca.
     * @return privilegios int que hace referencia a que puede hacer el usuario conectado(administrador o usuario normal).
     */
    public static int menuAdministrador(int privilegios, Biblioteca biblioteca) {
        int opcion;
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
            if (opcion==1){
                opcion = gestorLibrosAdministrador(opcion, biblioteca);
            }
            else if (opcion==2){
                opcion = gestorPersonasAdministrador(opcion, biblioteca);
            }
            else if (opcion==0){
                System.out.println("Volvamos al selector de gestores entonces");
                privilegios=9;
            }
        }
        return privilegios;
    }
    /**
     * Metodo del menu del gestor de Personas de los administradores, recibe por parametro el int opcion
     * para poder entrar en el bucle y el objeto biblioteca de la clase Biblioteca para poder entrar en
     * su instancia con los diferentes metodos que se usan(devuelve un int opcion).
     * 
     * @param opcion int para poder entrar en el bucle i salir de el
     * @param biblioteca Objeto de la clase Biblioteca.
     * @return opcion int para poder entrar en el bucle i salir de el
     */
    public static int gestorPersonasAdministrador(int opcion, Biblioteca biblioteca) {
        int opcionGestor;
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
        return opcion;
    }
    /**
     * Metodo del menu del gestor de Libros de los administradores, recibe por parametro el int opcion
     * para poder entrar en el bucle y el objeto biblioteca de la clase Biblioteca para poder entrar en
     * su instancia con los diferentes metodos que se usan(devuelve un int opcion).
     * 
     * @param opcion int para poder entrar en el bucle i salir de el
     * @param biblioteca Objeto de la clase Biblioteca.
     * @return opcion int para poder entrar en el bucle i salir de el
     */
    public static int gestorLibrosAdministrador(int opcion, Biblioteca biblioteca) {
        int opcionGestor;
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
            System.out.println("Pulsa 8 para devolver un libro de un usuario a la biblioteca");
            System.out.println("Pulsa 9 para ver los libros reservados de un usuario de la biblioteca");
            System.out.println("Pulsa 0 volver al selector de gestores");
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
                    System.out.println("Inserta el NIF del usuario para el que va a devolver el libro");
                    NIF=sc.nextLine();
                    i=0;
                    encontrado=false;
                    while (i<biblioteca.getListaUsuario().size() && !encontrado){
                        if (biblioteca.getListaUsuario().get(i).getNIF().equals(NIF)){
                            biblioteca.getListaUsuario().get(i).devolverLibro(biblioteca.getListaLibros());
                            encontrado=true;
                        }
                        i++;
                    }
                    if(!encontrado){
                        System.out.println("No existe ningun usuario de la biblioteca que tenga ese NIF");
                    }
                    break;
                    
                case 9:
                    System.out.println("Inserta el NIF del usuario");
                    NIF=sc.nextLine();
                    i=0;
                    encontrado=false;
                    while (i<biblioteca.getListaUsuario().size() && !encontrado){
                        if (biblioteca.getListaUsuario().get(i).getNIF().equals(NIF)){
                            biblioteca.getListaUsuario().get(i).mostrarLibrosReservados();
                            encontrado=true;
                        }
                        i++;
                    }
                    if(!encontrado){
                        System.out.println("No existe ningun usuario de la biblioteca que tenga ese NIF");
                    }
                    break;
                    
                case 0:
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
        return opcion;
    }
}
