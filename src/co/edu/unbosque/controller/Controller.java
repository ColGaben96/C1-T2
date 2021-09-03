package co.edu.unbosque.controller;

import co.edu.unbosque.model.Academia;

import java.util.Scanner;

/**
 * @author Gabriel Blanco
 * @version 1.0
 * <h1>Descripción</h1> <br>
 * <p>Clase controladora de toda la aplicación</p>
 */
public class Controller {
    /**
     * Atributo donde se trae el modelo
     */
    private Academia modelo = new Academia();
    /**
     * Atributo donde se utiliza la entrada del usuario.
     */
    private Scanner sc = new Scanner(System.in);

    /**
     * Método madre donde funciona toda la consola
     */
    public void consola() {
        System.out.println("""
                ============================
                Bitácora de Estudiantes
                V1.0
                gblancol@unbosque.edu.co
                ============================
                Ingresa '1' para ayuda y '0' para salir""");
        System.out.println("Conectando...");
        if (modelo.getDb().connect() == 0) {
            modelo.restaurar();
            System.out.println("Hay "+modelo.getEstudiantes().obtenerArreglo().size()+" estudiantes registrados");
        }
        boolean active = true;
        while(active) {
            try {
                System.out.print("Ingresa una opción: ");
                var opcion = sc.nextLine();
                switch (opcion) {
                    default -> System.out.println("Ingresa una opción válida");
                    case "0" -> {
                        if (modelo.getDb().finishConnection() == 0) {
                            active = false;
                        }
                    }
                    case "1" -> ayuda();
                    case "2" -> crear();
                    case "3" -> buscar();
                }
            } catch (Exception e) {
                System.out.println("Unexpected error");
            }
        }

    }

    /**
     * Método para añadir un estudiante al DAO y al archivo de access
     */
    public void crear() {
        System.out.print("Ingresa los nombres del estudiante nuevo: ");
        var nombres = sc.nextLine();
        System.out.print("Ingresa los apellidos del estudiante nuevo: ");
        var apellidos = sc.nextLine();
        System.out.print("Ingresa el sexo del estudiante nuevo [M-F]: ");
        var sexo = sc.nextLine();
        System.out.print("Ingresa la edad del estudiante nuevo: ");
        var edad = sc.nextInt();
        System.out.print("Ingresa el curso del estudiante nuevo: ");
        sc.nextLine();
        var curso = sc.nextLine();
        modelo.crear(modelo.getEstudiantes().obtenerArreglo().size()+1, nombres, apellidos, sexo, edad, curso);
    }

    /**
     * Método para buscar un estudiante por curso
     */
    public void buscar() {
        System.out.print("Ingresa el nombre del curso: ");
        var curso = sc.nextLine();
        var estudiantes = modelo.getEstudiantes().buscarxcurso(curso);
        if (!curso.isEmpty()) {
            System.out.println("Resultados obtenidos por el curso \""+curso+"\".");
        }
        System.out.println("Matrícula\tNombre Completo\tSexo\tEdad\tCurso");
        for (int i = 0; i < estudiantes.size(); i++) {
            System.out.println(estudiantes.get(i).getMatricula()+"\t"+estudiantes.get(i).getNombres()+" "
                    + estudiantes.get(i).getApellidos()+"\t"+estudiantes.get(i).getSexo()+"\t"
                    + estudiantes.get(i).getCurso());
        }
    }

    /**
     * Método para mostrar ayuda
     */
    public void ayuda() {
        System.out.println("""
                Opción Descripción
                0   Salir
                1   Muestra esta ayuda
                2   Crear un estudiante
                3   Buscar estudiantes por curso""");
    }
}

/**
 * @author Gabriel Blanco
 * @version 1.0
 * <h1>Descripción</h1> <br>
 * Clase incrustada donde se arranca la aplicación
 */
class Launcher {
    /**
     * Método main para iniciar la aplicación
     * @param args
     */
    public static void main(String[] args) {
        Controller c = new Controller();
        c.consola();
    }
}
