package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.EstudianteDTO;

import java.util.ArrayList;

/**
 * @author Gabriel Blanco
 * @version 1.0
 * <h1>Descripción</h1> <br>
 * Clase para gestionar los estudiantes en la ejecución
 */
public class EstudianteDAO {
    /**
     * Atributo para definir un arreglo de tamaño indefinido de tipo estudiantes.
     */
    private ArrayList<EstudianteDTO> estudiantes = new ArrayList<>();

    /**
     * Método para crear un estudiante
     * @param matricula
     * @param nombres
     * @param apellidos
     * @param sexo
     * @param edad
     * @param curso
     * @return
     */
    public boolean crear(int matricula, String nombres, String apellidos, String sexo, int edad, String curso) {
        var estudiante = new EstudianteDTO(matricula, nombres, apellidos, sexo, edad, curso);
        if (buscarxmatricula(matricula) == null) {
            estudiantes.add(estudiante);
            return true;
        }
        return false;
    }

    /**
     * Método para buscar estudiantes por curso
     * @param curso
     * @return
     */
    public ArrayList<EstudianteDTO> buscarxcurso (String curso) {
        var encontrados = new ArrayList<EstudianteDTO>();
        for (EstudianteDTO busqueda : estudiantes) {
            if (busqueda.getCurso().contains(curso)) {
                encontrados.add(busqueda);
            }
        }
        return encontrados;
    }

    /**
     * Método para buscar un estudiante por matrícula
     * @param matricula
     * @return
     */
    public EstudianteDTO buscarxmatricula (int matricula) {
        for (EstudianteDTO busqueda : estudiantes) {
            if (busqueda.getMatricula() == matricula) {
                return busqueda;
            }
        }
        return null;
    }

    /**
     * Método para buscar estudiantes en la ejecución
     * @return
     */
    public ArrayList<EstudianteDTO> obtenerArreglo() {
        return estudiantes;
    }
}
