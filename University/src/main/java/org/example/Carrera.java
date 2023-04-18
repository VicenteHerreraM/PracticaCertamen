package org.example;

import java.util.ArrayList;

public class Carrera {
    private int identificador;
    private String nombre;
    private String area;
    private ArrayList<Carrera> ListaC = new ArrayList<>();
    private Estudiante e = new Estudiante();

    public Carrera() {

    }

    public Carrera(int identificador, String nombre, String area) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.area = area;
    }


    public int getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getArea() {
        return area;
    }

    public ArrayList<Carrera> getListaC() {
        return ListaC;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setListaC(ArrayList<Carrera> ListaC) {
        this.ListaC = ListaC;
    }

    public void setE(Estudiante e){
        this.e = e;
    }

    public Estudiante getE(){
        return e;
    }

    public boolean buscarCarrera(Carrera c, int idCarreraB){                                                            // RETORNA FALSO SI NO HAY NINGUNA ID COINCIDENTE
        if(c.getListaC()==null) return false;
        for(Carrera carrera : c.getListaC())
        {
            if(carrera.getIdentificador()==idCarreraB) return true;
        }
        return false;
    }

    public void agregarCarrera(Carrera carreraNueva){
        getListaC().add(carreraNueva);
    }
    public boolean agregarEstudiante(Estudiante estudianteNuevo,Carrera carreraA) {
        for (Carrera carrerita: getListaC()){
            if(carrerita == carreraA){
                carrerita.getE().agregarEstudiante(estudianteNuevo);
                return true;
            }
        }
        return false;

    }

    public Estudiante obtenerEstudiante(int rut){
        for (Carrera carrerita: getListaC()){
            for(Estudiante student: carrerita.getE().getListaE()){
                if(student.getRut()==rut){
                    return student;
                }
            }
        }
        return null;
    }

}
