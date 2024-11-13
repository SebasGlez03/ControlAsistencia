/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mock;

import entidades.Alumno;

/**
 *
 * @author PC
 */
public class PruebaListaAsistenciaMock {

    public static void main(String[] args) {

        Alumno alumno1 = new Alumno(4, 8.2f, 927384, "Pedro", "Ramirez", "Valenzuela", "pedro@gmail.com", "contrasenia");
        Alumno alumno2 = new Alumno(5, 8.75f, 123456, "Juan", "Pérez", "Gómez", "juan.perez@correo.com", "contrasenia123");
        Alumno alumno3 = new Alumno(3, 9.10f, 234567, "Ana", "Ramírez", "López", "ana.ramirez@correo.com", "seguridad321");
        Alumno alumno4 = new Alumno(7, 7.50f, 345678, "Carlos", "Martínez", "Vázquez", "carlos.martinez@correo.com", "abc123");
        Alumno alumno5 = new Alumno(2, 6.80f, 456789, "Marta", "Sánchez", "Pérez", "marta.sanchez@correo.com", "clave987");
        Alumno alumno6 = new Alumno(8, 9.50f, 567890, "Luis", "González", "Morales", "luis.gonzalez@correo.com", "pass456");
        Alumno alumno7 = new Alumno(4, 8.20f, 678901, "Elena", "Fernández", "Torres", "elena.fernandez@correo.com", "qwerty2024");
        Alumno alumno8 = new Alumno(6, 9.00f, 789012, "Pedro", "Díaz", "Serrano", "pedro.diaz@correo.com", "contraseña789");

        ListaAsistenciaMock listaMock = new ListaAsistenciaMock();
        listaMock.agregarUsuario(alumno1);
        listaMock.agregarUsuario(alumno2);
        listaMock.agregarUsuario(alumno3);
        listaMock.agregarUsuario(alumno4);
        listaMock.agregarUsuario(alumno5);
        listaMock.agregarUsuario(alumno6);
        listaMock.agregarUsuario(alumno7);
        listaMock.agregarUsuario(alumno8);

        System.out.println(listaMock.getListaAlumnos());

    }

}
