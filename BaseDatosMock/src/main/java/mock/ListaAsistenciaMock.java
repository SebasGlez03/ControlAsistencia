/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mock;

import entidades.Alumno;
import entidades.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class ListaAsistenciaMock {

    private List<Usuario> listaAlumnos = new ArrayList<>();

    public ListaAsistenciaMock() {
    }

    public void agregarUsuario(Alumno alumno) {
        listaAlumnos.add(alumno);
    }

    public List<Usuario> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(List<Usuario> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

}
