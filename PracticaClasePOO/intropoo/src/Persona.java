package eu.cifpfbmoll.intropoo;

import java.util.Scanner;

public class Persona {

    private static int contadorPersonas;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;

    Scanner sc=new Scanner(System.in);

    public Persona(){
        contadorPersonas++;

    }

    public Persona(String nombre, String apellido1, String apellido2, int edad){
        contadorPersonas++;
        this.nombre=nombre;
        this.apellido1=apellido1;
        this.apellido2=apellido2;
        this.edad=edad;
    }

    public Persona(Persona p1){
        contadorPersonas++;
        this.nombre=p1.nombre;
        this.apellido1=p1.apellido1;
        this.apellido2=p1.apellido2;
        this.edad=p1.edad;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String setNombre(String nombre){
        this.nombre=nombre;
    }

    public String setEdad(int edad){
        while(edad<18){
            System.out.println("La edad no es correcta, no puede haber menores");
            edad=sc.nextInt();
        }
        this.edad=edad;
    }

    public static Persona solicitarDatosPersona(){
        Scanner sc=new Scanner(System.in);
        Persona p1=new Persona();
        System.out.println("Dame el nombre");
        // p1.nombre=sc.nextLine(); NO HACER
        p1.setNombre(sc.nextLine());
        System.out.println("Dame el 1 apellido");
        p1.setApellido1(sc.nextLine());
        System.out.println("Dame el 2 apellido");
        p1.setApellido2(sc.nextLine());
        System.out.println("Dame la edad");
        p1.setEdad(sc.nextInt());
        return p1;
    }

}
