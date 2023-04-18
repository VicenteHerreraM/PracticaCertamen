package org.example;


import java.util.ArrayList;

public class Estudiante {
    private int rut;
    private String nombre;
    private ArrayList<Estudiante> ListaE = new ArrayList<>();

    public Estudiante() {
    }

    public Estudiante(int rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
    }

    public int getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }
    public ArrayList<Estudiante> getListaE() {
        return ListaE;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setListaE(ArrayList<Estudiante> ListaE) {
        this.ListaE = ListaE;
    }

    public void agregarEstudiante(Estudiante estudianteNuevo)
    {
        getListaE().add(estudianteNuevo);
    }
}
