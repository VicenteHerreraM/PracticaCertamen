package org.example;

import java.awt.*;
import java.util.Scanner;

public class Universidad{
    Universidad  u;
    Carrera c;
    Estudiante e;
    public static void main(String[] args){
        int ciclo1, idCarrera, rut;
        String nombre, area;
        Universidad  u = new Universidad();
        Carrera c = new Carrera();
        Scanner entrada = new Scanner(System.in);
        do{
            System.out.print("¿Desea hacer algo?\n1.- Agregar Carrera\n2.- Agregar Estudiante\n3.- Obtener Estudiante\n0.- Terminar el programa\n");
            do{
                ciclo1 = entrada.nextInt();
                if(ciclo1>3 || ciclo1<0){
                    System.out.println("""

                                ---------------------
                                HA OCURRIDO UN ERROR
                                  ID YA EXISTENTE
                                ---------------------
                                
                                """);
                }
            }while(ciclo1>3 || ciclo1<0);
            switch (ciclo1){
                case 1:
                    System.out.print("Ingrese la id de la carrera:");
                    idCarrera= entrada.nextInt();
                    System.out.print("\nIngrese el nombre de la carrera : ");
                    nombre= entrada.next();
                    System.out.print("Ingrese el area de la carrera : ");
                    area= entrada.next();
                    Carrera carrera= new Carrera(idCarrera, nombre, area);
                    if(u.agregarCarrera(c, carrera)){
                        System.out.print("""

                                -----------------------------
                                SE HA AGREGADO CORRECTAMENTE
                                -----------------------------
                                
                                """);
                    }else{
                        System.out.print("""

                                ---------------------
                                HA OCURRIDO UN ERROR
                                  ID YA EXISTENTE
                                ---------------------
                                
                                """);
                    }
                    break;
                case 2:
                    System.out.print("ID de la carrera del estudiante: ");
                    idCarrera = entrada.nextInt();
                    if(c.buscarCarrera(c, idCarrera)){
                        System.out.print("Ingrese la nombre del estudiante: ");
                        nombre=entrada.next();
                        System.out.print("Ingrese el RUT del estudiante: ");
                        rut=entrada.nextInt();
                        Estudiante estudiante = new Estudiante(rut,nombre);
                        if(u.agregarEstudiante(idCarrera,estudiante,c)){
                            System.out.print("""

                                -----------------------------
                                SE HA AGREGADO CORRECTAMENTE
                                -----------------------------
                                
                                """);
                        }else{
                            System.out.print("""

                                ------------------------------
                                HA INGRESADO UN DATO INVÁLIDO
                                      INTENTE NUEVAMENTE
                                ------------------------------
                                
                                """);
                            break;
                        }
                    }else{
                        System.out.print("""

                                ------------------------------
                                HA INGRESADO UN DATO INVÁLIDO
                                      INTENTE NUEVAMENTE
                                ------------------------------
                                
                                """);
                    }
                    break;
                case 3:
                    System.out.print("INGRESA EL RUT DEL ESTUDIANTE A BUSCAR: ");
                    rut = entrada.nextInt();
                    Estudiante studentFound = u.obtenerEstudiante(rut, c);
                    if(studentFound!=null){
                        System.out.print("\nEl Estudiante es "+studentFound.getNombre()+" y su RUT es: "+studentFound.getRut());
                    }else{
                        System.out.print("""

                                ------------------------------
                                HA INGRESADO UN DATO INVÁLIDO
                                      INTENTE NUEVAMENTE
                                ------------------------------
                                
                                """);
                    }
                    break;
                default:
                    System.out.print("""

                                ------------------------------
                                             FIN
                                ------------------------------
                                
                                """);
                    break;
            }
        }while(ciclo1!=0);
    }
    public boolean agregarCarrera(Carrera carreras, Carrera carrera)
    {
        if((!carrera.buscarCarrera(carreras,carrera.getIdentificador()))) {
            carreras.agregarCarrera(carrera);
            return true;
        }
        return false;
    }

    public boolean agregarEstudiante(int idCarrera, Estudiante estudiante, Carrera carreras){
        for(Carrera carrera:carreras.getListaC())
        {
            if(carrera.getIdentificador()==idCarrera)
            {
                if(carreras.agregarEstudiante(estudiante, carrera)){
                    return true;
                }
            }
        }
        return false;

    }

    public Estudiante obtenerEstudiante(int rutBuscado, Carrera carreras){
        return carreras.obtenerEstudiante(rutBuscado);
    }

    /**
     *  public void imprimirCarreras(Carrera carreras){
     *         System.out.println("Tamanyo: "+carreras.getListaC().size()+" \n");
     *         for(int i=0; i<carreras.getListaC().size();i++){
     *             System.out.println("Carrera ID: "+carreras.getListaC().get(i).getIdentificador()+"  -  Nombre: "+carreras.getListaC().get(i).getNombre());
     *             System.out.println("Tamanyo Lista Estudiantes: " + carreras.getListaC().get(i).getE().getListaE().size()+" \n");
     *             for(int j=0; j<carreras.getListaC().get(i).getE().getListaE().size(); j++){
     *                 System.out.println("Nombre Estudiante "+(j+1)+": "+ carreras.getListaC().get(i).getE().getListaE().get(j).getNombre()+"\n");
     *
     *             }
     *         }
     *         System.out.println("\n");
     *     }
     *
     * */
}
